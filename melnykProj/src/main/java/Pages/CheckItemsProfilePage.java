package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckItemsProfilePage extends ParentPage {



    public CheckItemsProfilePage (WebDriver driver) {
        super(driver);
    }

    public void enterLogin (String login) {actionsWithOurElements.enterText(".//input[@name='_username']", login);
    }
    public void enterPass (String pass) {
        actionsWithOurElements.enterText(".//*[@id='password']", pass);
    }
    public void clickOnButtonLogin () {
        actionsWithOurElements.clickOnButtonLogin (".//button");
    }


    public void clickAvatar () {
        actionsWithOurElements.clickAvatar(".//a[@class='dropdown-toggle' and @href='#']//*[@class='user-image']");

    }
    public void clickProfile () {
        actionsWithOurElements.clickProfile(".//a[@href='/users/profile/13']");

    }

    public Boolean actualResult () {
        actionsWithOurElements.actualResult(".//*//h3[@class='box-title' and text()='Профиль пользователя Студент']");
        actionsWithOurElements.actualResult(".//*[@id='userProfileEdit_user_email']");
        actionsWithOurElements.actualResult(".//*[@id='userProfileEdit_user_name']");
        actionsWithOurElements.actualResult(".//*[@id='userProfileEdit_user_username']");
        actionsWithOurElements.actualResult(".//*[@id='userProfileEdit_user_password_password']");
        actionsWithOurElements.actualResult(".//*[@id='userProfileEdit_user_password_password_confirm']");
        actionsWithOurElements.actualResult(".//button[@name='save']");
        actionsWithOurElements.actualResult(".//button[@name='delete']");
        return true;
    }





}
