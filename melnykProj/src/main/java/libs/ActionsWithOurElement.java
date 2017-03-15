package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ActionsWithOurElement {
    private WebDriver driver;
    private Logger logger;

    public ActionsWithOurElement(WebDriver driver) {
        this.driver = driver;
        logger = Logger.getLogger(getClass());
    }

   public void enterText(String xpathLocator, String text) {
        try {
            driver.findElement(By.xpath(xpathLocator)).clear();
            driver.findElement(By.xpath(xpathLocator)).sendKeys(text);
            logger.info(text + " was inputed");

        } catch (Exception e) {
            logger.error("Can not work with input");
            Assert.fail("Can not work with input");
        }
    }

    public void enterText(WebElement element, String text){
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was inputed");

        } catch (Exception e) {
            logger.error("Can not work with input");
            Assert.fail("Can not work with input");
        }
    }

   public void clickOnElement(String xpathLocator) {
        try {
            driver.findElement(By.xpath(xpathLocator)).click();
            logger.info("Element was clecked");

        } catch (Exception e) {
            logger.error("Can not work with button");
            Assert.fail("Can not work with button");
        }
    }

    /**
     * Method checked is element present on page
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

    public void clickOnElement(WebElement buttonLogin) {
        try {
            buttonLogin.click();
            logger.info("Element was clecked");

        } catch (Exception e) {
            logger.error("Can not work with button");
            Assert.fail("Can not work with button");
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed() && element.isEnabled();
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