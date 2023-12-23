package com.loop.test.tasks.day_9;

import com.github.javafaker.Faker;
import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;

public class Registration_Form {
    @Test
    public void regFormTest() {
        Driver.getDriver().get(ConfigurationReader.getProperty("reg"));
        Faker faker = new Faker();
        WebElement firstName = Driver.getDriver().findElement(By.name("firstname"));
        firstName.sendKeys(faker.name().firstName());
        WebElement lastName = Driver.getDriver().findElement(By.name("lastname"));
        lastName.sendKeys(faker.name().lastName());
        WebElement username = Driver.getDriver().findElement(By.name("username"));
        username.sendKeys(faker.name().username().replace(".", ""));
        WebElement email = Driver.getDriver().findElement(By.name("email"));
        email.sendKeys(faker.internet().emailAddress());
        WebElement password = Driver.getDriver().findElement(By.name("password"));
        password.sendKeys(faker.internet().password());
        WebElement phoneNumber = Driver.getDriver().findElement(By.name("phone"));
        phoneNumber.sendKeys(faker.numerify("###-###-####"));
        WebElement gender = Driver.getDriver().findElement(By.xpath("//input[@value='male']"));
        gender.click();
        WebElement dateBirth = Driver.getDriver().findElement(By.name("birthday"));
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String dob = sdf.format(faker.date().birthday(18, 60));
        dateBirth.sendKeys(dob);
        Select select = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        select.selectByIndex(4);
        Select dropdown2 = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        dropdown2.selectByVisibleText("QA");
        WebElement progLang = Driver.getDriver().findElement(By.xpath("//input[@value='java']"));
        progLang.click();
        WebElement singButton = Driver.getDriver().findElement(By.id("wooden_spoon"));
        singButton.click();
        WebElement message = Driver.getDriver().findElement(By.xpath("//div[@id='flash-messages']/div"));
        Assert.assertEquals(message.getText(), "Thanks for signing up!", "Actual message does NOT match excepted");
        Driver.getDriver().quit();
    }
}
