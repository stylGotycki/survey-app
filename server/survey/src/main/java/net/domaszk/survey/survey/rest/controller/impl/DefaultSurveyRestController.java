package net.domaszk.survey.survey.rest.controller.impl;

import lombok.RequiredArgsConstructor;
import net.domaszk.survey.common.rest.IterableDto;
import net.domaszk.survey.survey.domain.service.api.SurveyService;
import net.domaszk.survey.survey.persistence.entity.SurveyEntity;
import net.domaszk.survey.survey.rest.controller.api.SurveyRestController;
import net.domaszk.survey.survey.rest.dto.SurveyCreateDto;
import net.domaszk.survey.survey.rest.dto.SurveyDto;
import net.domaszk.survey.survey.rest.mapper.SurveyRestMapper;
import net.domaszk.survey.user.persistence.id.UserId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class DefaultSurveyRestController implements SurveyRestController {

    private final SurveyService service;
    private final SurveyRestMapper mapper;

    @Override
    public ResponseEntity<IterableDto<SurveyDto>> getAllSurveys() {
        return ResponseEntity.ok().body(mapper.toDto(service.findAll()));
    }

    @Override
    public ResponseEntity<SurveyDto> getSurvey(UUID surveyId) {
        return ResponseEntity.ok().body(mapper.toDto(service.findById(surveyId)));
    }

    @Override
    public ResponseEntity<Void> addSurvey(SurveyCreateDto dto) {
        SurveyEntity entity = mapper.toEntity(dto);
        service.save(entity);

        return ResponseEntity.created(URI.create("/api/surveys/" + entity.getId()))
                .build();
    }

    @Override
    public ResponseEntity<Void> updateSurvey(UUID surveyId, SurveyCreateDto dto) {
        if ( !service.existsById(surveyId) ) {
            return ResponseEntity.notFound().build();
        }


        SurveyEntity entity = service.findById(surveyId);
        mapper.update(entity, dto);
        service.save(entity);

        return ResponseEntity.created(URI.create("/api/surveys/" + entity.getId()))
                .build();
    }

    @Override
    public ResponseEntity<Void> deleteSurvey(UUID surveyId) {
        service.delete(service.findById(surveyId));

        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<IterableDto<SurveyDto>> getUserSurveys(UUID userId) {
        return ResponseEntity.ok().body(
                mapper.toDto(service.findByCreator(UserId.of(userId))   )
        );
    }

    @Override
    public ResponseEntity<Void> deleteUserSurveys(UUID userId) {
        service.deleteByCreator(UserId.of(userId));

        return ResponseEntity.noContent().build();
    }
}
