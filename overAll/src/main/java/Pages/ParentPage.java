package Pages;


import io.qameta.allure.Step;
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
    String expectedUrl;

    ActionsWithOurElement actionsWithOurElement;
    static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    protected final static String baseUrl = configProperties.base_url();

    public ParentPage(WebDriver driver, String expectedTitle, String expectedUrl){
        this.driver = driver;
        logger = Logger.getLogger(getClass());
        actionsWithOurElement = new ActionsWithOurElement(driver);
        PageFactory.initElements(driver,this);

        this.expectedTitle = expectedTitle;
        this.expectedUrl = baseUrl + expectedUrl;
    }

    /**
     * Method for open page with url
     * @param url
     */
    @Step
    public void open(String url){
        try {
            driver.get(url);
            logger.info("Page was opened with url " + url);
        } catch (Exception e){
            logger.error("Can not open " + url);
            Assert.fail("Can not open " + url);
        }
    }

    @Step
    public void checkCurrentUrl(){
        try {
            Assert.assertEquals("Url is not expected", driver.getCurrentUrl(), expectedUrl);
        }catch (Exception e){
            logger.error("Can not get url ");
            Assert.fail("Can not get url ");
        }
    }

    @Step
    public void checkTitle(){
        try {
            Assert.assertThat("Title not match", driver.getTitle(),
                    is(expectedTitle));
        } catch (Exception e){
            logger.error("Can not work with page " );
            Assert.fail("Can not work with page " );
        }
    }

    @Step
    public void checkIfThisPageIsOpened(){
        checkTitle();
        checkCurrentUrl();
    }

    @Step
    public String getTitle() {
        return driver.getTitle();
    }

    @Step
    public void checkTitleH1PresentOnPageWithText(String expectedText) {
        actionsWithOurElement.checkTextInElement(".//H1",expectedText);
    }

    public String getExpectedTitle() {
        return expectedTitle;
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

}
