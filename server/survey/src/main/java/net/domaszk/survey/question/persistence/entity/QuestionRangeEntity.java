package net.domaszk.survey.question.persistence.entity;

import jakarta.persistence.*;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name="question_ranges")
public class QuestionRangeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    @ToString.Exclude
    private QuestionEntity question;


    private int startValue;

    private int endValue;

    private int step;

    private String labelMin;

    private String labelMax;

}
