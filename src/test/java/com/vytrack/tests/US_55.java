package com.vytrack.tests;

import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VyTrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.module.Configuration;
import java.util.ArrayList;
import java.util.List;

public class US_55 {
    @BeforeMethod
    public void setUp() {

    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }


    @Test
    public void US55_Vehicle_page() {
        VyTrackUtils.loginAsSalesManager();
        //go to Fleet tab
        String fleetTabElementLocator = "//span[normalize-space()='Fleet' and contains(@class, 'title title-level-1')]";

        WebElement fleetTabElement = Driver.getDriver().findElement(By.xpath(fleetTabElementLocator));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(fleetTabElement).perform();

        //click Vehicles  Selection
        String vehiclesLocator = " //div//span[.='Vehicles']";
        WebElement vehiclesElement = Driver.getDriver().findElement(By.xpath(vehiclesLocator));
        vehiclesElement.click();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //checkboxes should be unchecked
    }

    @Test
    public void check_box() {

        //first checkbox to check all the cars
        VyTrackUtils.loginAsSalesManager();
        String headerCheckboxesElement = "//thead/tr/th[1]/div/button/input";

        WebElement checkbox = Driver.getDriver().findElement(By.xpath(headerCheckboxesElement));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(checkbox).perform();
        checkbox.click();

        //first checkbox to check all the cars



    }

}
    

