package com.vytrack.tests;

import com.vytrack.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class US62 extends TestBase {


    @Test(dataProvider = "LoginAll", dataProviderClass = DataProviderUtil.class)
    public void Test1(String username) {



        moduleUtils.loginBy(username);

        VyTrackUtils.waitTillLoaderMaskDisappear();
        moduleUtils.goToModule("Activities", "Calendar Events");

        VyTrackUtils.waitTillLoaderMaskDisappear();
        Driver.getDriver().findElement(By.xpath("(//div[@class='container-fluid page-title']/div/div/div)[2]")).click();


        WebElement TitleFields = Driver.getDriver().findElement(By.xpath("//input[starts-with(@id,'oro_calendar_event_form_title')]"));

        TitleFields.sendKeys("Meeting Time");

        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//iframe[starts-with(@id,'oro_calendar_event_form_description-uid')]")));
        Driver.getDriver().findElement(By.xpath("//p")).sendKeys("Scrum Daily Meeting");

        Driver.getDriver().switchTo().parentFrame();
        Driver.getDriver().findElement(By.xpath("//input[starts-with(@id,'recurrence-repeat')]")).click();

        Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-success action-button']")).click();



        String expectedResult = "Scrum Daily Meeting";
        String actualResult = Driver.getDriver().findElement(By.xpath("//p")).getText();

        System.out.println("Driver.getDriver().findElement(By.xpath(\"//p\")).getText() = " + Driver.getDriver().findElement(By.xpath("//p")).getText());

        Assert.assertEquals(actualResult, expectedResult);

    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }


}

