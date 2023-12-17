package com.loop.test.day_8_windowTables;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.PizzaOrderWebTableUtils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class T_2_pizza_order extends TestBase {

 /*
    1. go to https://loopcamp.vercel.app/web-tables.html
    2. create a method to test given field for a given name
    3. test type
    4. test amount
    5. test date
    6. test street
    7. test city
    8. test state
    9. test zip
    10. test card
    11. test card number
    12. test exp
     */


    @Test
    public void test_pyzza_type (){
        driver.get("https://loopcamp.vercel.app/web-tables.html");
        String name = "Alexandra Gray";
        String expectedPizzaType = "Thin Crust";
        String actualPizzaType = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "Pizza type");
        System.out.println("actual Pizza Type = " + actualPizzaType);
        assertEquals(actualPizzaType, expectedPizzaType, "Actual pizza type does NOT match expected");

        String expectedAmount = "2";
        String actualAmount = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "Amount");
        System.out.println("actual Amount = " + actualAmount);
        assertEquals(actualAmount, expectedAmount, "Actual amount does NOT match expected");

        String expectedDate = "04/15/2021";
        String actualDate = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "Date");
        System.out.println("actual Date = " + actualDate);
        assertEquals(actualDate, expectedDate, "Actual date does NOT match expected");

        String expectedStreet = "7, Miller Street";
        String actualStreet = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "Street");
        System.out.println("actual Street = " + actualStreet);
        assertEquals(actualStreet, expectedStreet, "Actual street does NOT match expected");

        String expectedCity = "Chicago, IL";
        String actualCity = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "City");
        System.out.println("actual City = " + actualCity);
        assertEquals(actualCity, expectedCity, "Actual city does NOT match expected");

        String expectedState = "US";
        String actualState = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "State");
        System.out.println("actual State = " + actualState);
        assertEquals(actualState, expectedState, "Actual state does NOT match expected");

        String expectedZip = "748";
        String actualZip = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "Zip");
        System.out.println("actual Zip = " + actualZip);
        assertEquals(actualZip, expectedZip, "Actual zip does NOT match expected");

        String expectedCard = "VISA";
        String actualCard = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "Card");
        System.out.println("actual Card = " + actualCard);
        assertEquals(actualCard, expectedCard, "Actual card does NOT match expected");

        String expectedCardNumber = "321456789012";
        String actualCardNumber = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "Card Number");
        System.out.println("actual Card Number = " + actualCardNumber);
        assertEquals(actualCardNumber, expectedCardNumber, "Actual card number does NOT match expected");

        String expectedExp = "02/24";
        String actualExp = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "Exp");
        System.out.println("actual Exp = " + actualExp);
        assertEquals(actualExp, expectedExp, "Actual exp does NOT match expected");

    }
}
