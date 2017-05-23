package com.bigeyedata.morttest.pages.report_pages;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by yingzhang on 19/05/2017.
 */
public class ReportWorkSpacePage {

    @FindBy(className = "report-canvas-container")
    WebElement chartCanvasDiv;

    public void selectSingleChart(){

        WebElement chartActionbar = chartCanvasDiv.findElement(By.cssSelector("div > div > div > div > div > div:nth-child(1)"));
        CommonFunctions.focusElement(chartActionbar);
        CommonFunctions.clickElementAtCoordinates(chartActionbar,1,2);
    }
}