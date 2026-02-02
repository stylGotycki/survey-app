package net.domaszk.survey.question.domain.service.api;

import net.domaszk.survey.question.persistence.entity.QuestionEntity;
import net.domaszk.survey.user.domain.event.UserDeletedEvent;
import net.domaszk.survey.user.persistence.id.UserId;

import java.util.List;
import java.util.UUID;

public interface QuestionService {

    QuestionEntity findById(UUID id);

    List<QuestionEntity> findAll();

    void save(QuestionEntity entity);

    void delete(QuestionEntity entity);

    boolean existsById(UUID id);

    List<QuestionEntity> findByCreator(UserId creatorId);

    void deleteByCreator(UserId creatorId);

    void deleteByCreator(UserDeletedEvent event);

}
