package mainPack;

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
    public void validLogOn (){
        driver.get("http://v3.test.itpmgroup.com/");
        driver.findElement(By.name("_username")).clear(); // find element and clear field
        driver.findElement(By.name("_username")).sendKeys("Student"); // sendKeys - enter from claviatura
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("909090");
        driver.findElement(By.tagName("button")).click();// tagName - name of tag in html
        checkAC("Avatar Not Present ", driver.findElement(By.xpath(".//a[@class='dropdown-toggle' and @href='#']//*[@class='user-image']")).isDisplayed(), true);
    }
}
