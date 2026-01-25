package net.domaszk.survey.user.rest.dto;

import lombok.Builder;

@Builder
public record UserDto(
        String username,
        String email
) {

}
