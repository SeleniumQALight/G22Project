package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparesPage extends ParentPage {
    @FindBy(xpath = ".//*[@href='http://v3.test.itpmgroup.com/dictionary/spares/edit']")
    private WebElement buttonPlus;

    public SparesPage(WebDriver driver) {
        super(driver,"");
    }

    public void clickOnPlusButton() {
        actionsWithOurElement.clickOnElement(buttonPlus);
    }
    
    public boolean isSpareInList(String nameOfSpare){
    	return actionsWithOurElement.isElementPresent(".//*[text()='"+nameOfSpare+"']");
	}
	
	public void clickOnSpare(String nameOfSpare){
    	actionsWithOurElement.clickOnElement(".//*[text()='"+nameOfSpare+"']");
	}
}
