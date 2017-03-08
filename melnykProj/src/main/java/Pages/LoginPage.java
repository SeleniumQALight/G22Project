package Pages;


import org.openqa.selenium.WebDriver;

public class LoginPage extends ParentPage {




    public LoginPage(WebDriver driver) {
        super(driver);
    }
    /*public void enterLogin (String login) {
        try {
            driver.findElement(By.name("_username")).clear();
            driver.findElement(By.name("_username")).sendKeys(login);
            logger.info(login + " was entered in input");
        } catch (Exception e) {
            logger.error("Cannot work with input login");
            Assert.fail("Cannot work with input login");
        }
    }*/
    public void enterLogin (String login) {
        actionsWithOurElements.enterText(".//input[@name='_username']", login);
    }
    public void enterPass (String pass) {
        actionsWithOurElements.enterText(".//*[@id='password']", pass);
    }
    public void clickOnButtonLogin () {
        actionsWithOurElements.clickOnButtonLogin (".//button");
    }


    public Boolean actualResult () {
       actionsWithOurElements.actualResult(".//a[@class='dropdown-toggle' and @href='#']//*[@class='user-image']");
        return true;
    }
    public Boolean actualResultNegativeTest () {
        actionsWithOurElements.actualResult(".//*/b[contains(text(),'Учет запчастей')]");
        return true;
    }
}


