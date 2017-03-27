package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class WorkersPage extends ParentPage {
    @FindBy(xpath = ".//*[@href='http://v3.test.itpmgroup.com/dictionary/workers/edit']")
    WebElement buttonPlus;




    public WorkersPage(WebDriver driver) {
        super(driver);
    }

    public void clickButtonPlus() {
        actionsWithOurElement.clickOnElement(buttonPlus);
    }

    public void checkTitleH1PresentOnPageDictionary(String expectedText) {
        actionsWithOurElement.checkTextInElement(".//h1",expectedText);
    }


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
