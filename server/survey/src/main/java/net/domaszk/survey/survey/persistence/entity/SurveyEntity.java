package net.domaszk.survey.survey.persistence.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.domaszk.survey.user.persistence.id.UserId;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name="surveys")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SurveyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "creator_id", nullable = false))
    private UserId creator;

    @Column(unique = true, nullable = false, length = 128)
    private String name;

    @Column(unique = true, nullable = false, length = 1024)
    private String description;


    private Instant createdAt;


    private Instant lastModifiedAt;


    private Instant deletedAt;
}
