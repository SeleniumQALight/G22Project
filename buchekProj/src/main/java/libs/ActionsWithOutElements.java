package libs;

import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActionsWithOutElements {
    WebDriver driver;
    Logger logger;

    public ActionsWithOutElements(WebDriver driver) {
        this.driver = driver;
        logger = Logger.getLogger(getClass());
    }

    public void enterText(String xpathLocator, String text) {
        try {
            driver.findElement(By.xpath(xpathLocator)).clear();
            driver.findElement(By.xpath(xpathLocator)).sendKeys(text);
            logger.info(text + "was inputed");
        } catch (Exception e) {
            logger.error("Can not work with imput");
            Assert.fail("Can not work with imput");
        }
    }

    public void enterPass(String pass) {


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
}
