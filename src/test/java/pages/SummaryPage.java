package pages;

import com.codeborne.selenide.SelenideElement;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SummaryPage extends BaseSitePage {
    LoginPage loginPage = new LoginPage();

    private By allColumnValue = By.xpath("//div[@class='text-right simple-table__row-value']");
    private By negativeColumnValue = By.xpath("//div[@class='text-right simple-table__row-value report-data-item__negative']");
    private By positiveColumnValue = By.xpath("//div[@class='text-right simple-table__row-value report-data-item__positive']");


    public void openSummaryPage() {

        mainMenu.clickOnItem("Summary");
    }

    public List<Integer> getAllColumn() {
        return setList(allColumnValue);
    }

    public List<Integer> getNegativeColumn() {
        return setList(negativeColumnValue);
    }

    public List<Integer> getPositiveColumn() {
        return setList(positiveColumnValue);
    }

    public List setList(By Xpath) {
        ArrayList<Integer> ValueList = new ArrayList<>();
        List<SelenideElement> ColumnList = $$(Xpath);
        for (int i = 0; i < ColumnList.size(); i++) {
            int Value = Integer.parseInt($(Xpath, i).getText());
            ValueList.add(Value);
        }
        return ValueList;
    }
}




