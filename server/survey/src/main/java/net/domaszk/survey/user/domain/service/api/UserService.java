package net.domaszk.survey.user.domain.service.api;

import net.domaszk.survey.common.base.BaseService;
import net.domaszk.survey.user.persistence.entity.UserEntity;
import java.util.UUID;

public interface UserService extends BaseService<UserEntity, UUID> {

    UserEntity findByUsername(String username);

    UserEntity findByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

}
