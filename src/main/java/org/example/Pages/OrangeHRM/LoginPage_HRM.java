package org.example.Pages.OrangeHRM;

import org.apache.logging.log4j.Logger;
import org.example.Base.BasePage;
import org.example.Constant.WaitStrategy;
import org.example.Driver.DriverManagerTL;
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
        logger.info("Goto the URL");
        DriverManagerTL.getDriver().get(PropertiesUtils.readkey("url"));

        Thread.sleep(2000);
        logger.info("Enter username");
        EnterText(USERNAME_TEXTFIELD_LOCATOR, email, WaitStrategy.CLICKABLE);

        logger.info("Enter pass");
        EnterText(PASSWORD_TEXTFIELD_LOCATOR, pass, WaitStrategy.CLICKABLE);

        logger.info("Click on login button");
        ClickElement(LOGIN_BTN, WaitStrategy.CLICKABLE);

        return new PIMPage_HRM();
    }



    public LoginPage_HRM doInvalidLogin(String email, String pass) throws IOException, InterruptedException {
        logger.info("Goto the URL");
        DriverManagerTL.getDriver().get(PropertiesUtils.readkey("url"));

        Thread.sleep(2000);
        logger.info("Enter username");
        EnterText(USERNAME_TEXTFIELD_LOCATOR, email, WaitStrategy.CLICKABLE);

        logger.info("Enter pass");
        EnterText(PASSWORD_TEXTFIELD_LOCATOR, pass, WaitStrategy.CLICKABLE);

        logger.info("Click on login button");
        ClickElement(LOGIN_BTN, WaitStrategy.CLICKABLE);

        return this;
    }


    public String getInvalidcredentialText() throws InterruptedException {
        Thread.sleep(2000);
        logger.info("verify the error text");
       return getVisiblText(INVALID_CREDENTIAL_TEXT, WaitStrategy.VISIBLE);
    }



}
