package com.vytrack.tests;


import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VyTrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US62 {


//    @DataProvider(name = "T1")
//    public Object[][] login_Datas() {
//        return new Object[][]{
//                {"user1"}, //{"salesmanager101"}, {"storemanager51"},
//
//        };
//    }

    @Test   (dataProvider = "T1")
    public void Test1(String email) {
//        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        Driver.getDriver().get("https://qa1.vytrack.com/user/login");
//        Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput']")).sendKeys(email);
//        Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput2']")).sendKeys(ConfigurationReader.getProperty("password"));
//        Driver.getDriver().findElement(By.xpath("//button[.='Log in']")).click();
        VyTrackUtils.loginAsDriver();

        Driver.getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][3]")).click();

        Driver.getDriver().findElement(By.xpath("//span[.='Calendar Events']")).click();

        try {
            Driver.getDriver().findElement(By.xpath("//div[@class='btn-group']")).click();
        } catch (ElementClickInterceptedException e) {

            Driver.getDriver().findElement(By.xpath("//div[@class='btn-group']")).click();
        }


        WebElement TitleFields = Driver.getDriver().findElement(By.xpath("//input[starts-with(@id,'oro_calendar_event_form_title')]"));

        TitleFields.sendKeys("Meeting Time");

        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//iframe[starts-with(@id,'oro_calendar_event_form_description-uid')]")));
        Driver.getDriver().findElement(By.xpath("//p")).sendKeys("Scrum meeting Only");
        Driver.getDriver().switchTo().parentFrame();
        Driver.getDriver().findElement(By.xpath("//input[starts-with(@id,'recurrence-repeat')]")).click();
        Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-success action-button']")).click();

        System.out.println("Driver.getDriver().findElement(By.xpath(\"//p\")).getText() = " + Driver.getDriver().findElement(By.xpath("//p")).getText());


    }


}
