package net.bratzel.quiz.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;
}