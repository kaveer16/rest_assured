//created by raj

package com.studentapp.studentinfo;

import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class StudentGetTest extends TestBase {
    @Test
    public void getAllStudentsInfo() {
        Response response = given()
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();
        // .then()
        // .statusCode(200);
    }

    @Test
    public void searchStudentWithParameter() {
        Response response = given()
                .queryParam("programme", "Financial Analysis")
                .queryParam("limit", 2)
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();
        // .then()
        // .statusCode(200);
    }

    @Test
    public void getSingleStudentsInfo() {
        Response response = given()
                .pathParam("id", 1)
                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();


    }
}
