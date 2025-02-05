package org.example.Base;

import org.example.Driver.DriverManager;
import org.example.Utils.PropertiesUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseTest {


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
