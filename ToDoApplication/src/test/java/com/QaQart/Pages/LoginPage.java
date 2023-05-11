package com.QaQart.Pages;

import com.QaQart.Base.BasePage;
import com.QaQart.utils.ConfigUtils;
import com.QaQart.utils.PropertiesUtils;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Properties;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailfield;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordfield;

    @FindBy(xpath = "//button[@id='submit']")
    private WebElement loginbutton;

    public LoginPage loadWebsite() {
       driver.get(ConfigUtils.getInstance().getBaseUrl());
        return this;
    }

    public TodoPage login(String email, String password) {
        emailfield.sendKeys(email);
        passwordfield.sendKeys(password);
        loginbutton.click();
        return new TodoPage(driver);
    }

}
