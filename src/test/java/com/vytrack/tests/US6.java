package com.vytrack.tests;


import com.vytrack.utilities.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class US6 {

    /*
    Story6:  As a user, I want to see edit car info icons from the Vehicle page.
    AC #1:  users should see “view, edit, delete” when they hover the mouse to the 3 dots “…”

     */


    @Test
    public void US6_test() throws InterruptedException {

        //1.	Users are on the homepage
        Driver.getDriver().get("https://qa2.vytrack.com/user/login ");

        //2.    Users can log in as a store manager
        WebElement usernameInput = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput']"));
        usernameInput.sendKeys("storemanager51");

        WebElement passwordInput = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput2']"));
        passwordInput.sendKeys("UserUser123");

        WebElement loginBtn = Driver.getDriver().findElement(By.xpath("//button[@id='_submit']"));
        loginBtn.click();

        //3.	Click the Vehicles under the Fleet
        WebElement fleet = Driver.getDriver().findElement(By.xpath("//ul[@class='nav-multilevel main-menu']/li[2]"));
        Thread.sleep(1000);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(fleet).perform();

        Thread.sleep(1000);

        //4.	Verify any car info has 3 dots “...”, and there are “view, edit, delete” icons

        WebElement vehicle = Driver.getDriver().findElement(By.xpath("//ul[@class='nav-multilevel main-menu']/li[2]/div/div/ul/li[3]"));

        vehicle.click();


        WebElement threeDot = Driver.getDriver().findElement(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr[1]/td[21]/div/div"));

        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true)", threeDot);

        actions.moveToElement(threeDot).perform();

        List<WebElement> list = Driver.getDriver().findElements(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr[1]/td[21]/div/div/ul/li/ul/li"));

        for (WebElement each : list) {
            Assert.assertTrue(each.isDisplayed());
        }



    }



}
