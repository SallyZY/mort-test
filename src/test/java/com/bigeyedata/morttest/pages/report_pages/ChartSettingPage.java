package com.bigeyedata.morttest.pages.report_pages;

import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

import static com.bigeyedata.morttest.CommonFunctions.waitForElementVisible;

/**
 * Created by yingzhang on 20/05/2017.
 */
public class ChartSettingPage extends Page {

    @FindBy(xpath = "//div[@class='view-panel']//div[@role='tabpanel'][3]")
    WebElement chartStyleSettingDiv;

    @FindBy(xpath = "//div[@class='view-panel']//div[@class='ant-tabs-nav-scroll']//div[@role='tab'][1]")
    WebElement bindingItemIconDiv;

    @FindBy(xpath = "//div[@class='view-panel']//div[@class='ant-tabs-nav-scroll']//div[@role='tab'][2]")
    WebElement filterIconDiv;

    @FindBy(xpath = "//div[@class='view-panel']//div[@class='ant-tabs-nav-scroll']//div[@role='tab'][3]")
    WebElement styleSettingIconDiv;

    @FindBy(id = "reportBindingsContainer")
    WebElement bindingItemsDiv;


    @FindBy(id = "presentationTitle")
    WebElement chartTitleSettingItem;

    @FindBy(css = "div#presentationTitle > div:nth-child(2) > div:nth-child(1) > span > input")
    WebElement chartTitle_TextInput;

    @FindBy(css = "div#presentationTitle > div:nth-child(2) > div:nth-child(4) > span:nth-child(2) > select")
    WebElement chartTitle_TextSizeSelect;


    @FindBy(id = "presentationDimensionAxis")
    WebElement dimensionSettingItem;

    @FindBy(css = "div#presentationDimensionAxis > div:nth-child(2) > div:nth-child(6) > span:nth-child(2) > span > i")
    WebElement dimensionTitleSwitch;


    @FindBy(id = "presentationMeasureAxis")
    WebElement measureSettingItem;

    @FindBy(css = "div#presentationMeasureAxis > div:nth-child(2) > div:nth-child(5) > span:nth-child(2)  > span > i")
    WebElement measureTitleSwitch;

    @FindBy(css = "div#presentationMeasureAxis > div:nth-child(2) > div:nth-child(6) > span:nth-child(2) > input")
    WebElement measureAliasInput;

    @FindBy(css = "div#presentationMeasureAxis > div:nth-child(2) > div:nth-child(10) > span:nth-child(2) > select")
    WebElement measureUnitSelect;

    @FindBy(css = "div#presentationMeasureAxis > div:nth-child(2) > div:nth-child(11) > span:nth-child(2) > select")
    WebElement measureNumberOfDecimalSelect;

    @FindBy(css = "div#presentationMeasureAxis > div:nth-child(2) > div:nth-child(12) > span:nth-child(2)  > span > i")
    WebElement measureThousandSeparatorDisplay;


    @FindBy(id = "presentationMeasureAxisRight")
    WebElement measureRightSettingItem;

    @FindBy(css = "div#presentationMeasureAxisRight > div:nth-child(2) > div:nth-child(5) > span:nth-child(2)  > span > i")
    WebElement measureRightTitleSwitch;

    @FindBy(css = "div#presentationMeasureAxisRight > div:nth-child(2) > div:nth-child(6) > span:nth-child(2) > input")
    WebElement measureRightAliasInput;

    @FindBy(css = "div#presentationMeasureAxisRight > div:nth-child(2) > div:nth-child(10) > span:nth-child(2) > select")
    WebElement measureRightUnitSelect;

    @FindBy(css = "div#presentationMeasureAxisRight > div:nth-child(2) > div:nth-child(11) > span:nth-child(2) > select")
    WebElement measureRightNumberOfDecimalSelect;

    @FindBy(css = "div#presentationMeasureAxisRight > div:nth-child(2) > div:nth-child(12) > span:nth-child(2)  > span > i")
    WebElement measureRightThousandSeparatorDisplay;


    @FindBy(id = "presentationLegend")
    WebElement legendSettingItem;

    @FindBy(css = "div#presentationLegend > div:nth-child(2) > div:nth-child(1) > span:nth-child(2)  > select")
    WebElement legendLocationSelect;

    @FindBy(css = "div#presentationLegend > div:nth-child(2) > div:nth-child(4) > span:nth-child(2)  > select")
    WebElement legendFontSizeSelect;


    @FindBy(id = "presentationDataLabel")
    WebElement dataLabelSettingItem;

    @FindBy(css = "div#presentationDataLabel > div:nth-child(2) > div:nth-child(1) > span:nth-child(2)  > select")
    WebElement dataLabelLocationSelect;

    @FindBy(css = "div#presentationDataLabel > div:nth-child(2) > div:nth-child(3) > span:nth-child(2)  > select")
    WebElement dataLabelFontSizeSelect;

    @FindBy(css = "div#presentationDataLabel > div:nth-child(2) > div:nth-child(4) > span:nth-child(2)  > select")
    WebElement dataLabelUnitSelect;

    @FindBy(css = "div#presentationDataLabel > div:nth-child(2) > div:nth-child(6) > span:nth-child(2)  > select")
    WebElement dataLabelDecimalSelect;

    @FindBy(css = "div#presentationDataLabel > div:nth-child(2) > div:nth-child(5) > span:nth-child(2)  > input")
    WebElement dataLabelPostfixInput;

    @FindBy(css = "div#presentationDataLabel > div:nth-child(2) > div:nth-child(7) > span:nth-child(2)  > span > i")
    WebElement dataLabelThousandSeparatorDisplay;


    @FindBy(id = "presentationDataColor")
    WebElement dataColorSettingItem;

    @FindBy(id = "presentationSortPannel")
    WebElement sortSettingItem;

    @FindBy(id = "presentationLimitation")
    WebElement limitationSettingItem;

    @FindBy(id = "presentationDirectionAxis")
    WebElement columnChartDirectionItem;


    @FindBy(css = "div#presentationTitle > div:nth-child(2) > div:nth-child(5) > span:nth-child(2) > select")
    WebElement KPIChartTitle_TextSizeSelect;

    @FindBy(id = "presentationKpiItemConfig")
    List<WebElement> KPIConfigItemList;

    private WebDriver webDriver =WebDriverManager.getDriver();

    public void gotoSettingPanel(String panelName) throws InterruptedException {

        switch (panelName){
            case "binding":
                bindingItemIconDiv.click();
                break;
            case "filter":
                filterIconDiv.click();
                break;
            case "style":
                styleSettingIconDiv.click();
                break;
        }
        waitForElementVisible(chartStyleSettingDiv);
    }

    public void setChartDataLabelStyle(List<Map<String, String>> dataLabelStyleList){

        expandSettingItem(dataLabelSettingItem);
        openSwitchOfSettingItem(dataLabelSettingItem);

        selectByVisibleText(dataLabelLocationSelect,dataLabelStyleList.get(0).get("Location").toString());
        selectByVisibleText(dataLabelFontSizeSelect,dataLabelStyleList.get(0).get("FontSize").toString());
        selectByVisibleText(dataLabelUnitSelect,dataLabelStyleList.get(0).get("Unit").toString());
        selectByVisibleText(dataLabelDecimalSelect,dataLabelStyleList.get(0).get("NumberOfDecimal").toString());

        dataLabelPostfixInput.clear();
        dataLabelPostfixInput.sendKeys(dataLabelStyleList.get(0).get("PostFix").toString());

        displayThousandSeparator(dataLabelThousandSeparatorDisplay,dataLabelStyleList.get(0).get("IsThousandSeparatorDisplay").toString());
    }

    public void setChartLegendStyle(List<Map<String, String>> legendStyleList){

        expandSettingItem(legendSettingItem);

        selectByVisibleText(legendLocationSelect,legendStyleList.get(0).get("Location").toString());
        selectByVisibleText(legendFontSizeSelect,legendStyleList.get(0).get("FontSize").toString());
    }

    public void DisplayChartDimensionTitle() {

        expandSettingItem(dimensionSettingItem);
        dimensionTitleSwitch.click();
    }

    public void setChartMeasureStyle(List<Map<String, String>> measureStyleList){

        expandSettingItem(measureSettingItem);
        measureAliasInput.clear();
        measureAliasInput.sendKeys(measureStyleList.get(0).get("Alias").toString());

        selectByVisibleText(measureUnitSelect,measureStyleList.get(0).get("Unit").toString());
        selectByVisibleText(measureNumberOfDecimalSelect,measureStyleList.get(0).get("NumberOfDecimal").toString());

        displayThousandSeparator(measureTitleSwitch,measureStyleList.get(0).get("IsTitleDisplay").toString());
        displayThousandSeparator(measureThousandSeparatorDisplay,measureStyleList.get(0).get("IsThousandSeparatorDisplay").toString());
    }

    public void setChartRightMeasureStyle(List<Map<String, String>> measureStyleList){

        expandSettingItem(measureRightSettingItem);
        measureRightAliasInput.clear();
        measureRightAliasInput.sendKeys(measureStyleList.get(0).get("Alias").toString());

        selectByVisibleText(measureRightUnitSelect,measureStyleList.get(0).get("Unit").toString());
        selectByVisibleText(measureRightNumberOfDecimalSelect,measureStyleList.get(0).get("NumberOfDecimal").toString());

        displayThousandSeparator(measureRightTitleSwitch,measureStyleList.get(0).get("IsTitleDisplay").toString());
        displayThousandSeparator(measureRightThousandSeparatorDisplay,measureStyleList.get(0).get("IsThousandSeparatorDisplay").toString());
    }

    public void setChartTitle(List<Map<String, String>> chartTitleList){

        expandSettingItem(chartTitleSettingItem);
        openSwitchOfSettingItem(chartTitleSettingItem);

        String text = chartTitleList.get(0).get("TitleText").toString();
        String align = chartTitleList.get(0).get("TitleAlign").toString();
        String size = chartTitleList.get(0).get("TitleSize").toString();

        chartTitle_TextInput.clear();
        chartTitle_TextInput.sendKeys(text);
        webDriver.findElement(By.xpath("//input[@name='title_align' and @value='"+ align.toLowerCase()+"']")).click();

        selectByVisibleText(chartTitle_TextSizeSelect,size);
    }

    private void expandSettingItem(WebElement item){

        item.click();
    }

    private void openSwitchOfSettingItem(WebElement item){

        item.findElement(By.cssSelector("div > span > span > i")).click();
    }

    private void selectByVisibleText(WebElement selectElement, String text){

        Select select = new Select(selectElement);
        select.selectByVisibleText(text);
    }

    private void displayThousandSeparator(WebElement element, String isThousandSeparatorDisplay){

        if(isThousandSeparatorDisplay.toLowerCase().equals("true"))
            element.click();
    }

    private int findKPIMeasureIndex(String measureName){

        int index = -1;
        for (int i=0;i<KPIConfigItemList.size();i++){
            if(KPIConfigItemList.get(i).findElement(By.cssSelector("div:nth-child(1) > i > span.ellipsis")).getText().equals(measureName)) {
                index = i;
                break;
            }
        }

        return index;
    }

}
