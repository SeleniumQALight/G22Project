package Pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.ActionsWithOurElement.enterText;

public class LoginPage extends ParentPage {

    @FindBy(name = "_username")
    private WebElement loginInput;

    @FindBy(id = "password")
    private WebElement passInput;

    @FindBy(xpath = ".//button")
    private WebElement buttonLogin;

    public LoginPage(WebDriver driver) {
        super(driver, "Account of spare:Авторизация", "/login");
    }

    @Step
    public void openLoginPage() {
        open(configProperties.base_url());
        checkTitle();
        checkCurrentUrl();
    }

    @Step
    public void enterLogin(String login) {
        enterText(loginInput, login);
    }

    @Step
    public void enterPass(String pass) {
        enterText(passInput, pass);
    }

    @Step
    public void clickButtonLogin() {
        actionsWithOurElement.clickOnElement(buttonLogin);
    }

    @Step
    public void loginUser(String login, String pass) {
        openLoginPage();
        checkIfThisPageIsOpened();
        enterLogin(login);
        enterPass(pass);
        clickButtonLogin();

    }
}
