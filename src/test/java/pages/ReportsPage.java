package pages;

import org.openqa.selenium.By;

public class ReportsPage extends BaseSitePage{

    private By legend=By.xpath("//div[contains(text(),'Legend')]");

    private By ordersByInstrument=By.xpath("//div[@class='d-flex flex-column h-100 view position-relative']");

    public void openReportsPage(){
        mainMenu.clickOnItem("Reports");

    }
}
