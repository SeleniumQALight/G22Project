package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage{
    @FindBy(xpath = ".//div[@class='pull-left image']//img[@class='img-circle']")
    WebElement avatar;
    @FindBy(xpath = ".//*[@id='dictionary']/a")
    private WebElement menuDictionary;
    @FindBy(xpath = ".//*[@id='workers']/a")
    private WebElement workersMenu;


    public HomePage(WebDriver driver) {
        super(driver);
    }
    public boolean isAvatarPresent() {
        return actionsWithOurElements.isElementPresent(avatar);
    }

    public void clickMenuDictionary() {
       actionsWithOurElements.clickOnElement(menuDictionary);
    }

    public void clickWorkersSubMenu() {
        actionsWithOurElements.clickOnElement(workersMenu);
    }


}
