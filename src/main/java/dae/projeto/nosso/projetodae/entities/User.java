package dae.projeto.nosso.projetodae.entities;

import dae.projeto.nosso.projetodae.enums.Role;
import dae.projeto.nosso.projetodae.enums.UserStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(
                name = "getAllUsers",
                query = "SELECT u FROM User u"),
        @NamedQuery(
                name = "getUserByName",
                query = "SELECT u FROM User u WHERE u.username = :username")
})

public class User {

    //Nao esta acabado
    //IDS NAS CLASSES TÊM DE SER LONG COM (L) MAIUSCULO

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @NotNull
    private String email;

    @NotNull
    private String password;


    @Enumerated(EnumType.STRING)
    private Role role; // COLABORADOR, RESPONSAVEL, ADMINISTRADOR

    @Enumerated(EnumType.STRING)
    private UserStatus status; // ATIVO, SUSPENSO

    @OneToMany
    private List<Publication> publications;

    @ManyToMany
    private List<Tag> subscribedTags;

}

