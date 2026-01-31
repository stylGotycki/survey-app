package net.domaszk.survey.user.domain.service.api;

import net.domaszk.survey.user.persistence.entity.UserEntity;

import java.util.List;
import java.util.UUID;

public interface UserService {

    UserEntity findById(UUID id);

    List<UserEntity> findAll();

    void save(UserEntity entity);

    void delete(UserEntity entity);

    UserEntity findByUsername(String username);

    UserEntity findByEmail(String email);


    boolean existsById(UUID id);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);


}
