package com.loop.test.day_6_alerts_iframes;

import com.loop.test.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class T1_1 extends TestBase {
    /*
   Information alert practice
   1. Open browser
   2. Go to website: https://loopcamp.vercel.app/javascript-alerts.html
   3. Click to “Click for JS Alert” button
   4. Click to OK button from the alert
   5. Validate “You successfully clicked an alert” text is displayed


    */
    @Test (priority = 1)
    public void informationAlert(){
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickForJSAlert = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        clickForJSAlert.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement successMessageForInformationAlert = driver.findElement(By.xpath("//p[@id='result']"));
        String expected = "You successfully clicked an alert";
        String actual = successMessageForInformationAlert.getText();
        assertEquals(actual, expected, "actual does not match the expected");
    }

//    Confirmation alert practice
//   1. Click to “Click for JS Confirm” button
//   2. Click to OK button from the alert
//   3. Verify “You clicked: Ok” text is displayed.
//   4. Click to “Click for JS Confirm” button
//   5. Click to Cancel button from the alert
//   6. Validate “You clicked: Cancel” text is displayed.

    @Test (priority = 2)
    public void confirmationAlert(){
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickForJSConfirm = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]"));
        clickForJSConfirm.click();
        driver.switchTo().alert().accept(); //will click ok and accept
        WebElement successMessageForConfirmationAlert = driver.findElement(By.xpath("//p[@id='result']"));
        String expected = "You clicked: Ok";
        String actual = successMessageForConfirmationAlert.getText();
        assertEquals(actual, expected, "Actual does not match the expected");

        clickForJSConfirm.click();
        driver.switchTo().alert().dismiss();
        actual = successMessageForConfirmationAlert.getText();
        expected = "You clicked: Cancel";
        assertEquals(actual, expected, "actual does not match the expected");
    }

//    Prompt alert practice
////   1. Click to “Click for JS Prompt” button
////   2. Send "Loop Academy"
////   3. Click Ok
////   4. Validate "You entered: Loop Academy" text is displayed


    @Test (priority = 3)
    public void promptAlert(){
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickForJSPrompt = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"));
        clickForJSPrompt.click();
        String text = "Loop Academy";
        driver.switchTo().alert().sendKeys(text);
        driver.switchTo().alert().accept();

        WebElement succesMessagePrompt = driver.findElement(By.xpath("//p[@id='result']"));
        String actualPrompt = succesMessagePrompt.getText();
        String expectedPrompt = "You entered: " + text;
        assertEquals(actualPrompt, expectedPrompt, "actual does not match the expected");




    }


}
