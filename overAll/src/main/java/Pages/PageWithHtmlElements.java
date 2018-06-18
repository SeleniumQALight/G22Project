package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import libs.ActionsWithOurElement;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class PageWithHtmlElements {

    ActionsWithOurElement actionsWithOurElement;

    @Name(" 'Input Login' ")
    @FindBy(name = "_username1")
    private TextInput loginInput;

    public PageWithHtmlElements(WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
        actionsWithOurElement = new ActionsWithOurElement(driver);
    }

    public void enterTextLogin(String text){
        actionsWithOurElement.enterText(loginInput,text);
    }
}
