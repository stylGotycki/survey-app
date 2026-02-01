package net.domaszk.survey.survey.rest.dto;

import lombok.Builder;


@Builder
public record SurveyDto(
        String id,
        String creator,
        String name,
        String description,
        String createdAt,
        String lastEdit,
        String deletedAt
) {
}
