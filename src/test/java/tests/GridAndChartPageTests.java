package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.GridPage;
import pages.HistogramPage;
import pages.LoginPage;
import pages.PageFactory;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GridAndChartPageTests {

    private static LoginPage loginPage;
    private static GridPage gridPage;
    private static HistogramPage histogramPage;


    @BeforeAll
    public static void sighIn() {
        loginPage = PageFactory.createPage(LoginPage.class);
        loginPage.openLoginPage();
        gridPage=PageFactory.createPage(GridPage.class);
        gridPage.openGridPage();
        histogramPage=PageFactory.createPage(HistogramPage.class);

    }

    @Test
    public void checkAvgPriceTest() {
        histogramPage.openHistogramPage();
        gridPage.openGridPage();
        gridPage.clickIcebergElement();
        gridPage.clickLinesButton();
        gridPage.checkAvgButton();
        gridPage.checkMidButton();
        gridPage.setFilter();

        Assertions. assertAll(
                () -> assertEquals(gridPage.getTextAvgValueInfoString(), gridPage.getTextAvgPriceLabelsContainer()),
                () -> assertEquals(gridPage.getTextAvgPriceLabelsContainer(),gridPage.getTextAvgLegendContainerValue()),
                () -> assertEquals(gridPage.getTextAvgLegendContainerValue(),gridPage.getTextAvgPriceGrid())
        );

        gridPage.setFilter();
        sleep(2000);

        gridPage.clickIcebergElement();
        sleep(2000);

    }

    @Test
    public void checkAvgColor(){
        gridPage.clickIcebergElement();
        gridPage.clickLinesButton();
        gridPage.checkVwapLegendContainer();
        gridPage.checkAvgButton();

        String fill=gridPage.getHexColorAvgLabelsColor();

        Integer r=Color.decode(fill).getRed();
        Integer g=Color.decode(fill).getGreen();
        Integer b=Color.decode(fill).getBlue();

        assertEquals(gridPage.getRgbColorAvgLegendColor(), ("border-color: rgb("+r+", "+g+", "+b+");"));
        gridPage.clickIcebergElement();
        sleep(2000);


    }

    @Test
    public void checkMidPriceTest() {
        gridPage.clickIcebergElement();
        gridPage.clickLinesButton();
        gridPage.checkMidButton();

        Assertions.assertEquals(gridPage.getTextMidPriceLabelsContainer(),gridPage.getTextMidLegendContainerValue());
        gridPage.clickIcebergElement();
        sleep(2000);


    }


    @AfterAll
    public static void sighOut() {

        loginPage.sighOut();
    }

}

