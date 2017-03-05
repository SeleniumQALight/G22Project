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
        driver.get("http://v3.test.itpmgroup.com/");
        driver.findElement(By.name("_username")).clear(); // find element and clear field
        driver.findElement(By.name("_username")).sendKeys("W222"); // sendKeys - enter from claviatura
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("fdsjkfdsl");
        driver.findElement(By.tagName("button")).click();// tagName - name of tag in html
        checkAC("Not found message - Учет запчастей", driver.findElement(By.xpath(".//*/b[contains(text(),'Учет запчастей')]")).isDisplayed(), true);
    }

}
