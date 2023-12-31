package com.loop.test.day_11_waits_pom;

import com.loop.pages.LoopPracticeDynamicLoadingPage;
import com.loop.test.utilities.BrowserUtils;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class T_2_explicit_wait {
    /*
          1. go https://loopcamp.vercel.app/dynamic_loading/7.html
          2. Wait until title is “Dynamic title”
          3. Assert: Message “Done!” is displayed.
          4. Assert: Image is displayed.
        */
    LoopPracticeDynamicLoadingPage loopPracticeDynamicLoadingPage;
    WebDriverWait wait;

    @BeforeMethod
    public void setUpMethod() {
        loopPracticeDynamicLoadingPage = new LoopPracticeDynamicLoadingPage();
        Driver.getDriver().get("https://loopcamp.vercel.app/dynamic_loading/7.html");
    }

    @Test
    public void explicit_wait_test() {
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("Dynamic title"));
        assertEquals(Driver.getDriver().getTitle(), "Dynamic title", "Actual DOES NOT match");
        assertTrue(loopPracticeDynamicLoadingPage.doneMessage.isDisplayed());
        assertTrue(loopPracticeDynamicLoadingPage.image.isDisplayed());
//        loopPracticeDynamicLoadingPage.doneMessage.click();
//        BrowserUtils.waitForVisibility(loopPracticeDynamicLoadingPage.doneMessage, 10);  ---- with using method
    }

    @AfterClass
    public void tearDown() {
        Driver.getDriver().close();
    }
}
