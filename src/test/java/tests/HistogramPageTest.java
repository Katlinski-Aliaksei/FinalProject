package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.HistogramPage;
import pages.LoginPage;
import pages.PageFactory;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class HistogramPageTest {

    private static LoginPage loginPage;
    private static HistogramPage histogramPage;

    @BeforeAll
    public static void sighIn() {
        loginPage= PageFactory.createPage(LoginPage.class);
        loginPage.openLoginPage();
        histogramPage=PageFactory.createPage(HistogramPage.class);
        histogramPage.openHistogramPage();
    }

    @Test
    public void barSelectorTest(){

        List<SelenideElement> barContainerList=histogramPage.getBarContainer();
        for(int i=0;i<barContainerList.size();i++){
            histogramPage.hoverBarContainer(i);
            sleep(2000);
            Assertions.assertTrue(histogramPage.visibleTooltipValue());
            histogramPage.clickBarContainer(i);
        }
    }

    @AfterAll
    public static void sighOut() {

        loginPage.sighOut();
    }
}

