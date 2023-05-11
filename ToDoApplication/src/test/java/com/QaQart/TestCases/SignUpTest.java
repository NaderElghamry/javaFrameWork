package com.QaQart.TestCases;

import com.QaQart.Base.BaseTest;
import com.QaQart.Pages.SignUpPage;
import com.QaQart.utils.ConfigUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {
    @Test
    public void shouldBeAbleToSignUp(){
        SignUpPage signUpPage = new SignUpPage(driver);
       boolean welcomeMessageIsDisplayed=  signUpPage
                .loadWebsite()
                .signUp(ConfigUtils.getInstance().getFirstName(),
                        ConfigUtils.getInstance().getLastMame(),
                        ConfigUtils.getInstance().getSignUpEmail(),
                        ConfigUtils.getInstance().getSignUpPassword(),
                        ConfigUtils.getInstance().getConfirmPassword())
                .welcomeMessageIsDisplayed();
        Assert.assertTrue(welcomeMessageIsDisplayed);
    }
}
