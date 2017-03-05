package LogOn;

import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;

/**
 * Created by Evgeniy on 01.03.2017.
 */
public class LoginTest extends ParentTest {
    public LoginTest(String browser) {
        super(browser);
    }

    @Test
    public void validLogOn(){

        driver.get("http://v3.test.itpmgroup.com"); //opening website

        driver.findElement(By.name("_username")).clear();  //locating the field "Login" and clearing its contents
        driver.findElement(By.name("_username")).sendKeys("Student");  //entering "Student" in the login field

        driver.findElement(By.id("password")).clear();  //locating the field "Password" and clearing its contents
        driver.findElement(By.id("password")).sendKeys("909090"); //entering 909090 as password

        driver.findElement(By.tagName("button")).click();  //locating the "Submit" button and clicking on it;
        checkAC("Avatar is not present", driver.findElement(By.xpath(".//div[@class='pull-left image']//img[@class='img-circle']")).isDisplayed(), true);

    }
}
