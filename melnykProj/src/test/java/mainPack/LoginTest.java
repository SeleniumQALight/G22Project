package mainPack;

import libs.ActionsWithOurElements;
import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;

/**
 * Created by k.melnyk on 01.03.2017.
 */
public class LoginTest extends ParentTest {
    public LoginTest(String browser) {
        super(browser);
    }

    @Test
    public void validLogOn() {

        loginPage.open("http://v3.test.itpmgroup.com/");
        loginPage.checkTitle("Account of spare:Авторизация");
        loginPage.enterLogin("Student");
        loginPage.enterPass("909090");
        loginPage.clickOnButtonLogin();
        checkAC( "Actual result != expected result", loginPage.isAvatarPresent(), true);


    }
}

