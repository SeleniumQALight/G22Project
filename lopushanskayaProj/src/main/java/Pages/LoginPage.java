package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Admin on 06.03.2017.
 */
public class LoginPage extends ParentPage{
    /**
     * Constructor : to not open browser for each page
     * @param driver
     */

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterLogin(String login){
        try{
            driver.findElement(By.name("_username")).clear();
            driver.findElement(By.name("_username")).sendKeys(login);
            logger.info("Login '"+login+"' was entered in input ");
        } catch (Exception o){
            logger.error("Cannot work with input login");
            Assert.fail("Cannot work with input login");
        }
    }

    /**
     * not good example of inputting, indian code
     * @param password


    public void enterPassword(String password){
        try{
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys(password);
            logger.info("Password '"+password+"' was entered in input ");
        } catch (Exception o){
            logger.error("Cannot work with input password");
            Assert.fail("Cannot work with input password");
        }
    } */

    /**
     *  correct example, details in ActionsWithTestElements
     * @param pass
     */
    public void enterPass (String pass){
        actionsWithTestElements.enterText(".//*[@id = 'password']", pass);
    }

    public void clickButtonLogin(){
        actionsWithTestElements.clickOnElement(".//*button");

    }



}
