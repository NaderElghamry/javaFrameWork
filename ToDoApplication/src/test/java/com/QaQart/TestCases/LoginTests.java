package com.QaQart.TestCases;

import com.QaQart.Base.BaseTest;
import com.QaQart.Factory.DriverFactory;
import com.QaQart.Pages.LoginPage;
import com.QaQart.Pages.TodoPage;
import com.QaQart.utils.ConfigUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

//    @DataProvider(name = "TestData")
//    public static Object[][] Data() {
//        return new Object[][]{
//                  {"naderbailey97@gmail.com", "blackdeath"}      // happy scenario
//                , {"naderbaiiiley97@gmail.com", "blackdeath"}    // invalid e-mail
//                , {"naderbailey97@gmail.com", "blackdeathttt"}   // invalid password
//        };
//    }

    @Test
    public void ShouldBeAbleToLogin() {

        LoginPage loginPage = new LoginPage(driver);
        boolean iswelcomemessagedisplayed =
                loginPage
                        .loadWebsite()
                        .login(ConfigUtils.getInstance().getEmail(),
                               ConfigUtils.getInstance().getPassword())
                        .welcomeMessageIsDisplayed();

        Assert.assertTrue(iswelcomemessagedisplayed);

    }
}
