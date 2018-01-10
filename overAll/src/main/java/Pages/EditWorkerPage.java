package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditWorkerPage extends ParentPage {
    @FindBy(id = "workers_workerSurname")
    private WebElement workerSurnameInput;
    @FindBy(id = "workers_workerName")
    private WebElement workerNameInput;
    @FindBy(id = "workers_workerMiddleName")
    private WebElement workerMiddleNameInput;
    @FindBy(id = "workers_workerPhone")
    private WebElement workerPhoneInput;
    @FindBy(tagName = "button")
    private WebElement buttonCreate;
    @FindBy(name = "delete")
    private WebElement buttonDelete;

    public EditWorkerPage(WebDriver driver) {
        super(driver,"Учет запчастей","/dictionary/workers/edit");
    }

    public void enterTextInToWorkerSurnameInput(String text) {
        actionsWithOurElement.enterText(workerSurnameInput, text);
    }

    public void enterTextInToWorkerNameInput(String text) {
        actionsWithOurElement.enterText(workerNameInput, text);
    }

    public void enterTextInToWorkerMiddleNameInput(String text) {
        actionsWithOurElement.enterText(workerMiddleNameInput, text);
    }

    public void enterTextInToWorkerPhoneInput(String phone) {
        actionsWithOurElement.enterText(workerPhoneInput, phone);
    }

    public void clickButonCreate() {
        actionsWithOurElement.clickOnElement(buttonCreate);
    }

    public void clickButonDelete() {
        actionsWithOurElement.clickOnElement(buttonDelete);
    }
}
