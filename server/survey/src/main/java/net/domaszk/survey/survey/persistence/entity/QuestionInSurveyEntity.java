package net.domaszk.survey.survey.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.domaszk.survey.survey.persistence.id.QuestionInSurveyId;

import java.time.Instant;

@Entity
@Table(name="questions_in_survey")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionInSurveyEntity {

    @EmbeddedId
    private QuestionInSurveyId questionId;

    @Builder.Default
    private boolean active = true;

    @Column(name="added_at")
    private Instant addedAt;

}
