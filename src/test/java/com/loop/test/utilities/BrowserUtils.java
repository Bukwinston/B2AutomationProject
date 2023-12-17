package com.loop.test.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Set;

import static org.testng.Assert.*;

public class BrowserUtils {


    /**
     * validate if driver switch to expected URL and Title
     * @param driver
     * @param expectedUrl
     * @param expectedTitle
     * @author bukwinston
     * inplements assertion
     */


    public static void switchWindowAndValidate(WebDriver driver, String expectedUrl, String expectedTitle){
        expectedTitle = expectedTitle.toLowerCase();
        expectedUrl = expectedUrl.toLowerCase();
        Set <String> windowHandles = driver.getWindowHandles();
    for (String each : windowHandles){
        driver.switchTo().window(each);
        if(driver.getCurrentUrl().toLowerCase().contains(expectedUrl)){
            break;
        }
    }
    assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));

}

    /**
     * switches to the new window by the exact title
     * return to original window if the window with given title not found
     * @param driver
     * @param targetTitle
     * @author bukwinston
     */
    public static void switchToWindow (WebDriver driver, String targetTitle){
        String origin = driver.getWindowHandle();
        // Set<String> windowHanles = driver.getWindowHandles();
        for (String each : driver.getWindowHandles()){
            driver.switchTo().window(each);
            if (driver.getTitle().contains(targetTitle)){
                return;
            }
        }
        driver.switchTo().window(origin);
    }
}
