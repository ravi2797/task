package com.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
//import io.qameta.allure.Description;
//import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class PostAPITest extends BaseTest {

    @Test

    public void testPostApi() {
        // Request body for POST request
        String requestBody = "{ \"title\": \"New Post\", \"body\": \"This is a new post.\", \"userId\": 1 }";

        // Perform the POST request
        Response response = performPostRequest("/posts", requestBody);

        // Print response body
        System.out.println("Response Body: " + response.getBody().asString());

        // Assert the status code is 201 (Created)
        assertEquals(response.getStatusCode(), 201);

        // Assert the response contains the new post data
        assertEquals(response.jsonPath().getString("title"), "New Post");
    }

   // @Step("Perform POST request to endpoint: {endpoint} with body: {body}")
    private Response performPostRequest(String endpoint, String body) {
        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }
}
