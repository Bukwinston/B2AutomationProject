package com.loop.test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {

     WebDriverManager.chromedriver().setup();

     WebDriver driver = new ChromeDriver();
     //Thread.sleep(5000); // wait 5 sec before running web page

     driver.get("http://www.google.com");
     //driver.navigate().to("http://www.google.com");

            //maximaze
         driver.manage().window().maximize();
            //driver.manage().window().fullscreen();
         driver.navigate().to("http://www.etsy.com");

            //navigate back
         driver.navigate().back();

         //navigate forward
        driver.navigate().forward();

        //refresh the web page
        driver.navigate().refresh();

        //quit and close browser
       // driver.quit();
        driver.close();





    }
}
