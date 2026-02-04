package net.domaszk.survey.question.persistence.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name="question_options")
@Data
public class QuestionOptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    @ToString.Exclude
    private QuestionEntity question;

    @Column(nullable = false, length = 1024)
    private String content;

    @Column(nullable = false, name="display_order")
    private int displayOrder;

}
