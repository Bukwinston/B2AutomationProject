package com.loop.test.tasks.day_3;

import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.LoopCampConstants;
import com.loop.test.utilities.WebDriverFactory;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;

public class Task_0 {
    public static void main(String[] args) {
        // 1. go to https://loopcamp.vercel.app/forgot-password.html
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://loopcamp.vercel.app/forgot-password.html");

        WebElement forgotPassword = driver.findElement(By.cssSelector("h2"));
        String actualForgotPassword = forgotPassword.getText();

        if (LoopCampConstants.FORGOT_PASSWORD.equalsIgnoreCase(actualForgotPassword)){
            System.out.println("Expected logo text: " + LoopCampConstants.FORGOT_PASSWORD + ", matches actual logo text: "  + actualForgotPassword + ", => TEST PASS");
        } else {
            System.out.println("Expected logo text: " + LoopCampConstants.FORGOT_PASSWORD + ", DOES NOT MATCH actual logo text: "  + actualForgotPassword + ", => TEST FAIL");
        }

        WebElement email = driver.findElement(By.cssSelector("label[for='email']"));
        String actual_email=email.getText();
        String expected_email= "E-mail";

        if (expected_email.equalsIgnoreCase(actual_email)){
            System.out.println("Expected logo text: " + expected_email + ", matches actual logo text: "  + actual_email + ", => TEST PASS");
        } else {
            System.out.println("Expected logo text: " + expected_email + ", DOES NOT MATCH actual logo text: "  + actual_email + ", => TEST FAIL");
        }

        WebElement email_input = driver.findElement(By.cssSelector("#email"));
        String actual_email_input = email_input.getAttribute("id");
        String expected_email_input = "email";
        if (expected_email_input.equalsIgnoreCase(actual_email_input)){
            System.out.println("Expected logo text: " + expected_email_input + ", matches actual logo text: "  + actual_email_input + ", => TEST PASS");
        } else {
            System.out.println("Expected logo text: " + expected_email_input + ", DOES NOT MATCH actual logo text: "  + actual_email_input + ", => TEST FAIL");
        }

        WebElement retrieve_password = driver.findElement(By.cssSelector("i[class='icon-2x icon-signin']"));
        String actual_retrieve_password = retrieve_password.getText();
        String expected_retrieve_password = "Retrieve password";

        if (expected_retrieve_password.equalsIgnoreCase(actual_retrieve_password)){
            System.out.println("Expected logo text: " + expected_retrieve_password + ", matches actual logo text: "  + actual_retrieve_password + ", => TEST PASS");
        } else {
            System.out.println("Expected logo text: " + expected_retrieve_password + ", DOES NOT MATCH actual logo text: "  + actual_retrieve_password + ", => TEST FAIL");
        }

        WebElement powered_by_LOOPCAMP = driver.findElement(By.cssSelector("div[style='text-align: center;']"));
        String actual_powered_by_LOOPCAMP = powered_by_LOOPCAMP.getText();
        String expected_powered_by_LOOPCAMP = "Powered by LOOPCAMP";

        if (expected_powered_by_LOOPCAMP.equalsIgnoreCase(actual_powered_by_LOOPCAMP)){
            System.out.println("Expected logo text: " + expected_powered_by_LOOPCAMP + ", matches actual logo text: "  + actual_powered_by_LOOPCAMP + ", => TEST PASS");
        } else {
            System.out.println("Expected logo text: " + expected_powered_by_LOOPCAMP + ", DOES NOT MATCH actual logo text: "  + actual_powered_by_LOOPCAMP + ", => TEST FAIL");
        }



       // assertEquals(actual_powered_by_LOOPCAMP,"Sasa","Failed 567777");
       // driver.quit();
    }




}


/*
* 1. go to https://loopcamp.vercel.app/forgot-password.html
2. locate 5 elements, forgot password, email, email input, retrieve password, powered by LOOPCAMP
3. use css
4. verify those elements are displayed

* */