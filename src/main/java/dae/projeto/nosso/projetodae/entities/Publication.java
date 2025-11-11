// src/main/java/dae/projeto/nosso/projetodae/entities/Publication.java
package dae.projeto.nosso.projetodae.entities;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "publications")
public class Publication {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) private String title;
    @Column(nullable = false) private String authors;
    @Column(nullable = false) private String scientificArea;
    @Column(columnDefinition = "text") private String summary;
    @Column(nullable = false) private boolean visible = true;
    @Column(nullable = false) private String filename;

    @Temporal(TemporalType.TIMESTAMP) @Column(nullable = false)
    private Date createdAt = new Date();

    @Temporal(TemporalType.TIMESTAMP) @Column(nullable = false)
    private Date updatedAt = new Date();

    @ManyToOne(optional = false)
    @JoinColumn(name = "uploaded_by_id")
    private User uploadedBy;

    @ManyToMany
    @JoinTable(name = "publication_tags",
            joinColumns = @JoinColumn(name = "publication_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags = new ArrayList<>();

    // getters/setters...
}
