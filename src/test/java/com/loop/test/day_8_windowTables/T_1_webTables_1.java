package com.loop.test.day_8_windowTables;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.DocuportUtils;
import com.loop.test.utilities.DocuportWebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class T_1_webTables_1 extends TestBase {

 /*
    1. login as an advisor
    2. go to users
    3. validate that full name for alex.de.souza@gmail.com is Alex De Souza
    4. validate that user name for alex.de.souza@gmail.com is alexdesouze
    5. validate that phone number for alex.de.souza@gmail.com is +994512060042
    6. validate that role for alex.de.souza@gmail.com is client
    7. validate that advisor for alex.de.souza@gmail.com is  Batch1 Group1
     */

    @Test
    public void test_webTables() throws InterruptedException {
        DocuportUtils.login(driver, DocuportConstants.ADVISOR);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement users = driver.findElement(By.xpath("//span[contains(., 'Users')]"));
        users.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        validateUserInformation("Alex De Souza","alex.de.souza@gmail.com","alexdesouze",
                                "+994512060042", "Client","Batch1 Group1");

//        String expectedFullName = "Alex De Souza";
//        String actualFullName = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com","Full name");
//        System.out.println("actual Full Name = " + actualFullName);
//        assertEquals(actualFullName, expectedFullName, "Actual does NOT match expected");
//
//        String expectedUsename = "alexdesouze";
//        String actualUsername = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "username");
//        System.out.println("actual Username = " + actualUsername);
//        assertEquals(actualUsername, expectedUsename, "Actual does NOT match expected");
//
//        String expectedEmail = "alex.de.souza@gmail.com";
//        String actualEmail = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "email address");
//        System.out.println("actual Email = " + actualEmail);
//        assertEquals(actualEmail, expectedEmail, "Actual does NOT match expected");
//
//        String expectedPhone = "+994512060042";
//        String actualPhone = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "phone number");
//        System.out.println("actual Phone = " + actualPhone);
//        assertEquals(actualPhone, expectedPhone, "Actual does NOT match expected");
//
//        String expectedRole = "Client";
//        String actualRole = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "role");
//        System.out.println("actual Role = " + actualRole);
//        assertEquals(actualRole, expectedRole, "Actual does NOT match expected");
//
//        String expectedAdvisor = "Batch1 Group1";
//        String actualAdviser = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "advisor");
//        System.out.println("actual Adviser = " + actualAdviser);
//        assertEquals(actualAdviser, expectedAdvisor, "Actual does NOT match expected");


    }
    public static void validateUserInformation(String fullName, String email, String username, String phoneNumber, String userRole, String advisor){
        By BY_FULL_NAME = By.xpath("//td[2][.='"+email+"']/preceding-sibling::td//span[2]");
        By BY_EMAIL = By.xpath("//td[2][.='"+email+"']");
        By BY_USERNAME = By.xpath("//td[2][.='"+email+"']/following-sibling::td[1]");
        By BY_PHONE_NUMBER = By.xpath("//td[2][.='"+email+"']/following-sibling::td//span");
        By BY_ROLE = By.xpath("//td[2][.='"+email+"']/following-sibling::td[4]//span/span");
        By BY_ADVISOR = By.xpath("//td[2][.='"+email+"']/following-sibling::td[5]");

        assertEquals(driver.findElement(BY_FULL_NAME).getText(), fullName, "Actual name does NOT match expected");
        assertEquals(driver.findElement(BY_EMAIL).getText(), email, "Actual email does NOT match expected");
        assertEquals(driver.findElement(BY_USERNAME).getText(), username, "Actual username does NOT match expected");
        assertEquals(driver.findElement(BY_PHONE_NUMBER).getText(), phoneNumber, "Actual phone number does NOT match expected");
        assertEquals(driver.findElement(BY_ROLE).getText(), userRole, "Actual role does NOT match expected");
        assertEquals(driver.findElement(BY_ADVISOR).getText(), advisor, "Actual advisor does NOT match expected");

    }

}
