package com.vytrack.tests;


<<<<<<< HEAD
=======
import com.vytrack.utilities.ConfigurationReader;
>>>>>>> 8c3ab30d416a9a00f3bbbb23667c06ecfe983482
import com.vytrack.utilities.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

<<<<<<< HEAD
public class TestBase {
    @BeforeMethod
    public void setUp() {


        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Driver.getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() { Driver.closeDriver(); }

}
=======
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
>>>>>>> 8c3ab30d416a9a00f3bbbb23667c06ecfe983482
