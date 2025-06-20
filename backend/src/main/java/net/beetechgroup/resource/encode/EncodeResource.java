package net.beetechgroup.resource.encode;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import net.beetechgroup.service.SaveURL;
import org.jboss.resteasy.reactive.RestResponse;

@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
@Path("/")
public class EncodeResource {

    private final SaveURL saveURL;

    @POST
    public RestResponse<EncodeOutput> encode(EncodeInput encodeInput) {
        return RestResponse.ok(saveURL.execute(encodeInput));
    }

}
