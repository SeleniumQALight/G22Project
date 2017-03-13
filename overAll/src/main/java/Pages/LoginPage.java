package Pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends ParentPage {
    @FindBy(name = "_username")
    WebElement loginInput;
    @FindBy(id= "password")
    WebElement passInput;
    @FindBy(xpath= ".//button")
    WebElement buttonLogin;



    public LoginPage(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver,this);
    }
    public void openLoginPage(){
        open("http://v3.test.itpmgroup.com");
    }

    public void enterLogin(String login) {
        try {
            driver.findElement(By.name("_username")).clear();
            driver.findElement(By.name("_username")).sendKeys(login);
            logger.info(login + " was entered in input ");
        } catch (Exception e) {
            logger.error("Cannot work with input login");
            Assert.fail("Cannot work with input login");
        }
    }

    public void enterPass(String pass) {
        actionsWithOurElement.enterText(".//*[@id='password']", pass);
    }

    public void clickButtonLogin() {
        actionsWithOurElement.clickOnElement(buttonLogin);
    }

    public void loginUser(String login,String pass){
        openLoginPage();
        checkTitle("Account of spare:Авторизация");
        enterLogin(login);
        enterPass(pass);
        clickButtonLogin();
    }



}
