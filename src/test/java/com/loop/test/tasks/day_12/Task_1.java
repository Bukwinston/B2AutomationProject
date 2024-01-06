package com.loop.test.tasks.day_12;

import com.github.javafaker.Faker;
import com.loop.pages.SecureSmartBear;
import com.loop.test.utilities.BrowserUtils;
import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

import static org.testng.Assert.assertEquals;

public class Task_1 {
    SecureSmartBear secureSmartBear;
    Select dropdown;
    Faker faker;
    WebDriverWait wait;

    @BeforeMethod
    public void setUpMethod() {
        secureSmartBear = new SecureSmartBear();
        Driver.getDriver().get(ConfigurationReader.getProperty("secure.smartbear"));}
    @AfterTest
    public void tearDown() {Driver.getDriver().close();}
    @Test
    public void testOrder() {
        secureSmartBear.username.sendKeys(ConfigurationReader.getProperty("secure.smartbear.username"));
        secureSmartBear.password.sendKeys(ConfigurationReader.getProperty("secure.smartbear.password"));
        secureSmartBear.loginButton.click();
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(secureSmartBear.allOrders));
        secureSmartBear.order.click();
        dropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")));
        dropdown.selectByValue("FamilyAlbum");
        secureSmartBear.quantity.clear();
        secureSmartBear.quantity.sendKeys("2");
        secureSmartBear.calculate.click();
        faker = new Faker();
        secureSmartBear.customerName.sendKeys(faker.name().fullName());
        secureSmartBear.street.sendKeys(faker.address().streetAddress());
        secureSmartBear.city.sendKeys(faker.address().city());
        secureSmartBear.state.sendKeys(faker.address().state());
        secureSmartBear.zipCode.sendKeys(faker.numerify("#####"));
        secureSmartBear.cardType.click();
        secureSmartBear.cardNumber.sendKeys(faker.finance().creditCard().replace("-", ""));
        SimpleDateFormat sdf = new SimpleDateFormat("MM/yy");
        String dob = sdf.format(faker.date().birthday(-5, -1));
        secureSmartBear.expDate.sendKeys(dob);
        secureSmartBear.processButton.click();
        assertEquals(secureSmartBear.verifyMessage.getText(), "New order has been successfully added.", "Actual message DOES NOT match expected");
    }
}
