package org.example.Pages;

import org.apache.logging.log4j.Logger;
import org.example.Base.BasePage;
import org.example.Utils.LoggerUtility;
import org.openqa.selenium.By;

public final class LoginPage extends BasePage {
    Logger logger = LoggerUtility.getLogger(this.getClass());

    //locator
    private static final By EMAL_TEXTBOX_LOCATOR = By.id("email");
    private static final By PASS_TEXTBOX_LOCATOR = By.id("passwd");
    private static final By lOGIN_BUTTON_LOCATOR = By.xpath("//button[@id='SubmitLogin']");


    //Action
//    public MyAccountPage doLoginWith()
//    {
//        EnterText(EMAL_TEXTBOX_LOCATOR, "haciwi1152@gufutu.com");
//        EnterText(PASS_TEXTBOX_LOCATOR, "Mohd@!234");
//        ClickElement(lOGIN_BUTTON_LOCATOR);
//        MyAccountPage myAccountPage = new MyAccountPage();
//        return myAccountPage;
//    }


    public LoginPage enterEmail(String email)
    {
        logger.info("Enter email address");
        EnterText(EMAL_TEXTBOX_LOCATOR, email);
        return this;
    }

    public LoginPage enterPassword(String pass)
    {
        logger.info("Enter Password");
        EnterText(PASS_TEXTBOX_LOCATOR, pass);
        return this;
    }

    public MyAccountPage clicklogin()
    {
        logger.info("Click on sign in");
        ClickElement(lOGIN_BUTTON_LOCATOR);
        MyAccountPage myAccountPage = new MyAccountPage();
        return myAccountPage;
    }









}
