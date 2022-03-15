package com.vytrack.utilities;

import org.openqa.selenium.By;

public class ExtraUtils {
  public static void goToModule(String head , String module){

      Driver.getDriver().findElement(By.linkText(head)).click();
      Driver.getDriver().findElement(By.linkText(module)).click();
  }

}
