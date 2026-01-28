package net.domaszk.survey.survey.domain.service.impl;

import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import net.domaszk.survey.common.base.AbstractBaseService;
import net.domaszk.survey.survey.domain.service.api.SurveyService;
import net.domaszk.survey.survey.persistence.entity.SurveyEntity;
import net.domaszk.survey.survey.persistence.repository.SurveyRepository;
import net.domaszk.survey.user.domain.event.UserDeletedEvent;
import net.domaszk.survey.user.persistence.id.UserId;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DefaultSurveyService extends AbstractBaseService<SurveyEntity, UUID> implements SurveyService {

    private final SurveyRepository surveyRepository;

    public DefaultSurveyService(SurveyRepository surveyRepository) {
        super(surveyRepository);
        this.surveyRepository = surveyRepository;
    }

    @ApplicationModuleListener
    @Transactional
    void onUserDeleted(UserDeletedEvent event) {

        surveyRepository.deleteByCreator(event.userId());

        System.out.println("DELETED SURVEYS WHICH REFERENCED USER 2");
    }


}
