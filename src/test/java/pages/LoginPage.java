package pages;


import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BaseSitePage {

    private By userInput = By.xpath("//input[@formcontrolname='username']");

    private By passwordInput = By.xpath("//input[@formcontrolname='password']");

    private By signButton = By.xpath("//button");

    private By signOutButton=By.xpath("//a[@class='header__link header__link_font mr-3'][2]");
    private By settingsButton=By.xpath("//a[@class='header__link header__link_font mr-3'][1]");
    private By benchmarkSelector=By.xpath("//div[@class='d-flex align-items-center benchmark-selection']");
    private By applicationToolbar=By.xpath("//div[@class='d-flex w-100 justify-content-between']" +
            "//div[@class='d-flex align-items-center']");

    public  void doLogin(String userName, String password) {

        $(userInput).sendKeys(userName);
        $(passwordInput).sendKeys(password);
        $(signButton).click();

    }

    public void openLoginPage(){
        open("https://app.qa.axa.epm-rtc.projects.epam.com");
        doLogin("selenium_chrome", "Staging@Axa");

    }

    public void sighOut(){
        $(signOutButton).click();
    }

    public boolean visibleSettingsButton(){
        return isVisibleElement(settingsButton);
    }

    public boolean visibleBenchmarkSelector(){
        return isVisibleElement(benchmarkSelector);
    }

    public boolean visibleHaveTextApplicationToolbar(){
        return isVisibleHaveText(applicationToolbar,
                "Summary\nGrid & chart\nHistogram\nScatter-plot\nReports");
    }




}
