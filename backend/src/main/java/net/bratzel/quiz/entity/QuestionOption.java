package net.bratzel.quiz.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "question_options")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionOption {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "QUESTION_ID")
    private Long questionId;

    @Column(name = "OPTION_TEXT")
    private String optionText;
}