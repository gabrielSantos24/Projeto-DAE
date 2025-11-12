// src/main/java/dae/projeto/nosso/projetodae/dtos/UserDTO.java
package dae.projeto.nosso.projetodae.dtos;

import dae.projeto.nosso.projetodae.entities.User;
import dae.projeto.nosso.projetodae.enums.Role;
import dae.projeto.nosso.projetodae.enums.UserStatus;
import java.util.Date;

public class UserDTO {
    public Long id;
    public String username;
    public String email;
    public Role role;
    public UserStatus status;
    public Date createdAt;
    public Date lastLogin;

    public UserDTO() {
    }

    public UserDTO(User u){
        this.id = u.getId();
        this.username = u.getUsername();
        this.email = u.getEmail();
        this.role = u.getRole();
        this.status = u.getStatus();
        this.createdAt = u.getCreatedAt();
        this.lastLogin = u.getLastLogin();
    }
}
