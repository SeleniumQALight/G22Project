package mainPack;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPositiveTestWithOutPageObject {
    WebDriver webdriver;
    @Test
    // creation test case
    public void loginPositiveTestWithOutPageObject () {
        webdriver = new ChromeDriver(); //webdriver - this is our browser
        webdriver.manage().window().maximize(); //maximize window
        webdriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); // timeout checking. default checking

        webdriver.get("http://v3.test.itpmgroup.com/");
        webdriver.findElement(By.name("_username")).clear(); // find element and clear field
        webdriver.findElement(By.name("_username")).sendKeys("Student"); // sendKeys - enter from claviatura
        webdriver.findElement(By.id("password")).clear();
        webdriver.findElement(By.id("password")).sendKeys("909090");
        webdriver.findElement(By.tagName("button")).click(); // tagName - name of tag in html

        Assert.assertTrue(webdriver.findElement(By.xpath(".//a[@class='dropdown-toggle' and @href='#']//*[@class='user-image']")).isDisplayed());
        webdriver.quit(); // close browser webdriver.close() - close page in browser
    }
}
