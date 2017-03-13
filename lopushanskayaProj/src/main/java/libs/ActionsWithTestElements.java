package libs;



import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Admin on 06.03.2017.
 */
public class ActionsWithTestElements {
    WebDriver driver;
    Logger logger;

    public ActionsWithTestElements(WebDriver driver){
        this.driver = driver;
        logger = Logger.getLogger(getClass());
    }

    /**
     * better way
     * @param xpathLocator
     * @param text
     */

    public  void  enterText(String xpathLocator, String text){
        try {
            driver.findElement(By.xpath(xpathLocator)).clear();
            driver.findElement(By.xpath(xpathLocator)).sendKeys(text);
            logger.info("Text was inputted");
        } catch (Exception o){
            logger.error("Cannot open xpath locator " + xpathLocator);
            Assert.fail("Cannot open xpath locator " + xpathLocator);

        }
    }
    public void enterText(WebElement element, String text){
        try{
            element.clear();
            element.sendKeys(text);
            logger.info("Text was inputted");}
            catch (Exception o){
            logger.error("Cannot input text " + text);
            Assert.fail("Cannot input text " + text);

        }

    }



    public void clickOnElement(WebElement buttonLogin) {
        try {
            buttonLogin.click();
            logger.info("Button was clicked");
        } catch (Exception o){
            logger.error("Cannot open button  " + buttonLogin);
            Assert.fail("Cannot open button  " + buttonLogin);
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
}
