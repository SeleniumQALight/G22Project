package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class WorkersPage extends ParentPage{
    @FindBy(xpath = ".//*[@href=\"http://v3.test.itpmgroup.com/dictionary/workers/edit\"]")
    private WebElement buttonPlus;

    public WorkersPage(WebDriver driver) {
        super(driver);
    }

    public void clickButtonPlus() {
        actionsWithOurElements.clickOnElement(buttonPlus);
    }

    /**
     * Method fine worker by text in format
     * WORKER_SURNAME +" " + WORKER_NAME + " " + WORKER_MIDDLE_NAME
     * @param workerSurnameNameMiddleName
     * @return
     */
    public Boolean isWorkerInList(String workerSurnameNameMiddleName) {
        return actionsWithOurElements.isElementPresent(".//*[text()='"+workerSurnameNameMiddleName+"']");
    }

    public String getPhoneNumberForWorker(String workerSurnameNameMiddleName) {
        return actionsWithOurElements.getTextFromElement(".//*[text()='"+workerSurnameNameMiddleName+"']//..//TD[2]");
    }

    public void clickOnWorker(String full_worker_name) {
        actionsWithOurElements.clickOnElement(".//*[text()='"+full_worker_name+"']//..//TD[2]");
    }
}