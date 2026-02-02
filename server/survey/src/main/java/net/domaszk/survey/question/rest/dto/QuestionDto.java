package net.domaszk.survey.question.rest.dto;

public sealed interface QuestionDto
        permits OpenQuestionDto, RangeQuestionDto {
     String id();
     String creator();
     String name();
     String content();
     String type();
}
