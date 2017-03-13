package Pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends ParentPage {

    @FindBy (name = "_username")
    WebElement loginInput;

    @FindBy (id = "password")
    WebElement passInput;

    @FindBy (id = ".//button")
    WebElement buttonLogin;

    public LoginPage(WebDriver driver) {

        super(driver);
    }
    public void openLogInPage (){
        open ("http://v3.test.itpmgroup.com");
    }

    public void enterLogin(String login) {
        try {
            loginInput.clear();
            loginInput.sendKeys(login);
            logger.info(login + " was entered in input ");
        } catch (Exception e) {
            logger.error("Cannot work with input login");
            Assert.fail("Cannot work with input login");
        }
    }

    public void enterPass(String pass) {
        actionsWithOurElement.enterText(passInput, pass);
    }

    public void clickButtonLogin() {
        actionsWithOurElement.clickOnElement(buttonLogin);
    }

    public void LogInUser (String login, String password){
        openLogInPage();
        checkTitle("Account of spare:Авторизация");
        enterLogin(login);
        enterPass(password);
        clickButtonLogin();
    }


}
