package com.loop.test.day3_locators_css_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.google.com/");
        driver.manage().window().maximize();
        WebElement searchBoxWithID = driver.findElement(By.id("APjFqb"));
        WebElement searchBoxWithName = driver.findElement(By.name("q"));
        WebElement aboutLink = driver.findElement(By.linkText("About"));

        //aboutLink.click();

        //create21
        searchBoxWithID.sendKeys("Feyruz is handsome");
        searchBoxWithID.clear();

        String textToSearch = "Loop Academy";
        searchBoxWithID.sendKeys(textToSearch + Keys.ENTER);


        //driver.quit();

    }
}
