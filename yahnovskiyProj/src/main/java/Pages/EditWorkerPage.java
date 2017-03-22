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
        super(driver);
    }

    public void enterTextInToWorkerSurnameInput(String text) {
        actionsWithOurElements.enterText(workerSurnameInput, text);
    }

    public void enterTextInToWorkerNameInput(String text) {
        actionsWithOurElements.enterText(workerNameInput, text);
    }

    public void enterTextInToWorkerMiddleNameInput(String text) {
        actionsWithOurElements.enterText(workerMiddleNameInput, text);
    }

    public void enterTextInToWorkerPhoneInput(String phone) {
        actionsWithOurElements.enterText(workerPhoneInput, phone);
    }

    public void clickButonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }

    public void clickButonDelete() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }
}
