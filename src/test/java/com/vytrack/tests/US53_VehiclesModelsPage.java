package com.vytrack.tests;


import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VyTrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US53_VehiclesModelsPage {

    @BeforeMethod
    public void setUp() {
        //Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        System.out.println("Test is started");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Test is finished");
        Driver.closeDriver();
    }

    @Test
    public void verify_columns_as_sales_manager() {

        //login as sales manager
        VyTrackUtils.loginAsSalesManager();

        //go to Fleet tab
        String fleetTabElementLocator = "//span[normalize-space()='Fleet' and contains(@class, 'title title-level-1')]";

        WebElement fleetTabElement = Driver.getDriver().findElement(By.xpath(fleetTabElementLocator));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(fleetTabElement).perform();

        //click Vehicles Model Selection
        String vehiclesModelModuleLocator = "//span[normalize-space()='Vehicles Model' and contains(@class, 'title title-level-2')]";
        WebElement vehiclesModelElement = Driver.getDriver().findElement(By.xpath(vehiclesModelModuleLocator));
        vehiclesModelElement.click();
        BrowserUtils.sleep(3);

        //Verify 10 columns on Vehicle Models Page
        List<WebElement> headerElements = Driver.getDriver().findElements(By.xpath("//thead[@class='grid-header']//th//span[@class='grid-header-cell__label']"));
        System.out.println("Number of Columns " + headerElements.size());
        List<String> headerTitles = new ArrayList<>();
        for (WebElement eachTitle : headerElements) {
            headerTitles.add(eachTitle.getText());
        }
        // headerElements.forEach(k -> headerTitles.add(k.getText()));

        List<String> actualheadersFromVehicleModelTable = headerTitles;
        List<String> expectedheadersFromVehicleModelTable = new ArrayList<>(Arrays.asList(
                "MODEL NAME",
                "MAKE",
                "CAN BE REQUESTED",
                "CVVI",
                "CO2 FEE (/MONTH)",
                "COST (DEPRECIATED)",
                "TOTAL COST (DEPRECIATED)",
                "CO2 EMISSIONS",
                "FUEL TYPE",
                "VENDORS"
        ));

        //verify header columns
        Assert.assertEquals(actualheadersFromVehicleModelTable, expectedheadersFromVehicleModelTable);

    }

    @Test
    public void verify_columns_as_store_manager() {
        //login at store manager
        VyTrackUtils.loginAsStoreManger();
        //go to Fleet tab
        String fleetTabElementLocator = "//span[normalize-space()='Fleet' and contains(@class, 'title title-level-1')]";

        WebElement fleetTabElement = Driver.getDriver().findElement(By.xpath(fleetTabElementLocator));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(fleetTabElement).perform();
        //click Vehicles Model Selection
        String vehiclesModelModuleLocator = "//span[normalize-space()='Vehicles Model' and contains(@class, 'title title-level-2')]";
        WebElement vehiclesModelElement = Driver.getDriver().findElement(By.xpath(vehiclesModelModuleLocator));
        vehiclesModelElement.click();
        BrowserUtils.sleep(3);
        //Verify 10 columns on Vehicle Models Page
        List<WebElement> headerElements = Driver.getDriver().findElements(By.xpath("//thead[@class='grid-header']//th//span[@class='grid-header-cell__label']"));
        System.out.println("Number of Columns " + headerElements.size());
        List<String> headerTitles = new ArrayList<>();
        for (WebElement eachTitle : headerElements) {
            headerTitles.add(eachTitle.getText());
        }

        List<String> actualheadersFromVehicleModelTable = headerTitles;
        List<String> expectedheadersFromVehicleModelTable = new ArrayList<>(Arrays.asList(
                "MODEL NAME",
                "MAKE",
                "CAN BE REQUESTED",
                "CVVI",
                "CO2 FEE (/MONTH)",
                "COST (DEPRECIATED)",
                "TOTAL COST (DEPRECIATED)",
                "CO2 EMISSIONS",
                "FUEL TYPE",
                "VENDORS"
        ));

        //verify header columns
        Assert.assertEquals(actualheadersFromVehicleModelTable, expectedheadersFromVehicleModelTable);
    }

    @Test
    public void verify_columns_as_driver() {
        //login as driver
        VyTrackUtils.loginAsDriver();
        //go to Fleet tab
        String fleetTabElementLocator = "//span[normalize-space()='Fleet' and contains(@class, 'title title-level-1')]";

        WebElement fleetTabElement = Driver.getDriver().findElement(By.xpath(fleetTabElementLocator));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(fleetTabElement).perform();
        //click Vehicles Model Selection
        String vehiclesModelModuleLocator = "//span[normalize-space()='Vehicles Model' and contains(@class, 'title title-level-2')]";
        WebElement vehiclesModelElement = Driver.getDriver().findElement(By.xpath(vehiclesModelModuleLocator));
        vehiclesModelElement.click();
        BrowserUtils.sleep(3);

        WebElement errMsg = Driver.getDriver().findElement(By.xpath("//div[.='You do not have permission to perform this action.']"));
        String expectedMessage = "You do not have permission to perform this action.";
        String actualMessage = errMsg.getText();

        Assert.assertEquals(actualMessage, expectedMessage);


    }
}
