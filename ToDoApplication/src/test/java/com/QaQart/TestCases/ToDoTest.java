package com.QaQart.TestCases;

import com.QaQart.Base.BaseTest;
import com.QaQart.Pages.LoginPage;
import com.QaQart.Pages.NewToDoPage;
import com.QaQart.Pages.TodoPage;
import com.QaQart.utils.ConfigUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ToDoTest extends BaseTest {


    @Test(priority = 2)
    public void shouldBeableToAddToDo() {
        LoginPage loginPage = new LoginPage(driver);
        String actualResult = loginPage
                .loadWebsite()
                .login(ConfigUtils.getInstance().getEmail(),
                        ConfigUtils.getInstance().getPassword())
                .clickPlus()
                .addNewTodo("learn selenium").toDoText();
        Assert.assertEquals(actualResult, "learn selenium");
    }

    @Test(priority = 3, enabled = false)
    public void shouldBeableTodeleteToDo() {
        LoginPage loginPage = new LoginPage(driver);
        TodoPage todoPage = new TodoPage(driver);
        boolean todomessageispisplayed = loginPage
                .loadWebsite()
                .login(ConfigUtils.getInstance().getEmail(),
                        ConfigUtils.getInstance().getPassword())
                .clickPlus()
                .addNewTodo("learn selenium")
                .clickDelete()
                .noToDoMssgDisplayed();

        Assert.assertTrue(todomessageispisplayed);

    }


}
