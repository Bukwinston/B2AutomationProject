package com.loop.test.tasks.day_6;

import com.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task_2 extends TestBase {
//1. go to https://demoqa.com/nestedframes
//2. Validate "Child Iframe" text
//3. Validate "Parent Iframe" text
//4. Validate the "Sample Nested Iframe page. There are nested iframes in this page. Use browser inspecter or
// firebug to check out the HTML source. In total you can switch between the parent frame and the nested child frame."
    @Test
    public void iframe (){
        driver.get("https://demoqa.com/nestedframes");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement childIframe = driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
        driver.switchTo().frame(childIframe);

        WebElement childBox = driver.findElement(By.xpath("//p[.='Child Iframe']"));
        String actualChild = childBox.getText();
        String expectedChild = "Child Iframe";
        Assert.assertEquals(actualChild, expectedChild, "Actual does NOT match expected");
    }



}
