package com.max.garnet.entities;



import java.security.Timestamp;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "logs")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String gameName;

    @Column(updatable = false)
    private Timestamp timestamp;

    private String result; // Win/Lose/Draw
}

