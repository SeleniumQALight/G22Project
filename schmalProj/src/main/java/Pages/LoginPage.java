package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created  on 06.03.2017.
 */
public class LoginPage extends ParentPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * do not use this govno-code, this code is transited in ActionsWithOurElement
     * @param login
     */
    public void enterLogin(String login){
        try {
            driver.findElement(By.name("_username")).clear();
            driver.findElement(By.name("_username")).sendKeys(login);
            logger.info("Login '" + login + "' was entered in Login field");
        }
        catch (Exception e) {
            logger.error("Cannot work with login input");
            Assert.fail("Cannot work with login input"); //org.junit
        }
    }

    public void enterPass(String pass){
        actionsWithOurElement.enterText(".//*[@id='password']", pass);
    }

    public void clickButtonLogin(){
        actionsWithOurElement.clickOnElement(".//*button");
    }
}
