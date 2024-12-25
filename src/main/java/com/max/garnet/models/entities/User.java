package com.max.garnet.models.entities;

import lombok.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String email;

    private String role;

    private BigDecimal balance = BigDecimal.ZERO;

    private BigDecimal rolling = BigDecimal.ZERO;

    @Column(updatable = false)
    private Timestamp created_at;
}
