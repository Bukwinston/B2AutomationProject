package com.loop.test.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.loop.test.base.TestBase.driver;
import static org.testng.Assert.assertEquals;

public class PizzaOrderWebTableUtils {

    /**
     * @p
     */

public static String returnAnyFieldValue(WebDriver driver, String name, String field){

    String index = "";
    if(field.equalsIgnoreCase("Pizza Type")){
        index = "[1]";
    } else if (field.equalsIgnoreCase("Amount")) {
        index = "[2]";
    } else if (field.equalsIgnoreCase("Date")) {
        index = "[3]";
    } else if (field.equalsIgnoreCase("Street")) {
        index = "[4]";
    } else if (field.equalsIgnoreCase("City")){
        index = "[5]";
    } else if (field.equalsIgnoreCase("State")) {
        index = "[6]";
    } else if (field.equalsIgnoreCase("Zip")) {
        index = "[7]";
    } else if (field.equalsIgnoreCase("Card")) {
        index = "[8]";
    } else if (field.equalsIgnoreCase("Card Number")) {
        index = "[9]";
    } else if (field.equalsIgnoreCase("Exp")) {
        index = "[10]";
    } else {
        System.out.println("There is not such a field: " + field);
    }

    WebElement element = driver.findElement(By.xpath("//td[.='"+name+"']//following-sibling::td"+ index));
    return element.getText().trim();

}

/**
 *validate information about pizza order for each client
 */
public static void orderInfoemation(String name,String type,String amount, String date, String street,
                                    String city, String state, String zip, String card, String cardNumber, String expiration){

    By BY_NAME = By.xpath("//td[.='"+name+"']");
    By BY_TYPE = By.xpath("//td[.='"+name+"']//following-sibling::td[1]");
    By BY_AMOUNT = By.xpath("//td[.='"+name+"']//following-sibling::td[2]");
    By BY_DATE = By.xpath("//td[.='"+name+"']//following-sibling::td[3]");
    By BY_STREET = By.xpath("//td[.='"+name+"']//following-sibling::td[4]");
    By BY_CITY = By.xpath("//td[.='"+name+"']//following-sibling::td[5]");
    By BY_STATE = By.xpath("//td[.='"+name+"']//following-sibling::td[6]");
    By BY_ZIP = By.xpath("//td[.='"+name+"']//following-sibling::td[7]");
    By BY_CARD = By.xpath("//td[.='"+name+"']//following-sibling::td[8]");
    By BY_CARD_NUMBER = By.xpath("//td[.='"+name+"']//following-sibling::td[9]");
    By BY_EXPIRATION = By.xpath("//td[.='"+name+"']//following-sibling::td[10]");

    assertEquals(driver.findElement(BY_NAME).getText(), name, "Actual does NOT match expected");
    assertEquals(driver.findElement(BY_TYPE).getText(), type, "Actual does NOT match expected");
    assertEquals(driver.findElement(BY_AMOUNT).getText(), amount, "Actual does NOT match expected");
    assertEquals(driver.findElement(BY_DATE).getText(), date, "Actual does NOT match expected");
    assertEquals(driver.findElement(BY_STREET).getText(), street, "Actual does NOT match expected");
    assertEquals(driver.findElement(BY_CITY).getText(), city, "Actual does NOT match expected");
    assertEquals(driver.findElement(BY_STATE).getText(), state, "Actual does NOT match expected");
    assertEquals(driver.findElement(BY_ZIP).getText(), zip, "Actual does NOT match expected");
    assertEquals(driver.findElement(BY_CARD).getText(), card, "Actual does NOT match expected");
    assertEquals(driver.findElement(BY_CARD_NUMBER).getText(), cardNumber, "Actual does NOT match expected");
    assertEquals(driver.findElement(BY_EXPIRATION).getText(), expiration, "Actual does NOT match expected");




}
}
