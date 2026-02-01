package net.domaszk.survey.survey.rest.dto;

import jakarta.validation.constraints.Size;

public record SurveyCreateDto(
        @Size() String name,
        @Size() String creator,
        @Size() String description
) {
}
