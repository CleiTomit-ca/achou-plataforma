package com.dev.achou_plataforma.entity;

import com.dev.achou_plataforma.entity.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 150, unique = true)
    @Email
    private String email;

    @Column(nullable = false)
    private String password_hash;

    @Column(nullable = false, length = 100)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "created_on", nullable = false)
    private LocalDateTime created_on;

    @PrePersist
    public void prePersist(){
        this.created_on = LocalDateTime.now();
    }
}
