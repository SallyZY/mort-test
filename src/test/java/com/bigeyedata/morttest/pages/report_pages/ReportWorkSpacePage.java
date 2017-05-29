package com.bigeyedata.morttest.pages.report_pages;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by yingzhang on 19/05/2017.
 */
public class ReportWorkSpacePage extends Page {

    @FindBy(className = "ReportDetail")
    WebElement reportDetailDiv;

    @FindBy(id = "saveReport")
    WebElement saveReportButton;

    @FindBy(id = "backToPreviewReport")
    WebElement backToPreviewReportButton;

    @FindBy(css = "div.pages")
    WebElement pageDiv;

    @FindBy(className = "ant-dropdown")
    List<WebElement> chartDropdownMenuList;

    @FindBy(css = "div.ReportDetail > div > div > div > div > div:nth-child(1) > div:nth-child(2) > i")
    WebElement chartDropdownMenuIcon;

    @FindBy(css = "div.ReportCanvasPages > div:nth-child(2) > div:nth-child(2)")
    WebElement addReportPageIcon;

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

    public void copyChart(int chartIndex) throws InterruptedException {

        selectSingleChart();
        chartDropdownMenuIcon.click();
        CommonFunctions.waitForElementVisible(chartDropdownMenuList.get(chartIndex));
        chartDropdownMenuList.get(chartIndex).findElement(By.cssSelector("ul > li:nth-child(1)")).click();
    }

    public void moveChart(int chartIndex) throws InterruptedException {

        Thread.sleep(2);
        chartDropdownMenuIcon.click();
        CommonFunctions.waitForElementVisible(chartDropdownMenuList.get(chartIndex));
        chartDropdownMenuList.get(chartIndex).findElement(By.cssSelector("ul > li:nth-child(3)")).click();
        chartDropdownMenuList.get(chartIndex).findElement(By.cssSelector("ul > li:nth-child(3) > ul > li:nth-child(1)")).click();
    }

    public void addNewReportPage(){

        addReportPageIcon.click();
    }
}
