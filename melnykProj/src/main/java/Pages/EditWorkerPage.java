package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditWorkerPage extends ParentPage {


    @FindBy(xpath = ".//*[@id='workers_workerSurname']")
    WebElement workerSurnameInput;

    @FindBy(xpath = ".//*[@id='workers_workerName']")
    WebElement workerNameInput;

    @FindBy(xpath = ".//*[@id='workers_workerMiddleName']")
    WebElement workerMiddleNameInput;

    @FindBy(xpath = ".//*[@id='workers_workerPhone']")
    WebElement workerPhoneInput;

    @FindBy(xpath = ".//button[@name='add']")
    WebElement buttonCreate;
    @FindBy(name = "delete")
    private WebElement buttonDelete;



    public EditWorkerPage(WebDriver driver) {
        super(driver);
    }

    public void creationWorker(String workerSurname, String workerName, String workerMiddleName, String workerPhone) {
        enterWorkerSurname(workerSurname);
        enterWorkerName(workerName);
        enterWorkerMiddleName(workerMiddleName);
        enterWorkerPhone(workerPhone);

    }
    public void enterWorkerSurname(String workerSurname) {
        actionsWithOurElement.enterText(workerSurnameInput, workerSurname);

    }
    public void enterWorkerName(String workerName) {
        actionsWithOurElement.enterText(workerNameInput,workerName);
    }
    public void enterWorkerMiddleName(String workerMiddleName) {
        actionsWithOurElement.enterText(workerMiddleNameInput,workerMiddleName);
    }
    public void enterWorkerPhone(String workerPhone) {
        actionsWithOurElement.enterText(workerPhoneInput,workerPhone);
    }

    public void clickButtonCreate() {
        actionsWithOurElement.clickOnElement(buttonCreate);
    }

    public void clickButonDelete() {
        actionsWithOurElement.clickOnElement(buttonDelete);
    }

}
