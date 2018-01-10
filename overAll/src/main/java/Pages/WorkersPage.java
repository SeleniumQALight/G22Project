package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class WorkersPage extends ParentPage{
    @FindBy(xpath = ".//*[@href=\"http://v3.test.itpmgroup.com/dictionary/workers/edit\"]")
    private WebElement buttonPlus;


    public WorkersPage(WebDriver driver) {
        super(driver,"Учет запчастей","/dictionary/workers");
    }

    public void clickButtonPlus() {
        actionsWithOurElement.clickOnElement(buttonPlus);
    }

    /**
     * Method fine worker by text in format
     * WORKER_SURNAME +" " + WORKER_NAME + " " + WORKER_MIDDLE_NAME
     * @param workerSurnameNameMiddleName
     * @return
     */
    public Boolean isWorkerInList(String workerSurnameNameMiddleName) {
        return actionsWithOurElement.isElementPresent(".//*[text()='"+workerSurnameNameMiddleName+"']");
    }

    public String getPhoneNumberForWorker(String workerSurnameNameMiddleName) {
        return actionsWithOurElement.getTextFromElement(".//*[text()='"+workerSurnameNameMiddleName+"']//..//TD[2]");
    }

    public void clickOnWorker(String full_worker_name) {
        actionsWithOurElement.clickOnElement(".//*[text()='"+full_worker_name+"']//..//TD[2]");
    }
}
