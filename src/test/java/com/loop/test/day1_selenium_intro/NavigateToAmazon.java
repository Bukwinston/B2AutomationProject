package com.loop.test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateToAmazon {
    public static void main(String[] args) {

         /*
    navigate to amazon
    maximize
    navigate back
    navigate forward
    refresh
     */

        WebDriverManager.chromedriver();
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.amazon.com");
        driver.manage().window().maximize();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.quit();


    }
}
