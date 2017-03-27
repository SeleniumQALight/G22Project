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

            // driver.get("http://v3.test.itpmgroup.com"); //opening website
            //REFACTOR 06.03.2017: instead of driver.get we refactor it on the following two lines:
        loginPage.openLoginPage();
        loginPage.checkTitle("Account of spare:Авторизация");

            //driver.findElement(By.name("_username")).clear();  //locating the field "Login" and clearing its contents
            //driver.findElement(By.name("_username")).sendKeys("Student");  //entering "Student" in the login field
            //REFACTOR 06.03.2017: instead of driver.findElement we refactor it on the following line:
        loginPage.enterLogin("Student");


            //driver.findElement(By.id("password")).clear();  //locating the field "Password" and clearing its contents
            //driver.findElement(By.id("password")).sendKeys("909090"); //entering 909090 as password
            //REFACTOR 06.03.2017: instead of driver.findElement we refactor it on the following line:
        loginPage.enterPass("909090");

            //driver.findElement(By.tagName("button")).click();  //locating the "Submit" button and clicking on it;
            //REFACTOR 06.03.2017: instead of driver.findElement we refactor it on the following line:
        loginPage.clickButtonLogin();

        homePage.checkTitle("Учет запчастей");   //13.03.2017  verifying if we reached the home page

        checkAC("Avatar is not present", homePage.isAvatarPresent(), true);
        //HW !!! 13.03.2017 - done in class
    }

    //negative tests   13.03.2017

    @Test
    public void invalidLogOn(){
        // loginPage.openLoginPage();  //"http://v3.test.itpmgroup.com" - replaced in LoginPage
        // loginPage.checkTitle("Account of spare:Авторизация");
        // loginPage.enterLogin("Studik");  //invalid login
        // loginPage.enterPass("909090");
        //loginPage.clickButtonLogin();
        //loginPage.checkTitle("Account of spare:Авторизация");
        //or
        //checkAC("Home page title is not expected", loginPage.getTitle(), "Account of spare:Авторизация");

        //Refactor:
        loginPage.loginUser("Studik", "909090");
        checkAC("Home page title is not expected", loginPage.getTitle(), "Account of spare:Авторизация");


    }

}
