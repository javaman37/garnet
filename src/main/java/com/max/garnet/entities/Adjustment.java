package com.max.garnet.entities;

import lombok.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "adjustments")
public class Adjustment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "partner_id")
    private Partner partner;

    private BigDecimal adjustment_amount;

    @Column(name = "adjustment_type")
    private String adjustmentType;

    @Column(updatable = false)
    private Timestamp created_at;
}

