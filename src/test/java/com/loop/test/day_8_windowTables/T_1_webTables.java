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

public class T_1_webTables extends TestBase {

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

        String expectedFullName = "Alex De Souza";
        String actualFullName = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com","Full name");
        System.out.println("actual Full Name = " + actualFullName);
        Assert.assertEquals(actualFullName, expectedFullName, "Actual does NOT match expected");

        String expectedUsename = "alexdesouze";
        String actualUsername = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "username");
        System.out.println("actual Username = " + actualUsername);
        Assert.assertEquals(actualUsername, expectedUsename, "Actual does NOT match expected");

        String expectedEmail = "alex.de.souza@gmail.com";
        String actualEmail = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "email address");
        System.out.println("actual Email = " + actualEmail);
        Assert.assertEquals(actualEmail, expectedEmail, "Actual does NOT match expected");

        String expectedPhone = "+994512060042";
        String actualPhone = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "phone number");
        System.out.println("actual Phone = " + actualPhone);
        Assert.assertEquals(actualPhone, expectedPhone, "Actual does NOT match expected");

        String expectedRole = "Client";
        String actualRole = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "role");
        System.out.println("actual Role = " + actualRole);
        Assert.assertEquals(actualRole, expectedRole, "Actual does NOT match expected");

        String expectedAdvisor = "Batch1 Group1";
        String actualAdviser = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "advisor");
        System.out.println("actual Adviser = " + actualAdviser);
        Assert.assertEquals(actualAdviser, expectedAdvisor, "Actual does NOT match expected");


    }
}
