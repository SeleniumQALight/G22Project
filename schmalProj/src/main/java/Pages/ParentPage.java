package Pages;

import libs.ActionsWithOurElement;
import org.apache.log4j.Logger;
import static org.hamcrest.Matchers.is;   //manually written
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//creating current driver and transiting it to the variable driver
public class ParentPage {
    WebDriver driver;
    Logger logger;
    ActionsWithOurElement actionsWithOurElement;

    public ParentPage (WebDriver driver){
        this.driver = driver;
        logger = Logger.getLogger(getClass());
        actionsWithOurElement = new ActionsWithOurElement(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Method for opening page with url
     * @param url
     */
    public void open(String url){
        try {
            driver.get(url);
            logger.info("Page was opened with URL: " + url);
        } catch (Exception e){
            logger.error("Cannot open " + url);
            Assert.fail("Cannot open " + url);
        }
    }

    /**
     * Method of
     * @param expectedTitle
     */
     public void checkTitle(String expectedTitle){
         try {
             Assert.assertThat("Title does not match!", driver.getTitle(), is(expectedTitle));
         }
         catch (Exception e){
             logger.error("Cannot work with page");
             Assert.fail("Cannot work with page");
         }
     }

    //13.03.2017
    public String getTitle() {
        return driver.getTitle();
    }
}
