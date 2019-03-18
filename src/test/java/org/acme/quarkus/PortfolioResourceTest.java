package org.acme.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.iterableWithSize;

@QuarkusTest
public class PortfolioResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/portfolio?per_page=5&page=2")
          .then()
             .statusCode(200)
             .body("$.size()", is(5));
    }

}