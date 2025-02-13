package org.example.Test.OrangeHRM;

import io.cucumber.java.en.*;
import org.example.Base.BaseTest;
import org.example.POJO.OrangeHRM.LoginUser;
import org.example.Pages.OrangeHRM.LoginPage_HRM;
import org.example.Pages.OrangeHRM.PIMPage_HRM;
import org.testng.Assert;

import java.io.IOException;

public class StepDefs  extends BaseTest  {

  protected PIMPage_HRM pimPageHrm;
  protected LoginPage_HRM loginPageHrm;
  protected String pimtext;
  protected String errortext;

    @Given("Launch the browser")
    public void launch_the_browser() throws IOException {
       setup();
    }

    @When("Login webapplication with {string} and {string}")
    public void loginWithValidUserDetails(String email, String pass) throws IOException, InterruptedException {
        LoginUser loginUser= null;
        email = loginUser.getValidEmail();
        pass = loginUser.getValidPassword();
        pimPageHrm = new LoginPage_HRM().doLogin(email, pass);
    }



    @Then("Verify the PIM text on the logged in page")
    public void verify_the_pim_text_on_the_logged_in_page() throws InterruptedException {
        pimtext= pimPageHrm.getPIMText();
        Assert.assertEquals(pimtext, "PIM");
    }


    @When("I login with Invalid user details using LoginUser object")
    public void loginWithInvalidUserDetails(LoginUser loginUser) throws IOException, InterruptedException {
        loginPageHrm = new LoginPage_HRM().doInvalidLogin(loginUser.getInvalidEmail(), loginUser.getInvalidPassword());
    }

    //Verify the error message
    @Then("Verify the Error Message")
    public void verify_the_Error_Message() throws InterruptedException {
        errortext= loginPageHrm.getInvalidcredentialText();
        System.out.println("error "+errortext);
        Assert.assertEquals(errortext, "Invalid credentials");
    }


    @And("Close the browser")
    public void Close_the_browser() {
        TearDown();
    }


    @Then("Click on EmployeeList Header")
    public void clickOnEmployeeListHeader() throws InterruptedException {
        pimPageHrm.ClickEmployeeList();

    }

    @Then("Scroll to the second carausel")
    public void scrollToTheSecondCarausel() throws InterruptedException {
        pimPageHrm.ScrollToSecondCrousel();
    }


}
