package com.loop.test.tasks.day_4;

import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task_1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

       // 1. go to docuport app
        driver.get(DocuportConstants.USER_LOGIN_PAGE);
        driver.manage().window().maximize();
        driver.findElement(By.id("input-14")).sendKeys(DocuportConstants.USERNAME_ADVISOR,
        Keys.TAB,DocuportConstants.ALL_PASSWORD, Keys.ENTER);

//        Long way to log in:
/**        WebElement username = driver.findElement(By.id("input-14"));
//        username.sendKeys(DocuportConstants.USERNAME_ADVISOR);
//        username.sendKeys(Keys.TAB);
//
//        WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
//        password.sendKeys(DocuportConstants.ALL_PASSWORD);
//        password.sendKeys(Keys.TAB);
//
//        WebElement log_in = driver.findElement(By.cssSelector("span[class='v-btn__content']"));
//        log_in.click();
*/

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[.='Home']")));

       // 2. validate that Home, Received docs, My uploads, Invitations are displayed
        List<WebElement> webElements = Arrays.asList(
                driver.findElement(By.xpath("//span[.='Home']")),
                driver.findElement(By.xpath("//a[@href='/received-docs']")),
                driver.findElement(By.xpath("//a[@href='/my-uploads']")),
                driver.findElement(By.xpath("//a[@href='/invitations']")));

        for (WebElement each: webElements) {
            System.out.println((each.isDisplayed())
            ? "Test passed ==> Web element \"" + each.getText() + "\" is displayed"
            : "Test Failed ==> Web element \"" + each.getText() + "\" is NOT displayed");
        }


        //Long way, to validate if displayed its elements.
/**       WebElement home = driver.findElement(By.xpath("//span[.='Home']"));
//        if (home.isDisplayed()){
//            System.out.println("Home is displayed");
//        } else {
//            System.out.println("Home is NOT displayed");
//        }
//
//        WebElement receivedDocs = driver.findElement(By.xpath("//span[.='Received docs']"));
//        if (receivedDocs.isDisplayed()){
//            System.out.println("Received Docs is displayed");
//        } else {
//            System.out.println("Received Docs is NOT displayed");
//        }

//        WebElement myUploads = driver.findElement(By.xpath("//span[.='My uploads']"));
//        if (myUploads.isDisplayed()){
//            System.out.println("My Uploads is displayed");
//        } else {
//            System.out.println("My Uploads is NOT displayed");
//        }
//
//        WebElement invitation = driver.findElement(By.xpath("//span[.='Invitations']"));
//        if (invitation.isDisplayed()){
//            System.out.println("Invitation is displayed");
//        } else {
//            System.out.println("Invitation is NOT displayed");
*/

        System.out.println("******************************************");

        // 3. press three lines

        driver.findElement(By.xpath(" //div[@class='row align-center']//i")).click();
//        Long way to click
//        WebElement threeLineButton = driver.findElement(By.xpath(" //div[@class='row align-center']//i"));
//        threeLineButton.click();

//        4. Home, Received docs, My uploads, Invitations will disappear
//        5. Validate the buttons are not displayed

        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//span[.='Home']"))));
        int count = 0;
        for (WebElement each: webElements) {
            System.out.println((!each.isDisplayed())
                    ? "Test passed ==> Web element \"" + count++ + "\" is NOT displayed"
                    : "Test Failed ==> Web element \"" + count++ + "\" is displayed");
        }

         driver.quit();

    }
}
