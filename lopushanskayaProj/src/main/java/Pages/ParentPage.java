package Pages;


import org.apache.log4j.Logger;
import static org.hamcrest.Matchers.is;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ParentPage {
    WebDriver driver;
    Logger logger;

    public ParentPage(WebDriver driver){
        this.driver = driver;
        logger = Logger.getLogger(getClass());
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


}
