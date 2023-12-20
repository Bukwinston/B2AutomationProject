package com.loop.test.day_8_windowTables;

import com.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class T_2_llc_registration2 extends TestBase {

    @Test
    public void llcRegister() {
        // COMPANY INFORMATION STEP
        driver.get("https://app.docuport.app/company-formation/resident");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement typeOfBusiness = driver.findElement(By.xpath("//label[.= 'Corporation']/../div/div"));
        typeOfBusiness.click();
        WebElement state = driver.findElement(By.xpath("//label[.= 'Virginia']/../div/div"));
        state.click();
        WebElement legalName = driver.findElement(By.xpath("//label[.= 'Legal Company Name  *']/../input"));
        legalName.sendKeys("John Brown");
        WebElement availability = driver.findElement(By.xpath("//a[.= 'Check name availability']"));
        availability.click();
        String parent = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles) {
            System.out.println("each window's handle = " + each);
            driver.switchTo().window(each);}
        WebElement nameEnter = driver.findElement(By.xpath("//input[@id='txtEntityName']"));
        nameEnter.sendKeys("John Brown");
        WebElement nameCheck = driver.findElement(By.xpath("//input[@value='Name Check']"));
        nameCheck.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement confirmation = driver.findElement(By.xpath("//span[.='The Name is Available']"));
        String actualConfirm = confirmation.getText();
        String expectedConfirm = "The Name is Available";
        Assert.assertEquals(actualConfirm, expectedConfirm, "Actual does NOT match expected");
        driver.close();
        driver.switchTo().window(parent);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement dba = driver.findElement(By.xpath("//label[.= 'DBA (Doing Business As)']/following-sibling::input"));
        dba.sendKeys("John Brown Incorporation");
        WebElement industry = driver.findElement(By.xpath("//label[.= 'Industry *']/following-sibling::input"));
        industry.click();
        WebElement foodService = driver.findElement(By.xpath("//div[.= 'Food Services']/div/div"));
        foodService.click();
        WebElement firstName = driver.findElement(By.xpath("(//label[.= 'First name *']/following-sibling::input)[1]"));
        firstName.sendKeys("John");
        WebElement lastName = driver.findElement(By.xpath("(//label[.= 'Last name *']/following-sibling::input)[1]"));
        lastName.sendKeys("Brown");
        WebElement emailAdress = driver.findElement(By.xpath("//label[.= 'Email address *']/following-sibling::input"));
        emailAdress.sendKeys("jo-bro@gmail.com");
        WebElement phoneNumber = driver.findElement(By.xpath("(//label[.= 'Phone number *']/following-sibling::input)[1]"));
        phoneNumber.sendKeys("252-635-0001");
        WebElement fax = driver.findElement(By.xpath("//label[.= 'Fax']/following-sibling::input"));
        fax.sendKeys("252-365-7557");
        WebElement nextButton = driver.findElement(By.xpath("(//span[.=' Next ']/..)[1]"));
        nextButton.click();
        // REGISTERED AGENT AND BUSINESS ADDRESS STEP
        // Agent information
        WebElement fisrtNameA = driver.findElement(By.xpath("(//label[.= 'First name *']/following-sibling::input)[2]"));
        fisrtNameA.sendKeys("Mike");
        WebElement lastNameA = driver.findElement(By.xpath("(//label[.= 'Last name *']/following-sibling::input)[2]"));
        lastNameA.sendKeys("Smith");
        WebElement middleName = driver.findElement(By.xpath("(//label[.= 'Middle name']/following-sibling::input)[1]"));
        middleName.sendKeys("None");
        WebElement addressLineA = driver.findElement(By.xpath("(//label[.= 'Address line 1 *']/following-sibling::input)[1]"));
        addressLineA.sendKeys("5698 Forest Way");
        WebElement addressLine2A = driver.findElement(By.xpath("(//label[.= 'Address line 2']/following-sibling::input)[1]"));
        addressLine2A.sendKeys("office 45");
        WebElement cityA = driver.findElement(By.xpath("(//label[.= 'City *']/following-sibling::input)[1]"));
        cityA.sendKeys("Richmond");
        WebElement jurisdictionA = driver.findElement(By.xpath("(//label[.= 'Jurisdiction *']/following-sibling::input)[1]"));
        jurisdictionA.click();
        WebElement accomack = driver.findElement(By.xpath("(//div[.='Accomack'])[1]"));
        accomack.click();
        WebElement zipA = driver.findElement(By.xpath("(//label[.= 'Zip code *']/following-sibling::input)[1]"));
        zipA.sendKeys("25698");
        WebElement emailA = driver.findElement(By.xpath("(//label[.= 'Email address']/following-sibling::input)[1]"));
        emailA.sendKeys("mike1978@gmail.com");
        WebElement phoneNumberA = driver.findElement(By.xpath("(//label[.= 'Phone number *']/following-sibling::input)[2]"));
        phoneNumberA.sendKeys("252-632-0002");
        // Business address
        WebElement addBisnessAddress = driver.findElement(By.xpath("//label[.= 'Add Business Address']"));
        addBisnessAddress.click();
        WebElement addressLineB = driver.findElement(By.xpath("(//label[.= 'Address line 1 *']/following-sibling::input)[2]"));
        addressLineB.sendKeys("6336 Green way");
        WebElement addressLine2B = driver.findElement(By.xpath("(//label[.= 'Address line 2']/following-sibling::input)[2]"));
        addressLine2B.sendKeys("None");
        WebElement cityB = driver.findElement(By.xpath("(//label[.= 'City *']/following-sibling::input)[2]"));
        cityB.sendKeys("Arlington");
        WebElement zipB = driver.findElement(By.xpath("(//label[.= 'Zip code *']/following-sibling::input)[2]"));
        zipB.sendKeys("26761");
        WebElement emailB = driver.findElement(By.xpath("(//label[.= 'Email address']/following-sibling::input)[2]"));
        emailB.sendKeys("johnfoods@gmail.com");
        WebElement phoneNumberB = driver.findElement(By.xpath("//label[.='Phone number']/following-sibling::input"));
        phoneNumberB.sendKeys("252-456-0003");
        WebElement nextButton2 = driver.findElement(By.xpath("(//span[.=' Next ']/..)[2]"));
        nextButton2.click();
        // MANAGEMENT STRUCTURE
        // President title
        WebElement title1 = driver.findElement(By.xpath("//label[.='Title *']/../div/input"));
        title1.click();
        WebElement president = driver.findElement(By.xpath("//div[.='President']/../div/div/div/div"));
        president.click();
        WebElement fisrtNameP = driver.findElement(By.xpath("(//label[.= 'First name *']/following-sibling::input)[3]"));
        fisrtNameP.sendKeys("John");
        WebElement lastNameP = driver.findElement(By.xpath("(//label[.= 'Last name *']/following-sibling::input)[3]"));
        lastNameP.sendKeys("Brown");
        WebElement middleNameP = driver.findElement(By.xpath("(//label[.= 'Middle name']/following-sibling::input)[2]"));
        middleNameP.sendKeys("None");
        WebElement shareOwnershipP = driver.findElement(By.xpath("(//label[.= 'Share Ownership (%) *']/following-sibling::input)[1]"));
        shareOwnershipP.sendKeys("75");
        WebElement checkDirector = driver.findElement(By.xpath("//label[.= 'Are you the director?']/../div"));
        checkDirector.click();
        WebElement addOfficer = driver.findElement(By.xpath("//span[.= ' Add additional officer ']/../span/i"));
        addOfficer.click();
        // Vice President title
        WebElement title2 = driver.findElement(By.xpath("(//label[.='Title *']/../div/input)[2]"));
        title2.click();
        WebElement vicePresident = driver.findElement(By.xpath("(//div[.='Vice President']/../div/div/div/div)[5]"));
        vicePresident.click();
        WebElement fisrtNameVP = driver.findElement(By.xpath("(//label[.= 'First name *']/following-sibling::input)[4]"));
        fisrtNameVP.sendKeys("Oliver");
        WebElement lastNameVP = driver.findElement(By.xpath("(//label[.= 'Last name *']/following-sibling::input)[4]"));
        lastNameVP.sendKeys("Twist");
        WebElement middleNameVP = driver.findElement(By.xpath("(//label[.= 'Middle name']/following-sibling::input)[3]"));
        middleNameVP.sendKeys("None");
        WebElement shareOwnershipVP = driver.findElement(By.xpath("(//label[.= 'Share Ownership (%) *']/following-sibling::input)[2]"));
        shareOwnershipVP.sendKeys("25");
        WebElement ssn = driver.findElement(By.xpath("//label[.= 'SSN of an Organizing Member *']/following-sibling::input"));
        ssn.sendKeys("458-25-2598");
        WebElement fisrtNameO = driver.findElement(By.xpath("(//label[.= 'First name *']/following-sibling::input)[5]"));
        fisrtNameO.sendKeys("John");
        WebElement lastNameO = driver.findElement(By.xpath("(//label[.= 'Last name *']/following-sibling::input)[5]"));
        lastNameO.sendKeys("Brown");
        WebElement goToPaymentButton = driver.findElement(By.xpath("//span[.= ' Go to payment ']/.."));
        goToPaymentButton.click();

    }
}




