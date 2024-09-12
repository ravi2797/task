package com.example;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class PutAPITest extends BaseTest {

    @Test
    public void testPutApi() {
        // Body data for PUT request
        String requestBody = "{ \"Teja\": \"Updated Title\", \"body\": \"Updated Body\", \"userId\": 1 }";

        // Sending PUT request
        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put("/posts/1")
                .then()
                .extract()
                .response();

        // Print response body
        System.out.println("Response Body: " + response.getBody().asString());

        // Assert status code is 200
        assertEquals(response.getStatusCode(), 200);

        // Assert the response contains the updated title
        assertEquals(response.jsonPath().getString("title"), "Updated Title");
    }
}
