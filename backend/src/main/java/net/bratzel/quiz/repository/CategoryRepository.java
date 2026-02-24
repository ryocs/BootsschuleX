package net.bratzel.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.bratzel.quiz.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
