package com.max.garnet.entities;

import java.security.Timestamp;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "affiliations")
public class Affiliation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;
    private String type;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Affiliation parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Affiliation> children;

    @Column(updatable = false)
    private Timestamp created_at;

    private Timestamp updated_at;
}