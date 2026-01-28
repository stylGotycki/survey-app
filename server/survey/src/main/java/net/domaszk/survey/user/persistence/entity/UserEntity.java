package net.domaszk.survey.user.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, length = 32, nullable = false)
    private String username;

    @Column(unique = true, length = 64, nullable = false)
    private String email;

    @Column(length = 80, nullable = false, name="password_hash")
    private String passwordHash;

    @Column(name="last_login")
    private Instant lastLogin;

    @Builder.Default
    private boolean active = false;
}
