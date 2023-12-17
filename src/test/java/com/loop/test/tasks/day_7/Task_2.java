package com.loop.test.tasks.day_7;

import com.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

//Task 1 at day 7 practice
public class Task_2 extends TestBase {

// 1. go to https://loopcamp.vercel.app/
// 2. click "Multiple Windows" link
// 3. Validate "Powered by Loopcamp" is displayed
// 4. Validate title is "Windows"
// 5. Click - click here
// 6. Switch to new window and validate title

    @Test
    public void Windows (){
        driver.get("https://loopcamp.vercel.app/");
        WebElement mWindows = driver.findElement(By.xpath("//a[contains(., 'Multiple Windows')]"));
        mWindows.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement powerBLC = driver.findElement(By.xpath("//a[contains(., 'LOOPCAMP')]"));
        System.out.println(powerBLC.isDisplayed());

        Assert.assertEquals(driver.getTitle(), "Windows", "Actual title does NOT match expected");
        System.out.println(driver.getWindowHandle());

        WebElement clickHere = driver.findElement(By.xpath("//a[contains(., 'Click Here')]"));
        clickHere.click();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String each : windowHandles) {
            driver.switchTo().window(each);
        }

        System.out.println(driver.getWindowHandle());
        Assert.assertEquals(driver.getTitle(), "New Window", "Actual title does NOT match expected");

    }
}
