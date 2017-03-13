package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends ParentPage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // индусский код
    public void enterLogin(String login) {
        try {
            driver.findElements(By.name("_username")).clear();
            driver.findElement(By.name("_username")).sendKeys(login);
            logger.info(login + " was entered in input ");
        } catch (Exception e) {
            logger.error("Cannot work with input login");
            Assert.fail("Cannot work with input login");
        }
    }

    // нормальный код
    public void enterPass(String pass) {
        actionsWithOurElements.enterText(".//*[@id='password']", pass);
    }


}
