package LogOn;

import Pages.HomePage;
import org.junit.Test;
import parentTest.ParentTest;

public class LoginTest extends ParentTest {
    public LoginTest(String browser) {
        super(browser);
    }

    @Test
    public void validLogOn(){

        loginPage.openLogInPage();
        loginPage.checkTitle("Account of spare:Авторизация");
        loginPage.enterLogin("Student");
        loginPage.enterPass("909090");
        loginPage.clickButtonLogin();
        homePage.checkTitle("Учет запчастей");

        checkAC("Avatar Not present ", homePage.isAvatarPresent(),true);
    }

    @Test
    public void unvalidLogOn(){
        loginPage.LogInUser("student","909090");
        checkAC("Title not expected", loginPage.getTitle(),"Account of spare:Авторизация");
    }
}
