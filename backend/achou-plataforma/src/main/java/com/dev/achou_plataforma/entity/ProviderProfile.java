package com.dev.achou_plataforma.entity;

import com.dev.achou_plataforma.entity.enums.Category;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.UUID;

import java.math.BigDecimal;

@Entity
@Table(name = "Providers_Profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class ProviderProfile {

    @UUID
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(nullable = false, length = 100)
    private String bio;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(nullable = false, length = 150)
    private String city;

    @Column(nullable = false, precision = 3, scale = 2)
    private BigDecimal averageRating;
}
