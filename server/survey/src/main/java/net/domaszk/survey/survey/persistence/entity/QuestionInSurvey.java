package net.domaszk.survey.survey.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.domaszk.survey.survey.persistence.id.QuestionInSurveyId;

import java.time.Instant;

@Entity
@Table(name="question_in_survey")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionInSurvey {

    @EmbeddedId
    private QuestionInSurveyId id;

    private boolean active;

    @Column(name="added_at")
    private Instant addedAt;

}
