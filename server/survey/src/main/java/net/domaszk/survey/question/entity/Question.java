package net.domaszk.survey.question.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name="questions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 128)
    private String name;

    @Column(nullable = false, length = 1024)
    private String content;

    @Column(nullable = false)
    private int minValue;

    @Column(nullable = false)
    private int maxValue;

    @Column(nullable = false)
    private int step;

    @Column(nullable = false)
    private QuestionType type;

}
