package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CRM_Utilities {
    /*
        this method will login with helpdesk1@cybertekschool.com user when it is called
         */
    public static void crm_login(WebDriver driver){
    //3. Enter valid username
        driver.findElement(By.xpath("//input[@name='USER_LOGIN'][1]")).

    sendKeys("helpdesk1@cybertekschool.com");
    //4. Enter valid password
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).

    sendKeys("UserUser");
    //5. Click to `Log In` button
        driver.findElement(By.xpath("//input[@value='Log In']")).

    click();

}

    public static void crm_login(WebDriver driver, String username, String password){
        //3. Enter valid username
        driver.findElement(By.xpath("//input[@name='USER_LOGIN'][1]")).sendKeys(username);
        //4. Enter valid password
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys(password);
        //5. Click to `Log In` button
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

    }
}

//TC #4: Create utility method
// 1. Create a new method for login
//2. Create a method to make Task3 logic re-usable
//3. When method is called, it should simply login
//
//This method should have at least 2 overloaded versions.
//
//Method #1 info:
//• Name: login_crm()
//• Return type: void
//• Arg1: WebDriver
//
//
//Method #2 info:
//• Name: login_crm()
//• Return type: void
//• Arg1: WebDriver
//• Arg2: String username
//• Arg3: String password