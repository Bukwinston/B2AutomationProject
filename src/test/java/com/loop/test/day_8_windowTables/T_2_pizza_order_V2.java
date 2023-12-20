package com.loop.test.day_8_windowTables;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.PizzaOrderWebTableUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class T_2_pizza_order_V2 extends TestBase {

    @Test
    public void testPizzaOrder (){
        driver.get("https://loopcamp.vercel.app/web-tables.html");
        PizzaOrderWebTableUtils.orderInfoemation("Alexandra Gray","Thin Crust","2","04/15/2021","7, Miller Street",
                                           "Chicago, IL","US","748","VISA","321456789012","02/24");



    }

@Test
    public void testPizzaOrder2 (){
    driver.get("https://loopcamp.vercel.app/web-tables.html");
    PizzaOrderWebTableUtils.orderInfoemation("Robert Baratheon","Hawaiian","4","12/04/2021","29, Sanderson Ave","Bluecity, CA",
                                            "US","63325","MasterCard","776565770000","03/26");
}

}
