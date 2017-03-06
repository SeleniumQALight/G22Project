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
     * @param xpathlocator
     * @param text
     */

    public  void  enterText(String xpathlocator, String text){
        try {
            driver.findElement(By.xpath(xpathlocator)).clear();
            driver.findElement(By.xpath(xpathlocator)).clear();
            logger.info("Text was inputted");
        } catch (Exception o){
            logger.error("Cannot open xpath locator " + xpathlocator);
            Assert.fail("Cannot open xpath locator " + xpathlocator);

        }
    }



}
