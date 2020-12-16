package com.studentapp.studentinfo;

import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StudentDeleteTest extends TestBase {
    @Test
    public void deleteStudentRecord() {
        Response response = given().log().all()
                .when()
                .delete("/22");
        response.then().log().all().statusCode(202);
        response.prettyPrint();
    }
}