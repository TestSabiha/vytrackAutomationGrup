package com.vytrack.tests;

import com.vytrack.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US62 extends TestBase {
    @DataProvider(name = "LoginAll")
    public Object[][] login_Data() {
        return new Object[][]{
////              {ConfigurationReader.getProperty("driver_username"), ConfigurationReader.getProperty("password")},
//             {ConfigurationReader.getProperty("sales_manager_username"), ConfigurationReader.getProperty("password")},
//               {ConfigurationReader.getProperty("store_manager_username"), ConfigurationReader.getProperty("password")}

               {"user44"},
                {"user49"},
               {"salesmanager133"},
                {"salesmanager136"},
                {"storemanager75"},
                {"storemanager78"}

        };
    }

    @Test(dataProvider = "LoginAll")
    public void Test1(String username) {

      //  WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        BrowserUtils.sleep(3);
        ExtraUtils.loginBy(username);
        ///  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(VyTrackUtils.login(username,password)));
        BrowserUtils.sleep(3);

        ExtraUtils.goToModule("Activities", "Calendar Events");

//        Actions actions = new Actions(Driver.getDriver());
//        try {
//            actions.moveToElement(Driver.getDriver().findElement(By.xpath("//div[@class='btn-group']"))).click().perform();
//        } catch (ElementClickInterceptedException e) {
//            e.printStackTrace();
//      }
///*
//        try {
//            Driver.getDriver().findElement(By.xpath("//a[starts-with(@class,'btn main-group')]")).click();
//        } catch (ElementClickInterceptedException e) {
//            e.printStackTrace();
//        }*/

      //  WebElement clickButton =
        BrowserUtils.sleep(3);
          Driver.getDriver().findElement(By.xpath("(//div[@class='container-fluid page-title']/div/div/div)[2]")).click();

       // wait.until(ExpectedConditions.elementToBeClickable(clickButton));


        WebElement TitleFields = Driver.getDriver().findElement(By.xpath("//input[starts-with(@id,'oro_calendar_event_form_title')]"));

        TitleFields.sendKeys("Meeting Time");

        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//iframe[starts-with(@id,'oro_calendar_event_form_description-uid')]")));
        Driver.getDriver().findElement(By.xpath("//p")).sendKeys("Scrum Daily Meeting");
        // BrowserUtils.sleep(2);
        Driver.getDriver().switchTo().parentFrame();
        Driver.getDriver().findElement(By.xpath("//input[starts-with(@id,'recurrence-repeat')]")).click();
        //  BrowserUtils.sleep(2);
        Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-success action-button']")).click();
        //  BrowserUtils.sleep(3);


        String expectedResult = "Scrum Daily Meeting";
        String actualResult = Driver.getDriver().findElement(By.xpath("//p")).getText();

        System.out.println("Driver.getDriver().findElement(By.xpath(\"//p\")).getText() = " + Driver.getDriver().findElement(By.xpath("//p")).getText());
        // BrowserUtils.sleep(3);
        Assert.assertEquals(actualResult, expectedResult);

       // Driver.getDriver().close();
    }




}

