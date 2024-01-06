package com.loop.test.day_11_waits_pom;
import com.loop.pages.LoopPracticeDragDropPage;
import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.loop.test.utilities.Driver.getDriver;
import static org.testng.Assert.assertEquals;

public class T_1_drag_drop_pom {
     /*
    Loop Practice Drag and Drop Test
    1. Open a Chrome browser
    2. Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
    3. validate expected default text appears on big circle
    Expected = "Drag the small circle here."

    Loop Practice Drag and Drop Test
    1. Open a Chrome browser
    2. Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
    3. Click and hold small circle
    4. validate "Drop here." text appears on big circle

    1. Open a Chrome browser
    2. Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
    3. Click and hold small circle
    4. Move it on top of the big circle
    5. validate “Now drop…” text appears on big circ

    1. Open a Chrome browser
    2. Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
    3. Click and hold small circle
    4. Dropped anywhere outside big circle
    5. validate “Try again!” text appears on big circle
     */

    LoopPracticeDragDropPage LoopPracticeDragDropPage;
    Actions actions;

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("loop.draganddrop"));
        LoopPracticeDragDropPage = new LoopPracticeDragDropPage();
        actions = new Actions(Driver.getDriver());
    }

    @Test
    public void drag_small_here_test(){
        String expected = "Drag the small circle here.";
        String actual = LoopPracticeDragDropPage.bigCircle.getText();
        assertEquals(actual, expected, "Actual DOES NOT match expected");
    }
    @Test
    public void drag_and_hold(){
        actions.clickAndHold(LoopPracticeDragDropPage.smallCircle).moveByOffset(100, 100).perform();
        assertEquals(LoopPracticeDragDropPage.bigCircle.getText(), "Drop here.", "Actual DOES NOT match expected");
    }
    @Test
    public void moveToBigCircle(){
        actions.clickAndHold(LoopPracticeDragDropPage.smallCircle).moveToElement(LoopPracticeDragDropPage.bigCircle).perform();
        assertEquals(LoopPracticeDragDropPage.bigCircle.getText(), "Now drop...", "Actual DOES NOT match expected");
    }
    @Test
    public void dropAnywhere(){
        actions.dragAndDrop(LoopPracticeDragDropPage.smallCircle, LoopPracticeDragDropPage.logo).perform();
        assertEquals(LoopPracticeDragDropPage.bigCircle.getText(), "Try again!", "Actual DOES NOT match expected");
    }
    @AfterClass
    public void tearDown(){
        Driver.getDriver().close();
    }
}
