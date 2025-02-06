package org.example.Pages.AutomationPractice.pl;

import org.apache.logging.log4j.Logger;
import org.example.Base.BasePage;

import org.example.Constant.WaitStrategy;
import org.example.Driver.DriverManagerTL;
import org.example.Utils.LoggerUtility;
import org.example.Utils.PropertiesUtils;
import org.openqa.selenium.By;

import java.io.IOException;

public final class HomePage extends BasePage {
    Logger logger = LoggerUtility.getLogger(this.getClass());


    //Locator
    private static final By SIGN_IN_LOCATOR = By.linkText("Sign in");



    //Actions
    public LoginPage ClickSignIn() throws IOException {

        logger.info("Get the URL");
        DriverManagerTL.getDriver().get(PropertiesUtils.readkey("url"));

        logger.info("Click on Signin");
        ClickElement(SIGN_IN_LOCATOR, WaitStrategy.PRESENT);
        LoginPage loginPage = new LoginPage();
        return loginPage;
    }


}
