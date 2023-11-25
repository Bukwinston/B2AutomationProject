package com.loop.test.tasks.day_3;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task_2 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://beta.docuport.app/login");
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.cssSelector("label[for='input-14']"));
        String actual_username = username.getText();
        String expected_username = "Username or email";
        if (expected_username.equalsIgnoreCase(actual_username)){
            System.out.println("Expected logo text: " + expected_username + ", matches actual logo text: "  + actual_username + ", => TEST PASS");
        } else {
            System.out.println("Expected logo text: " + expected_username + ", DOES NOT MATCH actual logo text: "  + actual_username + ", => TEST FAIL");
        }

        WebElement password = driver.findElement(By.cssSelector("label[for='input-15']"));
        String actual_password = password.getText();
        String expected_password = "Password";
        if (expected_password.equalsIgnoreCase(actual_password)){
            System.out.println("Expected logo text: " + expected_password + ", matches actual logo text: "  + actual_password + ", => TEST PASS");
        } else {
            System.out.println("Expected logo text: " + expected_password + ", DOES NOT MATCH actual logo text: "  + actual_password + ", => TEST FAIL");
        }

        WebElement log_in = driver.findElement(By.cssSelector("span[class='v-btn__content']"));
        log_in.click();

        WebDriverWait wait =new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[.='Please enter your username or email address']")));


        WebElement error_username = driver.findElement(By.xpath("//*[.='Please enter your username or email address']"));
        String actual_error_username = error_username.getText();
        String expected_error_username = "Please enter your username or email address";
        if (expected_error_username.equalsIgnoreCase(actual_error_username)){
            System.out.println("Expected logo text: " + expected_error_username + ", matches actual logo text: "  + actual_error_username + ", => TEST PASS");
        } else {
            System.out.println("Expected logo text: " + expected_error_username + ", DOES NOT MATCH actual logo text: "  + actual_error_username + ", => TEST FAIL");
        }

        WebElement error_password = driver.findElement(By.xpath("//*[.='Please enter your password']"));
        String actual_error_password = error_password.getText();
        String expected_error_password = "Please enter your password";
        if (expected_error_password.equalsIgnoreCase(actual_error_password)){
            System.out.println("Expected logo text: " + expected_error_password + ", matches actual logo text: "  + actual_error_password + ", => TEST PASS");
        } else {
            System.out.println("Expected logo text: " + expected_error_password + ", DOES NOT MATCH actual logo text: "  + actual_error_password + ", => TEST FAIL");
        }


        driver.quit();


    }
}
