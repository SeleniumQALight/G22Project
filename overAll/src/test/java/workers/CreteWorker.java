package workers;


import org.junit.Test;
import parentTest.ParentTest;

public class CreteWorker extends ParentTest {
    final private String WORKER_SURNAME = "TarasWorker1";
    final private String WORKER_NAME = "TarasWorkerName1";
    final private String WORKER_MIDDLE_NAME = "TarasWorkerMiddleName";
    final private String FULL_WORKER_NAME = WORKER_SURNAME + " " + WORKER_NAME + " " + WORKER_MIDDLE_NAME;
    final private String WORKER_PHONE = "555-55-55";

    public CreteWorker(String browser) {
        super(browser);
    }

    @Test
    public void creteWorker() {
        loginPage.loginUser("Student", "909090");
        homePage.checkIfThisPageIsOpened();
        homePage.clickMenuDictionary();
        homePage.clickWorkersSubMenu();
        workersPage.checkIfThisPageIsOpened();
        workersPage.checkTitleH1PresentOnPageWithText("Сотрудники Список");
        workersPage.clickButtonPlus();
        editWorkerPage.checkIfThisPageIsOpened();
        editWorkerPage.checkTitleH1PresentOnPageWithText("Словарь");
        editWorkerPage.enterTextInToWorkerSurnameInput(WORKER_SURNAME);
        editWorkerPage.enterTextInToWorkerNameInput(WORKER_NAME);
        editWorkerPage.enterTextInToWorkerMiddleNameInput(WORKER_MIDDLE_NAME);
        editWorkerPage.enterTextInToWorkerPhoneInput(WORKER_PHONE);
        editWorkerPage.clickButonCreate();
        workersPage.checkIfThisPageIsOpened();
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
