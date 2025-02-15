package org.example.Listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.Logger;
import org.example.Utils.LoggerUtility;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListener implements ITestListener {

    Logger logger = LoggerUtility.getLogger(this.getClass());
    ExtentSparkReporter extentsparkreporter;
    ExtentReports extentReports;
    ExtentTest extentTest;


    public void onTestStart(ITestResult result) {
        logger.info("Starting Test: " + result.getMethod().getMethodName());
        logger.info("Description: " + result.getMethod().getDescription());
        logger.info("Groups: " + Arrays.toString(result.getMethod().getGroups()));
        extentTest = extentReports.createTest(result.getMethod().getMethodName());



    }

    public void onTestSuccess(ITestResult result) {
        logger.info(result.getMethod().getMethodName() + " PASSED");
       extentTest.log(Status.PASS, result.getMethod().getMethodName() + " "+" PASSED");
    }

    public void onTestFailure(ITestResult result) {
        logger.error(result.getMethod().getMethodName() + " FAILED");
        logger.error(result.getThrowable().getMessage());
        extentTest.log(Status.FAIL, result.getMethod().getMethodName() + " "+" Failed");
    }

    public void onTestSkipped(ITestResult result) {
        logger.warn(result.getMethod().getMethodName() + " SKIPPED");
        extentTest.log(Status.SKIP, result.getMethod().getMethodName() + " "+" SKIPPED");
    }

    public void onStart(ITestContext context) {
        logger.info("Test Suite Started");
        extentsparkreporter = new ExtentSparkReporter(System.getProperty("user.dir")+"index.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentsparkreporter);
    }

    public void onFinish(ITestContext context) {
        logger.info("Test Suite Completed");
        extentReports.flush();
    }
}
