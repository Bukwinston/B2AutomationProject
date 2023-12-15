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

    @Test
    public void leftFrame(){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement left = driver.findElement(By.xpath("//*[contains(text(), 'LEFT')]"));
        String actualLeft = left.getText();
        String expectedLeft = "LEFT";
        Assert.assertEquals(actualLeft, expectedLeft, "Actual does NOT match expected");

    }

}
