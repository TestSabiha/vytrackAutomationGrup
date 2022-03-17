package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.moduleUtils;
import com.vytrack.utilities.VyTrackUtils;
import com.vytrack.utilities.moduleUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.Utils;

import java.util.List;

public class US61 {

    @Test
    public void storeManagerCanManageFilters() {

        // Log in to the page as a Store Manager
        VyTrackUtils.loginAsStoreManger();
        BrowserUtils.sleep(2);

        // Go to "Marketing", then go to "Campaigns"
        moduleUtils.goToModule("Marketing", "Campaigns");
        BrowserUtils.sleep(2);

        // Locate Filter icon and click it
        Driver.getDriver().findElement(By.xpath("//a[@title='Filters']")).click();
        BrowserUtils.sleep(2);

        // Go to Manage Filers and click it
        Driver.getDriver().findElement(By.xpath("//a[@class='add-filter-button']")).click();
        BrowserUtils.sleep(2);

        // Locate all checkboxes
        List<WebElement> allCheckBoxes = Driver.getDriver().findElements(By.xpath("//ul//input[@name='multiselect_0']"));

        // Assert if the checkboxes are checked by default
        for (WebElement eachCheckBox : allCheckBoxes) {
            Assert.assertTrue(eachCheckBox.isSelected());
        }

        // Any checkboxes can be unchecked
        WebElement codeCheckBox = Driver.getDriver().findElement(By.xpath("//label[@title='Name']"));
        codeCheckBox.click();
        BrowserUtils.sleep(1);

        WebElement nameCheckBox = Driver.getDriver().findElement(By.xpath("//label[@title='Name']"));
        nameCheckBox.click();
        BrowserUtils.sleep(1);

        WebElement startDateCheckBox = Driver.getDriver().findElement(By.xpath("//label[@title='Start Date']"));
        startDateCheckBox.click();
        BrowserUtils.sleep(1);

        WebElement endDateCheckBox = Driver.getDriver().findElement(By.xpath("//label[@title='End Date']"));
        endDateCheckBox.click();
        BrowserUtils.sleep(1);

        WebElement budgetCheckBox = Driver.getDriver().findElement(By.xpath("//label[@title='Budget']"));
        budgetCheckBox.click();
        BrowserUtils.sleep(1);

        Driver.closeDriver();

    }

    @Test

    public void salesManagerCanManageFilters() {

        // Log in to the page as a Sales Manager
        VyTrackUtils.loginAsSalesManager();
        BrowserUtils.sleep(2);

        // Go to "Marketing", then go to "Campaigns"
        moduleUtils.goToModule("Marketing", "Campaigns");
        BrowserUtils.sleep(2);

        // Locate Filter icon and click it
        Driver.getDriver().findElement(By.xpath("//a[@title='Filters']")).click();
        BrowserUtils.sleep(2);

        // Go to Manage Filers and click it
        Driver.getDriver().findElement(By.xpath("//a[@class='add-filter-button']")).click();
        BrowserUtils.sleep(2);

        // Locate all checkboxes
        List<WebElement> allCheckBoxes = Driver.getDriver().findElements(By.xpath("//ul//input[@name='multiselect_0']"));

        // Assert if the checkboxes are checked by default
        for (WebElement eachCheckBox : allCheckBoxes) {
            Assert.assertTrue(eachCheckBox.isSelected());
        }

        // Any checkboxes can be unchecked
        WebElement codeCheckBox = Driver.getDriver().findElement(By.xpath("//label[@title='Name']"));
        codeCheckBox.click();
        BrowserUtils.sleep(1);

        WebElement nameCheckBox = Driver.getDriver().findElement(By.xpath("//label[@title='Name']"));
        nameCheckBox.click();
        BrowserUtils.sleep(1);

        WebElement startDateCheckBox = Driver.getDriver().findElement(By.xpath("//label[@title='Start Date']"));
        startDateCheckBox.click();
        BrowserUtils.sleep(1);

        WebElement endDateCheckBox = Driver.getDriver().findElement(By.xpath("//label[@title='End Date']"));
        endDateCheckBox.click();
        BrowserUtils.sleep(1);

        WebElement budgetCheckBox = Driver.getDriver().findElement(By.xpath("//label[@title='Budget']"));
        budgetCheckBox.click();
        BrowserUtils.sleep(1);

        Driver.closeDriver();


    }
}

