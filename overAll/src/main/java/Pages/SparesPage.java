package Pages;

import org.openqa.selenium.WebDriver;

public class SparesPage extends ParentPage {

    public SparesPage(WebDriver driver) {
        super(driver,"Учет запчастей", "/dictionary/spares");
    }

    public void clickOnPlusButton() {
        actionsWithOurElement.clickOnElement(".//*[@href='"+baseUrl+"/dictionary/spares/edit']");
    }
    
    public boolean isSpareInList(String nameOfSpare){
    	return actionsWithOurElement.isElementPresent(".//*[text()='"+nameOfSpare+"']");
	}
	
	public void clickOnSpare(String nameOfSpare){
    	actionsWithOurElement.clickOnElement(".//*[text()='"+nameOfSpare+"']");
	}
}
