package mainPack;

import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;

/**
 * Created by QALight on 01.03.2017.
 */
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

//    @Test
//    public void unvalidLogon(){
//        loginPage.open("http://v3.test.itpmgroup.com/");
//        loginPage.checkTitle("Account of spare:Авторизация");
//        loginPage.enterLogin("studend");
//        loginPage.enterPass("909090");
//        loginPage.clickButtonLogin();
//        loginPage.checkTitle("Account of spare:Авторизация");
//        checkAC("Title not expected", loginPage.getTitle(), "Account of spare:Авторизация");
//
//    }
    @Test
    public void unvalidLogon(){
        loginPage.loginUser("Studentd", "909090");
        checkAC("Title not expected", loginPage.getTitle(), "Account of spare:Авторизация");

    }
}