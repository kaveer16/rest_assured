package com.studentapp.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StudentPostTest extends TestBase {

    @Test
    public void createStudent(){
        List<String > courses = new ArrayList<>();
        courses.add("JAVA");
        courses.add("API");
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("kaveer");
        studentPojo.setLastName("Malhotra");
        studentPojo.setEmail("kaveer1234@gmail.com");
        studentPojo.setProgramme("Api Testing");
        studentPojo.setCourses(courses);
        Response response = given().log().all()
                .header("Content-Type","application/json")
                .when()
                .body(studentPojo)
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }
}
