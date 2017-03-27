package mainPack;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginPositiveTestWithOutPageObject {
    WebDriver webDriver;


    @Test
    public void loginPositiveTestWithOutPageObject() {

        File fileFF = new File(".././drivers/geckodriver.exe");
        System.setProperty("webdriver.gecko.driver", fileFF.getAbsolutePath());
        webDriver = new FirefoxDriver();
//    System.setProperty("webdriver.gecko.driver", "E:\\Download\\Download\\geckodriver-v0.11.1-win64\\geckodriver.exe");
//   webDriver = new FirefoxDriver();
       // System.setProperty("webdriver.chrome.driver", "D:\\All_Projects\\QA_light\\G22YR\\G22Project\\drivers\\chromedriver_win32\\chromedriver.exe");
       // webDriver = new ChromeDriver();


        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        webDriver.get("http://v3.test.itpmgroup.com/");

        webDriver.findElement(By.name("_username")).clear();
        webDriver.findElement(By.name("_username")).sendKeys("Student");
        webDriver.findElement(By.id("password")).clear();
        webDriver.findElement(By.id("password")).sendKeys("909090");
        webDriver.findElement(By.tagName("button")).click();

        Assert.assertTrue(webDriver.findElement(By.xpath(".//*[@class='user-panel']")).isDisplayed());

        webDriver.quit();
    }

}
