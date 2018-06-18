package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@FindBy(xpath = ".//aside")
public class LeftMenu {
  @FindBy(id = ".//*[@id='dictionary']/a")
  public WebElement dictionary;

}
