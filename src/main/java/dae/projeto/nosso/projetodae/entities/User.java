package dae.projeto.nosso.projetodae.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(
                name = "getAllSubjects",
                query = "SELECT u FROM User u"),
        @NamedQuery(
                name = "getUserByName",
                query = "SELECT u FROM User u WHERE u.username = :username")
})

public class User {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String email;

    @NotNull
    private String password;



}
