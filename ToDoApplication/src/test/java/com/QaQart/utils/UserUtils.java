package com.QaQart.utils;

import com.QaQart.POJO.UsersPojo;
import com.github.javafaker.Faker;

public class UserUtils {
    private String firstname = new Faker().name().firstName();
    private String lastname = new Faker().name().lastName();
    private String email = new Faker().internet().emailAddress();
    private String password = new Faker().internet().password();


    public UsersPojo generateNewUsers() {

        UsersPojo users = new UsersPojo(email, firstname, lastname, password);
        return users;

    }
}
