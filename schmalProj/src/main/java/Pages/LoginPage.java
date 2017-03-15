package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created  on 06.03.2017.
 */
public class LoginPage extends ParentPage {

    @FindBy(name = "_username")  // = driver.findElement(By.name(_username"); = loginInput in lines 28-29
    WebElement loginInput;

    @FindBy(id = "password")
    WebElement passInput;   // = ".//*[@id='password']"

    @FindBy(xpath = ".//*button")
    WebElement clickButton;     // = ".//*button"


    public LoginPage(WebDriver driver) {
        super(driver);
        // PageFactory.initElements(driver, this);  //PageFactory - library
    }


    public void openLoginPage(){
        open("http://v3.test.itpmgroup.com");
    }

    public void loginUser (String login, String pass){
        openLoginPage();
        checkTitle("Account of spare:Авторизация");
        enterLogin(login);
        enterPass(pass);
        clickButtonLogin();
    }



    /**
     * do not use this govno-code, this code is transited in ActionsWithOurElement
     * @param login
     */
    public void enterLogin(String login){
        try {
            loginInput.clear();
            loginInput.sendKeys(login);
            logger.info("Login '" + login + "' was entered in Login field");
        }
        catch (Exception e) {
            logger.error("Cannot work with login input");
            Assert.fail("Cannot work with login input"); //org.junit
        }
    }

    public void enterPass(String pass){
        actionsWithOurElement.enterText(passInput, pass);
    }

    public void clickButtonLogin(){
        actionsWithOurElement.clickOnElement(clickButton);
    }
}
