// src/main/java/dae/projeto/nosso/projetodae/ejb/UserBean.java
package dae.projeto.nosso.projetodae.ejb;

import dae.projeto.nosso.projetodae.entities.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UserBean {
    @PersistenceContext
    private EntityManager em;

    public List<User> getAll() {
        return em.createNamedQuery("getAllUsers", User.class).getResultList();
    }
}
