package Pages;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends ParentPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterLogin (String login) {
        try {
            driver.findElement(By.name("_username")).clear();
            driver.findElement(By.name("_username")).sendKeys(login);
            logger.info(login + " was entered in input");
        } catch (Exception e) {
            logger.error("Can not work with login input");
            Assert.fail("Can not work with login input");
        }
    }

    public void enterPass (String password) {
        actionsWithOurElements.enterText(".//input[@id='password']", password);
    }

}
