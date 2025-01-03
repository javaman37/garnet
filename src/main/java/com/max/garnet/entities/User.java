package com.max.garnet.entities;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String nickname;

    private String password;

    private String email;

    private String role;

    private BigDecimal balance = BigDecimal.ZERO;

    private BigDecimal rolling = BigDecimal.ZERO;

    @Column(updatable = false)
    private LocalDateTime created_at;
    
    @Column(name = "before_repayment")
    private BigDecimal beforeRepayment;

    @Column(name = "money_held")
    private BigDecimal moneyHeld;
    
    @ManyToOne
    @JoinColumn(name = "partner_id", referencedColumnName = "id")
    private Partner partner;

    @ManyToOne
    @JoinColumn(name = "affiliation_id", referencedColumnName = "id")
    private Affiliation affiliation;
    
    @Column(name = "phone_number")
    private String phoneNumber; 

    @Column(name = "situation")
    private String situation; 

	
}
