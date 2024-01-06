package com.loop.test.tasks.day_11;

import com.loop.pages.SecureSmartBear;
import com.loop.test.utilities.BrowserUtils;
import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
public class Task_1 {

    SecureSmartBear secureSmartBear;
    WebDriverWait wait;

    @BeforeMethod
    public void setUpMethod() {
        secureSmartBear = new SecureSmartBear();
        Driver.getDriver().get(ConfigurationReader.getProperty("secure.smartbear"));
    }
    @AfterTest
    public void tearDown(){
        Driver.getDriver().close();
    }

    @Test
    public void test() {
        secureSmartBear.username.sendKeys(ConfigurationReader.getProperty("secure.smartbear.username"));
        secureSmartBear.password.sendKeys(ConfigurationReader.getProperty("secure.smartbear.password"));
        secureSmartBear.loginButton.click();
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(secureSmartBear.allOrders));

        System.out.println(secureSmartBear.list.size());
        BrowserUtils.printLinks(secureSmartBear.allOrders);

    }
}
