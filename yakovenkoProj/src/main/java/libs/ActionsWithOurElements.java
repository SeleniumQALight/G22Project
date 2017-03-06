package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by user on 06.03.2017.
 */
public class ActionsWithOurElements {
    WebDriver driver;
    Logger logger;
    public ActionsWithOurElements(WebDriver driver){
        this.driver= driver;
        logger= Logger.getLogger(getClass());
    }
    public  void enterText(String xpathlocator,String text){
        try{
            driver.findElement(By.xpath(xpathlocator)).clear();
            driver.findElement(By.xpath(xpathlocator)).sendKeys(text);
            logger.info(text + "was inputed");
        }catch (Exception e){
            logger.error("Can not work with input");
            Assert.fail("Can not work with input");
        }
    }
}
