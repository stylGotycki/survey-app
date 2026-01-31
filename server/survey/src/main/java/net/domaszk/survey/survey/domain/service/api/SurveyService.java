package net.domaszk.survey.survey.domain.service.api;

import net.domaszk.survey.survey.persistence.entity.SurveyEntity;
import net.domaszk.survey.user.domain.event.UserDeletedEvent;
import net.domaszk.survey.user.persistence.id.UserId;

import java.util.List;
import java.util.UUID;

public interface SurveyService {

    SurveyEntity findById(UUID id);

    List<SurveyEntity> findAll();

    void save(SurveyEntity entity);

    void delete(SurveyEntity entity);

    boolean existsById(UUID id);

    List<SurveyEntity> findByCreator(UserId creatorId);

    void deleteByCreator(UserId creatorId);

    void deleteByCreator(UserDeletedEvent event);

}
