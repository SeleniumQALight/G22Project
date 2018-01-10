package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.Matchers.is;

public class ActionsWithOurElement {
    private WebDriver driver;
    private static Logger logger;
    private static WebDriverWait webDriverWait15;
    private WebDriverWait webDriverWait20;

    public ActionsWithOurElement(WebDriver driver) {
        this.driver = driver;
        logger = Logger.getLogger(getClass());
        webDriverWait15 = new WebDriverWait(driver, 15);
        webDriverWait20 = new WebDriverWait(driver, 20);
    }

    public void enterText(String xpathLocator, String text) {
        try {
            driver.findElement(By.xpath(xpathLocator)).clear();
            driver.findElement(By.xpath(xpathLocator)).sendKeys(text);
            logger.info(text + " was inputed");
        } catch (Exception e) {
            printErrorAndStopTest();
        }
    }

    public static void enterText(WebElement element, String text) {
        try {
            webDriverWait15.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was inputed into " + element);
        } catch (Exception e) {
            printErrorAndStopTest();
        }
    }

    public void clickOnElement(String xpathLocator) {
        try {
            driver.findElement(By.xpath(xpathLocator)).click();
            logger.info("Element was clecked");
        } catch (Exception e) {
            printErrorAndStopTest();
        }
    }

    /**
     * Method checked is element present on page
     *
     * @param xpathLocator
     * @return
     */
    public boolean isElementPresent(String xpathLocator) {
        try {
            WebElement webElement = driver.findElement(By.xpath(xpathLocator));
            return webElement.isDisplayed() && webElement.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            webDriverWait20.until(ExpectedConditions.elementToBeClickable(element));
//            webDriverWait20.until(ExpectedConditions.not(ExpectedConditions.invisibilityOf(element)));
            element.click();
            logger.info("Element was clicked " + element);
        } catch (Exception e) {
            printErrorAndStopTest();
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            boolean tempState = element.isDisplayed() && element.isEnabled();
            logger.info("Element is Present : " + tempState);
            return tempState;
        } catch (Exception e) {
            logger.info("Element is Present : false");
            return false;
        }
    }

    public void checkTextInElement(String locator, String expectedText) {
        try {
//            Thread.sleep(3000);
            String textFromElement = driver.findElement(By.xpath(locator)).getText();
            Assert.assertThat("Text in element not matched", textFromElement, is(expectedText));
        } catch (Exception e) {
            printErrorAndStopTest();
        }
    }

    public void checkTextInElement(WebElement element, String expectedText) {
        try {
            String textFromElement = element.getText();
            Assert.assertThat("Text in element not matched", textFromElement, is(expectedText));
        } catch (Exception e) {
            printErrorAndStopTest();
        }
    }

    public String getTextFromElement(String xpathLocator) {
        String textFromElement = "";
        try {
            textFromElement = webDriverWait15
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator))).getText();
//            textFromElement =  driver.findElement(By.xpath(xpathLocator)).getText();
        } catch (Exception e) {
            printErrorAndStopTest();
        }
        return textFromElement;
    }

    /**
     * Method selected TEXT in dropDown
     * @param dropDownElement
     * @param textForSelection
     */
    public void selectTextInDropDown(WebElement dropDownElement, String textForSelection) {
        try {
            Select optionsFromDD = new Select(dropDownElement);
            optionsFromDD.selectByVisibleText(textForSelection);
            logger.info(textForSelection + " text was selected in DropDown");
        } catch (Exception e) {
            printErrorAndStopTest();
        }
    }

    /**
     * Method selected Value in dropDown 
     * @param dropDownElement
     * @param valueForSelection
     */
    public void selectValueInDropDown(WebElement dropDownElement, String valueForSelection) {
        try {
            Select optionsFromDD = new Select(dropDownElement);
            optionsFromDD.selectByValue(valueForSelection);
            logger.info(valueForSelection + " value was selected in DropDown");
        } catch (Exception e) {
            printErrorAndStopTest();
        }
    }

    private static void printErrorAndStopTest() {
        logger.error("Can not work with element");
        Assert.fail("Can not work with element");
    }


}
