package com.dev.v1.achou_api.model.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table(name = "tb_assessments")
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder 
@EqualsAndHashCode(of = "id")
public class Assessment {

    @Id 
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "scheduling_id", nullable = false, unique = true)
    private Scheduling scheduling;

    @Column(nullable = false)
    private Integer note;

    @Column(nullable = false)
    private String comment;
}
