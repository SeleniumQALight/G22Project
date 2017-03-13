package mainPack;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import parentTest.ParentTest;

import java.util.concurrent.TimeUnit;

public class LoginPositiveTestWithoutPageObject1 extends ParentTest {
    WebDriver webDriver;

    public LoginPositiveTestWithoutPageObject1(String browser) {
        super(browser);
    }

    @Test
    public void loginPositiveTestWithoutPageObject() {


        webDriver.get("http://v3.test.itpmgroup.com/");

        webDriver.findElement(By.name("_username")).clear();
        webDriver.findElement(By.name("_username")).sendKeys("Student");

        webDriver.findElement(By.id("password")).clear();
        webDriver.findElement(By.id("password")).sendKeys("909090");

        webDriver.findElement(By.tagName("button")).click();

        Assert.assertTrue(webDriver.findElement(By.xpath(".//div[@class='pull-left image']//img[@class='img-circle']")).isDisplayed());



       /* webDriver.quit(); */

    }
}
