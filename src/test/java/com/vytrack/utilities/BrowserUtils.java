package com.vytrack.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

/*
in this class only generate utulity methods that are not related to dsome spesfic page
 */
public class BrowserUtils {


    /*
        This method will accept int (in seconds) and execute Thread.sleep
        for given duration
         */
    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
        }
    }


 /*
    This method accepts 3 arguments.
    Arg1: webdriver
    Arg2: expectedInUrl : for verify if the url contains given String.
        - If condition matches, will break loop.
    Arg3: expectedInTitle to be compared against actualTitle
     */

    public static void switchWindowAndVerify(WebDriver driver, String expectedInUrl, String expectedInTitle) {
        Set<String> allWindowsHandles = driver.getWindowHandles();

        for (String each : allWindowsHandles) {

            driver.switchTo().window(each);

            System.out.println("Current URL: " + driver.getCurrentUrl());

            if (driver.getCurrentUrl().contains(expectedInUrl)) {
                break;
            }
            //5. Assert:Title contains “Etsy”
        }
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle));
        //Lines to be pasted:
    }

    public static void verifyTitle(WebDriver driver, String expectedTitle) {
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

}


//TC #2: Create utility method
// 1. Create a new class called BrowserUtils
//2. Create a method to make Task1 logic re-usable
//3. When method is called, it should switch window and verify title.
//
//
//Method info:
//• Name: switchWindowAndVerify
//• Return type: void
//• Arg1: WebDriver
//• Arg2: String expectedInUrl
//• Arg3: String expectedTitle