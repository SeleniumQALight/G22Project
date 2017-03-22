package workers;

import org.junit.Test;
import parentTest.ParentTest;

public class CreateWorker extends ParentTest {
    final private String WORKER_SURNAME = "RomanYWorker1";
    final private String WORKER_NAME = "RomanYWorkerName1";
    final private String WORKER_MIDDLE_NAME = "RomanYWorkerMiddleName";
    final private String FULL_WORKER_NAME = WORKER_SURNAME + " " + WORKER_NAME + " " + WORKER_MIDDLE_NAME;
    final private String WORKER_PHONE = "888-42-65";

    public CreateWorker(String browser) {
        super(browser);
    }

    @Test
    public void creteWorker() {
        loginPage.loginUser("Student", "909090");
        homePage.checkTitle("Учет запчастей");
        homePage.clickMenuDictionary();
        homePage.clickWorkersSubMenu();
        workersPage.checkTitle("Учет запчастей");
        workersPage.checkTitleH1PresentOnPageWithText("Сотрудники Список");
        workersPage.clickButtonPlus();
        editWorkerPage.checkTitleH1PresentOnPageWithText("Словарь");
        editWorkerPage.enterTextInToWorkerSurnameInput(WORKER_SURNAME);
        editWorkerPage.enterTextInToWorkerNameInput(WORKER_NAME);
        editWorkerPage.enterTextInToWorkerMiddleNameInput(WORKER_MIDDLE_NAME);
        editWorkerPage.enterTextInToWorkerPhoneInput(WORKER_PHONE);
        editWorkerPage.clickButonCreate();
        workersPage.checkTitleH1PresentOnPageWithText("Сотрудники Список");
        checkAC("Can not find element with text: " + FULL_WORKER_NAME,
                workersPage.isWorkerInList(FULL_WORKER_NAME), true);
        checkAC("Worker Phone", workersPage.getPhoneNumberForWorker(FULL_WORKER_NAME), WORKER_PHONE);
        workersPage.clickOnWorker(FULL_WORKER_NAME);
        editWorkerPage.checkTitleH1PresentOnPageWithText("Словарь");
        editWorkerPage.clickButonDelete();
        checkAC("Worker was not deleted", workersPage.isWorkerInList(FULL_WORKER_NAME), false);
    }
}
