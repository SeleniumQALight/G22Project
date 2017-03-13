package Pages;


//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//public class LoginPage extends ParentPage {
//
//    public LoginPage(WebDriver driver) {
//        super(driver);
//    }
//
//    public void enterLogin(String login) {
//        try {
//            driver.findElement(By.name("_username")).clear();
//            driver.findElement(By.name("_username")).sendKeys(login);
//            logger.info(login + "was entered in input");
//        } catch (Exception e) {
//            logger.error("Can not work with input login");
//            Assert.fail("Can not work with input login");
//        }
//    }
//    public void enterPass(String pass){
//        actionsWithOurElements.enterText(".//*[@id='password']", pass);
//    }
//public void clickButtonLogin(){
//        actionsWithOurElements.clickOnElement(".//*button");
//
//}
//
//}
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends ParentPage {

    @FindBy(name = "_username")
    WebElement loginInput;
    @FindBy(id = "password")
    WebElement passInput;
    @FindBy(xpath = ".//button")
    WebElement buttonLogin;


    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void openLoginPage() {
        open("http://v3.test.itpmgroup.com/");

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

    //    public void enterPass(String pass) {
//        actionsWithOurElements.enterText(".//*[@id='password']", pass);
//    }
    public void enterPass(String pass) {
        actionsWithOurElements.enterText(passInput, pass);
    }


    public void clickButtonLogin() {
        actionsWithOurElements.clickOnElement(buttonLogin);
    }

    public void loginUser(String login, String pass){

    openLoginPage();

    checkTitle("Account of spare:Авторизация");

    enterLogin(login);

    enterPass(pass);

    clickButtonLogin();
}

}