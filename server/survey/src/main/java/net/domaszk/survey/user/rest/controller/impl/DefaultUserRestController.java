package net.domaszk.survey.user.rest.controller.impl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.domaszk.survey.common.rest.IterableDto;
import net.domaszk.survey.user.persistence.entity.UserEntity;
import net.domaszk.survey.user.rest.controller.api.UserRestController;
import net.domaszk.survey.user.rest.dto.UserDto;
import net.domaszk.survey.user.domain.service.api.UserService;
import net.domaszk.survey.user.rest.mapper.UserRestMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class DefaultUserRestController implements UserRestController {

    private final UserService userService;
    private final UserRestMapper userMapper;

    @Override
    public ResponseEntity<IterableDto<UserDto>> getAllUsers() {
        Iterable<UserEntity> entities = userService.findAll();

        return ResponseEntity.ok().body(userMapper.toDto(entities));
    }


    @Override
    public ResponseEntity<UserDto> getUser(UUID userId) {
        UserEntity entity = userService.findById(userId);

        return ResponseEntity.ok().body(userMapper.toDto(entity));
    }


    @Override
    public ResponseEntity<Void> updateUser(UUID userId, @Valid UserDto dto) {
        UserEntity entity = userService.findById(userId);

        userMapper.update(entity, dto);
        userService.save(entity);

        return ResponseEntity.created(URI.create("/api/users/" + userId)).build();
    }


    @Override
    public ResponseEntity<Void> deactivateUser(UUID userId) {
        UserEntity entity = userService.findById(userId);

        entity.setActive(false);
        userService.save(entity);

        return ResponseEntity.ok().build();
    }
}
