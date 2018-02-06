package Pages;

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
        super(driver,"Account of spare:Авторизация", "/login");
    }

    public void openLoginPage(){
        open(configProperties.base_url());
        checkTitle();
        checkCurrentUrl();
    }

    public void enterLogin(String login) {
        enterText(loginInput, login);
    }

    public void enterPass(String pass) {
        enterText(passInput, pass);
    }

    public void clickButtonLogin() {
        actionsWithOurElement.clickOnElement(buttonLogin);
    }


    public void loginUser(String login, String pass){
        openLoginPage();
        checkIfThisPageIsOpened();
        enterLogin(login);
        enterPass(pass);
        clickButtonLogin();

    }
}
