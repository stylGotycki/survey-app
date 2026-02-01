package net.domaszk.survey.survey.rest.controller.impl;

import lombok.RequiredArgsConstructor;
import net.domaszk.survey.common.rest.IterableDto;
import net.domaszk.survey.survey.domain.service.api.SurveyService;
import net.domaszk.survey.survey.rest.controller.api.SurveyRestController;
import net.domaszk.survey.survey.rest.dto.SurveyDto;
import net.domaszk.survey.survey.rest.mapper.SurveyRestMapper;
import net.domaszk.survey.user.persistence.id.UserId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Void> addSurvey(SurveyDto surveyDto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> updateSurvey(SurveyDto surveyDto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteSurvey(UUID surveyId) {
        return null;
    }

    @Override
    public ResponseEntity<IterableDto<SurveyDto>> getUserSurveys(UUID userId) {
        return ResponseEntity.ok().body(
                mapper.toDto(service.findByCreator(UserId.of(userId)))
        );
    }

    @Override
    public ResponseEntity<Void> deleteUserSurveys(UUID userId) {
        return null;
    }
}
