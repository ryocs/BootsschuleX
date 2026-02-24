package net.bratzel.quiz.controller;

import lombok.RequiredArgsConstructor;
import net.bratzel.quiz.dto.AnswerRequestDTO;
import net.bratzel.quiz.dto.AnswerResultDTO;
import net.bratzel.quiz.dto.CategoryProgressDTO;
import net.bratzel.quiz.dto.NextQuestionDTO;
import net.bratzel.quiz.service.QuizService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") 
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @GetMapping("/categories")
    public List<CategoryProgressDTO> getCategories() {
        return quizService.getAllCategoriesWithProgress();
    }

    @GetMapping("/categories/{id}/next-question")
    public NextQuestionDTO getNextQuestion(@PathVariable Long id) {
        return quizService.getNextQuestion(id);
    }

    @PostMapping("/questions/{id}/answer")
    public AnswerResultDTO submitAnswer(@PathVariable Long id, @RequestBody AnswerRequestDTO request) {
        return quizService.checkAnswer(id, request);
    }

    @PostMapping("/questions/resetall")
    public Boolean postMethodName() {
        return quizService.resetAll();
    }
    
}