package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.collections.ExactTexts;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import pages.LoginPage;
import pages.PageFactory;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.*;

public class LoginPageTest {

    private static LoginPage loginPage;


    @BeforeAll
    public static void sighIn() {
        loginPage=PageFactory.createPage(LoginPage.class);
        loginPage.openLoginPage();
    }

    @Test
    public void checkMainComponentsTest() {

        Assertions.assertTrue(loginPage.visibleSettingsButton());
        Assertions.assertTrue(loginPage.visibleBenchmarkSelector());
        Assertions.assertTrue(loginPage.visibleHaveTextApplicationToolbar());
    }

    @AfterAll
    public static void sighOut() {

        loginPage.sighOut();
    }
}




