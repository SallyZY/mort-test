package com.bigeyedata.morttest.pages.report_pages;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.bigeyedata.morttest.CommonFunctions.*;

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

    @FindBy(name = "actionBarMenu")
    List<WebElement> actionBarMenuList;

    @FindBy(name = "actionBar")
    List<WebElement> actionBarList;

    @FindBy(xpath = "//canvas")
    List<WebElement> chartCanvasList;

    @FindBy(css = "div.ReportCanvasPages > div:nth-child(2) > div:nth-child(2)")
    WebElement addReportPageIcon;

    public void gotoReportPageByName(String name) throws InterruptedException {

        pageDiv.findElement(By.xpath("//input[@value='" + name + "']")).click();
        waitForElementVisibleAndLocated(By.className("Chart"));
    }

    public void backToPreviewReport() throws InterruptedException {

        waitForElementClickable(backToPreviewReportButton);
        backToPreviewReportButton.click();
    }

    public void saveReport(){
        saveReportButton.click();
    }

    public void selectSingleChart(){

        WebElement chartActionbar = reportDetailDiv.findElement(By.cssSelector("div > div > div > div > div:nth-child(1)"));
        focusElement(chartActionbar);
        clickElementAtCoordinates(chartActionbar,2,1);
    }

    public void selectChartByIndex(int chartIndex) throws InterruptedException {

        chartIndex--;
        mouseOver(chartCanvasList.get(chartIndex));
        focusElement(actionBarList.get(chartIndex));
        actionBarList.get(chartIndex).click();
    }

    public void copyChart(int chartIndex) throws InterruptedException {

        chartIndex --;
        clickActingBarMenu(chartIndex);
        CommonFunctions.waitForElementVisible(chartDropdownMenuList.get(chartIndex));
        chartDropdownMenuList.get(chartIndex).findElement(By.cssSelector("ul > li:nth-child(1)")).click();
    }

    public void moveChart(int chartIndex, String PageName) throws InterruptedException {

        chartIndex --;
        clickActingBarMenu(chartIndex);
        CommonFunctions.waitForElementVisible(chartDropdownMenuList.get(chartIndex));
        clickMoveToPageName(chartIndex,PageName);
    }

    public void addNewReportPage(){

        addReportPageIcon.click();
    }

    public void renameReportPage(String originName, String newName) throws InterruptedException {

        Thread.sleep(2000);
        doubleClick(pageDiv.findElement(By.xpath("//input[@value='" + originName + "']")));
        Thread.sleep(2000);
        pageDiv.findElement(By.xpath("//input[@value='" + originName + "']")).clear();
        pageDiv.findElement(By.xpath("//input[@value='" + originName + "']")).sendKeys(newName);
    }

    private void clickMoveToPageName(int index, String pageName){

        chartDropdownMenuList.get(index).findElement(By.cssSelector("ul > li:nth-child(3)")).click();
        List<WebElement> pageNameList=chartDropdownMenuList.get(index).findElements(By.cssSelector("ul > li:nth-child(3) > ul > li"));

        for (int i=0; i<pageNameList.size();i++){
            if(pageNameList.get(i).getText().equals(pageName)) {
                pageNameList.get(i).click();
                break;
            }
        }
    }

    private void clickActingBarMenu(int index) throws InterruptedException {

        Thread.sleep(2000);
        mouseOver(chartCanvasList.get(index));
        actionBarMenuList.get(index).click();
    }
}
