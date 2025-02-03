package org.example.Listener;

import org.apache.logging.log4j.Logger;
import org.example.Utils.LoggerUtility;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListener implements ITestListener {

    Logger logger = LoggerUtility.getLogger(this.getClass());


    public void onTestStart(ITestResult result) {

        logger.info(result.getMethod().getMethodName());
        logger.info(result.getMethod().getDescription());
        logger.info(Arrays.toString(result.getMethod().getGroups()));

    }


    public void onTestSuccess(ITestResult result) {
        logger.info(result.getMethod().getMethodName() + " "+"PASSED");

    }


    public void onTestFailure(ITestResult result) {
        logger.error(result.getMethod().getMethodName() + " "+"Failed");
        logger.error(result.getThrowable().getMessage());

    }



    public void onTestSkipped(ITestResult result) {
        logger.warn(result.getMethod().getMethodName() + " "+"Ignored");

    }


    public void onStart(ITestContext context) {
        logger.info("Test Suite Started");


    }


    public void onFinish(ITestContext context) {
        logger.info("Test Suite Completed");

    }

}
