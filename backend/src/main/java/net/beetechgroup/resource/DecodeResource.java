package net.beetechgroup.resource;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import net.beetechgroup.service.FindURLByCode;
import org.jboss.resteasy.reactive.RestResponse;

@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
@Path("/")
public class DecodeResource {

    private final FindURLByCode findURLByCode;

    @GET
    @Path("/{code}")
    public RestResponse<Void> decode(@PathParam("code") String code) {
        URI redirectUri = URI.create(findURLByCode.execute(code));
        return RestResponse.temporaryRedirect(redirectUri);
    }

}
