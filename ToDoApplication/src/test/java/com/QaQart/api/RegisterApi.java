package com.QaQart.api;

import com.QaQart.POJO.UsersPojo;
import com.QaQart.utils.ConfigUtils;
import com.QaQart.utils.UserUtils;
import io.restassured.*;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import java.util.List;

public class RegisterApi {
    private static List<Cookie> restAssuredCookies;
    private static String accessToken;
    private static String userId;
    private static String firstName;


    public void register() {
        UsersPojo users = new UserUtils().generateNewUsers();
        Response response;
        response = RestAssured
                .given()
                .baseUri(ConfigUtils.getInstance().getBaseUrl())
                .header("Content-type", "application/json")
                .body(users)
                .log().all()
                .when()
                .post("/api/v1/users/register")
                .then()
                .assertThat().statusCode(201)
                .log().all()
                .extract().response();

        restAssuredCookies = response.detailedCookies().asList();
        accessToken = response.path("access_token");
        userId = response.path("userID");
        firstName = response.path("firstName");

    }

    public List<Cookie> getRestAssuredCookies() {
        return restAssuredCookies;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }
}
