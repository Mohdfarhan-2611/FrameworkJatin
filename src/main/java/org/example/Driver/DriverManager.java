package org.example.Driver;

import org.example.Base.BasePage;
import org.example.Constant.Browser;
import static org.example.Constant.Env.*;
import org.example.Utils.PropertiesUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.Objects;

public abstract class DriverManager extends BasePage {

    private DriverManager() {         //No one can create the object of this class

    }

    private static WebDriver driver;  //Static Variable, class variable
                                      //Non primitive, Default null

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

    public static void init()  {
        if (Objects.isNull(getDriver()))
        {
            setDriver(new ChromeDriver());
            MaximizeWindow();
        }
    }


    public static void quit()
    {
        if(Objects.nonNull(getDriver()))
        {
            getDriver().quit();
            setDriver(null);
        }
    }


}
