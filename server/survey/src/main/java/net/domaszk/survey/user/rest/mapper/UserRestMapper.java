package net.domaszk.survey.user.rest.mapper;

import lombok.RequiredArgsConstructor;
import net.domaszk.survey.common.rest.IterableDto;
import net.domaszk.survey.common.util.MapperUtil;
import net.domaszk.survey.user.persistence.entity.UserEntity;
import net.domaszk.survey.user.rest.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.stream.StreamSupport;

@Component
@RequiredArgsConstructor
public class UserRestMapper {

    private final MapperUtil util;

    public IterableDto<UserDto> toDto(Iterable<UserEntity> entities) {
        return IterableDto.<UserDto>builder()
                .items(StreamSupport.stream(entities.spliterator(), false)
                        .map(this::toDto)
                        .toList())
                .build();
    }


    public UserDto toDto(UserEntity entity) {
        return UserDto.builder()
                .username(entity.getUsername())
                .email(entity.getEmail())
                .build();
    }


    public void update(UserEntity entity, UserDto dto) {
        util.updateIfNotNull(dto::username, entity::setUsername);
        util.updateIfNotNull(dto::email, entity::setEmail);
    }
}
