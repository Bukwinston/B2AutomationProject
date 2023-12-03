package com.loop.test.day_5_testNG_checBox_radioButton_dropdown;

import org.testng.Assert;
import org.testng.annotations.*;

public class T1_testNG_Intro {

    @BeforeClass
    public void setUp(){
        System.out.println("Bfore class is running");
    }

    @AfterClass
    public void TearDown(){
        System.out.println("After class is running");
    }

    @BeforeMethod
    public void setUpMethod(){
        System.out.println("Before method is running");
    }
    @AfterMethod
    public void tearDownMethod(){
        System.out.println("After method is running");
    }


    @Test (priority = 1)
public void test1() {
        System.out.println("Test 1 is running");
        String actual = "Alex";
        String expected = "Alex";
        Assert.assertEquals(actual, expected, "Message from Assertion, it will show if test fails");
    }


    @Test (priority = 2)
public void atest2(){
        System.out.println("Test 2 is running");
    }


}

