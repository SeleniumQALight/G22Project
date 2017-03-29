package Pages;


import libs.ActionsWithOurElement;
import org.apache.log4j.Logger;

import org.apache.xerces.impl.xs.identity.Selector;
import static org.hamcrest.Matchers.is;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {
    WebDriver driver;
    Logger logger;
    ActionsWithOurElement actionsWithOurElement;

    public ParentPage(WebDriver driver){
        this.driver = driver;
        logger = Logger.getLogger(getClass());
        actionsWithOurElement = new ActionsWithOurElement(driver);
        PageFactory.initElements(driver,this);
    }

    /**
     * Method for open page with url
     * @param url
     */
    public void open(String url){
        try {
            driver.get(url);
            logger.info("Page was opened with url " + url);
        } catch (Exception e){
            logger.error("Can not open " + url);
            Assert.fail("Can not open " + url);
        }
    }

    public void checkTitle(String expectedTitle){
        try {
            Assert.assertThat("Title not match", driver.getTitle(),
                    is(expectedTitle));
        } catch (Exception e){
            logger.error("Can not work with page " );
            Assert.fail("Can not work with page " );
        }
    }


    public String getTitle() {
        return driver.getTitle();
    }
}
