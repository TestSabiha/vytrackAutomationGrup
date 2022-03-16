package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.DataProviderUtil;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.ExtraUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class US50_NewWindow_OroInc extends TestBase{

        @Test(dataProvider = "LoginAll", dataProviderClass = DataProviderUtil.class)
        public void US50(String username) {

            BrowserUtils.sleep(3);
            ExtraUtils.loginBy(username);
            WebElement helpTab = Driver.getDriver().findElement(By.xpath("//i[@class='fa-question-circle']"));
            helpTab.click();
            //Handles all the windows and switching driver's focus to the new one
            Set<String> newWindow = Driver.getDriver().getWindowHandles();
            for (String each : newWindow) {
                Driver.getDriver().switchTo().window(each);
                System.out.println("getCurrentUrl() = " + Driver.getDriver().getCurrentUrl());
            }
            //Verifies if the expected url is same with the actual url
            String expectedUrl = "https://doc.oroinc.com/";
            String actualUrl = Driver.getDriver().getCurrentUrl();
            Assert.assertEquals(expectedUrl, actualUrl);

        }
    }
