package com.bigeyedata.morttest.pages.report_pages;

import com.bigeyedata.morttest.pages.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by yingzhang on 29/05/2017.
 */
public class KPIChartSettingPage extends Page {

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

    @FindBy(css = "div#presentationTitle > div:nth-child(2) > div:nth-child(5) > span:nth-child(2) > select")
    WebElement chartTitle_TextSizeSelect;
}
