package com.loop.test.tasks.day_5;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Task_1 {

        /*
        Task 1
1. go to http://the-internet.herokuapp.com/dropdown
2. validate "Please select an option" is selected by default
3. Choose option 1 and validate that it is selected
4. Choose option 2 and validate that it is selected
5. Validate dropdown name is "Dropdown List"
 */

WebDriver driver;
    String expected; String actual;
    String actualOpt1;String expectedOpt1;String actualOpt2;String expectedOpt2;


    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown(){
      // driver.quit();
    }


    @Test (priority = 1)
    public void Test1(){
        driver.get("http://the-internet.herokuapp.com/dropdown");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement text = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        actual = dropdown.getFirstSelectedOption().getText();
        expected =  "Please select an option";
        Assert.assertEquals(actual, expected, "Actual does NOT match expected");

        dropdown.selectByValue("1");
        actualOpt1 = dropdown.getFirstSelectedOption().getText();
        expectedOpt1 = "Option 1";
        Assert.assertEquals(actualOpt1, expectedOpt1, "Actual does NOT match expected");

       dropdown.selectByValue("2");
       actualOpt2 = dropdown.getFirstSelectedOption().getText();
       expectedOpt2 = "Option 2";
       Assert.assertEquals(actualOpt2, expectedOpt2, "Actual does NOT match expected");

       WebElement name = driver.findElement(By.xpath("//h3[.='Dropdown List']"));

       Assert.assertEquals(name.getText(), "Dropdown List", "Actual does NOT match name");


       driver.close();
    }

    /*
    Task 2
1. go to https://www.etsy.com/
2. search for rings
3. validate that Estimated Arrival shows any time
3. click Estimated Arrival dropdown
4. click Select custom date
5. choose may 30 from dropdown
6. validate Estimated Arrival shows may 30
     */

    @Test (priority = 2)
    public void test2(){
        driver.get("https://www.etsy.com/");
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement search = driver.findElement(By.xpath("//input[@id='global-enhancements-search-query']"));
        search.sendKeys("Rings");
        search.sendKeys(Keys.ENTER);



    }


}



