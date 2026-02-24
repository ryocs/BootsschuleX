package net.bratzel.quiz.dto;

public record CategoryProgressDTO(
    Long id, 
    String name, 
    long totalQuestions, 
    long correctlyAnswered, 
    String progressText
) {}
