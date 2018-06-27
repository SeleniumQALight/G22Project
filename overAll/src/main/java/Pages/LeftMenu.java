package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

@FindBy(xpath = ".//*[@class='sidebar-menu']")
public class LeftMenu extends HtmlElement {

  @FindBy(xpath = ".//a[@href='#']1")
  private Link dictionary;

  @FindBy(xpath = ".//*[@id='workers']/a")
  private WebElement workersSubMenu;

  @FindBy(id = "spares")
  private Link sparesSubMenu;

  public Link getDictionary() {
    return dictionary;
  }

  public Link getSparesSubMenu() {
    return sparesSubMenu;
  }
}
