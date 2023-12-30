package com.loop.test.tasks.day_10;

import com.loop.test.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.loop.test.utilities.Driver.getDriver;
import static org.testng.Assert.assertEquals;

public class Dag_And_Drop {
    By small = By.id("draggable");
    By large = By.id("droptarget");
    By outside = By.xpath("//a[contains(., 'LOOPCAMP')]");
    public Actions actions() {return new Actions(getDriver());}

    @BeforeTest
    public void setUp() {getDriver().get(ConfigurationReader.getProperty("loop.draganddrop"));}

    @AfterTest
    public void tearDown() {getDriver().close();}

    @Test(priority = 1)
    public void task1() {
        assertEquals(getDriver().getTitle(), "Drag and Drop Circles", "Title DOES NOT match");
        actions().clickAndHold(getDriver().findElement(small)).moveToElement(getDriver().findElement(large)).perform();
        assertEquals(getDriver().findElement(large).getText(), "Now drop...", "Actual DOES NOT match expected");
    }
    @Test(priority = 2)
    public void task2() {
        assertEquals(getDriver().getTitle(), "Drag and Drop Circles", "Title DOES NOT match");
        actions().dragAndDrop(getDriver().findElement(small), getDriver().findElement(outside)).perform();
        assertEquals(getDriver().findElement(large).getText(), "Try again!", "Actual DOES NOT match expected");
    }
    @Test(priority = 3)
    public void drop() {
        actions().dragAndDrop(getDriver().findElement(small), getDriver().findElement(large)).perform();
        assertEquals(getDriver().findElement(large).getText(), "You did great!", "Actual DOES NOT match expected");
    }
}

