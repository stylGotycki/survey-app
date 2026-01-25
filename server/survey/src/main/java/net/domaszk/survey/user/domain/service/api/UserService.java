package net.domaszk.survey.user.domain.service.api;

import net.domaszk.survey.user.persistence.entity.UserEntity;

public interface UserService {

    UserEntity findByUsername(String username);

    UserEntity findByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

}
