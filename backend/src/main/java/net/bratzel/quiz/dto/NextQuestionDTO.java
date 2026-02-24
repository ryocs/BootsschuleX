package net.bratzel.quiz.dto;

import java.util.List;

public record NextQuestionDTO(
    Long id, 
    String text, 
    List<OptionDTO> options, 
    String message
) {}
