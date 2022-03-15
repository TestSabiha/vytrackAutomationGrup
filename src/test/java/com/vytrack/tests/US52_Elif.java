package com.vytrack.tests;

import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

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
    public void US52(){

        //Login as store or sales manager
        //Users are on the homepage

        WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username or Email']"));
        username.sendKeys("storemanager54");

        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("UserUser123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn btn-uppercase btn-primary pull-right']"));
        loginButton.click();

        //Click the Vehicle contracts under the Fleet
        WebElement fleet = driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][1]"));
        fleet.click();










        //Verify managers can access the Vehicle contracts page

        //AC1: Store managers and Sales managers access the Vehicle contracts page.
        //Expected URL: https://qa2.vytrack.com/entity/Extend_Entity_VehicleContract
        //Expected title: All - Vehicle Contract - Entities - System - Car - Entities - System

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
