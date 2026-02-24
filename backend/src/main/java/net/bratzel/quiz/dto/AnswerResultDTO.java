package net.bratzel.quiz.dto;

public record AnswerResultDTO(
    boolean isCorrect,
    Long correctOptionId
) {}