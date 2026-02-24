package net.bratzel.quiz.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users_questions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "CATEGORY_ID")
    private Long categoryId;

    @Column(name = "QUESTION_ID")
    private Long questionId;

    @Column(name = "ANSWERED")
    private int answered;
}