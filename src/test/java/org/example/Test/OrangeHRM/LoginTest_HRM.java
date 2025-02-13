package org.example.Test.OrangeHRM;

import org.example.Base.BaseTest;
import org.example.POJO.OrangeHRM.LoginUser;
import org.example.Pages.OrangeHRM.LoginPage_HRM;
import org.example.Report.ExtentReport;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest_HRM extends BaseTest {


    @Test(description = "verify user is able to login Orange HRM with valid credentials", dataProviderClass = org.example.DataProvider.DataProviderGETDATA.class ,dataProvider = "ORANGEHRMLOGINDATAFROMCSVFILE", retryAnalyzer = org.example.Listener.MyRetryAnalyzer.class)
    public void validLogin(LoginUser loginUser) throws IOException, InterruptedException {
        String  pimText = new LoginPage_HRM().doLogin(loginUser.getValidEmail(), loginUser.getValidPassword()).getPIMText();
        Assert.assertEquals(pimText, "PIM");

    }

    @Test(description="verify user is unable to login Orange HRM with invalid credentials", dataProviderClass = org.example.DataProvider.DataProviderGETDATA.class ,dataProvider = "ORANGEHRMLOGINDATAFROMCSVFILE", retryAnalyzer = org.example.Listener.MyRetryAnalyzer.class)
    public void invalidLogin(LoginUser loginUser) throws IOException, InterruptedException {
        String Invaliderrortext = new LoginPage_HRM().doInvalidLogin(loginUser.getInvalidEmail(), loginUser.getInvalidPassword()).getInvalidcredentialText();
        Assert.assertEquals(Invaliderrortext, "Invalid credential");


    }



}