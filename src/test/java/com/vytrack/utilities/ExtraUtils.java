package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExtraUtils {
    public static void goToModule(String head, String module) {
        // WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        //  WebElement activities =
        Driver.getDriver().findElement(By.linkText(head)).click();
        //wait.until(ExpectedConditions.elementToBeClickable(activities));
        Driver.getDriver().findElement(By.linkText(module)).click();


    }

    public static void loginBy(String username) {
        //go to website
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        // pass username
        // Driver.getDriver().findElement(By.cssSelector("#prependedInput"));
        Driver.getDriver().findElement(By.id("prependedInput")).sendKeys(username);
        //pass password
        Driver.getDriver().findElement(By.cssSelector("#prependedInput2")).sendKeys(ConfigurationReader.getProperty("driver_password"));
        //click login button
        Driver.getDriver().findElement(By.tagName("button")).click();

    }
}