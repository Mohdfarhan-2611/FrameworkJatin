package org.example.Test.OrangeHRM;

import org.apache.logging.log4j.Logger;
import org.example.Base.BaseTest;
import org.example.Driver.DriverManagerTL;
import org.example.Pages.OrangeHRM.LoginPage_HRM;
import org.example.Pages.OrangeHRM.PIMPage_HRM;
import org.example.Utils.LoggerUtility;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class PIMTest extends BaseTest {
    Logger logger = LoggerUtility.getLogger(this.getClass());



    @Test(description = "verify user is able to click on EmployeeList header")
    public void ClickEmployeeListOption() throws IOException, InterruptedException {
        PIMPage_HRM pimText = new LoginPage_HRM().doLogin("admin","Hacker@4321").ClickEmployeeList();

    }

    @Test(description = "verify user is able to scroll to the bottom till the carousel")
    public void ScrollDownInTheEnd() throws IOException, InterruptedException {
        PIMPage_HRM pimText = new LoginPage_HRM().doLogin("admin","Hacker@4321").ClickEmployeeList().ScrollToSecondCrousel();

    }

    @Test(description = "verify user is able to click on Second Carousel")
    public void clickonSecondCarousel() throws IOException, InterruptedException {
        boolean isPreviousEnabled = new LoginPage_HRM().doLogin("admin", "Hacker@4321").ScrollToSecondCrousel().clickSecondCorousel().isPrevousEnabled();
        Assert.assertTrue(isPreviousEnabled);

    }


    @Test(description = "verify user is able to click on Third Carousel")
    public void clickonThirdCarousel() throws IOException, InterruptedException {
        boolean isPreviousEnabled = new LoginPage_HRM().doLogin("admin", "Hacker@4321").ScrollToSecondCrousel().clickThirdCorousel().isPrevousEnabled();
        Assert.assertTrue(isPreviousEnabled);

    }

    @Test(description = "verify user is able to click on Fourth Carousel")
    public void clickonFourthCarousel() throws IOException, InterruptedException {
        boolean isPreviousEnabled = new LoginPage_HRM().doLogin("admin", "Hacker@4321").ScrollToSecondCrousel().clickForthCorousel().isPrevousEnabled();
        Assert.assertTrue(isPreviousEnabled);

    }

    @Test(description = "verify user is able to click on Next Carousel")
    public void clickonNextCarousel() throws IOException, InterruptedException {
        boolean isPreviousEnabled = new LoginPage_HRM().doLogin("admin", "Hacker@4321").ScrollToSecondCrousel().clickNextCorousel().isPrevousEnabled();
        Assert.assertTrue(isPreviousEnabled);

    }

    @Test(description = "verify user is able to click on Previous Carousel")
    public void clickonPreviousCarousel() throws IOException, InterruptedException {
        boolean isPreviousEnabled = new LoginPage_HRM().doLogin("admin", "Hacker@4321").ScrollToSecondCrousel().clickNextCorousel().clickPreviousCorousel().isNextEnabled();
        Assert.assertTrue(isPreviousEnabled);

    }




    @Test(description = "Verify user is able to search the Employee Record with valid employee name")
    public void searchEmployeewithValidusername() throws IOException, InterruptedException {
        String resultText = new LoginPage_HRM().doLogin("admin", "Hacker@4321").doValidEmployeeSearch("amayra");
        Assert.assertEquals(resultText.toLowerCase(),"amayra");

    }

    @Test(description = "verify user is able to click on EmployeeList")
    public void searchEmployeewithInvalidusername() throws IOException, InterruptedException {
        String resultText = new LoginPage_HRM().doLogin("admin", "Hacker@4321").doInValidEmployeeSearch("@@");
        Assert.assertEquals(resultText, "No Records Found");
        logger.info("Inavlid Employee not found");

    }

















    }
