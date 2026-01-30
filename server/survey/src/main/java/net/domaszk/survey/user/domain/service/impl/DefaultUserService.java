package net.domaszk.survey.user.domain.service.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.domaszk.survey.common.base.AbstractBaseService;
import net.domaszk.survey.user.domain.event.UserDeletedEvent;
import net.domaszk.survey.user.persistence.entity.UserEntity;
import net.domaszk.survey.user.persistence.id.UserId;
import net.domaszk.survey.user.persistence.repository.UserRepository;
import net.domaszk.survey.user.domain.service.api.UserService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DefaultUserService extends AbstractBaseService<UserEntity, UUID> implements UserService {

    private final UserRepository userRepository;
    private final ApplicationEventPublisher eventPublisher;

    public DefaultUserService(UserRepository userRepository, ApplicationEventPublisher eventPublisher) {
        super(userRepository);
        this.userRepository = userRepository;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void delete(UserEntity entity) {
        super.delete(entity);
        eventPublisher.publishEvent(new UserDeletedEvent(UserId.of(entity.getId())));
        System.out.println("DELETED SURVEYS WHICH REFERENCED USER 1");
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(EntityNotFoundException::new);
    }


    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(EntityNotFoundException::new);
    }


    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }


    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
