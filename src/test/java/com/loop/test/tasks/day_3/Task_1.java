package com.loop.test.tasks.day_3;

import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.WebDriverFactory;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;
import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Task_1 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://beta.docuport.app/login");
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.id("input-14"));
        username.sendKeys(DocuportConstants.ESERNAME_EMPLOYEE);
        username.sendKeys(Keys.TAB);

        WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
        password.sendKeys(DocuportConstants.ALL_PASSWORD);
        password.sendKeys(Keys.TAB);

        WebElement log_in = driver.findElement(By.cssSelector("span[class='v-btn__content']"));
        log_in.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("span[class='subtitle-2 text-none pl-2 pr-3 gray--text text--darken-3']")));

        if (driver.getCurrentUrl().contains(DocuportConstants.USER_HOME_PAGE)) {
            System.out.println("Log in is successful");
        } else {
            System.out.println("Log in failed");
        }
        WebElement batch = driver.findElement(By.cssSelector("span[class='subtitle-2 text-none pl-2 pr-3 gray--text text--darken-3']"));

        batch.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[.='Log out']")));
        WebElement logout = driver.findElement(By.xpath("//span[.='Log out']"));
        logout.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("h1[class='text-h5 font-weight-medium mb-6']")));
        if (driver.getCurrentUrl().contains(DocuportConstants.USER_LOGIN_PAGE)) {
            System.out.println("Log out is successful");
        } else {
            System.out.println("Log out failed");
        }
        driver.quit();
    }
}
 /* String actual_batch = batch.getText();
        String expected_batch = "Batch1 Group1";
        if (expected_batch.equalsIgnoreCase(actual_batch)){
            System.out.println("Expected logo text: " + expected_batch + ", matches actual logo text: "  + actual_batch + ", => TEST PASS");
        } else {
            System.out.println("Expected logo text: " + expected_batch + ", DOES NOT MATCH actual logo text: "  + actual_batch + ", => TEST FAIL");
        }*/


 /* WebElement login = driver.findElement(By.cssSelector("h1[class='text-h5 font-weight-medium mb-6']"));
        String actual_login = login.getText();
        String expected_login = "Login";
        if (expected_batch.equalsIgnoreCase(actual_batch)){
            System.out.println("Expected logo text: " + expected_batch + ", matches actual logo text: "  + actual_batch + ", => TEST PASS");
        } else {
            System.out.println("Expected logo text: " + expected_batch + ", DOES NOT MATCH actual logo text: "  + actual_batch + ", => TEST FAIL");
        }*/
