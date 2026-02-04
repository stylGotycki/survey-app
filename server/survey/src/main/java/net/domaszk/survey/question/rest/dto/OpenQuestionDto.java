package net.domaszk.survey.question.rest.dto;

public record OpenQuestionDto(
        String id,
        String creator,
        String name,
        String content,
        String type
) implements QuestionDto {

}
