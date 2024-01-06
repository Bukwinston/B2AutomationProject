package com.loop.pages;

import com.loop.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SecureSmartBear {
    public SecureSmartBear(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "ctl00_MainContent_username")
    public WebElement username;
    @FindBy(id = "ctl00_MainContent_password")
    public WebElement password;
    @FindBy(id = "ctl00_MainContent_login_button")
    public WebElement loginButton;
    @FindBy(xpath = "//a[@href='Default.aspx']")
    public WebElement allOrders;
    @FindBy(tagName = "a")
    public List<WebElement> list;
    @FindBy(xpath = "//a[@href='Process.aspx']")
    public WebElement order;
    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantity;
    @FindBy(xpath = "//input[@type='submit']")
    public WebElement calculate;
    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    public WebElement customerName;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement street;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement city;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement state;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zipCode;
    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    public WebElement cardType;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNumber;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement expDate;
    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processButton;
    @FindBy(xpath = "//div[@class='buttons_process']/strong")
    public WebElement verifyMessage;

}
