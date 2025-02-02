package org.example.Pages;

import org.example.Base.BasePage;
import org.openqa.selenium.By;

public final class MyAccountPage extends BasePage {


    //Locator
    private static final By USER_INFO = By.xpath("//div[@class=\"header_user_info\"]/a[@title=\"View my customer account\"]");


    //Action
    public String getusername()
    {
        return getVisiblText(USER_INFO);
    }



}
