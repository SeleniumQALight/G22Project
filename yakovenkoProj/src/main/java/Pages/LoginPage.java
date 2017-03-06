package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by user on 06.03.2017.
 */
public class LoginPage extends ParentPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void enterLogin(String login){
        try {
            driver.findElement(By.name("_username")).clear();
            driver.findElement(By.name("_username")).sendKeys(login);
            logger.info(login + "was entered in input");
        }catch (Exception e){
            logger.error("Cannot work with input login");
            Assert.fail("Cannot work with input login");
        }
    }
    public void enterPass(String pass){
        actionsWithOurElements.enterText(".//*[@id='password']",pass);

    }
}
