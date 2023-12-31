package com.loop.pages;

import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoopPracticeDragDropPage {

    @FindBy(id="draggable")
    public WebElement smallCircle;

    @FindBy(id="droptarget")
    public WebElement bigCircle;
    @FindBy(xpath= "//a[contains(., 'LOOPCAMP')]")
    public WebElement logo;

    public LoopPracticeDragDropPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
