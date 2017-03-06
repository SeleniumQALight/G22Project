package Pages;

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


}
