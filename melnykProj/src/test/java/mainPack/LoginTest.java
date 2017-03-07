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
        checkAC( "Actual result != expected result", loginPage.actualResult(), true);
        //driver.get("http://v3.test.itpmgroup.com/");
       // driver.findElement(By.name("_username")).clear(); // find element and clear field
       // driver.findElement(By.name("_username")).sendKeys("Student"); // sendKeys - enter from claviatura
       // driver.findElement(By.id("password")).clear();
       // driver.findElement(By.id("password")).sendKeys("909090");
       // driver.findElement(By.tagName("button")).click();// tagName - name of tag in html
        //loginPage.actualResult();

    }
}

