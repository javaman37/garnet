package com.max.garnet.entities;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bets")
@Data
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "game_type")
    private String gameType;

    private BigDecimal bet_amount;

    private BigDecimal win_amount;

    private BigDecimal rolling;

    @Column(updatable = false)
    private LocalDateTime created_at;
    
    private String gameCompany;
    private String gameName;
    private String roundId;
    
    @Column(name = "fraudulent_amount", precision = 18, scale = 2, nullable = false)
    private BigDecimal fraudulentAmount = BigDecimal.ZERO;

    @Column(name = "is_cheating", nullable = false)
    private Boolean isCheating = false;

}

