package net.domaszk.survey.question.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.domaszk.survey.user.persistence.id.UserId;

import java.util.UUID;

@Entity
@Table(name="questions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @AttributeOverride(name = "value", column = @Column(name = "creator_id", nullable = false))
    private UserId creator;

    @Column(nullable = false, length = 128)
    private String name;

    @Column(nullable = false, length = 1024)
    private String content;

    private int minValue;

    private int maxValue;

    private int step;

    @Column(nullable = false)
    private QuestionType type;

}
