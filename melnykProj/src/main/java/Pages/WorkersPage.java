package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class WorkersPage extends ParentPage {
    @FindBy(xpath = ".//*[@href='http://v3.test.itpmgroup.com/dictionary/workers/edit']")
    WebElement buttonPlus;

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

    @FindBy(xpath = ".//*[text()='Melnik Konstantin Sergeevitch']")
    WebElement newWorker;

    @FindBy(xpath = ".//*[text()='06777777777']")
    WebElement newWorkerPhone;



    public WorkersPage(WebDriver driver) {
        super(driver);
    }

    public void clickButtonPlus() {
        actionsWithOurElement.clickOnElement(buttonPlus);
    }

    public void checkTitleH1PresentOnPageDictionary(String expectedText) {
        actionsWithOurElement.checkTextInElement(".//h1",expectedText);
    }

    public void creationWorker(String workerSurname, String workerName, String workerMiddleName, String workerPhone) {
        enterWorkerSurname(workerSurname);
        enterWorkerName(workerName);
        enterWorkerMiddleName(workerMiddleName);
        enterWorkerPhone(workerPhone);

    }
    public void enterWorkerSurname(String workerSurname) {
        try {
            workerSurnameInput.clear();
            workerSurnameInput.sendKeys(workerSurname);
            logger.info(workerSurname + " was entered in input ");
        } catch (Exception e) {
            logger.error("Failed input workerSurname");
            Assert.fail("Failed input workerSurname");
        }
    }
    public void enterWorkerName(String workerName) {
        try {
            workerNameInput.clear();
            workerNameInput.sendKeys(workerName);
            logger.info(workerName + " was entered in input ");
        } catch (Exception e) {
            logger.error("Failed input workerName");
            Assert.fail("Failed input workerName");
        }
    }
    public void enterWorkerMiddleName(String workerMiddleName) {
        try {
            workerMiddleNameInput.clear();
            workerMiddleNameInput.sendKeys(workerMiddleName);
            logger.info(workerMiddleName + " was entered in input ");
        } catch (Exception e) {
            logger.error("Failed input workerMiddleName");
            Assert.fail("Failed input workerMiddleName");
        }
    }
    public void enterWorkerPhone(String workerPhone) {
        try {
            workerPhoneInput.clear();
            workerPhoneInput.sendKeys(workerPhone);
            logger.info(workerPhone + " was entered in input ");
        } catch (Exception e) {
            logger.error("Failed input workerPhone");
            Assert.fail("Failed input workerPhone");
        }
    }

    public void clickButtonCreate() {
        actionsWithOurElement.clickOnElement(buttonCreate);
    }


    public Boolean createdWorker() {
      return
              actionsWithOurElement.isElementPresent(newWorker) && actionsWithOurElement.isElementPresent(newWorkerPhone);
    }
}
