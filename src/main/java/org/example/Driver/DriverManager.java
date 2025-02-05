package org.example.Driver;

import org.apache.logging.log4j.Logger;
import org.example.Base.BasePage;
import org.example.Utils.LoggerUtility;
import org.example.Utils.PropertiesUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;
import java.util.Objects;

public abstract class DriverManager extends BasePage {


    protected DriverManager() {         //No one can create the object of this class

    }

    static Logger logger = LoggerUtility.getLogger(DriverManager.class);


    public static void init() throws IOException {
        String browser = null;
        browser = PropertiesUtils.readkey("browser");
        boolean isheadless = Boolean.parseBoolean(PropertiesUtils.readkey("isheadless"));
        logger.info("Headless mode: " + isheadless);

        if (browser == null || browser.isEmpty()) {
            throw new RuntimeException("Browser property not set in config.");
        } else {
            browser = browser.toLowerCase();
            if (Objects.isNull(DriverManagerTL.getDriver())) {
                switch (browser) {

                    case "edge":
                        EdgeOptions edgeOptions = new EdgeOptions();
                        edgeOptions.addArguments("--guest");
                        if (isheadless) {
                            edgeOptions.addArguments("--headless");
                            edgeOptions.addArguments("--window-size=1920,1080");
                            edgeOptions.addArguments("--disable-gpu");
                        } else {
                            edgeOptions.addArguments("--start-maximized");
                        }

                        DriverManagerTL.setDriver(new EdgeDriver(edgeOptions));
                        DriverManagerTL.getDriver().get(PropertiesUtils.readkey("url"));
                        break;

                    case "chrome":
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("--guest");
                        if (isheadless) {
                            chromeOptions.addArguments("--headless");
                            chromeOptions.addArguments("--window-size=1920,1080");
                            chromeOptions.addArguments("--disable-gpu");
                        } else {
                            chromeOptions.addArguments("--start-maximized");
                        }

                        DriverManagerTL.setDriver(new ChromeDriver(chromeOptions));
                        DriverManagerTL.getDriver().get(PropertiesUtils.readkey("url"));
                        break;

                    case "firefox":
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.addArguments("--guest");
                        if (isheadless) {
                            firefoxOptions.addArguments("--headless");
                            firefoxOptions.addArguments("--window-size=1920,1080");
                            firefoxOptions.addArguments("--disable-gpu");
                        } else {
                            firefoxOptions.addArguments("--start-maximized");
                        }

                        DriverManagerTL.setDriver(new FirefoxDriver(firefoxOptions));
                        DriverManagerTL.getDriver().get(PropertiesUtils.readkey("url"));
                        break;

                    default:
                        System.out.println("Browser not found");
                }
            }
        }
    }


    public static void quit() {
        if (Objects.nonNull(DriverManagerTL.getDriver())) {
            logger.info("Close the browser");
            DriverManagerTL.getDriver().quit();
            DriverManagerTL.unload();
        }
    }


}
