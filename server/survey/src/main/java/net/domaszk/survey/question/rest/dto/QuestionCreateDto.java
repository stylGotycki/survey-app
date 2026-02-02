package net.domaszk.survey.question.rest.dto;

public record QuestionCreateDto(
    String id,
    String creator,
    String name,
    String content,
    String type
) {

}
