package workers;

import org.junit.Test;
import parentTest.ParentTest;


public class CreateWorker extends ParentTest {


    public CreateWorker(String browser) {
        super(browser);
    }

    @Test
    public void createWorker(){
        loginPage.loginUser("Student", "909090");
        homePage.checkTitle("Учет запчастей");
        homePage.clickMenuDictionary();
        homePage.clickworkersSubMenu();
        workersPage.checkTitle("Учет запчастей");
        workersPage.checkTitleH1PresentOnPageWithPage("Сотрудники Список");
    }
}
