package com.bigeyedata.morttest.pages.report_pages;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by yingzhang on 20/05/2017.
 */
public class ChartSettingPage extends Page {

    @FindBy(id = "reportPresentation")
    WebElement chartSettingDiv;

    @FindBy(id = "icon-data")
    WebElement bindingItemIconDiv;

    @FindBy(id = "icon-filter")
    WebElement filterIconDiv;

    @FindBy(id = "icon-geshishua")
    WebElement styleSettingIconDiv;


    @FindBy(id = "presentationTitle")
    WebElement chartTitleSettingItem;

    @FindBy(css = "div#presentationTitle > div:nth-child(2) > div:nth-child(1) > span > input")
    WebElement chartTitle_TextInput;

    @FindBy(css = "div#presentationTitle > div:nth-child(2) > div:nth-child(4) > span:nth-child(2) > select")
    WebElement chartTitle_TextSizeSelect;


    @FindBy(id = "presentationDimensionAxis")
    WebElement dimensionSettingItem;

    @FindBy(css = "div#presentationDimensionAxis > div:nth-child(2) > div:nth-child(2) > span:nth-child(2) > span > i")
    WebElement dimensionTitleSwitch;


    @FindBy(id = "presentationMeasureAxis")
    WebElement measureSettingItem;

    @FindBy(css = "div#presentationMeasureAxis > div:nth-child(2) > div:nth-child(2) > span:nth-child(2)  > span > i")
    WebElement measureTitleSwitch;

    @FindBy(css = "div#presentationMeasureAxis > div:nth-child(2) > div:nth-child(3) > span:nth-child(2) > input")
    WebElement measureAliasInput;

    @FindBy(css = "div#presentationMeasureAxis > div:nth-child(2) > div:nth-child(6) > span:nth-child(2) > select")
    WebElement measureUnitSelect;

    @FindBy(css = "div#presentationMeasureAxis > div:nth-child(2) > div:nth-child(7) > span:nth-child(2) > select")
    WebElement measureNumberOfDecimalSelect;

    @FindBy(css = "div#presentationMeasureAxis > div:nth-child(2) > div:nth-child(8) > span:nth-child(2)  > span > i")
    WebElement measureThousandSeparatorDisplay;


    @FindBy(id = "presentationLegend")
    WebElement legendSettingItem;

    @FindBy(id = "presentationDataLabel")
    WebElement dataLabelSettingItem;

    @FindBy(id = "presentationDataColor")
    WebElement dataColorSettingItem;

    @FindBy(id = "presentationSortPannel")
    WebElement sortSettingItem;

    @FindBy(id = "presentationLimitation")
    WebElement limitationSettingItem;

    @FindBy(id = "presentationDirectionAxis")
    WebElement columnChartDirectionItem;


    private WebDriver webDriver =WebDriverManager.getDriver();
    private Select select;

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
        CommonFunctions.waitForElementVisible(chartSettingDiv);
    }

    public void DisplayChartDimensionTitle() {

        expandSettingItem(dimensionSettingItem);
        dimensionTitleSwitch.click();
    }

    public void setChartMeasureStyle(List<Map<String, String>> measureStyleList){

        expandSettingItem(measureSettingItem);
        measureAliasInput.sendKeys(measureStyleList.get(0).get("Alias").toString());

        select =new Select(measureUnitSelect);
        select.selectByVisibleText(measureStyleList.get(0).get("Unit").toString());
        select=new Select(measureNumberOfDecimalSelect);
        select.selectByVisibleText(measureStyleList.get(0).get("NumberOfDecimal").toString());

        if(measureStyleList.get(0).get("IsTitleDisplay").toString().equals("true"))
            measureTitleSwitch.click();
        if(measureStyleList.get(0).get("IsThousandSeparatorDisplay").toString().equals("true"))
            measureThousandSeparatorDisplay.click();
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
        select = new Select(chartTitle_TextSizeSelect);
        select.selectByVisibleText(size);
    }

    private void expandSettingItem(WebElement item){

        item.click();
    }

    private void openSwitchOfSettingItem(WebElement item){

        item.findElement(By.cssSelector("div > span > span > i")).click();
    }
}
