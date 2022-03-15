package com.vytrack.tests;


import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
        @BeforeMethod
        public void setUp() {

            Driver.getDriver().get(ConfigurationReader.getProperty("env1"));

            Driver.getDriver().manage().window().maximize();
            Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            Driver.getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        }

        @AfterMethod
        public void tearDown() { Driver.closeDriver(); }

    }
