package com.loop.test.day3_locators_css_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllLocatorsPractice {
    public static void main(String[] args) {

        WebDriverManager.chromedriver();
        WebDriver driver = new ChromeDriver();

        driver.get("https://loopcamp.vercel.app/registration_form.html");


    }
}
