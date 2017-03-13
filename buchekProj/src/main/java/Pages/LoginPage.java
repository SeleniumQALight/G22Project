package Pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends ParentPage {


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterLogin(String login) {
        try {
            driver.findElement(By.name("_username")).clear();
            driver.findElement(By.name("_username")).sendKeys(login);
            logger.info(login + "was entered in input ");
        } catch (Exception e) {
            logger.error("Cannot work with input login");
            Assert.fail("Cannot work with input login");
        }
    }

    public void enterPass(String pass) {
        actionsWithOutElement.enterText(".//*[@id='password']", pass);
    }

    public void clickButtonLogin() {
        actionsWithOutElement.clickOnElement(".//*button");

    }

}
