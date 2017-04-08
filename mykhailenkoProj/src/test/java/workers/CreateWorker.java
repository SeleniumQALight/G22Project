package workers;


import Pages.WorkersPage;
import org.junit.Test;
import parentTest.ParentTest;

public class CreateWorker extends ParentTest {

    public CreateWorker(String browser) {
        super(browser);
    }

    @Test
    public void createWorker(){
        loginPage.logInUser("Student", "909090");
        homePage.checkTitle("Учет запчастей");
        homePage.clickMenuDictionary();
        homePage.clickWorkersSubMenu();
        workersPage.checkTitle("Учет запчастей");
        workersPage.checkTitleH1PresentOnPageWithText("Сотрудники Список");

    }
}
