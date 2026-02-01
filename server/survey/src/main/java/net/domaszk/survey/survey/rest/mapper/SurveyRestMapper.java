package net.domaszk.survey.survey.rest.mapper;

import lombok.RequiredArgsConstructor;
import net.domaszk.survey.common.rest.IterableDto;
import net.domaszk.survey.common.util.MapperUtil;
import net.domaszk.survey.survey.persistence.entity.SurveyEntity;
import net.domaszk.survey.survey.rest.dto.SurveyCreateDto;
import net.domaszk.survey.survey.rest.dto.SurveyDto;
import net.domaszk.survey.user.persistence.id.UserId;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.StreamSupport;

@Component
@RequiredArgsConstructor
public class SurveyRestMapper {

    private final MapperUtil util;


    public IterableDto<SurveyDto> toDto(Iterable<SurveyEntity> entities) {
        return IterableDto.<SurveyDto>builder()
                .items(StreamSupport.stream(entities.spliterator(), false)
                        .map(this::toDto)
                        .toList())
                .build();
    }


    public SurveyDto toDto(SurveyEntity entity) {
        return SurveyDto.builder()
                .id(entity.getId().toString())
                .name(entity.getName())
                .description(entity.getDescription())
                .creator(entity.getCreator().getValue().toString())
                .deletedAt(entity.getDeletedAt().toString())
                .createdAt(entity.getCreatedAt().toString())
                .lastEdit(entity.getLastModifiedAt().toString())
                .build();

    }


    public SurveyEntity toEntity(SurveyCreateDto dto) {
        return SurveyEntity.builder()
                .name(dto.name())
                .description(dto.description())
                .creator(UserId.of(UUID.fromString(dto.creator())))
                .build();
    }


    public void update(SurveyEntity entity, SurveyCreateDto dto) {
        util.updateIfNotNull(dto::name, entity::setName);
        util.updateIfNotNull(dto::description, entity::setDescription);
        // fixme: transferring between account should be considered as different case
        // util.updateIfNotNull(dto::creator, entity::setCreator);
    }
}
