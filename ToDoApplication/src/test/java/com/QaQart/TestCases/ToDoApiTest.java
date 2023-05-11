package com.QaQart.TestCases;

import com.QaQart.Base.BaseTest;
import com.QaQart.Pages.LoginPage;
import com.QaQart.Pages.ToDoApiPage;
import com.QaQart.Pages.TodoPage;
import com.QaQart.api.RegisterApi;
import com.QaQart.api.TasksApi;
import com.QaQart.utils.ConfigUtils;
import io.restassured.http.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ToDoApiTest extends BaseTest {
    @Test
    public void shouldBeAbleToAddToDo() {

        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
        ToDoApiPage toDoApiPage = new ToDoApiPage(driver);
        toDoApiPage.load();
        injectCookies(registerApi.getRestAssuredCookies());

        String actualResult = toDoApiPage
                .load()
                .clickPlus()
                .addNewTodo("learn selenium")
                .toDoText();
        Assert.assertEquals(actualResult, "learn selenium");
        System.out.println(registerApi.getAccessToken());
    }

    @Test
    public void shouldBeAbleToDeleteToDo() {
        RegisterApi registerApi = new RegisterApi();
        TasksApi tasksApi = new TasksApi();
        ToDoApiPage toDoApiPage = new ToDoApiPage(driver);

        registerApi.register();
        tasksApi.addTask(registerApi.getAccessToken());
        toDoApiPage.load();
        injectCookies(registerApi.getRestAssuredCookies());

        boolean welcomeMessageIsDisplayed = toDoApiPage
                .load()
                .clickDelete()
                .welcomeMessageIsDisplayed();
        Assert.assertTrue(welcomeMessageIsDisplayed);
    }
}
