package workers;

import Pages.WorkersPage;
import org.junit.Test;
import parentTest.ParentTest;


public class CreateWorkers extends ParentTest {
    public  CreateWorkers(String browser) {
        super(browser);
    }

    @Test
    public  void  createWorkers(){
        loginPage.loginUser("Student","909090");
        homePage.checkTitle("Учет запчастей");
        homePage.clickMenuDictionary();
        homePage.clickworkersSubMenu();
        workersPage.checkTitle("Учет запчастей");
        workersPage.checkTitleH1PresentOnPageWithText("Сотрудники Список");

    }
}
