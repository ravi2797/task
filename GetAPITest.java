package com.example;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class GetAPITest extends BaseTest {

    @Test
    public void testGetApi() {
        // Sending a GET request to /posts/1
        Response response = given()
                .when()
                .get("/posts/1")
                .then()
                .extract()
                .response();

        // Print response body
        System.out.println("Response Body: " + response.getBody().asString());

        // Assert the status code is 200
        assertEquals(response.getStatusCode(), 200);

        // Additional validation (optional)
        assertEquals(response.jsonPath().getString("userId"), "1");
    }
}
