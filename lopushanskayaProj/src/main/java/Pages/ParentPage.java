package Pages;


import libs.ActionsWithTestElements;
import org.apache.log4j.Logger;
import static org.hamcrest.Matchers.is;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {
    WebDriver driver;
    Logger logger;
    ActionsWithTestElements actionsWithTestElements;

    /**
     * Constructor : inputting driver in constr to not open browser for each page
     * @param driver
     */

    public ParentPage(WebDriver driver){
        this.driver = driver;
        logger = Logger.getLogger(getClass());
        actionsWithTestElements = new ActionsWithTestElements(driver);
        PageFactory.initElements(driver, this); //this - in this class; findby - describes, pagefactory - creates
    }

    /**
     * Method for opening page with url
     * @param url
     */
    public void open(String url){
        try{
            driver.get(url);
            logger.info("Page was opened with url: "+ url);

        } catch (Exception o){
            logger.error("Cannot open " + url);
            Assert.fail("Cannot open " + url);
        }

    }

    public void checkTitle(String expectedTitle){
        try{
            Assert.assertThat("Title not match", driver.getTitle(), is(expectedTitle));
        } catch (Exception o){
            logger.error("Cannot work with page ");
            Assert.fail("Cannot work with page ");
        }
    }


    public String getTitle() {
        return getTitle();
    }
}
