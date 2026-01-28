package net.domaszk.survey.survey.persistence.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.NonNull;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionInSurveyId implements Serializable, Comparable<QuestionInSurveyId> {

    @Column(name = "survey_id", nullable = false)
    private UUID surveyId;

    @Column(name = "question_id", nullable = false)
    private UUID questionId;


    @Override
    public int compareTo(@NonNull QuestionInSurveyId o) {
        int compare = this.surveyId.compareTo(o.surveyId);
        if (compare == 0) {
            return this.questionId.compareTo(o.questionId);
        }
        return compare;
    }
}

