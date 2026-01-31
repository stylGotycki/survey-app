package net.domaszk.survey.user.domain.service.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.domaszk.survey.user.domain.event.UserDeletedEvent;
import net.domaszk.survey.user.persistence.entity.UserEntity;
import net.domaszk.survey.user.persistence.id.UserId;
import net.domaszk.survey.user.persistence.repository.UserRepository;
import net.domaszk.survey.user.domain.service.api.UserService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DefaultUserService implements UserService {

    private final UserRepository repository;
    private final ApplicationEventPublisher eventPublisher;


    @Override
    public UserEntity findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }


    @Override
    public List<UserEntity> findAll() {
        return repository.findAll();
    }


    @Override
    public void save(UserEntity entity) {
        // todo: validation logic
        repository.save(entity);
    }

    @Transactional
    public void delete(UserEntity entity) {
        repository.delete(entity);
        System.out.println("DELETED USER WITH ID: " + entity.getId());
        eventPublisher.publishEvent(new UserDeletedEvent(UserId.of(entity.getId())));
    }

    @Override
    public UserEntity findByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(EntityNotFoundException::new);
    }


    @Override
    public UserEntity findByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public boolean existsById(UUID id) {
        return repository.existsById(id);
    }


    @Override
    public boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }


    @Override
    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }
}
