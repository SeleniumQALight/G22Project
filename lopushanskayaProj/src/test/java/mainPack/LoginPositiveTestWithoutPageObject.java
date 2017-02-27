package mainPack;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPositiveTestWithoutPageObject {
  WebDriver webDriver;

  @Test
    public void loginPositiveTestWithoutPageObject(){
    webDriver = new ChromeDriver(); //webDriver is browser
    webDriver.manage().window().maximize();
    webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    webDriver.get("http://v3.test.itpmgroup.com");
    webDriver.findElement(By.name("_username")).clear();
    webDriver.findElement(By.name("_username")).sendKeys("Student");
    webDriver.findElement(By.id("_password")).clear();
    webDriver.findElement(By.id("_password")).sendKeys("909090");
    webDriver.findElement(By.tagName("button")).click();

    Assert.assertTrue(webDriver.findElement(By.xpath(".//div[@class='pull-left image']//img[@class='img-circle']")).isDisplayed());

    webDriver.quit();//deletes object instead of close

  }
}
