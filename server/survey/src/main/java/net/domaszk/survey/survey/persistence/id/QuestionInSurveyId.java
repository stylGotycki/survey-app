package net.domaszk.survey.survey.persistence.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import org.jspecify.annotations.NonNull;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class QuestionInSurveyId implements Serializable {

    @Column(name = "survey_id", nullable = false)
    private UUID surveyId;

    @Column(name = "question_id", nullable = false)
    private UUID questionId;

}

