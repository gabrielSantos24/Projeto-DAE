package dae.projeto.nosso.projetodae.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "ratings")
public class Rating {

    //Nao esta acabado
    //IDS NAS CLASSES TÊM DE SER LONG COM (L) MAIUSCULO

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Max(5)
    @Min(1)
    @NotNull
    private int stars; // 1 - 5 estrelas

    @ManyToOne
    private User user;

    @ManyToOne
    private Publication publication;

    @Column
    private Date createdAt;

    @Column
    private Date updatedAt;

    public Rating() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }




}
