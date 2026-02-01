package net.domaszk.survey.survey.rest.dto;

import jakarta.validation.constraints.NotNull;


//todo: rename to something more significant
public record SurveyCreateDto(
        @NotNull String name,
        @NotNull String creator,
        @NotNull String description
) {
}
