package com.bigeyedata.morttest.pages.report_pages;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.WebDriverManager;
import com.sun.tools.javac.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by yingzhang on 19/05/2017.
 */
public class ReportWorkSpacePage {

    @FindBy(className = "ReportDetail")
    WebElement reportDetailDiv;

    @FindBy(id = "saveReport")
    WebElement saveReportButton;

    @FindBy(id = "backToPreviewReport")
    WebElement backToPreviewReportButton;

    @FindBy(css = "div.pages")
    WebElement pageDiv;

    public void gotoReportPageByName(String name) throws InterruptedException {

        pageDiv.findElement(By.xpath("//input[@value='" + name + "']")).click();
        CommonFunctions.waitForElementVisibleAndLocated(By.className("Chart"));
    }

    public void backToPreviewReport() throws InterruptedException {

        CommonFunctions.waitForElementClickable(backToPreviewReportButton);
        backToPreviewReportButton.click();
    }

    public void saveReport(){
        saveReportButton.click();
    }

    public void selectSingleChart(){

        WebElement chartActionbar = reportDetailDiv.findElement(By.cssSelector("div > div > div > div >div:nth-child(1)"));
        CommonFunctions.focusElement(chartActionbar);
        CommonFunctions.clickElementAtCoordinates(chartActionbar,2,1);
    }
}
