package com.QaQart.Pages;

import com.QaQart.Base.BasePage;
import com.QaQart.utils.ConfigUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-testid=\"first-name\"]")
    private WebElement first_name_field;

    @FindBy(css = "[data-testid=\"last-name\"]")
    private WebElement last_name_field;

    @FindBy(css = "[data-testid=\"email\"]")
    private WebElement email;

    @FindBy(css = "[data-testid=\"password\"]")
    private WebElement password;

    @FindBy(css = "[data-testid=\"confirm-password\"]")
    private WebElement confirm_password;

    @FindBy(css = "[data-testid=\"submit\"]")
    private WebElement submit_button;

    public SignUpPage loadWebsite(){
        driver.get(ConfigUtils.getInstance().getSignUpUrl());
        return this ;
    }
    public TodoPage signUp(String firstname , String lastname , String email , String password , String confirm_password ){
        first_name_field.sendKeys(firstname);
        last_name_field.sendKeys(lastname);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.confirm_password.sendKeys(confirm_password);
        submit_button.click();
        return new TodoPage(driver);


    }

}
