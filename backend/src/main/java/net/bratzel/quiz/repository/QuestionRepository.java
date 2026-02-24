package net.bratzel.quiz.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import net.bratzel.quiz.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByCategoryId(Long categoryId);
    long countByCategoryId(Long categoryId);
}
