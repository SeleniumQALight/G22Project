package mainPack;


import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;

public class CheckItemsProfile extends ParentTest {
    public CheckItemsProfile(String browser) {
        super(browser);
    }

    @Test
    public void ckeckitemsProfileOnValid (){

        checkItemsProfilePage.open("http://v3.test.itpmgroup.com/");
        checkItemsProfilePage.checkTitle("Account of spare:Авторизация");
        checkItemsProfilePage.enterLogin("Student");
        checkItemsProfilePage.enterPass("909090");
        checkItemsProfilePage.clickOnButtonLogin();
        checkItemsProfilePage.clickAvatar();
        checkItemsProfilePage.clickProfile();

        checkAC( "Actual result != expected result", checkItemsProfilePage.isElementsPresent(), true);


    }
}
