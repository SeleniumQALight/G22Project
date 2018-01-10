package Pages;


import libs.ActionsWithOurElement;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;

import static org.hamcrest.Matchers.is;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class ParentPage {
    WebDriver driver;
    Logger logger;
    String expectedTitle;
    ActionsWithOurElement actionsWithOurElement;
    ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    public ParentPage(WebDriver driver, String expectedTitle){
        this.driver = driver;
        logger = Logger.getLogger(getClass());
        actionsWithOurElement = new ActionsWithOurElement(driver);
        PageFactory.initElements(driver,this);
        this.expectedTitle = expectedTitle;
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

    public void checkTitle(){
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

    public void checkTitleH1PresentOnPageWithText(String expectedText) {
        actionsWithOurElement.checkTextInElement(".//H1",expectedText);
    }

    public String getExpectedTitle() {
        return expectedTitle;
    }


}
