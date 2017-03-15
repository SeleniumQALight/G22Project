package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckItemsProfilePage extends ParentPage {

    @FindBy(name = "_username")
    WebElement loginInput;

    @FindBy(id = "password")
    WebElement passInput;

    @FindBy(xpath = ".//button")
    WebElement buttonLogin;

    public CheckItemsProfilePage (WebDriver driver) {
        super(driver);
    }

    public void enterLogin (String login) {actionsWithOurElement.enterText(".//input[@name='_username']", login);
    }
    public void enterPass (String pass) {
        actionsWithOurElement.enterText(".//*[@id='password']", pass);
    }
    public void clickOnButtonLogin () {
        actionsWithOurElement.clickOnElement (".//button");
    }


    public void clickAvatar () {
        actionsWithOurElement.clickAvatar(".//a[@class='dropdown-toggle' and @href='#']//*[@class='user-image']");

    }
    public void clickProfile () {
        actionsWithOurElement.clickProfile(".//a[@href='/users/profile/13']");

    }

    public Boolean isProfileItemsPresent () {
        return
        actionsWithOurElement.isElementPresent(".//*//h3[@class='box-title' and text()='Профиль пользователя Студент']")&&
        actionsWithOurElement.isElementPresent(".//*[@id='userProfileEdit_user_email']")&&
        actionsWithOurElement.isElementPresent(".//*[@id='userProfileEdit_user_name']")&&
        actionsWithOurElement.isElementPresent(".//*[@id='userProfileEdit_user_username']")&&
        actionsWithOurElement.isElementPresent(".//*[@id='userProfileEdit_user_password_password']")&&
        actionsWithOurElement.isElementPresent(".//*[@id='userProfileEdit_user_password_password_confirm']")&&
        actionsWithOurElement.isElementPresent(".//button[@name='save']")&&
        actionsWithOurElement.isElementPresent(".//button[@name='delete']");

    }





}
