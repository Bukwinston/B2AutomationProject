package com.loop.test.day_4_xpath;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T00_css_isDisplayed {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://the-internet.herokuapp.com/forgot_password");
        driver.manage().window().maximize();

    WebElement forgetPassword = driver.findElement(By.cssSelector("div[class='example']>h2"));
        System.out.println(forgetPassword.isDisplayed());
    if (forgetPassword.isDisplayed()){
        System.out.println("Forget password is displayed");
    } else {
        System.out.println("Forget password is NOT displayed");
    }

    driver.quit();
    }

}
