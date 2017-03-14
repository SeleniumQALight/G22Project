package Pages;


import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import static org.hamcrest.Matchers.is;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ParentPage {
    WebDriver driver;
    Logger logger;
    ActionsWithOurElements actionsWithOurElements;

    public ParentPage (WebDriver driver) {
        this.driver = driver;
        logger = Logger.getLogger(getClass());
        actionsWithOurElements = new ActionsWithOurElements(driver);
    }

    /**
     * Method for open page with url
     *
     * */

    public void open (String url) {
        try {
driver.get(url);
logger.info("Page was opened with url "+url);
    } catch (Exception e) {
            logger.error("Can't open "+url);
            Assert.fail("Can't open "+url);
        }

        }
        public void checkTitle (String expectedTitle) {
        try {
           Assert.assertThat("Title not match", driver.getTitle(), is(expectedTitle));
        } catch (Exception e) {
            logger.error("Can't work with page");
            Assert.fail("Can't work with page");
        }
        }
}
