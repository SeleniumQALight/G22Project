package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActionsWithOurElements {
    WebDriver driver;
    Logger logger;
    public ActionsWithOurElements(WebDriver driver){
        this.driver = driver;
        logger = Logger.getLogger(getClass());
    }
    public void enterText(String xpathLocator, String text){
        try{
            driver.findElement(By.xpath(xpathLocator)).clear();
            driver.findElement(By.xpath(xpathLocator)).sendKeys(text);
            logger.info(text + "was input");
        }catch (Exception e){
            logger.error("Can not work with input login");
            Assert.fail("Can not work with input login");
        }
    }

    public void clickOnElement(String xpathLocator) {
        try{
            driver.findElement(By.xpath(xpathLocator)).click();
            logger.info("Element was clicked");

        }catch (Exception e){
            logger.error("Can not work with input login");
            Assert.fail("Can not work with input login");
        }

    }
}

