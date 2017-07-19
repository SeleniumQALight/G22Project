package Pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends ParentPage {

    @FindBy(name = "_username")
    private WebElement loginInput;

    @FindBy(id = "password")
    private WebElement passInput;

    @FindBy(xpath = ".//button")
    private WebElement buttonLogin;

    public LoginPage(WebDriver driver) {
        super(driver);

    }

    public void openLoginPage(){
        open("http://v3.test.itpmgroup.com");
        checkTitle("Account of spare:Авторизация");
    }

    public void enterLogin(String login) {
        try {
            actionsWithOurElement.enterText(loginInput, login);
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


    public void loginUser(String login, String pass){
        openLoginPage();
        checkTitle("Account of spare:Авторизация");
        enterLogin(login);
        enterPass(pass);
        clickButtonLogin();

    }
}
