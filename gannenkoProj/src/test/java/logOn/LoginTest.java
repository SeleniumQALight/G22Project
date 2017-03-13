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

        checkAC("Avatar not present ", driver.findElement(By.xpath(".//div[@class='pull-left image']//img[@class='img-circle']"))
                .isDisplayed(), true);
    }

}
