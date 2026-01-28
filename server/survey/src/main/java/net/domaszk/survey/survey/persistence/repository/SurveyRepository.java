package net.domaszk.survey.survey.persistence.repository;

import jakarta.transaction.Transactional;
import net.domaszk.survey.common.base.BaseRepository;
import net.domaszk.survey.survey.persistence.entity.SurveyEntity;
import net.domaszk.survey.user.persistence.id.UserId;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SurveyRepository extends BaseRepository<SurveyEntity, UUID> {

    @Transactional
    void deleteByCreator(UserId creator);
}
