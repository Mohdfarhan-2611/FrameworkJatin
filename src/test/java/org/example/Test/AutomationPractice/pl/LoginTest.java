package org.example.Test.AutomationPractice.pl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest {


    @Test
    public void Login()
    {   //Launch Chrome Browser or Create a new Chrome Session
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.automationpractice.pl");

        //Click on signin
        By signinLocator = By.linkText("Sign in");
        WebElement signInElement =  driver.findElement(signinLocator);
        signInElement.click();

        //Enteremail
        By emailTextboxLocator = By.id("email");
        WebElement emailElement =  driver.findElement(emailTextboxLocator);
        emailElement.sendKeys("haciwi1152@gufutu.com");

        //Enter password in password Textbox
        By passwordTextboxLocator = By.id("passwd");
        WebElement passElement =  driver.findElement(passwordTextboxLocator);
        passElement.sendKeys("Mohd@!234");

        //Click on login button
        By loginButtonLocator = By.xpath("//button[@id='SubmitLogin']");
        WebElement loginElement =  driver.findElement(loginButtonLocator);
        loginElement.click();

        //Fetch signedin username
        By userInfo = By.xpath("//div[@class=\"header_user_info\"]/a[@title=\"View my customer account\"]");
        WebElement username = driver.findElement(userInfo);
        System.out.println(username.getText());

        driver.quit();

    }

}
