package com.vytrack.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {
    @DataProvider(name = "LoginAll")
    Object[][] loginCredentials() {

        return new Object[][]{
                {"user44"},
                {"user49"},
                {"salesmanager133"},
                {"salesmanager136"},
                {"storemanager75"},
                {"storemanager78"}
        };

    }
}
