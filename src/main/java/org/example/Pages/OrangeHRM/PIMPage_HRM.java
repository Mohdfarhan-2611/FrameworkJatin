package org.example.Pages.OrangeHRM;

import org.apache.logging.log4j.Logger;
import org.example.Base.BasePage;
import org.example.Constant.WaitStrategy;
import org.example.Utils.LoggerUtility;
import org.openqa.selenium.By;

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
    private static final By RECORDFOUND_TEXT = By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//span[contains(normalize-space(.), 'Record Found')  or contains(normalize-space(.), 'Records Found') ]");
    private static final By EMPLOYEE_USER_TEXT_INLIST= By.xpath("//div[@role='row']/child::div[@role='cell']/child::div[contains(text(),'Amayra')]");



    //Actions
    public String getPIMText() throws InterruptedException {

        Thread.sleep(2000); // wait for 5 seconds to ensure the page is loaded
        logger.info("Verify Pim text");
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
        ClickElement(EMPLOYEENAME_TEXTBOX_LOCATOR, WaitStrategy.PRESENT);
        logger.info("Enter valid text in Employee name");
        EnterText(EMPLOYEENAME_TEXTBOX_LOCATOR, name, WaitStrategy.PRESENT);
        logger.info("Click on search button");
        ClickElement(SEARCH_BUTTON, WaitStrategy.CLICKABLE);
        logger.info("Scroll to record");
        ScrollToElement(RECORDFOUND_TEXT, WaitStrategy.PRESENT);
        logger.info("Verify the record");
        return getVisiblText(RECORDFOUND_TEXT, WaitStrategy.VISIBLE);
    }




}
