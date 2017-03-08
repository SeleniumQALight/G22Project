package logOn;

import org.junit.Test;
import parentTest.ParentTest;

public class LoginTest extends ParentTest {
    public LoginTest(String browser) {
        super(browser);
    }

    @Test
    public void validLogOn(){

        loginPage.open("http://v3.test.itpmgroup.com");
        loginPage.checkTitle("Account of spare:Авторизация");
        loginPage.enterLogin("Student");
        loginPage.enterPass("909090");
        loginPage.clickButtonLogin();

        checkAC("Avatar Not present ", loginPage.isAvatarPresent(),true);
    }
}
