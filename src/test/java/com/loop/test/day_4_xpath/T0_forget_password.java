package com.loop.test.day_4_xpath;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 * verify forget password
 * identify reset password heading using css and go from parent to child
 */
public class T0_forget_password {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://beta.docuport.app/login");
        driver.manage().window().maximize();

        WebElement forgotPassword = driver.findElement(By.cssSelector("a[href='/reset-password']"));
        forgotPassword.click();

        WebElement resetPassword = driver.findElement(By.cssSelector("div[class='login-layout__form']>h1"));
        System.out.println("resetPassword.getText() = " + resetPassword.getText());

    }

}
