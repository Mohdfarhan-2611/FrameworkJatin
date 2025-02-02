package org.example.Listener;

import org.example.Utils.PropertiesUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.io.IOException;

import static org.example.Utils.PropertiesUtils.readkey;

public class MyRetryAnalyzer implements IRetryAnalyzer {

    private static final int MAX_NUMBER_OF_ATTEMPTS;
    private static int Current_number_of_attemps;

    static {
        try {
            MAX_NUMBER_OF_ATTEMPTS = Integer.parseInt(readkey("MAX_NUMBER_OF_ATTEMPTS"));
            Current_number_of_attemps= Integer.parseInt(readkey("Current_number_of_attemps"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public boolean retry(ITestResult result) {

        if(Current_number_of_attemps<=MAX_NUMBER_OF_ATTEMPTS)
        {
            Current_number_of_attemps++;
            return true;
        }

        return false;
    }
}
