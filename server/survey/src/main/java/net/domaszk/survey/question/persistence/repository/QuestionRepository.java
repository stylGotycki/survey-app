package net.domaszk.survey.question.persistence.repository;

import net.domaszk.survey.question.persistence.entity.QuestionEntity;
import net.domaszk.survey.user.persistence.id.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity, UUID> {

    List<QuestionEntity> findByCreator(UserId creatorId);

    void deleteByCreator(UserId creatorId);

}
