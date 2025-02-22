package org.example.Base;

import io.cucumber.java.en_old.Ac;
import org.apache.logging.log4j.Logger;
import org.example.Constant.WaitStrategy;
import org.example.Driver.DriverManagerTL;
import org.example.Utils.LoggerUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    Logger logger = LoggerUtility.getLogger(this.getClass());

    protected BasePage() {
    }

    public static void MaximizeWindow() {
        DriverManagerTL.getDriver().manage().window().maximize();
    }

    public static void geturl(String url) {
        DriverManagerTL.getDriver().get(url);
    }


    public void ClickElement(By locator, WaitStrategy waitStrategy) {
        WebElement Element = DriverManagerTL.getDriver().findElement(locator);
        Element.click();
    }


    public void ClickElementByJS(By locator, WaitStrategy waitStrategy)
    {
        JavascriptExecutor js =  (JavascriptExecutor) DriverManagerTL.getDriver();
        WebElement element = DriverManagerTL.getDriver().findElement(locator);
        js.executeScript("arguments[0].click();", element);
    }




    public void EnterText(By locator, String text, WaitStrategy waitStrategy) {
        WebElement Element = DriverManagerTL.getDriver().findElement(locator);
        Element.sendKeys(text);
    }

    public String getVisiblText(By locator, WaitStrategy waitStrategy) {
        return DriverManagerTL.getDriver().findElement(locator).getText();
    }

    public void moveToElement(By locator, WaitStrategy waitStrategy)
    {
        Actions actions = new Actions(DriverManagerTL.getDriver());
        WebElement webElement = DriverManagerTL.getDriver().findElement(locator);
        actions.moveToElement(webElement).perform();
    }


    public void ScrollToElement(By locator, WaitStrategy waitStrategy) throws InterruptedException {
        WebDriver driver = DriverManagerTL.getDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        // Scroll to the element using JavaScript or actions
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element);

        // Wait for the element to be interactable
//        wait.until(ExpectedConditions.elementToBeClickable(element));
//        // Click using JavaScript to avoid MoveTargetOutOfBoundsException
//        try {
//            element.click();
//        } catch (ElementClickInterceptedException e) {
//            System.out.println("ElementClickInterceptedException occurred, using JavaScript click");
//            js.executeScript("arguments[0].click();", element);
//        }

    }

         public void ScrollToElementByAction(By locator)
         {
             WebDriverWait wait = new WebDriverWait(DriverManagerTL.getDriver(), Duration.ofSeconds(10));
             WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
             Actions actions = new Actions(DriverManagerTL.getDriver());
             actions.moveToElement(element).perform();
         }




    public void ScrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) DriverManagerTL.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }


    public boolean isEnabled(By locator, WaitStrategy waitStrategy) {
        WebElement element = DriverManagerTL.getDriver().findElement(locator);
        boolean isenable = element.isEnabled();
        return isenable;
    }


    public String getAttribute(By locator, String value, WaitStrategy waitStrategy) {
        WebElement element = DriverManagerTL.getDriver().findElement(locator);
        return element.getAttribute(value);

    }


    public static String getVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverManagerTL.getDriver(), Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(locator)));
        return element.getText();
    }



    public static WebElement getDropdownValue(By locator, String value) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(DriverManagerTL.getDriver(), Duration.ofSeconds(10));
        boolean isSelected = false;
        WebElement selectedElement = null;
        int attempts = 0;

        while (!isSelected && attempts < 3) {
            try {
                List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
                for (WebElement element : elements) {
                    if (element.getText().trim().equals(value)) {
                        ((JavascriptExecutor) DriverManagerTL.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
                        Thread.sleep(500);  // Ensure the UI updates properly
                        element.click();
                        isSelected = true;
                        selectedElement = element;
                        break;
                    }
                }
            } catch (StaleElementReferenceException e) {
                System.out.println("StaleElementReferenceException occurred, retrying...");
            } catch (NoSuchElementException e) {
                System.out.println("Dropdown value not found.");
            }
            attempts++;
        }
        return selectedElement;
    }




//    public static WebElement getDropdown(By locator, String value) {
//        WebDriverWait wait = new WebDriverWait(DriverManagerTL.getDriver(), Duration.ofSeconds(10));
//        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
//
//        for (WebElement element : elements) {
//            if (element.getText().trim().equals(value)) {
//                element.click();
//                return element;
//            }
//        }
//        throw new NoSuchElementException("Dropdown option '" + value + "' not found.");
//    }







    public static WebElement getHintfromList(By locator, String value) {
        int count = 0;  // Retry mechanism
        WebElement selectedElement = null;

        while (count < 3) {  // Retry fetching elements
            List<WebElement> elements = DriverManagerTL.getDriver().findElements(locator);
            for (WebElement element : elements) {
                if (element.getText().trim().equals(value)) {
                    element.click();
                    selectedElement = element;
                    return selectedElement;
                }
            }
            count++;
            try {
                Thread.sleep(1000); // Small wait before retrying
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return selectedElement;
    }







}