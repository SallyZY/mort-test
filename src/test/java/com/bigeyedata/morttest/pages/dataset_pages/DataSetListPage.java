package com.bigeyedata.morttest.pages.dataset_pages;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.bigeyedata.morttest.CommonFunctions.waitForElementInvisible;
import static com.bigeyedata.morttest.CommonFunctions.waitForElementVisible;

/**
 * Created by yingzhang on 02/08/2017.
 */
public class DataSetListPage extends Page {

    @FindBy(id = "reportDataSetCollection")
    WebElement dataSetListDiv;

    @FindBy(xpath = "//ul[@role='menu']//li[text()='虚拟字段']")
    WebElement virtualDimensionMenuLi;

    @FindBy(xpath = "//ul[@role='menu']//li[text()='虚拟指标']")
    WebElement virtualMeasureMenuLi;

    @FindBy(className = "ant-modal-content")
    WebElement virtualFieldDialog;


    public void openVirtualDimensionDialog(String dataSetName) throws InterruptedException {

        waitForElementVisible(dataSetListDiv);
        WebElement dataSetItem = WebDriverManager.getDriver().findElement(By.xpath("//div[@id='reportDataSetCollection']//div[@title='" + dataSetName + "']"));
        CommonFunctions.mouseOverAtCoordinates(dataSetItem,60,14);
        WebDriverManager.getDriver().findElement(By.xpath("//div[@id='reportDataSetCollection']//div[@title='" + dataSetName + "']/i")).click();

        waitForElementVisible(virtualDimensionMenuLi);
        virtualDimensionMenuLi.click();

        waitForElementVisible(virtualFieldDialog);
    }

}
