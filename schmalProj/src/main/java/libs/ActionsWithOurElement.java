package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created on 06.03.2017.
 */
public class ActionsWithOurElement {
    WebDriver driver;
    Logger logger;

    public ActionsWithOurElement(WebDriver driver){
        this.driver = driver;
        logger = Logger.getLogger(getClass());
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
            element.clear();
            element.sendKeys(text);
        }
    }

    public void clickOnElement(WebElement clickButton) {
        try{
            clickButton.click();
            logger.info("Element was clicked");
        }
        catch (Exception e){
            logger.error("Cannot work with button " + clickButton);
            Assert.fail("Cannot work with button " + clickButton);
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
}
