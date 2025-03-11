package org.example.Report;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {

    private ExtentReport(){};
    private static ExtentReports extent;
    public static ExtentTest test;

    public static void initReports()
    {   if(Objects.isNull(extent))
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
        extent.attachReporter(spark);
        spark.config().setTheme(Theme.STANDARD);
        spark.config().setDocumentTitle("TMB Report");
        spark.config().setReportName("Login Report");

    }
    public static void flushReports() {
        if(Objects.nonNull(extent)) {
            extent.flush();
        }
        try {
            Desktop.getDesktop().browse(new File("index.html").toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void createTest(String testcasename)
    {
        test = extent.createTest(testcasename);

    }

    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String destination = System.getProperty("user.dir") + "/test-output/screenshots/" + screenshotName + ".png";
            File finalDestination = new File(destination);
            FileUtils.copyFile(source, finalDestination);
            return destination;
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
            return null;
        }

    }
}
