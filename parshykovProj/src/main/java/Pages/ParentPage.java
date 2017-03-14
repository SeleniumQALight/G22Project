package Pages;


import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;

import static org.hamcrest.Matchers.is;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class ParentPage {
    WebDriver driver;
    Logger logger;
    ActionsWithOurElements actionsWithOurElements;

    public ParentPage(WebDriver driver) {
        this.driver = driver;
        logger = logger.getLogger(getClass());
        actionsWithOurElements = new ActionsWithOurElements(driver);
        PageFactory.initElements(driver,this);
    }

    /**
     * Method for open page with url
     *
     * @param url
     */
    public void open(String url) {
        try {
            driver.get(url);
            logger.info("Page was opened with url " + url);
        } catch (Exception e) {
            logger.error("Can not open " + url);
            Assert.fail("Can not open " + url);

        }
    }

    public void checkTitle(String expectedTitle) {
        try {
            Assert.assertThat("Title is not match", driver.getTitle(),
                    is(expectedTitle));
        } catch (Exception e) {
            logger.error("Can not work with page");
            Assert.fail("Can not work with page");
        }

    }

    public String getTitle() {
        return driver.getTitle();
    }
}
