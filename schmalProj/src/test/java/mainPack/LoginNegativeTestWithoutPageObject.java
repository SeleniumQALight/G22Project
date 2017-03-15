package mainPack;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginNegativeTestWithoutPageObject {

    /**
     * Negative autotest: homework 28.02.2017
     *
     */

    WebDriver webDriver;    //variable webDriver declared

    @Test                  //reference to the autotest
    public void loginNegativeTestWithoutPageObject() {
        webDriver = new ChromeDriver();   //here is the browser where tests will be run;
        webDriver.manage().window().maximize();     //maximizing the open window of the browser
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);     //the of timeout of the browser's waiting for the page opening
        webDriver.get("http://v3.test.itpmgroup.com"); //opening website

        webDriver.findElement(By.name("_username")).clear();  //locating the field "Login" and clearing its contents
        webDriver.findElement(By.name("_username")).sendKeys("sttt");  //entering "Student" in the login field

        //webDriver.findElement(By.id("password")).clear();  //locating the field "Password" and clearing its contents
        //webDriver.findElement(By.id("password")).sendKeys("909090"); //entering 909090 as password

        webDriver.findElement(By.tagName("button")).click();  //locating the "Submit" button and clicking on it;

        Assert.assertTrue(webDriver.findElement(By.xpath(".//*[contains(text(),'Учет запчастей')]")).isDisplayed());
        //verifying if the page in xpath is displayed = if the test runs positively


        webDriver.quit();  //quit - deleting object (=browser);  close - closing tab, browser is opened
        System.out.println("Negative autotest successfully completed: the login page is refreshed.");
    }
}