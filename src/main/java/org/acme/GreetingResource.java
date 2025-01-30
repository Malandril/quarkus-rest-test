package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.io.IOException;
import java.io.InputStream;

@Path("/hello")
public class GreetingResource {

    @Inject
    @RestClient
    MyRemoteService myRemoteService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() throws IOException {
        try (InputStream extensionsById = myRemoteService.getExtensionsById()) {
            return new String(extensionsById.readAllBytes());
        }
//        return myRemoteService.getExtensionsById();
    }
}
