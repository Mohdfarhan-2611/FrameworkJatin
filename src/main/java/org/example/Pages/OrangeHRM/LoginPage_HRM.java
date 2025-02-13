package org.example.Pages.OrangeHRM;

import org.apache.logging.log4j.Logger;
import org.example.Base.BasePage;
import org.example.Constant.WaitStrategy;
import org.example.Driver.DriverManagerTL;
import org.example.Report.ExtentReport;
import org.example.Utils.LoggerUtility;
import org.example.Utils.PropertiesUtils;
import org.openqa.selenium.By;

import java.io.IOException;

public class LoginPage_HRM extends BasePage {

    Logger logger = LoggerUtility.getLogger(this.getClass());


    //Locators
    private static final By USERNAME_TEXTFIELD_LOCATOR = By.xpath("//input[@name='username']");
    private static final By PASSWORD_TEXTFIELD_LOCATOR = By.xpath("//input[@name='password' and @type='password']");
    private static final By LOGIN_BTN = By.xpath("//button[@type='submit']");
    private static final By INVALID_CREDENTIAL_TEXT = By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");



    //Actions
    public PIMPage_HRM doLogin(String email, String pass) throws IOException, InterruptedException {
        logger.info("Goto the OrangeHRM URL");
        ExtentReport.getTest().info("Goto the OrangeHRM URL");
        DriverManagerTL.getDriver().get(PropertiesUtils.readkey("url"));


        Thread.sleep(2000);
        logger.info("Enter the valid username");
        ExtentReport.getTest().info("Enter the valid username");
        EnterText(USERNAME_TEXTFIELD_LOCATOR, email, WaitStrategy.CLICKABLE);


        logger.info("Entered the valid pass");
        ExtentReport.getTest().info("Entered the valid pass");
        EnterText(PASSWORD_TEXTFIELD_LOCATOR, pass, WaitStrategy.CLICKABLE);


        logger.info("Click on the login button");
        ExtentReport.getTest().info("Click on the login button");
        ClickElement(LOGIN_BTN, WaitStrategy.CLICKABLE);


        return new PIMPage_HRM();
    }



    public LoginPage_HRM doInvalidLogin(String email, String pass) throws IOException, InterruptedException {
        logger.info("Goto the OrangeHRM URL");
        ExtentReport.getTest().info("Goto the OrangeHRM URL");
        DriverManagerTL.getDriver().get(PropertiesUtils.readkey("url"));

        Thread.sleep(2000);
        logger.info("Enter the invalid username");
        ExtentReport.getTest().info("Enter the invalid username");
        EnterText(USERNAME_TEXTFIELD_LOCATOR, email, WaitStrategy.CLICKABLE);

        logger.info("Enter the invalid pass");
        ExtentReport.getTest().info("Enter the invalid pass");
        EnterText(PASSWORD_TEXTFIELD_LOCATOR, pass, WaitStrategy.CLICKABLE);

        logger.info("Click on the login button");
        ExtentReport.getTest().info("Click on the login button");
        ClickElement(LOGIN_BTN, WaitStrategy.CLICKABLE);

        return this;
    }


    public String getInvalidcredentialText() throws InterruptedException {
        Thread.sleep(2000);
        logger.info("verify the error text");
        ExtentReport.getTest().info("Verify the error text");
       return getVisiblText(INVALID_CREDENTIAL_TEXT, WaitStrategy.VISIBLE);
    }



}
