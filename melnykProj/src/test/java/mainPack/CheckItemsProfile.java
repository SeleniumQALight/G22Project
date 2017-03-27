package mainPack;


import org.junit.Test;
import parentTest.ParentTest;

public class CheckItemsProfile extends ParentTest {
    public CheckItemsProfile(String browser) {
        super(browser);
    }

    @Test
    public void ckeckitemsProfileOnValid (){

        loginPage.loginUser("Student", "909090");
        homePage.isAvatarPresent();
        checkItemsProfilePage.clickAvatar();
        checkItemsProfilePage.clickProfile();

        checkAC( "Actual result != expected result", checkItemsProfilePage.isProfileItemsPresent(), true);


    }
}
