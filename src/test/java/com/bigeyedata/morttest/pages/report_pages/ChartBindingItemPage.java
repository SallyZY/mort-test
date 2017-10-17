package com.bigeyedata.morttest.pages.report_pages;

import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.bigeyedata.morttest.CommonFunctions.waitForElementVisible;

/**
 * Created by yingzhang on 07/06/2017.
 */
public class ChartBindingItemPage extends Page {

//    @FindBy(id = "reportPresentation")
    @FindBy(id = "reportBindingsContainer")
    WebElement chartSettingDiv;


    WebDriver webDriver = WebDriverManager.getDriver();

    public void deleteBindingItem(String itemName) throws InterruptedException {

        waitForElementVisible(chartSettingDiv);
        String bindingItemID = getBindingItemIDByItemName(itemName);
        webDriver.findElement(By.xpath("//span[@id='" + bindingItemID + "']/span/i[1]")).click();
    }

    public boolean isBindingItemEmpty(String itemName){

        String bindingItemID = getBindingItemIDByItemName(itemName);
        return webDriver.findElement(By.xpath("//div[@id='" + bindingItemID + "' and @class='NoBindingLabel']")).isDisplayed();
    }

    private String getBindingItemIDByItemName(String itemName){

        String bindingItemID = "";
        switch (itemName) {
            case "Dimension":
                bindingItemID = "report-dimensions";
                break;
            case "Legend":
                bindingItemID = "report-legends";
                break;
            case "Measure":
                bindingItemID = "report-measures";
                break;
            case "LeftMeasure":
                bindingItemID = "report-leftMeasures";
                break;
            case "RightMeasure":
                bindingItemID = "report-rightMeasures";
                break;
        }

        return bindingItemID;
    }
}
