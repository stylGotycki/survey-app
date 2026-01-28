package net.domaszk.survey.survey.domain.service.impl;

import net.domaszk.survey.common.base.AbstractBaseService;
import net.domaszk.survey.survey.domain.service.api.SurveyService;
import net.domaszk.survey.survey.persistence.entity.SurveyEntity;
import net.domaszk.survey.survey.persistence.repository.SurveyRepository;

import java.util.UUID;

public class DefaultSurveyService extends AbstractBaseService<SurveyEntity, UUID> implements SurveyService {

    private final SurveyRepository surveyRepository;

    public DefaultSurveyService(SurveyRepository surveyRepository) {
        super(surveyRepository);
        this.surveyRepository = surveyRepository;
    }



}
