package com.max.garnet.models.entities;

import lombok.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PARTNERS")
public class Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal balance = BigDecimal.ZERO;

    private BigDecimal rolling = BigDecimal.ZERO;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Partner parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Partner> children;

    @Column(updatable = false)
    private Timestamp created_at;

    private Timestamp updated_at;
}

