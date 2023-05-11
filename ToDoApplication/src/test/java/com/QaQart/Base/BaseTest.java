package com.QaQart.Base;

import com.QaQart.Factory.DriverFactory;
import com.QaQart.utils.CookiesUtils;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.*;
import java.util.List;

import static java.sql.DriverManager.getDriver;


public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new DriverFactory().initializeDriver();

    }

    public void injectCookies(List<io.restassured.http.Cookie> restAssuredCookies) {
        List<Cookie> seleniumCookie;
        seleniumCookie =
                CookiesUtils.convertRestAssuredCookiesToSeleniumCookies((List<io.restassured.http.Cookie>) restAssuredCookies);
        for (Cookie cookie : seleniumCookie) {
            driver.manage().addCookie(cookie);
        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        try {
        String testCasesName = result.getMethod().getMethodName();
        File destinationFile = new File("target" + File.separator + "screenShots" + File.separator +testCasesName + ".png");
        takeScreenshot(destinationFile);
            InputStream inputStream = new FileInputStream(destinationFile);
            Allure.addAttachment("screenshot" ,inputStream );
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    public void takeScreenshot(File destinationFile) {
        WebDriver driver1 = driver;
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, destinationFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

