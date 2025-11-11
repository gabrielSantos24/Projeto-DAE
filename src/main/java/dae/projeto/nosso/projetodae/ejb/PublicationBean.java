// src/main/java/dae/projeto/nosso/projetodae/ejb/PublicationBean.java
package dae.projeto.nosso.projetodae.ejb;

import dae.projeto.nosso.projetodae.entities.Publication;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PublicationBean {
    @PersistenceContext
    private EntityManager em;

    public List<Publication> list(int page, int size) {
        return em.createQuery("SELECT p FROM Publication p WHERE p.visible = true ORDER BY p.createdAt DESC", Publication.class)
                .setFirstResult(page * size)
                .setMaxResults(size)
                .getResultList();
    }

    public Publication find(Long id) { return em.find(Publication.class, id); }
}
