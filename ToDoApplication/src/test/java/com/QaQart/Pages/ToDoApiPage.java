package com.QaQart.Pages;

import com.QaQart.Base.BasePage;
import com.QaQart.utils.ConfigUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ToDoApiPage extends BasePage {
    public ToDoApiPage(WebDriver driver) {
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

    public ToDoApiPage load() {
        driver.get(ConfigUtils.getInstance().getBaseUrl() + "todo");
        return this;
    }

    public boolean welcomeMessageIsDisplayed() {
        return welcomeMessage.isDisplayed();
    }

    public NewToDoPage clickPlus() {
        plusicon.click();
        return new NewToDoPage(driver);
    }

    public ToDoApiPage clickDelete() {
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
