package org.example.Test.OrangeHRM;

import org.example.Base.BaseTest;
import org.example.Pages.OrangeHRM.LoginPage_HRM;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest_HRM extends BaseTest {


    @Test(description = "verify user is able to login Orange HRM with valid credentials")
    public void validLogin() throws IOException, InterruptedException {
        String  pimText = new LoginPage_HRM().doLogin("admin","Hacker@4321").getPIMText();
        System.out.println(pimText);
    }

    @Test(description="verify user is unable to login Orange HRM with invalid credentials")
    public void invalidLogin() throws IOException, InterruptedException {
        String Invaliderrortext = new LoginPage_HRM().doInvalidLogin("admin", "admin").getInvalidcredentialText();
        Assert.assertEquals(Invaliderrortext, "Invalid credentials");

    }



}