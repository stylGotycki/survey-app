package net.domaszk.survey.user.rest.controller.api;

import net.domaszk.survey.common.rest.IterableDto;
import net.domaszk.survey.user.rest.dto.UserDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface UserRestController {

    @GetMapping(path="/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<IterableDto<UserDto>> getAllUsers();


    @GetMapping(path="/api/users/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserDto> getUser(@PathVariable UUID userId);


    @PutMapping(path="/api/users/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> updateUser(@PathVariable UUID userId, @RequestBody UserDto userDto);


    @DeleteMapping(path="/api/users/{userId}/deactivate")
    ResponseEntity<Void> deactivateUser(@PathVariable UUID userId);

}
