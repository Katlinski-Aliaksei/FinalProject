package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ScatterplotPage extends BaseSitePage {

    private By diagramXpath=By.xpath("//div[@class='visualization__view position-relative']");

    private By attributeX=By.xpath("//div[@class='mb-2'][1]//div[@class='autocomplete-container']");

    private By attributeY=By.xpath("//div[@class='mb-2'][2]//div[@class='autocomplete-container']");

    private By intervals=By.xpath("//div[@class='mb-2'][3]//div[@class='autocomplete-container']");

    private By intervals10=By.xpath("div[@class='autocomplete-dropdown-menu-wrapper']//li[@title='10']");

    private By allAttributeValueContainer = By.xpath("//ul[@class='autocomplete-dropdown-menu']/child::*");

    private By scatterPlotXLabel = By.xpath("//div[@class='scatter-plot-container']/descendant::*[5]");

    private By scatterPlotYLabel = By.xpath("//div[@class='scatter-plot-container']/descendant::*[3]");

    private By xAxis = By.xpath("//div[@class='scatter-plot-container']/descendant::*[2]/child::*[5]");

    private By yAxis = By.xpath("//div[@class='scatter-plot-container']/descendant::*[2]/child::*[6]");

    private By visualGrid = By.xpath("//app-selection-grid[@class='flex-1 visualization__selection-grid']");

    public void openScatterplotPage(){
        mainMenu.clickOnItem("Scatter-plot");

    }

    public void clickAttributeX(){
        $(attributeX).click();
    }
    public void clickAttributeY(){
        $(attributeY).click();
    }

    public ElementsCollection newAttributeValueList(){
        return $$(allAttributeValueContainer);
    }
    public void clickAllAttributeIndex(int i){
        $(allAttributeValueContainer, i).click();
    }

    public String getTextXAxisValue(){
        return $(xAxis).getText();
    }
    public String getTextYAxisValue(){
        return $(yAxis).getText();
    }

    public String getTextAllAttributeContainer(int i){
        return $(allAttributeValueContainer, i).getText();
    }

    public boolean scatterPlotXLabelShouldHave(String xAttribute){
        return isVisibleHaveText(scatterPlotXLabel,xAttribute);
    }

    public boolean scatterPlotYLabelShouldHave(String yAttribute){
        return isVisibleHaveText(scatterPlotYLabel,yAttribute);
    }

    public boolean xAxisNotHaveText(String text){
        return isNotHaveText(xAxis,text);
    }
    public boolean yAxisNotHaveText(String text){
        return isNotHaveText(yAxis,text);
    }

    public boolean gridNotBeVisible(){
        return isNotVisibleElement(visualGrid);
    }

}
