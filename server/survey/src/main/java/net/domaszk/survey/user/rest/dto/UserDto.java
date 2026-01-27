package net.domaszk.survey.user.rest.dto;

import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record UserDto(
        @Size(min=4, max=32) String username,
        @Size(min=4, max=64) String email
) {

}
