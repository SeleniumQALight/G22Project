package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckItemsProfilePage extends ParentPage {
@FindBy(xpath = ".//a[@class='dropdown-toggle' and @href='#']//*[@class='user-image']")
WebElement avatar;
@FindBy(xpath = ".//a[@href='/users/profile/13']")
WebElement profile;
    @FindBy(xpath = ".//*//h3[@class='box-title' and text()='Профиль пользователя Студент']")
    WebElement textProfilrUserStudent;
    @FindBy(xpath = ".//*[@id='userProfileEdit_user_email']")
    WebElement editUserEmail;
    @FindBy(xpath = ".//*[@id='userProfileEdit_user_name']")
    WebElement editUserName;
    @FindBy(xpath = ".//*[@id='userProfileEdit_user_username']")
    WebElement editUserUsername;
    @FindBy(xpath = ".//*[@id='userProfileEdit_user_password_password']")
    WebElement editUserPassword;
    @FindBy(xpath = ".//*[@id='userProfileEdit_user_password_password_confirm']")
    WebElement editUserPasswordConfirm;
    @FindBy(xpath = ".//button[@name='save']")
    WebElement buttonSave;
    @FindBy(xpath = ".//button[@name='delete']")
    WebElement buttonDelete;

    public CheckItemsProfilePage (WebDriver driver) {
        super(driver);
    }


    public void clickAvatar () {
        actionsWithOurElement.clickOnElement(avatar);

    }
    public void clickProfile () {
        actionsWithOurElement.clickOnElement(profile);

    }

    public Boolean isProfileItemsPresent () {
        return
        actionsWithOurElement.isElementPresent(textProfilrUserStudent)&&
        actionsWithOurElement.isElementPresent(editUserEmail)&&
        actionsWithOurElement.isElementPresent(editUserName)&&
        actionsWithOurElement.isElementPresent(editUserUsername)&&
        actionsWithOurElement.isElementPresent(editUserPassword)&&
        actionsWithOurElement.isElementPresent(editUserPasswordConfirm)&&
        actionsWithOurElement.isElementPresent(buttonSave)&&
        actionsWithOurElement.isElementPresent(buttonDelete);

    }


}
