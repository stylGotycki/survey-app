package net.domaszk.survey.question.rest.controller.api;

import net.domaszk.survey.common.rest.IterableDto;
import net.domaszk.survey.question.rest.dto.QuestionCreateDto;
import net.domaszk.survey.question.rest.dto.QuestionDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface QuestionRestController {

    @GetMapping(path="/api/questions")
    ResponseEntity<IterableDto<QuestionDto>> getAllQuestions();


    @GetMapping(path="/api/questions/{questionId}")
    ResponseEntity<QuestionDto> getQuestion(@PathVariable UUID questionId);


    @PostMapping(path="/api/questions", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> addQuestion(@RequestBody QuestionCreateDto dto);


    @PutMapping(path="/api/questions/{questionId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> updateQuestion(@PathVariable UUID questionId, @RequestBody QuestionCreateDto dto);


    @DeleteMapping(path="/api/questions/{questionId}")
    ResponseEntity<Void> deleteQuestion(@PathVariable UUID questionId);

    // users
    @GetMapping(path="/api/users/{userId}/questions")
    ResponseEntity<IterableDto<QuestionDto>> getUserQuestions(@PathVariable UUID userId);


    @DeleteMapping(path="/api/users/{userId}/questions")
    ResponseEntity<Void> deleteUserQuestions(@PathVariable UUID userId);

}
