package Pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends ParentPage{

    /**
     * Constructor : inputting driver in constr to not open browser for each page
     *
     * @param driver
     */
    public HomePage(WebDriver driver) {
        super(driver); //peremennaya obyavlena v Parente
    }

    public boolean isAvatarPresent() {
        return actionsWithTestElements.isElementPresent(
                ".//div[@class='pull-left image']//img[@class='img-circle']");
    }
}
