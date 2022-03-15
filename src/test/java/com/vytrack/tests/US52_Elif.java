package com.vytrack.tests;

import com.google.common.base.Verify;
import com.vytrack.utilities.VyTrackUtils;
import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class US52_Elif {

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        //User on login page
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://qa2.vytrack.com/user/login");

    }

    @Test
    public void US52_1(){

        //Login as store or store manager
        VyTrackUtils.loginAsStoreManger();

        //Click the Vehicle contracts under the Fleet
        VyTrackUtils.goToPage("Fleet", "Vehicle Contracts");

        //Verify managers can access the Vehicle contracts page
        String expectedURL = "https://qa2.vytrack.com/entity/Extend_Entity_VehicleContract";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL, expectedURL);

    }

    @Test

    public void US52_2(){
        //Login as sales manager
        VyTrackUtils.loginAsSalesManager();

        //Click the Vehicle contracts under the Fleet
        VyTrackUtils.goToPage("Fleet", "Vehicle Contracts");

        //Verify managers can access the Vehicle contracts page
        String expectedURL = "https://qa2.vytrack.com/entity/Extend_Entity_VehicleContract";
        String actualURL = driver.getCurrentUrl();

        assertEquals(actualURL, expectedURL);

    }

    @Test

    public void US52_3(){

        //Login as drivers
        VyTrackUtils.loginAsDriver();

        //Click the Vehicle contracts under the Fleet
        VyTrackUtils.goToPage("Fleet", "Vehicle Contracts");

        //Verify users see an error message: “You do not have permission to perform this action.”
        WebElement errorMessage = driver.findElement(By.linkText("You do not have permission to perform this action."));
        errorMessage.isDisplayed();

    }

}

/*
AC1: Store managers and Sales managers access the Vehicle contracts page.
Expected URL: https://qa2.vytrack.com/entity/Extend_Entity_VehicleContract
Expected title: All - Vehicle Contract - Entities - System - Car - Entities - System

AC2: Drivers should NOT able to access the Vehicle contracts page, the app should display “You do not have permission to perform this action.”

Test cases #1
Description: Managers access the Vehicle contracts page
Environment: https://qa2.vytrack.com/user/login
Steps:
Login as store or sales manager
Click the Vehicle contracts under the Fleet
Verify managers can access the Vehicle contracts page

Test cases #2
Description: Drivers can NOT access the Vehicle contracts page
Environment: https://qa2.vytrack.com/user/login
Steps:
Login as drivers
Click the Vehicle contracts under the Fleet
Verify users see an error message: “You do not have permission to perform this action.”

 */
