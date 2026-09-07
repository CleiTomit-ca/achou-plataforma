package com.dev.achou_plataforma.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "services")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of =  "id")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "provider_profile_id", referencedColumnName = "id")
    private ProviderProfile providerProfile;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 150)
    private String description;

    @Column(nullable = false)
    private Integer durationMinutes;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal price;
}
