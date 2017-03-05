package mainPack;


import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;

public class CheckItemsProfile extends ParentTest {
    public CheckItemsProfile(String browser) {
        super(browser);
    }
    @Test
    public void ckeckitemsProfile (){

        driver.get("http://v3.test.itpmgroup.com/");
        driver.findElement(By.name("_username")).clear(); // find element and clear field
        driver.findElement(By.name("_username")).sendKeys("Student"); // sendKeys - enter from claviatura
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("909090");
        driver.findElement(By.tagName("button")).click();// tagName - name of tag in html
        driver.findElement(By.xpath(".//a[@class='dropdown-toggle' and @href='#']//*[@class='user-image']")).click();
        driver.findElement(By.xpath(".//a[@href='/users/profile/13']")).click();
        Boolean element, element2, element3, element4, element5, element6, element7,element8;
        element=driver.findElement(By.xpath(".//*//h3[@class='box-title' and text()='Профиль пользователя Студент']")).isDisplayed();
        checkAC("Element not found", element,true);
        element2=driver.findElement(By.xpath(".//*[@id='userProfileEdit_user_email']")).isDisplayed();
        checkAC("Element not found", element2,true);
        element3=driver.findElement(By.xpath(".//*[@id='userProfileEdit_user_name']")).isDisplayed();
        checkAC("Element not found", element3,true);
        element4=driver.findElement(By.xpath(".//*[@id='userProfileEdit_user_username']")).isDisplayed();
        checkAC("Element not found", element4,true);
        element5=driver.findElement(By.xpath(".//*[@id='userProfileEdit_user_password_password']")).isDisplayed();
        checkAC("Element not found", element5,true);
        element6=driver.findElement(By.xpath(".//*[@id='userProfileEdit_user_password_password_confirm']")).isDisplayed();
        checkAC("Element not found", element6,true);
        element7=driver.findElement(By.xpath(".//button[@name='save']")).isDisplayed();
        checkAC("Element not found", element7,true);
        element8=driver.findElement(By.xpath(".//button[@name='delete']")).isDisplayed();
        checkAC("Element not found", element8,true);

    }
}
