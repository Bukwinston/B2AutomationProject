package com.loop.test.tasks.day_3;

import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task_3 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://google.com");
        driver.manage().window().maximize();

        WebElement button = driver.findElement(By.cssSelector("a[class='gb_E']"));
        button.click();

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
       // wait.until(ExpectedConditions.titleIs("Gmail: Private and secure email at no cost | Google Workspace"));

        String actual_title = driver.getTitle();
        String expected_title = "Gmail";
        if (actual_title.contains(expected_title)) {
            System.out.println("Title contains \"Gmail\". ==> Validation passed");
        } else {
            System.out.println("Title does not contain \"Gmail\". ==> Validation failed");
        }

        driver.navigate().back();

        String actual_title1 = driver.getTitle();
        String expected_title1 = "Google";
        if (actual_title1.contains(expected_title1)) {
            System.out.println("Title contains \"Google\". ==> Validation passed");
        } else {
            System.out.println("Title does not contain \"Google\". ==> Validation failed");
        }

        driver.quit();
    }

}
