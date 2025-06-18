package net.beetechgroup.resource;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import net.beetechgroup.service.FindURLByCode;

@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
@Path("/")
public class DecodeResource {

    private final FindURLByCode findURLByCode;

    @GET
    @Path("/{code}")
    public Response decode(@PathParam("code") String code) {
        return Response
                .temporaryRedirect(URI.create(findURLByCode.execute(code)))
                .build();
    }

}
