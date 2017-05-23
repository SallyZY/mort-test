package com.bigeyedata.morttest.pages.report_pages;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(css = "div#presentationTitle > div:nth-child(2) > div:nth-child(1) > input")
    WebElement chartTitle_Text;

    @FindBy(css = "div#presentationTitle > div:nth-child(2) > div:nth-child(2) > ")
    WebElement chartTitle_Align;

    @FindBy(id = "presentationDimensionAxis")
    WebElement dimensionSettingItem;

    @FindBy(id = "presentationMeasureAxis")
    WebElement measureSettingItem;

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


    public void gotoSettingPanel(String panelName){

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

    public void setChartTitle(){

        expandSettingItem(chartTitleSettingItem);
        openSwitchOfSettingItem(chartTitleSettingItem);

    }

    private void expandSettingItem(WebElement item){

        item.click();
    }

    private void openSwitchOfSettingItem(WebElement item){

        item.findElement(By.cssSelector("div > span > span > i")).click();
    }
}
