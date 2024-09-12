package com.example;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class DeleteAPITest extends BaseTest {

    @Test
    public void testDeleteApi() {
        // Sending DELETE request
        Response response = given()
                .when()
                .delete("/posts/1")
                .then()
                .extract()
                .response();

        // Print response body
        System.out.println("Response Body: " + response.getBody().asString());

        // Assert status code is 200
        assertEquals(response.getStatusCode(), 200);
    }
}
