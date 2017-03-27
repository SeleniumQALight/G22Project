package Pages;

import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    @FindBy(name = "_username")
    WebElement loginInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(xpath = ".//button")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterLogin(String login) {
        try {
            loginInput.clear();
            loginInput.sendKeys(login);
            logger.info(login + " was entered in input");
        } catch (Exception e) {
            logger.error("Can not work with login input");
            Assert.fail("Can not work with login input");
        }
    }

    public void enterPass(String password) {
        actionsWithOurElements.enterText(passwordInput, password);
    }

    public void clickButtonLogin() {
        actionsWithOurElements.clickOnElement(loginButton);
    }

}