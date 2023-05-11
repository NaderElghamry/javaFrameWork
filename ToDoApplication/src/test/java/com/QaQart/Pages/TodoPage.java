package com.QaQart.Pages;

import com.QaQart.Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoPage extends BasePage {
    public TodoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-testid=\"welcome\"]")
    private WebElement welcomeMessage;
    @FindBy(xpath = "//body/div[@id='root']/div[2]/div[1]/div[1]/div[1]/button[1]/span[1]/*[1]")
    private WebElement plusicon;
    @FindBy(css = "[data-testid=\"delete\"]")
    private WebElement deletebutton;
    @FindBy(css = "[data-testid=\"no-todos\"]")
    private WebElement notodoMssg;
    @FindBy(css = "[data-testid=\"todo-text\"]")
    private WebElement todoItem;


    public boolean welcomeMessageIsDisplayed() {
        return welcomeMessage.isDisplayed();
    }

    public NewToDoPage clickPlus() {
        plusicon.click();
        return new NewToDoPage(driver);
    }

    public TodoPage clickDelete() {
        deletebutton.click();
        return this;
    }

    public boolean noToDoMssgDisplayed() {
        return notodoMssg.isDisplayed();
    }

    public String toDoText() {
        return todoItem.getText();

    }
}

