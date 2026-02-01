package net.domaszk.survey.survey.rest.controller.api;


import net.domaszk.survey.common.rest.IterableDto;
import net.domaszk.survey.survey.rest.dto.SurveyDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface SurveyRestController {

    @GetMapping(path="/api/surveys")
    ResponseEntity<IterableDto<SurveyDto>> getAllSurveys();


    @GetMapping(path="/api/surveys/{surveyId}")
    ResponseEntity<SurveyDto> getSurvey(@PathVariable UUID surveyId);


    @PostMapping(path="/api/surveys", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> addSurvey(@RequestBody SurveyDto surveyDto);


    @PutMapping(path="/api/surveys", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> updateSurvey(@RequestBody SurveyDto surveyDto);


    @DeleteMapping(path="/api/surveys/{surveyId}")
    ResponseEntity<Void> deleteSurvey(@PathVariable UUID surveyId);

    // users
    @GetMapping(path="/api/users/{userId}/surveys")
    ResponseEntity<IterableDto<SurveyDto>> getUserSurveys(@PathVariable UUID userId);


    @DeleteMapping(path="/api/users/{userId}/surveys")
    ResponseEntity<Void> deleteUserSurveys(@PathVariable UUID userId);


}
