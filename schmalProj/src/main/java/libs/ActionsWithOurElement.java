package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.hamcrest.Matchers.is;   //manually written

/**
 * Created on 06.03.2017.
 */
public class ActionsWithOurElement {
    private WebDriver driver;
    private Logger logger;
    private WebDriverWait webDriverWait15;  //15.03.2017
    private WebDriverWait webDriverWait20; //15.03.2017

    public ActionsWithOurElement(WebDriver driver){
        this.driver = driver;
        logger = Logger.getLogger(getClass());
        webDriverWait15 = new WebDriverWait(driver, 15); //
        webDriverWait20 = new WebDriverWait(driver, 20); //
    }


    public void enterText(String xpathLocator, String text){
        try{
            driver.findElement(By.xpath(xpathLocator)).clear();
            driver.findElement(By.xpath(xpathLocator)).sendKeys(text);
            logger.info(text + " was input in the field");
        }
        catch (Exception e){
            logger.error("Cannot work with input " + xpathLocator);
            Assert.fail("Cannot work with input " + xpathLocator);
        }
    }
    public void enterText(WebElement element, String text) {
        try {
            webDriverWait15.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was inputed");
        }
        catch (Exception e){
            logger.error("Cannot work with input");
            Assert.fail("Cannot work with input");
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            webDriverWait20.until(ExpectedConditions.elementToBeClickable(element));  //15.03.2017 - line 52
//            webDriverWait20.until(ExpectedConditions.not(
//                    ExpectedConditions.invisibilityOf(element)));  //15.03.2017 - negative of line 52
            element.click();
            logger.info("Element was clicked");
        }
        catch (Exception e){
            logger.error("Cannot work with button " + element);
            Assert.fail("Cannot work with button " + element);
        }
    }

    //13.03.2017
    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed() && element.isEnabled(); //verify if element is displayed and if it is present
        } catch (Exception e) {
            return false;
        }
    }

    public void checkTextInElement(String locator, String expectedText) {
        try {
            String textFromElement = driver.findElement(By.xpath(locator)).getText();
            Assert.assertThat("Text in element does not match", textFromElement, is(expectedText));
        }
        catch (Exception e){
            logger.error("The element cannot be found");
            Assert.fail("The element cannot be found");
        }
    }
}
