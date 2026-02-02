package net.domaszk.survey.question.domain.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import net.domaszk.survey.question.domain.service.api.QuestionService;
import net.domaszk.survey.question.persistence.entity.QuestionEntity;
import net.domaszk.survey.question.persistence.repository.QuestionRepository;
import net.domaszk.survey.user.domain.event.UserDeletedEvent;
import net.domaszk.survey.user.persistence.id.UserId;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DefaultQuestionService implements QuestionService {

    private final QuestionRepository repository;

    @Override
    public QuestionEntity findById(UUID id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<QuestionEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(QuestionEntity entity) {
        repository.save(entity);
    }

    @Override
    public void delete(QuestionEntity entity) {
        if (!repository.existsById(entity.getId())) {
            throw new EntityNotFoundException();
        }

        repository.delete(entity);
    }

    @Override
    public boolean existsById(UUID id) {
        return repository.existsById(id);
    }

    @Override
    public List<QuestionEntity> findByCreator(UserId creatorId) {
        return repository.findByCreator(creatorId);
    }

    @Override
    public void deleteByCreator(UserId creatorId) {
        repository.deleteByCreator(creatorId);
    }

    @Override
    @ApplicationModuleListener
    public void deleteByCreator(UserDeletedEvent event) {
        System.out.println("DELETED QUESTIONS WHICH REFERENCED USER WITH ID: UserId(value=91dd6380-ccf9-4617-962c-471df0828c6a)\n");
        repository.deleteByCreator(event.userId());
    }
}
