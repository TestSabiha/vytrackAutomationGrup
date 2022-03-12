package com.vytrack.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {
    @DataProvider(name = "LoginAll")
    Object[][] loginCredentials() {

        return new Object[][]{
                {"user1"},
                {"salesmanager101"},
                {"storemanager51"},
        };

    }
}
