package com.QaQart.Pages;

import com.QaQart.Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewToDoPage extends BasePage {
    public NewToDoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//body/div[@id='root']/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")
    private WebElement todo_field;
    @FindBy(xpath = "//body/div[@id='root']/div[2]/div[1]/div[1]/button[1]")
    private WebElement create_todo_button;

    public TodoPage addNewTodo(String todo) {
        todo_field.sendKeys(todo);
        create_todo_button.click();
        return new TodoPage(driver);
    }

}
