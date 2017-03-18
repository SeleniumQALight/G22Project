package workers;


import Pages.WorkersPage;
import org.junit.Test;
import parentTest.ParentTest;

public class CreteWorker extends ParentTest {
    public CreteWorker(String browser) {
        super(browser);
    }

    @Test
    public void creteWorker(){
        loginPage.loginUser("Student","909090");
        homePage.checkTitle("Учет запчастей");
        homePage.clickMenuDictionary();
        homePage.clickWorkersSubMenu();
        workersPage.checkTitle("Учет запчастей");
        workersPage.checkTitleH1PresentOnPageWithText("Сотрудники Список");

    }
}
