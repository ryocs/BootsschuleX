package net.bratzel.quiz.service;


import net.bratzel.quiz.dto.*;
import net.bratzel.quiz.entity.Question;
import net.bratzel.quiz.entity.UserQuestion;
import net.bratzel.quiz.repository.CategoryRepository;
import net.bratzel.quiz.repository.QuestionRepository;
import net.bratzel.quiz.repository.UserQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final CategoryRepository categoryRepository;
    private final QuestionRepository questionRepository;
    private final UserQuestionRepository userQuestionRepository;
    
    private final Long TEST_USER_ID = 1L;

    public List<CategoryProgressDTO> getAllCategoriesWithProgress() {
        return categoryRepository.findAll().stream().map(category -> {
            long total = questionRepository.countByCategoryId(category.getId());
            long answered = userQuestionRepository.countByUserIdAndCategoryIdAndAnswered(TEST_USER_ID, category.getId(), 1);
            
            String progressText = answered + " von " + total + " Fragen richtig beantwortet";
            
            return new CategoryProgressDTO(category.getId(), category.getName(), total, answered, progressText);
        }).toList();
    }

    public NextQuestionDTO getNextQuestion(Long categoryId) {
        List<Question> allQuestions = questionRepository.findByCategoryId(categoryId);
        
        for (Question question : allQuestions) {
            boolean isAnsweredCorrectly = userQuestionRepository
                    .findByUserIdAndQuestionId(TEST_USER_ID, question.getId())
                    .map(uq -> uq.getAnswered() == 1)
                    .orElse(false);
            
            if (!isAnsweredCorrectly) {
                List<OptionDTO> optionDTOs = question.getOptions().stream()
                        .map(opt -> new OptionDTO(opt.getId(), opt.getOptionText()))
                        .toList();

                return new NextQuestionDTO(question.getId(), question.getText(), optionDTOs, null);
            }
        }
        
        return new NextQuestionDTO(null, null, null, "Glückwunsch! Du hast alle Fragen in dieser Kategorie richtig beantwortet.");
    }

    public AnswerResultDTO checkAnswer(Long questionId, AnswerRequestDTO request) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Question not found"));
                
        boolean isCorrect = question.getCorrectOptionId().equals(request.selectedOptionId());
        
        UserQuestion progress = userQuestionRepository
                .findByUserIdAndQuestionId(TEST_USER_ID, questionId)
                .orElse(UserQuestion.builder()
                        .userId(TEST_USER_ID)
                        .categoryId(question.getCategoryId())
                        .questionId(questionId)
                        .build());
                
        progress.setAnswered(isCorrect ? 1 : 0);
        userQuestionRepository.save(progress);
        
        return new AnswerResultDTO(isCorrect, question.getCorrectOptionId());
    }

    public Boolean resetAll() {
        userQuestionRepository.deleteAllByUserId(TEST_USER_ID);
        return true;
    }
}