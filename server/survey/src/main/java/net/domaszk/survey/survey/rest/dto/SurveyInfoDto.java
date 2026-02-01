package net.domaszk.survey.survey.rest.dto;


/**
 * todo: aggregate?
 * @param id Survey id.
 * @param name
 * @param creator
 * @param questionCount
 * @param responseCount
 * @param createdAt
 * @param lastEdit
 * @param deletedAt
 * @param lastEvent
 */
public record SurveyInfoDto(
        String id,
        String name,
        String creator,
        int questionCount,
        int responseCount,
        String createdAt,
        String lastEdit,
        String deletedAt,
        String lastEvent
) {
}
