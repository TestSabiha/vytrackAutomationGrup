package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;

import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VyTrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Us_8 {

    @Test   //Description:  users see the default repeat day as 1

    public static void driver_verifying_repeat_day() throws InterruptedException {

        VyTrackUtils.login("user1", "UserUser123");

        // Click the “Calendar Events” under the Activities
        Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[3]")).click();

        //Click the “Calendar Events” under the Activities
        Driver.getDriver().findElement(By.linkText("Calendar Events")).click();

        Thread.sleep(3000);
        // Click the “Create Calendar Event” button
        Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']")).click();

        //Check the Repeat checkbox
        // Driver.getDriver().findElement(By.xpath("(//div[@class='control-label wrap'])[10]")).click();
        Driver.getDriver().findElement(By.xpath("//*[contains(@for,'recurrence-repeat-vie')]")).click();
        //   Verify the repeat number is 1

        WebElement repeatNumber = Driver.getDriver().findElement(By.xpath("(//input[@class='recurrence-subview-control__number'])[1]"));
        Assert.assertTrue(repeatNumber.isDisplayed(), "Repeat Number 1 is not Display");
        Driver.closeDriver();

    }

    @Test
    public void driver_verifying_error_message() throws InterruptedException {
        VyTrackUtils.login("user1", "UserUser123");

        // Click the “Calendar Events” under the Activities
        Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[3]")).click();

        //Click the “Calendar Events” under the Activities
        Driver.getDriver().findElement(By.linkText("Calendar Events")).click();

        Thread.sleep(3000);
        // Click the “Create Calendar Event” button
        Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']")).click();


        //Check the Repeat checkbox
        Driver.getDriver().findElement(By.xpath("//*[contains(@for,'recurrence-repeat-vie')]")).click();
        //Clear  the number
        Driver.getDriver().findElement(By.xpath("(//input[@class='recurrence-subview-control__number'])[1]")).clear();

        //verify
        WebElement errorMessage = Driver.getDriver().findElement(By.xpath("(//span[.='This value should not be blank.'])[1]"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Message is not Displayed Test is Failed");

     Driver.closeDriver();
    }

    @Test
    public void storeManager_verifying_repeat_day() {
        VyTrackUtils.login("storemanager54", "UserUser123");

        WebElement activityButton = Driver.getDriver().findElement(By.xpath("//*[@id='main-menu']/ul/li[5]"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(activityButton).perform();

        Driver.getDriver().findElement(By.xpath("//span[.='Calendar Events']")).click();

        Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']")).click();

        BrowserUtils.sleep(2);

        WebElement repeatbox = Driver.getDriver().findElement(By.xpath("(//div[@class='control-label wrap'])[10]/label"));
        repeatbox.click();

        WebElement repeatNumber = Driver.getDriver().findElement(By.xpath("(//input[@class='recurrence-subview-control__number'])[1]"));
        Assert.assertTrue(repeatNumber.isDisplayed(), "Repeat Number 1 is not Display");

    Driver.closeDriver();
    }

    @Test
    public void storeManager_verifying_error_message() {
        VyTrackUtils.login("storemanager54", "UserUser123");

        WebElement activityButton = Driver.getDriver().findElement(By.xpath("//*[@id='main-menu']/ul/li[5]"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(activityButton).perform();

        Driver.getDriver().findElement(By.xpath("//span[.='Calendar Events']")).click();

        Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']")).click();

        BrowserUtils.sleep(2);

        WebElement repeatbox = Driver.getDriver().findElement(By.xpath("(//div[@class='control-label wrap'])[10]/label"));
        repeatbox.click();

        Driver.getDriver().findElement(By.xpath("(//input[@class='recurrence-subview-control__number'])[1]")).clear();

        //verify
        WebElement errorMessage = Driver.getDriver().findElement(By.xpath("(//span[.='This value should not be blank.'])[1]"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Message is not Displayed Test is Failed");
        Driver.closeDriver();

    }

    @Test
    public void salesManager_verifying_repeatDay() {

        VyTrackUtils.login("salesmanager101", "UserUser123");
        WebElement activities = Driver.getDriver().findElement(By.xpath("//*[@id='main-menu']/ul/li[5]"));
        BrowserUtils.sleep(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(activities).perform();


        WebElement calenderEvent = Driver.getDriver().findElement(By.xpath("//div/ul/li/a/span[.='Calendar Events']"));
        actions.click(calenderEvent).perform();


         //creatcalendar event
        Driver.getDriver().findElement(By.xpath("(//a[normalize-space()='Create Calendar event'])[1]")).click();


        //repeatday
        BrowserUtils.sleep(2);
        Driver.getDriver().findElement(By.xpath("//*[@data-name='recurrence-repeat']")).click();
        // Driver.getDriver().findElement(By.xpath("(//div[@class='control-group control-group-checkbox']/div)[4]")).click();

        //   Verify the repeat number is 1
        WebElement repeatNumber = Driver.getDriver().findElement(By.xpath("(//input[@class='recurrence-subview-control__number'])[1]"));
        Assert.assertTrue(repeatNumber.isDisplayed(), "Repeat Number 1 is not Display");

        Driver.closeDriver();
    }

    @Test
    public void salesManager_verifying_error_message() {

        VyTrackUtils.login("salesmanager101", "UserUser123");
        WebElement activities = Driver.getDriver().findElement(By.xpath("//*[@id='main-menu']/ul/li[5]"));
        BrowserUtils.sleep(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(activities).perform();


        WebElement calenderEvent = Driver.getDriver().findElement(By.xpath("//div/ul/li/a/span[.='Calendar Events']"));
        actions.click(calenderEvent).perform();


        //creatcalendar event
        Driver.getDriver().findElement(By.xpath("(//a[normalize-space()='Create Calendar event'])[1]")).click();


        //repeatday
        BrowserUtils.sleep(2);
        Driver.getDriver().findElement(By.xpath("//*[@data-name='recurrence-repeat']")).click();
        // Driver.getDriver().findElement(By.xpath("(//div[@class='control-group control-group-checkbox']/div)[4]")).click();

        BrowserUtils.sleep(2);
        //Clear
        Driver.getDriver().findElement(By.xpath("(//input[@class='recurrence-subview-control__number'])[1]")).clear();

        //verify
        WebElement errorMessage = Driver.getDriver().findElement(By.xpath("(//span[.='This value should not be blank.'])[1]"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Message is not Displayed Test is Failed");


    }
}






