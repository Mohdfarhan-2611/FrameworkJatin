package org.example.Base;

import org.apache.logging.log4j.Logger;
import org.example.Constant.Browser;
import org.example.Driver.DriverManager;
import org.example.Driver.DriverManagerTL;
import org.example.Utils.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class BasePage {
    Logger logger = LoggerUtility.getLogger(this.getClass());

    public BasePage() {}

    public static void MaximizeWindow()
    {
        DriverManagerTL.getDriver().manage().window().maximize();
    }

    public static void geturl(String url)
    {
        DriverManagerTL.getDriver().get(url);
    }


    public void ClickElement(By locator)
    {
        WebElement Element =  DriverManagerTL.getDriver().findElement(locator);
        Element.click();
    }

    public void EnterText(By locator, String text)
    {
        WebElement Element =  DriverManagerTL.getDriver().findElement(locator);
        Element.sendKeys(text);
    }

    public String getVisiblText(By locator)
    {
        return DriverManagerTL.getDriver().findElement(locator).getText();
    }





}
