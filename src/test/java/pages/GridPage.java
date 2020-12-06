package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import javax.lang.model.element.Element;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GridPage extends BaseSitePage {

    private By rootOfGrid = By.xpath("//div[@class='ag-root-wrapper ag-layout-normal ag-ltr']");

    private By legendContainer = By.xpath("//div[@class='d-flex align-items-center']/span");

    private By checkAvgInLegend = By.xpath("//div[@class='d-flex align-items-center']/span[contains(text(),'Avg fill price')]");

    private By checkMidInLegend = By.xpath("//div[@class='d-flex align-items-center']/span[contains(text(),'Mid price')]");

    private By linesButton = By.xpath("//span[contains(text(),'+ Lines')]");

    private By avgButton = By.xpath("//div[@class='lines-panel d-flex flex-column']//span[contains(text(),'Avg fill price')]");
    private By avgCheckBox = By.xpath("//app-chart-lines-panel-content//span[contains(text(),'Avg')]/..//label");

    private By midButton = By.xpath("//div[@class='lines-panel d-flex flex-column']//span[contains(text(),'Mid price')]");
    private By midCheckBox = By.xpath("//app-chart-lines-panel-content//span[contains(text(),'Mid')]/..//label");

    private By vwapButton = By.xpath("//div[@class='lines-panel d-flex flex-column']//span[contains(text(),'VWAP')]");
    private By vwapCheckBox = By.xpath("//app-chart-lines-panel-content//span[contains(text(),'VWAP')]/..//label");

    //private By gridBody = By.xpath("//div[@class='ag-pinned-right-cols-container']");
    //private By gridBodyNameIceberg = By.xpath("//div[@row-id='1dou6mcde:4340']/child::*[2]");
    private By gridBodyNameIceberg = By.xpath("//div[@class='ag-center-cols-clipper']//div[@row-id='1dou6mcde:4340']");

    private By avgPriceGrid = By.xpath("//div[@row-id='1dou6mcde:4340']/div[@col-id='averageFillPrice']/span");

    private By midPriceLabelsContainer = By.xpath("//div[@class='dc-general-container']/child::*/child::*/child::*[3]/child::*[2]/child::*[4]/child::*[2]/child::*[2]");

    //private By avgPriceLabelsContainer = By.xpath("//div[@class='dc-general-container']/child::*/child::*/child::*[3]/child::*[2]/child::*[4]/child::*[1]/child::*[2]");
    private By avgPriceLabelsContainer = By.xpath("//*[name()='g' and contains(@class,'AVERAGE_EXECUTION_PRICE')]//*[name()='text']");

    private By avgLegendContainerValue = By.xpath("//div[@class='d-flex align-items-center']/span[contains(text(),'Avg fill price')]/following-sibling::div");

    private By midLegendContainerValue = By.xpath("//div[@class='d-flex align-items-center']/span[contains(text(),'Mid price')]/following-sibling::div");

    private By dInline = By.xpath("//div[@class='d-inline']");

    private By filterButton = By.xpath("//button[@class='app-transparent-btn']");
    private By idFilter = By.xpath("//div[@class='ag-column-tool-panel-container']/div/div[2]/span[1]");
    private By instrFilter = By.xpath("//div[@class='ag-column-tool-panel-container']/div/div[4]/span[1]");
    private By sideFilter = By.xpath("//div[@class='ag-column-tool-panel-container']/div/div[5]/span[1]");
    private By startTimeFilter = By.xpath("//div[@class='ag-column-tool-panel-container']/div/div[6]/span[1]");
    private By endFilter = By.xpath("//div[@class='ag-column-tool-panel-container']/div/div[7]/span[1]");
    private By execTypeFilter = By.xpath("//div[@class='ag-column-tool-panel-container']/div/div[8]/span[1]");
    private By execSizeFilter = By.xpath("//div[@class='ag-column-tool-panel-container']/div/div[10]/span[1]");
    private By priceImpTicFilter = By.xpath("//div[@class='ag-column-tool-panel-container']/div/div[18]/span[1]");
    private By priceImpAmFilter = By.xpath("//div[@class='ag-column-tool-panel-container']/div/div[19]/span[1]");


    private By avgLegendColor = By.xpath("//div[@class='d-flex align-items-center']/span[contains(text(),'Avg fill price')]/preceding-sibling::*");

    //private By avgLabelsColor=By.xpath("//div[@class='dc-general-container']/child::*/child::*/child::*[3]/child::*[2]/child::*[4]/child::*[1]/child::*[1]");
    private By avgLabelsColor = By.xpath("//*[name()='g' and contains(@class,'AVERAGE_EXECUTION_PRICE')]//*[name()='rect']");
    private By typeColumnHeader = By.xpath("//div[@class='ag-header-container']//span[contains(text(),'Type')]");
    private By numOfExecutionsColumnHeader = By.xpath("//div[@class='ag-header-container']//span[contains(text(),'Num of executions')]");
    private By startTimeColumnHeader = By.xpath("//div[@class='ag-header-container']//span[contains(text(),'Start time')]");
    private By avgFillPriceColumnHeader = By.xpath("//div[@class='ag-header-container']//span[contains(text(),'Avg fill price')]");

    private By avgValue = By.xpath("//div[@role='gridcell' and @col-id='averageFillPrice']/span/span");
    private By numOfExecValue = By.xpath("//div[@role='gridcell' and @col-id='numberOfExecutions']/span");
    private By startTimeValue = By.xpath("//div[@role='gridcell' and @col-id='startTime']/span");
    private By typeValue = By.xpath("//div[@role='gridcell' and @col-id='orderType']/span");
    private By sortNumButton = By.xpath("//span[@class='ag-column-drop-cell-text hidden-text' and contains(text(),'Num of executions')]");
    private By sortAvgButton = By.xpath("//span[@class='ag-column-drop-cell-text hidden-text' and contains(text(),'Avg fill price')]");
    private By sortStartTimeButton = By.xpath("//span[@class='ag-column-drop-cell-text hidden-text' and contains(text(),'Start time')]");
    private By sortTypeButton = By.xpath("//span[@class='ag-column-drop-cell-text hidden-text' and contains(text(),'Type')]");
    private By idColumnHeader = By.xpath("//div[@class='ag-header-container']//span[contains(text(),'Id')]");
    private By toolsPanelButton = By.xpath("//div[@class='ag-side-buttons']//button");
    private By idCheckbox = By.xpath("//span[contains(text(),'Id')]/preceding-sibling::*");
    private By idHeaderCellMenuButton = By.xpath("//div[@ref='eLabel']/span[contains(text(),'Id')]/parent::*/preceding-sibling::*");
    private By agTab3 = By.xpath("//div[@ref='tabHeader']/span[3]");
    private By idCheckboxColsList = By.xpath("//div[@ref='tabBody']//div[@class='ag-primary-cols-list-panel']/div[1]/span[1]");
    private By vwapNameLegendContainer = By.xpath("//div[@class='legend-container__item d-flex align-items-center']//*[name()='span' and contains(text(),'VWAP')]");
    private By avgNameLegendContainer = By.xpath("//div[@class='legend-container__item d-flex align-items-center']//*[name()='span' and contains(text(),'Avg')]");
    private By midNameLegendContainer = By.xpath("//div[@class='legend-container__item d-flex align-items-center']//*[name()='span' and contains(text(),'Mid')]");


    public void openGridPage() {
        mainMenu.clickOnItem("Grid & chart");
    }

    public void clickTypeColumnHeaderName() {
        $(typeColumnHeader).click();
    }
    public void clickStartTimeHeaderName(){
        $(startTimeColumnHeader).click();
    }
    public void clickAvgFillPriceHeaderName(){
       $(avgFillPriceColumnHeader).click();
    }
    public void clickNumOfExecutionHeaderName(){
        $(numOfExecutionsColumnHeader).click();
    }


    public void clickIcebergElement() {
        $(gridBodyNameIceberg).click();
    }

    public void clickLinesButton() {
        $(linesButton).click();
    }


    public void checkAvgButton() {
        if ($(avgNameLegendContainer).is(Condition.not(Condition.visible))) {
            $(avgButton).click();
        }
    }

    public void checkMidButton() {

        if ($(midNameLegendContainer).is(Condition.not(Condition.visible))) {
            $(midButton).click();
        }
    }

    public void checkVwapLegendContainer() {
        if ($(vwapNameLegendContainer).is(Condition.visible)) {
            $(vwapButton).click();
        }
    }

    public void setFilter() {
        $(filterButton).click();
        $(idFilter).click();
        $(instrFilter).click();
        $(endFilter).click();
        $(execTypeFilter).click();
        $(filterButton).click();
    }

    public void setFilterForSort(){
        $(filterButton).click();
        $(idFilter).click();
        $(instrFilter).click();
        $(sideFilter).click();
        $(endFilter).click();
        $(execTypeFilter).click();
        $(execSizeFilter).click();
        $(filterButton).click();

    }

    public String getTextAvgValueInfoString() {
        String str = $(dInline).getText();
        String[] words = str.split("\\s");
        String[] value = words[15].split("\\.");
        String avgValueInfoString = value[0] + "." + value[1].substring(0, 4);
        return avgValueInfoString;
    }


    public String getTextAvgPriceLabelsContainer() {
        return $(avgPriceLabelsContainer).getText();
    }

    public String getTextAvgLegendContainerValue() {
        return $(avgLegendContainerValue).getText();
    }

    public String getTextAvgPriceGrid() {
        return $(avgPriceGrid).getText();
    }


    public String getTextMidLegendContainerValue() {
        return $(midLegendContainerValue).getText();
    }

    public String getTextMidPriceLabelsContainer() {
        return $(midPriceLabelsContainer).getText();
    }


    public String getRgbColorAvgLegendColor() {
        return $(avgLegendColor).getAttribute("style");
    }

    public String getHexColorAvgLabelsColor() {
        String fill = $(avgLabelsColor).getAttribute("fill");
        return fill;
    }

    public void openCloseFilterMenu() {
        $(filterButton).click();
    }
    public void clickIdFilter(){
        $(idFilter).click();
    }
    public boolean checkVisibleIdColumnHeader(){
        return $(idColumnHeader).is(Condition.visible);
    }

    public void openClosrToolPanelMenu(){
        $(toolsPanelButton).click();
    }
    public void clickIdCheckbox() {
        $(idCheckbox).click();
    }


    public void openIdHeaderCellMenu(){
        $(idHeaderCellMenuButton).click();
    }
    public void clickAgTab3(){
        $(agTab3).click();
    }
    public void clickIdCheckboxColsList(){
        $(idCheckboxColsList).click();
    }


    public List setTypeValueUpDownList(){
        return $$(typeValue);
    }
    public List setStartTimeUpDownList(){
        return  $$(startTimeValue);
    }
    public List setAvgUpDownList(){
        return  $$(avgValue);
    }
    public List setNumOfExecUpDownList(){
        return  $$(numOfExecValue);
    }


    public String getTypeValue(int i){
       return ($(typeValue,i).getText());
    }
    public String getStartTimeValue(int i){
        return ($(startTimeValue,i).getText());
    }
    public String getAvgValue(int i){
        return ($(avgValue,i).getText());
    }
    public String getNumOfExecValue(int i){
        return ($(numOfExecValue,i).getText());
    }

    public boolean checkSortTypeButton(){
        return $(sortTypeButton).is(Condition.visible);
    }
    public boolean checkSortStartTimeButton(){
        return $(sortStartTimeButton).is(Condition.visible);
    }
    public boolean checkSortAvgButton(){
        return $(sortAvgButton).is(Condition.visible);
    }
    public boolean checkSortNumOfExecButton(){
        return $(sortNumButton).is(Condition.visible);
    }

}