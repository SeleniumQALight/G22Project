package logOn;

import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;

public class LoginTest extends ParentTest {
    public LoginTest(String browser) {
        super(browser);
    }

    @Test
    public void validLogOn() {

        //driver.get("http://v3.test.itpmgroup.com");
        loginPage.open("http://v3.test.itpmgroup.com/login");
        loginPage.checkTitle("Account of spare:Авторизация");

        //driver.findElement(By.name("_username")).clear();
        //driver.findElement(By.name("_username")).sendKeys("Student");
        loginPage.enterLogin("Student");

        //driver.findElement(By.name("_password")).clear();
        //driver.findElement(By.id("password")).sendKeys("909090");
        loginPage.enterPass("909090");

        driver.findElement(By.tagName("button")).click();

        homePage.checkTitle("Учет запчастей");

        checkAC("Avatar not present ", homePage.isAvatarPresent(), true);
    }

    @Test
    public void invalidLogOn() {
        loginPage.open("http://v3.test.itpmgroup.com/login");
        loginPage.checkTitle("Account of spare:Авторизация");
        loginPage.enterLogin("Student");
        loginPage.enterPass("909090");
        driver.findElement(By.tagName("button")).click();
        homePage.checkTitle("Учет запчастей");

        checkAC("", loginPage.getTitle(), "Account of spare:Авторизация");
    }

}