package com.QaQart.api;

import com.QaQart.POJO.TasksPojo;
import com.QaQart.utils.ConfigUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class TasksApi {

    public void addTask(String token){

        TasksPojo tasksPojo = new TasksPojo("learn selenium" , false);
        Response response;
        response=
      given()
                .baseUri(ConfigUtils.getInstance().getBaseUrl())
                .header("Content-type", "application/json")
                .body(tasksPojo)
                .log().all()
                .auth().oauth2(token)
      .when()
                .post("/api/v1/tasks")
      .then()
                .log().all()
                .assertThat().statusCode(201)
                .extract().response();
    }
}
