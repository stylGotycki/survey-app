package net.domaszk.survey.survey.domain.service.impl;

import net.domaszk.survey.common.base.AbstractBaseService;
import net.domaszk.survey.survey.domain.service.api.SurveyService;
import net.domaszk.survey.survey.persistence.entity.SurveyEntity;
import net.domaszk.survey.survey.persistence.repository.SurveyRepository;
import net.domaszk.survey.user.domain.event.UserDeletedEvent;
import net.domaszk.survey.user.persistence.id.UserId;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.UUID;

@Service
public class DefaultSurveyService extends AbstractBaseService<SurveyEntity, UUID> implements SurveyService {

    private final SurveyRepository repository;

    public DefaultSurveyService(SurveyRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public void deleteByCreator(UserId id) {
        repository.deleteByCreator(id);
    }


}
