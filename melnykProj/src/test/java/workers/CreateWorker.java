package workers;

import org.junit.Test;
import parentTest.ParentTest;


public class CreateWorker extends ParentTest {
    final private String WORKER_SURNAME = "Melnik";
    final private String WORKER_NAME = "Konstantin";
    final private String WORKER_MIDDLE_NAME = "Sergeevitch";
    final private String FULL_WORKER_NAME = WORKER_SURNAME + " " + WORKER_NAME + " " + WORKER_MIDDLE_NAME;
    final private String WORKER_PHONE = "06777777777";

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
        workersPage.clickButtonPlus();
        workersPage.checkTitleH1PresentOnPageDictionary("Словарь");
        editWorkerPage.creationWorker("Melnik","Konstantin","Sergeevitch","06777777777");
        editWorkerPage.clickButtonCreate();
        checkAC("Can not find element with text: " + FULL_WORKER_NAME,
                workersPage.isWorkerInList(FULL_WORKER_NAME), true);
        checkAC("Worker Phone", workersPage.getPhoneNumberForWorker(FULL_WORKER_NAME), WORKER_PHONE);
        workersPage.clickOnWorker(FULL_WORKER_NAME);
        workersPage.checkTitleH1PresentOnPageWithPage("Словарь");
        editWorkerPage.clickButonDelete();
        checkAC("Worker was not deleted", workersPage.isWorkerInList(FULL_WORKER_NAME), false);

    }
}
