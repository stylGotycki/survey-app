package net.domaszk.survey.survey.persistence.entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name="survey_events")
public class SurveyEvents {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="survey_id", nullable = false)
    private UUID surveyId;

    private Instant start;

    private Instant end;

}

