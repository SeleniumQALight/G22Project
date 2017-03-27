package workers;

import Pages.WorkersPage;
import org.junit.Test;
import parentTest.ParentTest;

/**
 * Created on 15.03.2017.
 */
public class CreateWorker extends ParentTest {

    public CreateWorker(String browser) {
        super(browser);
    }

    @Test
    public void createWorker() {
        loginPage.loginUser("Student", "909090");
        homePage.checkTitle("Учет запчастей");
        homePage.clickMenuDictionary();
        homePage.clickWorkersSubMenu();
        workersPage.checkTitle("Учет запчастей");
        workersPage.checkTitleH1PresentOnPageWithText("Сотрудники Список");

    }

}
