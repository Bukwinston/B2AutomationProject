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
import java.util.Arrays;
import java.util.List;

public class Task_2 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

       // 1. go to docuport
        driver.get(DocuportConstants.USER_LOGIN_PAGE);
        // 2. sign as adviser
        driver.findElement(By.id("input-14")).sendKeys(DocuportConstants.USERNAME_ADVISOR,
                Keys.TAB,DocuportConstants.ALL_PASSWORD, Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[.='Home']")));

        //3. store left navigate items to (Home, Received docs, My uploads, Invitations etc) to the List
       // 4. iterate and print out href values
        List <WebElement> docLink = driver.findElements(By.xpath("//a[contains(@class, 'py-x-2')]"));
        System.out.println("User home page link size: " + docLink.size());
        for (WebElement eachLink : docLink) {
            if (!eachLink.getText().equals("")) {
                System.out.println(eachLink.getAttribute("href") + " Title name:  " + eachLink.getText());
            }
        }
        System.out.println("\n*********************************************************");
        System.out.println();

        //5. Validate that expected matching to actual: Home, Received docs, My uploads, Clients, Invitations,
        //                                              Users, Leads, Bookkeeping, 1099 form, Reconciliations

        List<String> actuaResult = Arrays.asList("Home", "Received docs", "My uploads", "Clients", "Invitations", "Users", "Leads", "Bookkeeping", "1099 Form", "Reconciliations");

        for (int i = 0; i < actuaResult.size(); i++) {
            if (actuaResult.get(i).equals(docLink.get(i).getText())){
                System.out.println("Actual result " + actuaResult.get(i) + " matches expected result ==> Test PASS");
            } else {
                System.out.println("Actual result " + actuaResult.get(i) + " does not match expected result ==> Test FAIL");

            }
        }
        System.out.println("\n*********************************************************");
        System.out.println();

        List<WebElement> webElements = Arrays.asList(
                driver.findElement(By.xpath("//span[.='Home']")),
                driver.findElement(By.xpath("//a[@href='/received-docs']")),
                driver.findElement(By.xpath("//a[@href='/my-uploads']")),
                driver.findElement(By.xpath("//a[@href='/clients']")),
                driver.findElement(By.xpath("//a[@href='/invitations']")),
                driver.findElement(By.xpath("//a[@href='/users']")),
                driver.findElement(By.xpath("//a[@href='/leads']")),
                driver.findElement(By.xpath("//a[@href='/bookkeeping']")),
                driver.findElement(By.xpath("//a[@href='/1099-form']")),
                driver.findElement(By.xpath("//a[@href='/reconciliations']")));

        for (WebElement each: webElements) {
            System.out.println((each.isDisplayed())
                    ? "Web element \"" + each.getText() + "\" is displayed ==> Test Passed"
                    : "Web element \"" + each.getText() + "\" is NOT displayed ==> Test Failed");
        }

        driver.quit();

    }
}
