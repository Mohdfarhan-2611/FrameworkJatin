package org.example.Test;

import org.example.Base.BaseTest;
import org.example.POJO.User;
import org.example.Pages.HomePage;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest2 extends BaseTest {


    @Test(dataProviderClass = org.example.DataProvider.DataProviderGETDATA.class ,dataProvider = "LOGINDATAFROMJSONFILE", retryAnalyzer = org.example.Listener.MyRetryAnalyzer.class)
    public void Login1(User user) throws IOException {
        String username = new HomePage().ClickSignIn().enterEmail(user.getEmailAddress()).enterPassword(user.getPassword()).clicklogin().getusername();
        System.out.println(username);
    }


    @Test(dataProviderClass = org.example.DataProvider.DataProviderGETDATA.class ,dataProvider = "LOGINDATAFROMCSVFILE", retryAnalyzer = org.example.Listener.MyRetryAnalyzer.class)
    public void Login2(User user) throws IOException {
        String username = new HomePage().ClickSignIn().enterEmail(user.getEmailAddress()).enterPassword(user.getPassword()).clicklogin().getusername();
        System.out.println(username);
    }


    @Test(dataProviderClass = org.example.DataProvider.DataProviderGETDATA.class ,dataProvider = "LOGINDATAFROMEXCELFILE", retryAnalyzer = org.example.Listener.MyRetryAnalyzer.class)
    public void Login3(User user) throws IOException {
        String username = new HomePage().ClickSignIn().enterEmail(user.getEmailAddress()).enterPassword(user.getPassword()).clicklogin().getusername();
        System.out.println(username);
    }



}
