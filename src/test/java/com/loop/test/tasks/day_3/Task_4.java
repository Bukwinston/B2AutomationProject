package com.loop.test.tasks.day_3;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task_4 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.etsy.com");
        driver.manage().window().maximize();

        WebElement search = driver.findElement(By.id("global-enhancements-search-query"));
        search.sendKeys("wooden spoon");
        search.sendKeys(Keys.ENTER);

        String actual_title = driver.getTitle();
        String expected_title = "Wooden spoon - Etsy";
        if (actual_title.contains(expected_title)) {
            System.out.println("Title contains \"Google\". ==> Validation passed");
        } else {
            System.out.println("Title does not contain \"Google\". ==> Validation failed");
        }

        driver.quit();

    }

}
