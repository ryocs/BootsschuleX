package net.bratzel.quiz.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import net.bratzel.quiz.entity.UserQuestion;

public interface UserQuestionRepository extends JpaRepository<UserQuestion, Long> {
    long countByUserIdAndCategoryIdAndAnswered(Long userId, Long categoryId, int answered);
    Optional<UserQuestion> findByUserIdAndQuestionId(Long userId, Long questionId);
    
    @Transactional
    @Modifying
    @Query("delete from UserQuestion uq where uq.userId = :userId")
    int deleteAllByUserId(@Param("userId") Long userId);
}
