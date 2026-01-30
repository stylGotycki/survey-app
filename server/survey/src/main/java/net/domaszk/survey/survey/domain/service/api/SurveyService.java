package net.domaszk.survey.survey.domain.service.api;

import net.domaszk.survey.common.base.BaseService;
import net.domaszk.survey.survey.persistence.entity.SurveyEntity;
import net.domaszk.survey.user.persistence.id.UserId;

import java.util.UUID;

public interface SurveyService extends BaseService<SurveyEntity, UUID> {

    void deleteByCreator(UserId userId);
}
