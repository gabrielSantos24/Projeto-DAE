package dae.projeto.nosso.projetodae.ws;

import dae.projeto.nosso.projetodae.dtos.UserDTO;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class UserResource {

    @EJB
    private UserBean userBean;

    @GET
    @Path("/")
    @RolesAllowed({"COLABORADOR", "RESPONSAVEL", "ADMINISTRADOR"})
    public Response getAllUsers() {
        List<UserDTO> users = userBean.getAll()
                .stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
        return Response.ok(users).build();
    }

}
