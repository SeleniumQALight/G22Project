package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import libs.ActionsWithOurElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class HomePageWithHtmlElements extends ParentPageWithHtmlElements{


    @FindBy(xpath = ".//div[@class='pull-left image']//img[@class='img-circle']")
    private TextInput avatar;

    private LeftMenu leftMenu;

    public HomePageWithHtmlElements(WebDriver driver) {
            super(driver,"Учет запчастей","/");
    }

    @Step
    public void leftMenuСlickMenuDictionary() {
        actionsWithOurElement.clickOnElement(leftMenu.getDictionary());
    }


    @Step
    public void leftMenuСlickSubMenuSpare() {
        actionsWithOurElement.clickOnElement(leftMenu.getSparesSubMenu());
    }
}
