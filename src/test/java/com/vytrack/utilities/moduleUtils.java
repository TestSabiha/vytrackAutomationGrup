package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class moduleUtils {
    public static void goToModule(String head, String module) {
       Actions actions = new Actions(Driver.getDriver());
       actions.moveToElement(Driver.getDriver().findElement(By.linkText(head))).perform();


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