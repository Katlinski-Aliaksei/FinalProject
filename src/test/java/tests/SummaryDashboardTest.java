package tests;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.LoginPage;
import pages.PageFactory;
import pages.ScatterplotPage;
import pages.SummaryPage;
import repositories.Summary;
import repositories.SummaryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SummaryDashboardTest {

    private static SummaryPage summaryPage;
    private static LoginPage loginPage;

    @BeforeAll
    public static void sighIn() {
        loginPage = PageFactory.createPage(LoginPage.class);
        loginPage.openLoginPage();
        summaryPage = PageFactory.createPage(SummaryPage.class);
        summaryPage.openSummaryPage();

    }

    @Test
    public void checkSummariesTest() {

        SummaryRepository summaryRepository = new SummaryRepository();
        List<Summary> summaries = summaryRepository.getAll();

        Assertions.assertEquals(summaries.stream().map(Summary::getAll).collect(Collectors.toList()),
                summaryPage.getAllColumn());
        Assertions.assertEquals(summaries.stream().map(Summary::getNegative).collect(Collectors.toList()),
                summaryPage.getNegativeColumn());
        Assertions.assertEquals(summaries.stream().map(Summary::getPositive).collect(Collectors.toList()),
                summaryPage.getPositiveColumn());

    }

    @AfterAll
    public static void sighOut() {

        loginPage.sighOut();
    }
}
