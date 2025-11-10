package dae.projeto.nosso.projetodae.entities;

import dae.projeto.nosso.projetodae.enums.ActivityType;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "activities")

public class Activity implements Serializable {

    //nao esta acabado

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ActivityType type; // UPLOAD, EDIT, COMMENT, RATING, etc.

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "entity_type")
    private String entityType; // "Publication", "Comment", etc.

    @Column(name = "entity_id")
    private Long entityId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date timestamp;
}
