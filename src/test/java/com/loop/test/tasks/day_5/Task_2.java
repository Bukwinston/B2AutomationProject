package com.loop.test.tasks.day_5;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class Task_2 {
    WebDriver driver;
    String expected;
    String actual;
    String actualOpt1;
    String expectedOpt1;
    String actualOpt2;
    String expectedOpt2;


    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() {
        // driver.quit();
    }
 /*
    Task 2
1. go to https://www.etsy.com/
2. search for rings
3. validate that Estimated Arrival shows any time
3. click Estimated Arrival dropdown
4. click Select custom date
5. choose may 30 from dropdown
6. validate Estimated Arrival shows may 30
     */

    @Test(priority = 2)
    public void test2() {
        driver.get("https://www.etsy.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        WebElement slider = driver.findElement(By.xpath("//div[@class='slider']"));
//        Actions action= new Actions(driver);
//        action.clickAndHold(slider);
//        action.moveByOffset(0,20);
//        action.release().build();

        WebElement seaech = driver.findElement(By.xpath("//input[@id='global-enhancements-search-query']"));
        seaech.sendKeys("Rings");
        seaech.sendKeys(Keys.ENTER);


    }
}