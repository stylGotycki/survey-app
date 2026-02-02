package net.domaszk.survey.question.persistence.id;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Data
public class QuestionId implements Serializable {

    private UUID value;

}
