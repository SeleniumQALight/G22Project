package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created on 13.03.2017.
 */
public class HomePage extends ParentPage{

    @FindBy(xpath = ".//div[@class='pull-left image']//img[@class='img-circle']")
    WebElement avatar;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isAvatarPresent() {
        return actionsWithOurElement.isElementPresent(avatar);
    }

}
