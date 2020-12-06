package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.ElementsContainer;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HistogramPage extends BaseSitePage {
    private By barContainer=By.xpath("//div[@class='histogram-container']/child::*/child::*/child::*[8]/child::*");
    private By tooltipValue=By.xpath("//div[@class='histogram-container']/following-sibling::div");


    private By histogramXpath=By.xpath("//div[@class='histogram-container']");

    private By attributeXpath=By.xpath("//div[@class=\"histogram-controls\"]/div[2]//div[@class='autocomplete-container']");

    private By intervalXpath=By.xpath("//div[@class=\"histogram-controls\"]/div[3]//div[@class='autocomplete-container']");

    public void openHistogramPage(){
        mainMenu.clickOnItem("Histogram");
    }


    public ElementsCollection getBarContainer(){
       return  $$(barContainer);
    }

    public void hoverBarContainer(int i){
        $(barContainer,i).hover();
    }

    public void clickBarContainer(int i){
        $(barContainer,i).click();
    }

    public boolean visibleTooltipValue(){
        return isVisibleElement(tooltipValue);
    }
}
