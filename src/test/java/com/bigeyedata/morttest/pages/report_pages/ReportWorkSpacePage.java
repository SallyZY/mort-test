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
import static com.bigeyedata.morttest.Hooks.getThreadSleepTime;

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

    @FindBy(css = "div.ReportCanvasPages")
    WebElement pageDiv;

    @FindBy(className = "ant-dropdown")
    List<WebElement> chartDropdownMenuList;

    @FindBy(name = "actionBarMenu")
    List<WebElement> actionBarMenuList;

    @FindBy(name = "actionBar")
    List<WebElement> actionBarList;

    @FindBy(xpath = "//div[@class='Chart']")
    List<WebElement> chartCanvasList;

//    @FindBy(css = "div.ReportCanvasPages > div:nth-child(2) > div:nth-child(2)")
    @FindBy(css = "div.ReportCanvasPages > div.addIcon > span.iconfont.icon-add")
//    @FindBy(className = "iconfont icon-add")
    WebElement addReportPageIcon;

    @FindBy(css = "div.savingReport > div:nth-child(2) > div:nth-child(1) > input")
    WebElement reportSavedNameInput;

    @FindBy(xpath = "//*[@id='reportActionBarMoreMenu']")
    WebElement reportOtherOperationButton;

    @FindBy(xpath = "//*[@id='reportActionBarMoreMenuList']/li[2]")
    WebElement reportSaveAsMenuItem;

    @FindBy(className = "savingReport")
    WebElement reportSaveDialogDiv;

    @FindBy(css = "div.ant-modal-wrap > div > div.ant-modal-content")
    WebElement saveReportConfirmDiv;

    @FindBy(css = "div.ant-confirm-btns.clearfix > button:nth-child(1)")
    WebElement doNotSaveButton;

    public void clickSaveAsMenu() throws InterruptedException {

        Thread.sleep(60000);
        reportOtherOperationButton.click();
        reportSaveAsMenuItem.click();
    }

    public void inputReportSavedName(String reportName) throws InterruptedException {

        waitForElementVisible(reportSaveDialogDiv);
        reportSavedNameInput.clear();
        reportSavedNameInput.sendKeys(reportName);
    }

    public void clickSaveReportButtonOnDialog(){

        reportSaveDialogDiv.findElement(By.cssSelector("div:nth-child(1)")).click();
        reportSaveDialogDiv.findElement(By.cssSelector("div:nth-child(4) > a:nth-child(2)")).click();
    }

    public void gotoReportPageByName(String name) throws InterruptedException {

        pageDiv.findElement(By.xpath("//span[text()='" + name + "']")).click();
        waitForElementVisibleAndLocated(By.className("Chart"));
    }

    public void backToPreviewReport() throws InterruptedException {

        waitForElementClickable(backToPreviewReportButton);
        backToPreviewReportButton.click();
    }

    public void saveReport() throws InterruptedException {
        saveReportButton.click();
        Thread.sleep(5000);
    }

    public void selectSingleChart(){

        WebElement chartActionbar = reportDetailDiv.findElement(By.cssSelector("div > div > div > div > div:nth-child(1)"));
        focusElement(chartActionbar);
        clickElementAtCoordinates(chartActionbar,2,1);
    }

    public void selectChartByIndex(int chartIndex) throws InterruptedException {

        chartIndex--;
        mouseOverAtCoordinates(chartCanvasList.get(chartIndex),20,20);
        focusElement(actionBarList.get(chartIndex));
        actionBarList.get(chartIndex).click();
    }

    public void copyChart(int chartIndex) throws InterruptedException {

        chartIndex --;
        clickActingBarMenu(chartIndex);
        waitForElementVisible(chartDropdownMenuList.get(chartIndex));
        chartDropdownMenuList.get(chartIndex).findElement(By.cssSelector("ul > li:nth-child(1)")).click();
    }

    public void moveChart(int chartIndex, String PageName) throws InterruptedException {

        chartIndex --;
        clickActingBarMenu(chartIndex);
        waitForElementVisible(chartDropdownMenuList.get(chartIndex));
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
        mouseOverAtCoordinates(chartCanvasList.get(index),20,20);
        actionBarMenuList.get(index).click();
    }

    public void giveUpSaveTheReport() throws InterruptedException {
        waitForElementClickable(saveReportConfirmDiv);
        doNotSaveButton.click();

    }
}
