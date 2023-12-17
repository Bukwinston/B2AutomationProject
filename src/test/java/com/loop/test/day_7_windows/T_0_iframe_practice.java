package com.loop.test.day_7_windows;

import com.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T_0_iframe_practice extends TestBase {

      /*
    go to https://loopcamp.vercel.app/nested-frames.html
    validate "LEFT", "MIDDLE", "RIGHT", "BOTTOM"

     */

    @Test (priority = 1)
    public void leftFrame(){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement left = driver.findElement(By.xpath("//*[contains(text(), 'LEFT')]"));
        String actualLeft = left.getText();
        String expectedLeft = "LEFT";
        Assert.assertEquals(actualLeft, expectedLeft, "Actual does NOT match expected");
    }
    @Test (priority = 2)
    public void middleFrame (){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        WebElement middle = driver.findElement(By.xpath("//*[contains(text(), 'MIDDLE')]"));
        String actualMiddle = middle.getText();
        String expectedMiddle = "MIDDLE";
        Assert.assertEquals(actualMiddle, expectedMiddle, "Actual does NOT match expected");
    }
    @Test (priority = 3)
    public void rightFrame (){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-right");
        WebElement right = driver.findElement(By.xpath("//*[contains(text(), 'RIGHT')]"));
        String actualRight = right.getText();
        String expectedRight = "RIGHT";
        Assert.assertEquals(actualRight, expectedRight, "Actual does NOT match expected");
    }
    @Test (priority = 4)
    public void bottomFrame (){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.switchTo().frame("frame-bottom");
        WebElement bottom = driver.findElement(By.xpath("//*[contains(text(), 'BOTTOM')]"));
        String actualBottom = bottom.getText();
        String expectedBottom = "BOTTOM";
        Assert.assertEquals(actualBottom, expectedBottom, "Actual does NOT match expected");
    }
}
