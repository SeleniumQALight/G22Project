package logOn;

import org.junit.Test;
import parentTest.ParentTest;

public class LoginTest extends ParentTest {
    public LoginTest(String browser) {
        super(browser);
    }

    @Test
    public void validLogOn(){

        loginPage.openLoginPage();
        loginPage.checkTitle("Account of spare:Авторизация");
        loginPage.enterLogin("Student");
        loginPage.enterPass("909090");
        loginPage.clickButtonLogin();
        homePage.checkTitle("Учет запчастей");

        checkAC("Avatar Not present ", homePage.isAvatarPresent(),true);
    }
    @Test
    public void unvalidLogOn(){
      loginPage.loginUser("studend","909090");

        checkAC("Title not expected ", loginPage.getTitle(),"Account of spare:Авторизация");


    }
}
