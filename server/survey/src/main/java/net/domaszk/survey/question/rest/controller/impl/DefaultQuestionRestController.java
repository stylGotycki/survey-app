package net.domaszk.survey.question.rest.controller.impl;

import lombok.RequiredArgsConstructor;
import net.domaszk.survey.common.rest.IterableDto;
import net.domaszk.survey.question.domain.service.api.QuestionService;
import net.domaszk.survey.question.rest.controller.api.QuestionRestController;
import net.domaszk.survey.question.rest.dto.QuestionCreateDto;
import net.domaszk.survey.question.rest.dto.QuestionDto;
import net.domaszk.survey.question.rest.mapper.QuestionRestMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class DefaultQuestionRestController implements QuestionRestController {

    private final QuestionService service;
    private final QuestionRestMapper mapper;

    @Override
    public ResponseEntity<IterableDto<QuestionDto>> getAllQuestions() {
        return null;
    }

    @Override
    public ResponseEntity<QuestionDto> getQuestion(UUID questionId) {
        return null;
    }

    @Override
    public ResponseEntity<Void> addQuestion(QuestionCreateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> updateQuestion(UUID questionId, QuestionCreateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteQuestion(UUID questionId) {
        return null;
    }

    @Override
    public ResponseEntity<IterableDto<QuestionDto>> getUserQuestions(UUID userId) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteUserQuestions(UUID userId) {
        return null;
    }
}
