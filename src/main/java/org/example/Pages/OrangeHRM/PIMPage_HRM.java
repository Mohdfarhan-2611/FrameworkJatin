package org.example.Pages.OrangeHRM;

import org.apache.logging.log4j.Logger;
import org.example.Base.BasePage;
import org.example.Constant.WaitStrategy;
import org.example.Utils.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class PIMPage_HRM extends BasePage {
    Logger logger = LoggerUtility.getLogger(this.getClass());
    //Locators
    private static final By PIM_TEXT_LOCATOR = By.xpath("//span[@class=\"oxd-topbar-header-breadcrumb\"]/child::h6");
    private static final By EMPLOYEE_LIST_OPTION = By.xpath("//a[contains(text(),'Employee List')]");
    private static final By PREVIOUS_BUTTON_CAROUSEL = By.xpath("//button[@class='oxd-pagination-page-item oxd-pagination-page-item--previous-next']//i[@class='oxd-icon bi-chevron-left']");
    private static final By COROUSEL_ONE = By.xpath("//ul[@class='oxd-pagination__ul']//li[1]");
    private static final By COROUSEL_TWO = By.xpath("//ul[@class='oxd-pagination__ul']//li[2]");
    private static final By COROUSEL_THREE = By.xpath("//ul[@class='oxd-pagination__ul']//li[3]");
    private static final By COROUSEL_FOUR = By.xpath("//ul[@class='oxd-pagination__ul']//li[4]");
    private static final By NEXT_BUTTON_CAROUSEL = By.xpath("//button[@class='oxd-pagination-page-item oxd-pagination-page-item--previous-next']");
    private static final By EMPLOYEENAME_TEXTBOX_LOCATOR = By.xpath("//label[contains(text(),'Employee Name')]/parent::*/following-sibling::div//input");
    private static final By SEARCH_BUTTON = By.xpath("//button[@type='submit']");
    private static final By RECORDFOUND_TEXT = By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//span[contains(normalize-space(.), 'Record Found')  or contains(normalize-space(.), 'Records Found')]");
    private static final By EMPLOYEE_USER_TEXT_INLIST= By.xpath("//div[@role='row']/child::div[@role='cell']/child::div[contains(text(),'Amayra')]");
    private static final By EMPLOYEE_ID_TEXTBOX = By.xpath("//div[@class='oxd-input-group__label-wrapper']/following-sibling::div/child::input");
    private static final By IDRECORDFOUND_TEXT = By.xpath("//div[@role='row']/child::div[@role='cell']/child::div[text()='0258']");
    private static final By EMPLOYEE_STATUS_DROPDOWN = By.xpath("//label[text()='Employment Status']/parent::div/following-sibling::div/div/div");
    private static final By DROPDOWN_OPTIONS= By.xpath("//div[@role='listbox']");
    private static final By EMPLOYEE_STATUS_DROPDOWN_LIST=By.xpath("//div[@role='listbox' and contains(@class, 'oxd-select-dropdown')]//div");
    //private static final By TERMINATED_TEXT_IN_THE_RECORD = By.xpath("//div[@role='table']/child::div/div[2]/descendant::div[@role='cell']/child::div[contains(text(),'Terminated')]");
    private static final By TERMINATED_TEXT_IN_THE_RECORD = By.xpath("//div[@role='table']//div[@role='cell']/div[contains(text(),'Terminated')]");
    private static final By WORKING_TEXT_IN_THE_RECORD = By.xpath("//div[@role='table']//div[@role='cell']/div[contains(text(),'Working')]");
    private static final By RESET_BUTTON = By.xpath("//button[@type='reset']");
    private static final By SUPERVISOR_NAME_TEXTBOX = By.xpath("//label[contains(text(),'Supervisor Name')]/parent::*/following-sibling::div//input");
    private static final By SUPERVISOR_NAME_RECORD = By.xpath("//div[@role='row']/child::div[@role='cell']/child::div[contains(text(),'Pramod Dutta Ji BB')]");
    private static final By SUPERVISOR_DROPDOWN = By.xpath("//div[@role='listbox']");
    private static final By SUPERVISOR_NAME_DROPDOWNLIST = By.xpath("//div[@role='listbox' and contains(@class, 'oxd-autocomplete-dropdown')]//div");
    private static final By INVALID_TEXT = By.xpath("//span[text()='Invalid']");


    //Actions
    public String getPIMText() throws InterruptedException {

        Thread.sleep(2000); // wait for 5 seconds to ensure the page is loaded
        logger.info("Get the PIM Page page text");
        //ExtentReport.getTest().info("Get the PIM Page page text");
        return getVisiblText(PIM_TEXT_LOCATOR, WaitStrategy.PRESENT);
    }

    public PIMPage_HRM ClickEmployeeList() throws InterruptedException {

        Thread.sleep(2000);
        logger.info("Click on Employee List");
        ClickElement(EMPLOYEE_LIST_OPTION, WaitStrategy.VISIBLE);
        return this;
    }

    public PIMPage_HRM ScrollToSecondCrousel() throws InterruptedException {
        Thread.sleep(2000);
        logger.info("Scroll to Second corousel");
        ScrollToElement(COROUSEL_TWO, WaitStrategy.PRESENT);
        return this;

    }


    public PIMPage_HRM clickSecondCorousel() throws InterruptedException {
        Thread.sleep(3000);
        logger.info("Click on Second corousel");
        ClickElement(COROUSEL_TWO, WaitStrategy.CLICKABLE);
        return this;
    }

    public PIMPage_HRM clickThirdCorousel() throws InterruptedException {
        Thread.sleep(3000);
        logger.info("Click on Third corousel");
        ClickElement(COROUSEL_THREE, WaitStrategy.CLICKABLE);
        return this;
    }


    public PIMPage_HRM clickForthCorousel() throws InterruptedException {
        Thread.sleep(3000);
        logger.info("Click on Forth corousel");
        ClickElement(COROUSEL_FOUR, WaitStrategy.CLICKABLE);
        return this;
    }


    public PIMPage_HRM clickNextCorousel() throws InterruptedException {
        Thread.sleep(3000);
        logger.info("Click on Next corousel");
        ClickElement(NEXT_BUTTON_CAROUSEL, WaitStrategy.CLICKABLE);
        return this;
    }


    public PIMPage_HRM clickPreviousCorousel() throws InterruptedException {
        Thread.sleep(3000);
        logger.info("Click on Previous corousel");
        ClickElement(PREVIOUS_BUTTON_CAROUSEL, WaitStrategy.CLICKABLE);
        return this;
    }

    public boolean isPrevousEnabled() throws InterruptedException {
        Thread.sleep(3000);
        logger.info("Verify Previous corousel is enabled");
        return isEnabled(PREVIOUS_BUTTON_CAROUSEL, WaitStrategy.VISIBLE);
    }

    public boolean isNextEnabled() throws InterruptedException {
        Thread.sleep(3000);
        logger.info("Verify Next corousel is enabled");
        return isEnabled(NEXT_BUTTON_CAROUSEL, WaitStrategy.VISIBLE);
    }

    public String doValidEmployeeSearch(String name) throws InterruptedException {
        Thread.sleep(3000);
        logger.info("Click on Employee name Text box");
        ClickElement(EMPLOYEENAME_TEXTBOX_LOCATOR, WaitStrategy.PRESENT);
        logger.info("Enter valid text in Employee name");
        EnterText(EMPLOYEENAME_TEXTBOX_LOCATOR, name, WaitStrategy.PRESENT);
        logger.info("Click on search button");
        ClickElement(SEARCH_BUTTON, WaitStrategy.CLICKABLE);
        Thread.sleep(3000);
//        logger.info("Scroll to record");
//        ScrollToElement(EMPLOYEE_USER_TEXT_INLIST, WaitStrategy.PRESENT);
        logger.info("Scroll to Bottom");
        ScrollToBottom();
        logger.info("Verify the record");
        return getVisiblText(EMPLOYEE_USER_TEXT_INLIST, WaitStrategy.VISIBLE);

    }

    public String doInValidEmployeeSearch(String name) throws InterruptedException {
        Thread.sleep(3000);
        logger.info("Click on Employee name Text box");
        ClickElement(EMPLOYEENAME_TEXTBOX_LOCATOR, WaitStrategy.CLICKABLE);
        logger.info("Enter valid text in Employee name");
        EnterText(EMPLOYEENAME_TEXTBOX_LOCATOR, name, WaitStrategy.PRESENT);
        logger.info("Click on search button");
        ClickElement(SEARCH_BUTTON, WaitStrategy.CLICKABLE);
        logger.info("Scroll to record");
        ScrollToElement(RECORDFOUND_TEXT, WaitStrategy.PRESENT);
        logger.info("Verify the record");
        return getVisiblText(RECORDFOUND_TEXT, WaitStrategy.VISIBLE);
    }


    public String doValidEmployeeIDSearch(String validid) throws InterruptedException {
        Thread.sleep(3000);
        logger.info("Click on Employee Id textbox");
        ClickElement(EMPLOYEE_ID_TEXTBOX, WaitStrategy.CLICKABLE);
        logger.info("Enter the valid Employee ID");
        EnterText(EMPLOYEE_ID_TEXTBOX, validid,  WaitStrategy.CLICKABLE);
        logger.info("Click on search button");
        ClickElement(SEARCH_BUTTON, WaitStrategy.CLICKABLE);
        logger.info("Scroll to record");
        ScrollToElement(IDRECORDFOUND_TEXT, WaitStrategy.PRESENT);
        logger.info("Verify the record");
        return getVisiblText(IDRECORDFOUND_TEXT, WaitStrategy.VISIBLE);

    }

    public String doInvalidEmployeeIDSearch(String invalidid) throws InterruptedException {
        Thread.sleep(3000);
        logger.info("Click on Employee Id textbox");
        ClickElement(EMPLOYEE_ID_TEXTBOX, WaitStrategy.CLICKABLE);
        logger.info("Enter the Invalid Employee ID");
        EnterText(EMPLOYEE_ID_TEXTBOX, invalidid,  WaitStrategy.CLICKABLE);
        logger.info("Click on search button");
        ClickElement(SEARCH_BUTTON, WaitStrategy.CLICKABLE);
        logger.info("Scroll to record");
        ScrollToElement(RECORDFOUND_TEXT, WaitStrategy.PRESENT);
        logger.info("Verify the record");
        return getVisiblText(RECORDFOUND_TEXT, WaitStrategy.VISIBLE);

    }


    public String doValidSupervisorNameSearch(String ValidSupervisorName) throws InterruptedException {
        Thread.sleep(3000);
        logger.info("Click on SupervisorName textbox");
        ClickElement(SUPERVISOR_NAME_TEXTBOX, WaitStrategy.CLICKABLE);
        logger.info("Enter the Valid Supervisor Name");
        EnterText(SUPERVISOR_NAME_TEXTBOX, ValidSupervisorName, WaitStrategy.CLICKABLE);
        logger.info("Select the option from the hint");
        getVisible(SUPERVISOR_DROPDOWN);
        WebElement selected = getHintfromList(SUPERVISOR_NAME_DROPDOWNLIST, ValidSupervisorName);
        logger.info("Click on search button");
        ClickElement(SEARCH_BUTTON, WaitStrategy.CLICKABLE);
        logger.info("Scroll to record");
        getVisible(SUPERVISOR_NAME_RECORD);  // Ensure visibility before scrolling
        ScrollToElement(SUPERVISOR_NAME_RECORD, WaitStrategy.PRESENT);
        logger.info("Verify the record");
        return getVisiblText(SUPERVISOR_NAME_RECORD, WaitStrategy.VISIBLE);
    }


    public String doInValidSupervisorNameSearch(String InvalidsupervisorName) throws InterruptedException {
        Thread.sleep(3000);
        logger.info("Click on SupervisorName textbox");
        ClickElement(SUPERVISOR_NAME_TEXTBOX, WaitStrategy.CLICKABLE);
        logger.info("Enter the InValid Supervisor Name");
        EnterText(SUPERVISOR_NAME_TEXTBOX, InvalidsupervisorName, WaitStrategy.CLICKABLE);
        logger.info("Click on search button");
        ClickElement(SEARCH_BUTTON, WaitStrategy.CLICKABLE);
        logger.info("Verify the invalid error message");
        return getVisiblText(INVALID_TEXT, WaitStrategy.VISIBLE);
    }


    public String selectNotJoinedOptionFromEmployeeStatus() throws InterruptedException {
        Thread.sleep(3000);
        logger.info("Click on the Employee Status Dropdown");
        ClickElement(EMPLOYEE_STATUS_DROPDOWN, WaitStrategy.CLICKABLE);
        logger.info("Select the Not Joined from the Dropdown");
        WebElement selected1 = getDropdownValue(EMPLOYEE_STATUS_DROPDOWN_LIST, "Not Joined");
        logger.info("Click on Seach button");
        ClickElementByJS(SEARCH_BUTTON, WaitStrategy.PRESENT);
        logger.info("Scroll to No record Found Test");
        ScrollToElementByAction(RECORDFOUND_TEXT);
        logger.info("Verify the record");
        return getVisiblText(RECORDFOUND_TEXT, WaitStrategy.VISIBLE);

    }

    public String selectTerminatedFromEmployeeStatusDropdown() throws InterruptedException {
        Thread.sleep(3000);
        logger.info("Click on the Employee Status Dropdown");
        ClickElement(EMPLOYEE_STATUS_DROPDOWN, WaitStrategy.CLICKABLE);
        logger.info("Select the Not Joined from the Dropdown");
        WebElement selected1 = getDropdownValue(EMPLOYEE_STATUS_DROPDOWN_LIST, "Terminated");
        logger.info("Click on Seach button");
        ClickElementByJS(SEARCH_BUTTON, WaitStrategy.PRESENT);
        logger.info("Scroll to Terminated Text in the record");
        ScrollToElementByAction(TERMINATED_TEXT_IN_THE_RECORD);
        logger.info("Verify the record");
        return getVisiblText(TERMINATED_TEXT_IN_THE_RECORD, WaitStrategy.VISIBLE);

    }

    public String selectWorkingFromEmployeeStatusDropdown() throws InterruptedException {
        Thread.sleep(3000);
        logger.info("Click on the Employee Status Dropdown");
        ClickElement(EMPLOYEE_STATUS_DROPDOWN, WaitStrategy.CLICKABLE);
        logger.info("Select the Not Joined from the Dropdown");
        WebElement selected = getDropdownValue(EMPLOYEE_STATUS_DROPDOWN_LIST, "Working");
        logger.info("Click on Seach button");
        ClickElementByJS(SEARCH_BUTTON, WaitStrategy.PRESENT);
        logger.info("Scroll to Terminated Text in the record");
        ScrollToElementByAction(WORKING_TEXT_IN_THE_RECORD);
        logger.info("Verify the record");
        return getVisiblText(WORKING_TEXT_IN_THE_RECORD, WaitStrategy.VISIBLE);

    }


    public PIMPage_HRM resetDropDownInformation(String Value) throws InterruptedException {
        Thread.sleep(3000);
        logger.info("Click on the Employee Status Dropdown");
        ClickElement(EMPLOYEE_STATUS_DROPDOWN, WaitStrategy.CLICKABLE);
        logger.info("Select the Working Option from the Dropdown");
        WebElement selected = getDropdownValue(EMPLOYEE_STATUS_DROPDOWN_LIST, Value);
        logger.info("Click on Seach button");
        ClickElementByJS(SEARCH_BUTTON, WaitStrategy.PRESENT);
        logger.info("Scroll down to the text");
        ScrollToElement(WORKING_TEXT_IN_THE_RECORD, WaitStrategy.VISIBLE);
        logger.info("Click on reset button");
        //Thread.sleep(3000);
        ClickElementByJS(RESET_BUTTON, WaitStrategy.PRESENT);
        return this;
    }


    public PIMPage_HRM resetTextboxInformation(String validid) throws InterruptedException {
        Thread.sleep(3000);
        Thread.sleep(3000);
        logger.info("Click on Employee Id textbox");
        ClickElement(EMPLOYEE_ID_TEXTBOX, WaitStrategy.CLICKABLE);
        logger.info("Enter the valid Employee ID");
        EnterText(EMPLOYEE_ID_TEXTBOX, validid,  WaitStrategy.CLICKABLE);
        logger.info("Click on search button");
        ClickElement(SEARCH_BUTTON, WaitStrategy.CLICKABLE);
        logger.info("Click on reset button");
        ClickElementByJS(RESET_BUTTON, WaitStrategy.PRESENT);
        String afterreset= getAttribute(EMPLOYEE_ID_TEXTBOX, "Value", WaitStrategy.VISIBLE);
        System.out.println(afterreset);
        return this;
    }





}
