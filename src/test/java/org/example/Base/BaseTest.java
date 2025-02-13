package org.example.Base;

import org.example.Driver.DriverManager;
import org.example.Report.ExtentReport;
import org.example.Utils.PropertiesUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class BaseTest {

    protected BaseTest(){};


    @BeforeSuite
    public void beforesuite()
    {
        ExtentReport.setupSparkReporter("index.html");
    }

    @AfterSuite
    public void aftersuite()
    {
        ExtentReport.flushReport();
    }



    @BeforeMethod
    public static void setup() throws IOException {
       DriverManager.init();
    }



    @AfterMethod
    public static void TearDown()
    {
       DriverManager.quit();
    }


}
