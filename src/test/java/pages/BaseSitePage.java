package pages;

import com.codeborne.selenide.Condition;
import elements.MainMenu;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;

public class BaseSitePage {
    protected MainMenu mainMenu;

    public BaseSitePage() {
        mainMenu = new MainMenu();

    }

    public boolean isVisibleElement(By XPath) {
        try {
            $(XPath).should(Condition.visible);
            return true;
        } catch (Exception ElementNotVisible) {
            return false;
        }

    }
    public boolean isNotVisibleElement(By XPath) {
        try {
            $(XPath).shouldNotBe(Condition.visible);
            return true;
        } catch (Exception ElementVisible) {
            return false;
        }

    }

    public boolean isVisibleHaveText(By Xpath, String text) {
        try {
            $(Xpath).shouldBe(Condition.visible).shouldHave(Condition.text(text));
            return true;
        } catch (Exception IsNotVisibleOrNotHaveText) {
            return false;
        }
    }

    public boolean isNotHaveText(By Xpath, String text){
        try {
            $(Xpath).shouldNotHave(Condition.text(text));
            return true;
        } catch (Exception IsHaveText) {
            return false;
        }

    }

}
