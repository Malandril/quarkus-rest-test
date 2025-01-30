package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.io.InputStream;

@RegisterRestClient(configKey="waow")
public interface MyRemoteService {

    @GET
    @Path("/hello")
    InputStream getExtensionsById();
}
