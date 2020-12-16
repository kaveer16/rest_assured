package com.studentapp.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.patch;

public class StudentPatchTest extends TestBase {


    @Test
    public void updateEmailOfStudent() {
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setEmail("rocky@gmail.com");
        Response response = given().log().all()
                .header("Content-Type","application/json")
                .when()
                .body(studentPojo)
                .patch("/3");
        response.then().statusCode(200);
        response.prettyPrint();

    }


    }
