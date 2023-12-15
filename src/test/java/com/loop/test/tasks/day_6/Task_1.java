package com.loop.test.tasks.day_6;

import com.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class Task_1 extends TestBase{


    @Test (priority = 1)
    public void aletrs_1() {
        driver.get("https://demoqa.com/alerts");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement alertButton1 = driver.findElement(By.xpath("//button[@id='alertButton']"));
        alertButton1.click();
        driver.switchTo().alert().accept();

    }

    @Test (priority = 2)
    public void alerts_2()throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        sleep(2000);
        WebElement timerAlertButton = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
        timerAlertButton.click();
        sleep(5000);
        driver.switchTo().alert().accept();
    }

    @Test (priority = 3)
    public void alerts_3(){
        driver.get("https://demoqa.com/alerts");

        WebElement confirmButton = driver.findElement(By.xpath("//button[@id='confirmButton']"));
        confirmButton.click();

        driver.switchTo().alert().accept();
        WebElement confirmation = driver.findElement(By.xpath("//span[contains(text(),'You selected ')]"));
        String actualConf = confirmation.getText();
        String expectedConf = "You selected Ok";
        Assert.assertEquals(actualConf, expectedConf, "Actual does NOT match expected");

    }

    @Test (priority = 4)
    public void alerts_4 (){
        driver.get("https://demoqa.com/alerts");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement promtButton = driver.findElement(By.xpath("//button[@id='promtButton']"));
        promtButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.switchTo().alert().sendKeys("Loop Academy");
        driver.switchTo().alert().accept();
        WebElement confirmPrompt = driver.findElement(By.xpath("//span[contains(text(),'You entered ')]"));
        String actualPrompt = confirmPrompt.getText();
        String expectedPrompt = "You entered Loop Academy";
        Assert.assertEquals(actualPrompt, expectedPrompt, "Actual does NOT match expected");

    }

}



