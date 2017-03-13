package libs;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Администратор on 06.03.17.
 */
public class ActionsWithOutElements {
    WebDriver driver;
    Logger logger;

    public ActionsWithOutElements(WebDriver driver) {
        this.driver = driver;
        logger = Logger.getLogger(getClass());
    }


    //  for example
    public void enterText(String xpathLocator, String text) {
        try {
            driver.findElement(By.xpath(xpathLocator)).clear();
            driver.findElement(By.xpath(xpathLocator)).sendKeys(text);
        } catch (Exception e) {
            logger.error("Can not work with input");
            Assert.fail("Can not work with input");
        }
    }


//    public void enterPass(String pass{
//        action
//    }

    public void clickOnElement(String xpathLocator) {
        try {
            driver.findElement(By.xpath(xpathLocator)).click();
            logger.info("Elrmrnt was clicked");
        } catch (Exception e) {
            logger.error("Can not work with input");
            Assert.fail("Can not work with input");
        }
    }
}
