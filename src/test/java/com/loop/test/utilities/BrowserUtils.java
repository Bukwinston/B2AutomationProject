package com.loop.test.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertTrue;

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


    /**
     * @param driver
     * @param expectedTitle
     * returns void, assertion is implemented
     * @author bukwinston
     */
    public static void validateTitle (WebDriver driver, String expectedTitle){
        assertTrue(driver.getTitle().contains(expectedTitle));
    }

    /**
     * Click any link from loop practice
     * @param nameOfPage
     * @author bukwinston
     */
    public static void loopLinkClick(String nameOfPage){
        WebElement element = Driver.getDriver().findElement(By.xpath("//a[.='"+nameOfPage+"']"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    /**
     * Moves the mouse to given element
     * @param element on which to hover
     * @author bukwinston
     */
    public static void hover(WebElement element){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    /**
     * Scrolls down to an element using JavaScript
     * @param element
     * @author nadir
     */
    public static void scrollToElement(WebElement element){
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Clicks on an element using JavaScript
     * @param element
     * @author bukwinston
     */
    public static void clickWithJS (WebElement element){
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     * Performs double click action on an element
     * @param element
     * @author bukwinston
     */
    public static void doubleClick(WebElement element){
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }

    /**
     * Waits for the provided element to be visible on the page
     * @param element
     * @param timeToWaitInSec
     * @return
     * @author bukwinston
     */
    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for the provided element to be invisible on the page
     * @param element
     * @param timeToWaitInSec
     * @return
     * @author bukwinston
     */
    public static void waitForInvisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * Waits for the provided element to be clickable on the page
     * @param element
     * @param timeout
     * @return
     * @author bukwinston
     */
    public static WebElement waitForClickable (WebElement element, int timeout){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Clicks on an element using JavaScript
     * @param second
     * @author nadir
     */
    public static void justWait(int second){
        try{
            Thread.sleep(second);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * print out each link text on webpage
     * @param element
     * @author bukwinton
     */
public static WebElement printLinks(WebElement element){
    List<WebElement> allList = Driver.getDriver().findElements(By.tagName("a"));
        for (WebElement each : allList){
            System.out.println(each.getText());}
      return element;
    }



}
