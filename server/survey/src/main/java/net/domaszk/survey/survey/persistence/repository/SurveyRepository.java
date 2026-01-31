package net.domaszk.survey.survey.persistence.repository;

import jakarta.transaction.Transactional;
import net.domaszk.survey.survey.persistence.entity.SurveyEntity;
import net.domaszk.survey.user.persistence.id.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SurveyRepository extends JpaRepository<SurveyEntity, UUID> {

    List<SurveyEntity> findByCreator(UserId creator);

    @Transactional
    void deleteByCreator(UserId creator);
}
