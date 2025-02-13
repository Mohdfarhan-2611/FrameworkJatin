package org.example.Listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.Logger;
import org.example.Report.ExtentReport;
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
        ExtentReport.createExtentTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        logger.info(result.getMethod().getMethodName() + " PASSED");
        if (ExtentReport.getTest() != null) {
            ExtentReport.getTest().log(Status.PASS, result.getMethod().getMethodName() + " Test Passed");
        }
    }

    public void onTestFailure(ITestResult result) {
        logger.error(result.getMethod().getMethodName() + " FAILED");
        logger.error(result.getThrowable().getMessage());
        if (ExtentReport.getTest() != null) {
            ExtentReport.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " Test Failed");
            ExtentReport.getTest().log(Status.FAIL, result.getThrowable().getMessage());
        }
    }

    public void onTestSkipped(ITestResult result) {
        logger.warn(result.getMethod().getMethodName() + " SKIPPED");
        if (ExtentReport.getTest() != null) {
            ExtentReport.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " Test Skipped");
            ExtentReport.getTest().log(Status.SKIP, result.getThrowable().getMessage());
        }
    }

    public void onStart(ITestContext context) {
        logger.info("Test Suite Started");
        ExtentReport.setupSparkReporter("index.html");
    }

    public void onFinish(ITestContext context) {
        logger.info("Test Suite Completed");
        ExtentReport.flushReport();
    }
}
