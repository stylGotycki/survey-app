package net.domaszk.survey.survey.domain.service.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.domaszk.survey.survey.domain.service.api.SurveyService;
import net.domaszk.survey.survey.persistence.entity.SurveyEntity;
import net.domaszk.survey.survey.persistence.repository.SurveyRepository;
import net.domaszk.survey.user.domain.event.UserDeletedEvent;
import net.domaszk.survey.user.persistence.id.UserId;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class DefaultSurveyService implements SurveyService {

    private final SurveyRepository repository;
    private final ApplicationEventPublisher applicationEventPublisher;


    @Override
    public SurveyEntity findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<SurveyEntity> findAll() {
        return List.of();
    }

    @Override
    public void save(SurveyEntity entity) {

    }

    @Override
    public void delete(SurveyEntity entity) {

    }

    @Override
    public boolean existsById(UUID id) {
        return false;
    }

    @Override
    public List<SurveyEntity> findByCreator(UserId creatorId) {
        return List.of();
    }

    @Override
    public void deleteByCreator(UserId creatorId) {

    }

    @Override
    @ApplicationModuleListener
    @Transactional
    public void deleteByCreator(UserDeletedEvent event) {
        repository.deleteByCreator(event.userId());
        System.out.println("DELETED SURVEYS WHICH REFERENCED USER WITH ID: " + event.userId());
    }
}
