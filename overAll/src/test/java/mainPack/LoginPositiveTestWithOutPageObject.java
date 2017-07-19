package mainPack;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static libs.Singletone.chromeDriver;


public class LoginPositiveTestWithOutPageObject {

    @Test
    public void loginPositiveTestWithOutPageObject(){
    
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        chromeDriver.get("http://v3.test.itpmgroup.com/login");
    
        chromeDriver.findElement(By.name("_username")).clear();
        chromeDriver.findElement(By.name("_username")).sendKeys("Student");
    
        chromeDriver.findElement(By.id("password")).clear();
        chromeDriver.findElement(By.id("password")).sendKeys("909090");
    
        chromeDriver.findElement(By.tagName("button")).click();
        Assert.assertTrue(chromeDriver.findElement(By.xpath(".//div[@class='pull-left image']//img[@class='img-circle']"))
                .isDisplayed());
    
        chromeDriver.quit();
    }
}
