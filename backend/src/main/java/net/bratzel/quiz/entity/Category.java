package net.bratzel.quiz.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categorys")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;
}