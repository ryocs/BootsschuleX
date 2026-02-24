package net.bratzel.quiz.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "questions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "TEXT")
    private String text;

    @Column(name = "CORRECT_OPTION_ID")
    private Long correctOptionId;

    @Column(name = "CATEGORY_ID")
    private Long categoryId;

    // Automatically fetches the options for this question
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "QUESTION_ID", insertable = false, updatable = false)
    private List<QuestionOption> options;
}