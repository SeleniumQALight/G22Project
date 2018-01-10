package logOn;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import parentTest.ParentTest;
import categories.SlowTests;

@Category(SlowTests.class)
public class LoginTest extends ParentTest {
    public LoginTest(String browser) {
        super(browser);
    }

    @Test
    public void validLogOn(){
        loginPage.openLoginPage();
        loginPage.checkTitle();
        loginPage.enterLogin("Student");
        loginPage.enterPass("909090");
        loginPage.clickButtonLogin();
        homePage.checkTitle();
        checkAC("Avatar Not present ", homePage.isAvatarPresent(),true);
    }

    @Test
    public void unvalidLogOn(){
       loginPage.loginUser("studend","909090");
        checkAC("Title not expected", loginPage.getTitle()
                ,loginPage.getExpectedTitle());

    }
}
