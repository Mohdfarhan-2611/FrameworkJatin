package org.example.Test.OrangeHRM;

import org.apache.logging.log4j.Logger;
import org.example.Base.BaseTest;
import org.example.Driver.DriverManagerTL;
import org.example.Pages.AutomationPractice.pl.LoginPage;
import org.example.Pages.OrangeHRM.LoginPage_HRM;
import org.example.Pages.OrangeHRM.PIMPage_HRM;
import org.example.Utils.LoggerUtility;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class PIMTest extends BaseTest {
    Logger logger = LoggerUtility.getLogger(this.getClass());



    @Test(description = "verify user is able to click on EmployeeList header", retryAnalyzer = org.example.Listener.MyRetryAnalyzer.class)
    public void ClickEmployeeListOption() throws IOException, InterruptedException {
        PIMPage_HRM pimText = new LoginPage_HRM().doLogin("admin","Hacker@4321").ClickEmployeeList();

    }

    @Test(description = "verify user is able to scroll to the bottom till the carousel", retryAnalyzer = org.example.Listener.MyRetryAnalyzer.class)
    public void ScrollDownInTheEnd() throws IOException, InterruptedException {
        PIMPage_HRM pimText = new LoginPage_HRM().doLogin("admin","Hacker@4321").ClickEmployeeList().ScrollToSecondCrousel();

    }

    @Test(description = "verify user is able to click on Second Carousel", retryAnalyzer = org.example.Listener.MyRetryAnalyzer.class)
    public void clickonSecondCarousel() throws IOException, InterruptedException {
        boolean isPreviousEnabled = new LoginPage_HRM().doLogin("admin", "Hacker@4321").ScrollToSecondCrousel().clickSecondCorousel().isPrevousEnabled();
        Assert.assertTrue(isPreviousEnabled);

    }


    @Test(description = "verify user is able to click on Third Carousel", retryAnalyzer = org.example.Listener.MyRetryAnalyzer.class)
    public void clickonThirdCarousel() throws IOException, InterruptedException {
        boolean isPreviousEnabled = new LoginPage_HRM().doLogin("admin", "Hacker@4321").ScrollToSecondCrousel().clickThirdCorousel().isPrevousEnabled();
        Assert.assertTrue(isPreviousEnabled);

    }

    @Test(description = "verify user is able to click on Fourth Carousel", retryAnalyzer = org.example.Listener.MyRetryAnalyzer.class)
    public void clickonFourthCarousel() throws IOException, InterruptedException {
        boolean isPreviousEnabled = new LoginPage_HRM().doLogin("admin", "Hacker@4321").ScrollToSecondCrousel().clickForthCorousel().isPrevousEnabled();
        Assert.assertTrue(isPreviousEnabled);

    }

    @Test(description = "verify user is able to click on Next Carousel", retryAnalyzer = org.example.Listener.MyRetryAnalyzer.class)
    public void clickonNextCarousel() throws IOException, InterruptedException {
        boolean isPreviousEnabled = new LoginPage_HRM().doLogin("admin", "Hacker@4321").ScrollToSecondCrousel().clickNextCorousel().isPrevousEnabled();
        Assert.assertTrue(isPreviousEnabled);

    }

    @Test(description = "verify user is able to click on Previous Carousel", retryAnalyzer = org.example.Listener.MyRetryAnalyzer.class)
    public void clickonPreviousCarousel() throws IOException, InterruptedException {
        boolean isPreviousEnabled = new LoginPage_HRM().doLogin("admin", "Hacker@4321").ScrollToSecondCrousel().clickNextCorousel().clickPreviousCorousel().isNextEnabled();
        Assert.assertTrue(isPreviousEnabled);

    }




    @Test(description = "Verify user is able to search the Employee Record with valid employee name", retryAnalyzer = org.example.Listener.MyRetryAnalyzer.class)
    public void searchEmployeewithValidusername() throws IOException, InterruptedException {
        String resultText = new LoginPage_HRM().doLogin("admin", "Hacker@4321").doValidEmployeeSearch("amayra");
        Assert.assertEquals(resultText.toLowerCase(),"amayra");

    }

    @Test(description = "verify user is able to click on EmployeeList", retryAnalyzer = org.example.Listener.MyRetryAnalyzer.class)
    public void searchEmployeewithInvalidusername() throws IOException, InterruptedException {
        String resultText = new LoginPage_HRM().doLogin("admin", "Hacker@4321").doInValidEmployeeSearch("@@");
        Assert.assertEquals(resultText, "No Records Found");


    }


    @Test(description = "verify user is able to search with valid employee id value")
    public void searchEmployeeIDwithValidID() throws IOException, InterruptedException {

        String employeeidtext = new LoginPage_HRM().doLogin("admin", "Hacker@4321").doValidEmployeeIDSearch("0258");
        Assert.assertEquals(employeeidtext, "0258");

    }

    @Test(description = "Verify No Record should appear when the user searches the Employee with invalid Employee ID")
    public void searchEmployeeIDwithInvalidID() throws IOException, InterruptedException {

        String resultText = new LoginPage_HRM().doLogin("admin", "Hacker@4321").doInvalidEmployeeIDSearch("1234");
        Assert.assertEquals(resultText, "No Records Found");
    }


    @Test(description = "Verify user is able to search Employee by selecting Not Joined option from Employee Status dropdown")
    public void selectNotJoinedFromEmployeeStatusDropdown() throws IOException, InterruptedException {

        String errortext = new LoginPage_HRM().doLogin("admin", "Hacker@4321").selectNotJoinedOptionFromEmployeeStatus();
        Assert.assertEquals(errortext,"No Records Found");

    }


    @Test(description = "Verify user is able to search Employee by selecting Terminated option from Employee Status dropdown")
    public void selectTerminatedFromStatusDropdown() throws IOException, InterruptedException {

        String errortext = new LoginPage_HRM().doLogin("admin", "Hacker@4321").selectTerminatedFromEmployeeStatusDropdown();
        Assert.assertEquals(errortext,"Terminated");

    }

    @Test(description = "Verify user is able to search Employee by selecting Working option from Employee Status dropdown")
    public void selectWorkingStatusDropdown() throws IOException, InterruptedException {

        String errortext = new LoginPage_HRM().doLogin("admin", "Hacker@4321").selectWorkingFromEmployeeStatusDropdown();
        Assert.assertEquals(errortext,"Working");

    }

    @Test(description = "Verify user is able to search the Emplyee Record with valid Supervisor name")
    public void searchSupervisornamewithValid() throws IOException, InterruptedException {

        String supervisorname= new LoginPage_HRM().doLogin("admin", "Hacker@4321").doValidSupervisorNameSearch("Pramod Dutta Ji BB");
        Assert.assertEquals(supervisorname, "Pramod Dutta Ji BB");



    }

    @Test(description = "Verify No Record should appear when the user search the Employee with invalid Supervisor name")
    public void searchSupervisornamewithINvalid() throws IOException, InterruptedException {
        String invalidtext = new LoginPage_HRM().doLogin("admin", "Hacker@4321").doInValidSupervisorNameSearch("Farhan");
        Assert.assertEquals(invalidtext, "Invalid");

    }


    @Test(description = "Verify User is able to reset the dropdown information by clicking on Reset button")
    public void resetDropDownInformation() throws IOException, InterruptedException {
        PIMPage_HRM pimPageHrm = new LoginPage_HRM().doLogin("admin", "Hacker@4321").resetDropDownInformation("Working");

    }

    @Test(description = "Verify User is able to reset the Textbox information by clicking on Reset button")
    public void resetTextboxInformation() throws IOException, InterruptedException {
        PIMPage_HRM pimPageHrm = new LoginPage_HRM().doLogin("admin", "Hacker@4321").resetTextboxInformation("0258");

    }






    }
