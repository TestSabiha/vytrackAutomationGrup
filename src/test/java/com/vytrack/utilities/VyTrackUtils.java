package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VyTrackUtils {
    public static void login(String username, String password) {
        //go to website
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        // pass username
        // Driver.getDriver().findElement(By.cssSelector("#prependedInput"));
        Driver.getDriver().findElement(By.id("prependedInput")).sendKeys(username);
        //pass password
        Driver.getDriver().findElement(By.cssSelector("#prependedInput2")).sendKeys(password);
        //click login button
        Driver.getDriver().findElement(By.tagName("button")).click();

    }

    public static void loginAsDriver() {
        //go to website
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        // pass username
        // Driver.getDriver().findElement(By.cssSelector("#prependedInput"));
        Driver.getDriver().findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.getProperty("driver_username"));
        //pass password
        Driver.getDriver().findElement(By.cssSelector("#prependedInput2")).sendKeys(ConfigurationReader.getProperty("password"));
        //click login button
        Driver.getDriver().findElement(By.tagName("button")).click();
    }

    public static void loginAsStoreManger() {
        //go to website
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        // pass username
        // Driver.getDriver().findElement(By.cssSelector("#prependedInput"));
        Driver.getDriver().findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.getProperty("store_manager_username"));
        //pass password
        Driver.getDriver().findElement(By.cssSelector("#prependedInput2")).sendKeys(ConfigurationReader.getProperty("password"));
        //click login button
        Driver.getDriver().findElement(By.tagName("button")).click();
    }

    public static void loginAsSalesManager() {
        //go to website
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        // pass username
        // Driver.getDriver().findElement(By.cssSelector("#prependedInput"));
        Driver.getDriver().findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.getProperty("sales_manager_username"));
        //pass password
        Driver.getDriver().findElement(By.cssSelector("#prependedInput2")).sendKeys(ConfigurationReader.getProperty("password"));
        //click login button
        Driver.getDriver().findElement(By.tagName("button")).click();
    }

    public static void waitTillLoaderMaskDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
            WebElement loaderMask = Driver.getDriver().findElement(By.cssSelector("div[class='loader-mask shown']"));
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void goToPage(String superTab, String subTab) {
        String TabElementLocator = "//span[normalize-space()='" + superTab + "' and contains(@class, 'title title-level-1')]";

        WebElement TabElement = Driver.getDriver().findElement(By.xpath(TabElementLocator));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(TabElement).perform();

        String subModuleLocator = "//span[normalize-space()='" + subTab + "' and contains(@class, 'title title-level-2')]";
        WebElement vehiclesModelElement = Driver.getDriver().findElement(By.xpath(subModuleLocator));
        //we are using for waiting until loader mask disappearing
        VyTrackUtils.waitTillLoaderMaskDisappear();
        vehiclesModelElement.click();
        VyTrackUtils.waitTillLoaderMaskDisappear();
    }
}
