package org.example.Base;

import org.apache.logging.log4j.Logger;
import org.example.Constant.WaitStrategy;
import org.example.Driver.DriverManagerTL;
import org.example.Utils.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public abstract class BasePage {
    Logger logger = LoggerUtility.getLogger(this.getClass());

    protected BasePage() {}

    public static void MaximizeWindow()
    {
        DriverManagerTL.getDriver().manage().window().maximize();
    }

    public static void geturl(String url)
    {
        DriverManagerTL.getDriver().get(url);
    }


    public void ClickElement(By locator, WaitStrategy waitStrategy)
    {
        WebElement Element =  DriverManagerTL.getDriver().findElement(locator);
        Element.click();
    }

    public void EnterText(By locator, String text, WaitStrategy waitStrategy)
    {
        WebElement Element =  DriverManagerTL.getDriver().findElement(locator);
        Element.sendKeys(text);
    }

    public String getVisiblText(By locator, WaitStrategy waitStrategy)
    {
        return DriverManagerTL.getDriver().findElement(locator).getText();
    }


    public void ScrollToElement(By locator, WaitStrategy waitStrategy)
    {
        JavascriptExecutor js = (JavascriptExecutor) DriverManagerTL.getDriver();
        WebElement element = DriverManagerTL.getDriver().findElement(locator);
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public boolean isEnabled(By locator, WaitStrategy waitStrategy)
    {
        WebElement element =  DriverManagerTL.getDriver().findElement(locator);
        boolean isenable =element.isEnabled();
        return isenable;
    }





}
