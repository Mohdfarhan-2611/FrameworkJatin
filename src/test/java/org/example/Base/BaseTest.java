package org.example.Base;

import org.example.Driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {


    @BeforeMethod
    public static void setup()
    {
       DriverManager.init();
    }



    @AfterMethod
    public static void TearDown()
    {
       DriverManager.quit();
    }


}
