package com.vytrack.tests;


import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VyTrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class US {

    @BeforeMethod
    public void setUp(){

    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

    @DataProvider(name = "roles")
    public Object[][] provideRoles() {
        return new Object[][]{
                {"salesmanager101", "UserUser123" },
                {"salesmanager102", "UserUser123" },
                {"salesmanager103", "UserUser123" },
                {"salesmanager104", "UserUser123" },
                {"storemanager51", "UserUser123" },
                {"storemanager52", "UserUser123" },
                {"storemanager53", "UserUser123" },
                {"storemanager54", "UserUser123" },
                {"user1", "UserUser123"},
                {"user2", "UserUser123"},
                {"user3", "UserUser123"},
                {"user4", "UserUser123"},
                {"user5", "UserUser123"},
                {"user6", "UserUser123"},
        };
    }

    @Test(dataProvider = "roles")
    public void verify_modules_as_user(String role, String password) {

        VyTrackUtils.login(role, password);
        VyTrackUtils.waitTillLoaderMaskDisappear();

        List<WebElement> mainModules = new ArrayList<>();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainModules = Driver.getDriver().findElements(By.xpath("//span[@class='title title-level-1']"));

        BrowserUtils.sleep(1);
        for (WebElement each : mainModules) {
            Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            System.out.println(each.getText());
            Assert.assertTrue(each.isDisplayed());
        }


    }





}



