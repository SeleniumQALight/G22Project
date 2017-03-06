package libs;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


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
}

