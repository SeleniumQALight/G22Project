package libs;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ActionsWithOurElements {

    WebDriver driver;
    Logger logger;
    public ActionsWithOurElements (WebDriver driver) {
        this.driver=driver;
       logger = Logger.getLogger(getClass());
    }
    public void enterText (String xpathLocator, String text) {
        try {
            driver.findElement(By.xpath(xpathLocator)).clear();
            driver.findElement(By.xpath(xpathLocator)).sendKeys(text);
            logger.info(text+" was imputed");
        } catch (Exception e) {
            logger.error("Cannot work with input");
            Assert.fail("Cannot work with input");
        }
    }

    public void clickOnButtonLogin(String xpathLocator) {
        try {
            driver.findElement(By.xpath(xpathLocator)).click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            logger.error("Cannot click button");
            Assert.fail("Cannot click button");
        }
    }

    public boolean isElementPresent(String xpathLocator) {
        try {
            WebElement webElement = driver.findElement(By.xpath(xpathLocator));
            return webElement.isDisplayed() && webElement.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickAvatar (String xpathLocator) {
        try {
            driver.findElement(By.xpath(xpathLocator)).click();
            logger.info("Element was found and clicked");
        } catch (Exception e) {
            logger.error("Cannot found element Avatar");
            Assert.fail("Cannot found element Avatar");
        }
    }
    public void clickProfile (String xpathLocator) {
        try {
            driver.findElement(By.xpath(xpathLocator)).click();
            logger.info("Element was found and clicked");
        } catch (Exception e) {
            logger.error("Cannot found element Avatar");
            Assert.fail("Cannot found element Avatar");
        }
    }
}

