package com.studentapp.extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class SearchJsonPathExample {
    private static final String API_KEY = "75e3u4sgb2khg673cbv2gjup";

    @BeforeClass
    public static void inIt(){
        RestAssured.baseURI = "http://api.walmartlabs.com";
        RestAssured.basePath = "/v1";
    }

   /*  public void test001(){
        Response response = given()
                .queryParam("query", "Samsung")
                .queryParam("format", "json")
                .queryParam("apiKey", API_KEY)
                .when()
                .get("/search");
        response.then().log().all().statusCode(200);


    }*/

    // 1) Extract numItems
    @Test
    public void test001() {
        int numItem = given()

                .queryParam("query", "Samsung")
                .queryParam("format", "json")
                .queryParam("apiKey", API_KEY)
                .when()
                .get("/search")
                .then()
                .extract().path("numItems");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total number of items are: " + numItem );
        System.out.println("------------------End of Test---------------------------");

    }

    // 2) Extract query
    @Test
    public void test002() {
        String query= given()

                .queryParam("query", "Samsung")
                .queryParam("format", "json")
                .queryParam("apiKey", API_KEY)
                .when()
                .get("/search")
                .then()
                .extract().path("query");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The search query is: " + query);
        System.out.println("------------------End of Test---------------------------");

    }

    // 3) Extract first productName by providing list index value
    @Test
    public void test003() {

        String name = given()

                .queryParam("query", "Samsung")
                .queryParam("format", "json")
                .queryParam("apiKey", API_KEY)
                .when()
                .get("/search")
                .then()
                .extract().path("items[0].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The product name is: " + name );
        System.out.println("------------------End of Test---------------------------");
    }

    // 4) Get the first list from imageEntities for the first product
    @Test
    public void test004() {

        HashMap entity = given()

                .queryParam("query", "Samsung")
                .queryParam("format", "json")
                .queryParam("apiKey", API_KEY)
                .when()
                .get("/search")
                .then()
                .extract().path("items[0].imageEntities[0]");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The gift options under the first product are: " + entity );
        System.out.println("------------------End of Test---------------------------");

    }



}
