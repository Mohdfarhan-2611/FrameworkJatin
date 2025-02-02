package org.example.Pages;

import org.example.Base.BasePage;
import org.example.Constant.Browser;
import static org.example.Constant.Env.*;
import org.example.Driver.DriverManager;
import org.example.Utils.PropertiesUtils;
import org.openqa.selenium.By;

import java.io.IOException;

public final class HomePage extends BasePage {



    //Locator
    private static final By SIGN_IN_LOCATOR = By.linkText("Sign in");



    //Actions
    public LoginPage ClickSignIn() throws IOException {

        DriverManager.getDriver().get(PropertiesUtils.readkey("url"));
        ClickElement(SIGN_IN_LOCATOR);
        LoginPage loginPage = new LoginPage();
        return loginPage;
    }


}
