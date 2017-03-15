package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.hamcrest.Matchers.is;

public class ActionsWithOurElements {
     private WebDriver driver;
     private  Logger logger;
     private  WebDriverWait webDriverWait15;
     private WebDriverWait webDriverWait20;


    public ActionsWithOurElements(WebDriver driver){
        this.driver = driver;
        logger = Logger.getLogger(getClass());
        webDriverWait15 = new WebDriverWait(driver, 15);
        webDriverWait20 = new WebDriverWait(driver,20);
    }
   // public  void enterText(String xpathlocator, String text){...}

    public  void enterText(WebElement element, String text){
        try{
            webDriverWait15.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(text);
            logger.info(text + "was input");
        }catch (Exception e){
            logger.error("Can not work with input login");
            Assert.fail("Can not work with input login");
        }
    }

//    public void clickOnElement(String xpathLocator) {
//        try{
//            driver.findElement(By.xpath(xpathLocator)).click();
//            logger.info("Element was clicked");
//
//        }catch (Exception e){
//            logger.error("Can not work with input login");
//            Assert.fail("Can not work with input login");
//        }
//
//    }

//    public boolean isElementPresent(String xpathLocator) {
//        try {
//            WebElement webElement = driver.findElement(By.xpath(xpathLocator));
//            return webElement.isDisplayed() && webElement.isEnabled();
//        } catch (Exception e) {
//            return false;
//        }
//    }

    public void clickOnElement(WebElement element) {
        try{
            webDriverWait20.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info("Element was clicked");

        }catch (Exception e){
            logger.error("Can not work with input login");
            Assert.fail("Can not work with input login");
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {

            return element.isDisplayed() && element.isEnabled();
        }catch (Exception e){
            return false;
        }
    }

    public void checkTextInElement(String locator, String expectedText) {
    try {
     String textFromElement = driver.findElement(By.xpath(locator)).getText();
    Assert.assertThat("Text in element not matched", textFromElement, is(expectedText));
    }
    catch (Exception e){
        logger.error("Can not work with element");
        Assert.fail("Can not work with element");
    }
    }
}

