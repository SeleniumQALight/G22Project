package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class LoginPageWithHtmlElements extends ParentPageWithHtmlElements {


  //    @Name(" 'Input Login' ")
  @FindBy(name = "_username")
  private TextInput loginInput;

  @FindBy(id = "password")
  private TextInput passInput;

  @FindBy(xpath = ".//button")
  private Button buttonLogin;

  public LoginPageWithHtmlElements(WebDriver driver) {
    super(driver, "Account of spare:Авторизация", "/login");
  }


  @Step
  public void enterTextLogin(String text) {
    actionsWithOurElement.enterText(loginInput, text);
  }

  @Step
  public void enterTextPass(String pass){
    actionsWithOurElement.enterText(passInput, pass);
  }

  @Step
  public void clickButtonLogin(){
    actionsWithOurElement.clickOnElement(buttonLogin);
  }
}
