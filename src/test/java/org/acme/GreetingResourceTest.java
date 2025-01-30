package org.acme;

import com.github.tomakehurst.wiremock.client.WireMock;
import io.quarkiverse.wiremock.devservice.ConnectWireMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@ConnectWireMock
class GreetingResourceTest {
    WireMock wiremock;
    @Test
    void testHelloEndpoint() {

        wiremock.register(get(urlEqualTo("/hello"))
                                  .willReturn(aResponse().withStatus(200).withBody("THIS IS MY TEST BODY")));
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("THIS IS MY TEST BODY"));
    }

}