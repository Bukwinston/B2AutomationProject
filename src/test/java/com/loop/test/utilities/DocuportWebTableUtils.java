package com.loop.test.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.InputMismatchException;

public class DocuportWebTableUtils {


    /**
     * return any field from table by given email
     * @param driver
     * @emailAddress
     * @param field
     * @author bukwinston
     */

public static String returnAnyField (WebDriver driver, String emailAddress, String field){
    WebElement element = null;
    String xpath = "";
    switch (field.toLowerCase()){
        case "full name" :
            xpath = "//td[2][.='"+emailAddress+"']/preceding-sibling::td//span[2]";
            element = driver.findElement(By.xpath(xpath));
            break;

        case "email address" :
            xpath = "//td[2][.='"+emailAddress+"']";
            element = driver.findElement(By.xpath(xpath));
            break;

        case "username" :
            xpath = "//td[2][.='"+emailAddress+"']/following-sibling::td[1]";
            element = driver.findElement(By.xpath(xpath));
            break;

        case "phone number" :
            xpath = "//td[2][.='"+emailAddress+"']/following-sibling::td//span";
            element = driver.findElement(By.xpath(xpath));
            break;

        case "role" :
            xpath = "//td[2][.='"+emailAddress+"']/following-sibling::td//span/span";
            element = driver.findElement(By.xpath(xpath));
            break;

        case "advisor" :
            xpath = "//td[2][.='"+emailAddress+"']/following-sibling::td[5]";
            element = driver.findElement(By.xpath(xpath));
            break;

        case "inviter" :
            xpath = "//td[2][.='"+emailAddress+"']/following-sibling::td[2]";
            element = driver.findElement(By.xpath(xpath));
            break;
        default: throw  new InputMismatchException("There is NOT such role: " + field);

    }
    return element.getText().trim();

}

}
