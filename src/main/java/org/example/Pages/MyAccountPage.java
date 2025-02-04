package org.example.Pages;

import org.apache.logging.log4j.Logger;
import org.example.Base.BasePage;
import org.example.Utils.LoggerUtility;
import org.openqa.selenium.By;

public final class MyAccountPage extends BasePage {
    Logger logger = LoggerUtility.getLogger(this.getClass());

    //Locator
    private static final By USER_INFO = By.xpath("//div[@class=\"header_user_info\"]/a[@title=\"View my customer account\"]");


    //Action
    public String getusername()
    {
        logger.info("get the signin user info");
        return getVisiblText(USER_INFO);
    }



}
