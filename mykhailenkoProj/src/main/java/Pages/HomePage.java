package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage{

    @FindBy (xpath = ".//div[@class='pull-left image']//img[@class='img-circle']")
    WebElement avatar;

    @FindBy (xpath = ".//*[@id='dictionary']/a")
    private WebElement menuDictionary;

    @FindBy(xpath = ".//*[@id='workers']/a")
    private WebElement workersSubMenu;

    @FindBy(id = "spares")
    private WebElement sparesSubMenu;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isAvatarPresent() {
        return actionsWithOurElement.isElementPresent(avatar);
    }

    public void clickMenuDictionary() {
        actionsWithOurElement.clickOnElement(menuDictionary);
    }

    public void clickWorkersSubMenu() {
        actionsWithOurElement.clickOnElement(workersSubMenu);
    }

    public void clickSparesSubMenu() {
        actionsWithOurElement.clickOnElement(sparesSubMenu);
    }
}
