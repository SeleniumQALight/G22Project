package mainPack;

import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;


public class FailedLoginTest extends ParentTest {
    public FailedLoginTest(String browser) {
        super(browser);
    }
    @Test
    public void filedLogin (){
        loginPage.open("http://v3.test.itpmgroup.com/");
        loginPage.checkTitle("Account of spare:Авторизация");
        loginPage.enterLogin("W222");
        loginPage.enterPass("fdsjkfdsl");
        loginPage.clickOnButtonLogin();
        checkAC( "Actual result = expected result. Failed negative Login Test", loginPage.isForFailedTest(), true);

    }

}
