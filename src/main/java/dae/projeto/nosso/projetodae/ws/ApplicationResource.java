// src/main/java/dae/projeto/nosso/projetodae/ws/PublicationResource.java
package dae.projeto.nosso.projetodae.ws;

import dae.projeto.nosso.projetodae.ejb.PublicationBean;
import dae.projeto.nosso.projetodae.entities.Publication;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/publications")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PublicationResource {
    @EJB private PublicationBean publicationBean;

    @GET @PermitAll
    public Response list(@QueryParam("page") @DefaultValue("0") int page,
                         @QueryParam("size") @DefaultValue("10") int size) {
        List<Publication> data = publicationBean.list(page, size);
        return Response.ok(data).build();
    }

    @GET @Path("/{id}") @PermitAll
    public Response get(@PathParam("id") Long id) {
        Publication p = publicationBean.find(id);
        if (p == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(p).build();
    }
}
