package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.LoginPage;
import pages.PageFactory;
import pages.ScatterplotPage;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class ScatterPlotPageTests {

    private static LoginPage loginPage;
    private static ScatterplotPage scatterplotPage;

    @BeforeAll
    public static void sighIn() {
        loginPage = PageFactory.createPage(LoginPage.class);
        loginPage.openLoginPage();
        scatterplotPage = PageFactory.createPage(ScatterplotPage.class);
        scatterplotPage.openScatterplotPage();

    }

    @Test
    public void ChangeXAttributeTest() {

        scatterplotPage.clickAttributeX();
        scatterplotPage.newAttributeValueList();
        List<SelenideElement> xAttributeValueList = scatterplotPage.newAttributeValueList();
        scatterplotPage.clickAllAttributeIndex(0);
        String xAxisValue = scatterplotPage.getTextXAxisValue();
        scatterplotPage.clickAttributeX();
        for (int i = 1; i < xAttributeValueList.size(); i++) {

            String xAttribute = scatterplotPage.getTextAllAttributeContainer(i);
            scatterplotPage.clickAllAttributeIndex(i);

            Assertions.assertTrue(scatterplotPage.scatterPlotXLabelShouldHave(xAttribute));
            Assertions.assertTrue(scatterplotPage.xAxisNotHaveText(xAxisValue));

            String xAxisValueNew = scatterplotPage.getTextXAxisValue();
            xAxisValue = xAxisValueNew;

            scatterplotPage.clickAttributeX();
        }
    }

    @Test
    public void ChangeYAttributeTest() {
        scatterplotPage.clickAttributeY();
        scatterplotPage.newAttributeValueList();
        List<SelenideElement> yAttributeValueList = scatterplotPage.newAttributeValueList();
        scatterplotPage.clickAllAttributeIndex(0);
        String yAxisValue = scatterplotPage.getTextYAxisValue();
        scatterplotPage.clickAttributeY();
        for (int i = 1; i < yAttributeValueList.size(); i++) {

            Assertions.assertTrue(scatterplotPage.gridNotBeVisible());

            String yAttribute = scatterplotPage.getTextAllAttributeContainer(i);
            scatterplotPage.clickAllAttributeIndex(i);

            Assertions.assertTrue(scatterplotPage.scatterPlotYLabelShouldHave(yAttribute));
            Assertions.assertTrue(scatterplotPage.yAxisNotHaveText(yAxisValue));

            String xAxisValueNew = scatterplotPage.getTextYAxisValue();
            yAxisValue = xAxisValueNew;
            scatterplotPage.clickAttributeY();
        }

    }

    @AfterAll
    public static void sighOut() {

        loginPage.sighOut();
    }
}
