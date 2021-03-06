package com.bigeyedata.morttest.pages.datasource_pages;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.DataSetPage;
import com.bigeyedata.morttest.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.bigeyedata.morttest.CommonFunctions.waitForElementVisible;
import static com.bigeyedata.morttest.CommonFunctions.waitForElementVisibleAndLocated;
import static com.bigeyedata.morttest.SeeThruUtils.onPage;

/**
 * Created by yingzhang on 10/05/2017.
 */
public class DataSourceDetailPage extends Page {

    @FindBy(id = "addNewDataSet")
    WebElement createNewDatasetButton;

    @FindBy(id="reportRelatedDataSet")
    WebElement relatedDataSetTable;

    @FindBy(css = "#resourceListMenuContainerMenu > li.ant-menu-item-selected.ant-menu-item > div > span > span.item-right")
    WebElement operationMenuIcon;

    @FindBy(className = "ant-dropdown-menu.ant-dropdown-menu-vertical.data-sources-resource-list-item-operation-menu.ant-dropdown-menu-light.ant-dropdown-menu-root")
    WebElement operationMenu;

    @FindBy(xpath = "//div[@class='ant-dropdown ant-dropdown-placement-bottomLeft']/ul[@class='ant-dropdown-menu ant-dropdown-menu-vertical data-sources-resource-list-item-operation-menu ant-dropdown-menu-light ant-dropdown-menu-root']/li[3]")
    WebElement editItem;

    @FindBy(css = "div.ant-modal-content > div.ant-modal-body")
    WebElement dataSourceConfigDiv;

    @FindBy(css = "#app > div > div.DefaultLayout > div.resource-page > div > div.ant-layout > div > div > div.ant-layout > div > div > div.data-source-config > div > div > div > div > div > div > table > tbody")
    WebElement dataSourceDetailInfoTbody;



    public boolean isDataSetNameDisplayed(List<Map<String,String>> datasetNameList) {

        waitForElementVisible(relatedDataSetTable);

        boolean isFindDatasetName = false;
        for (int i = 0; i < datasetNameList.size(); i++) {
            isFindDatasetName = relatedDataSetTable.getText().contains(datasetNameList.get(i).get("DatasetName").toString());
        }

        return isFindDatasetName;
    }

    public void CreateNewDatasetFromDatasource(){

        createNewDatasetButton.click();
        onPage(DataSetPage.class);
    }

    public void goToRDBEditPage(String title) {
        WebDriver driver = WebDriverManager.getDriver();
        WebElement dataSource = driver.findElement(By.xpath("//div/span/span[1]/span[text()='" + title + "']"));
        CommonFunctions.waitForElementVisible(dataSource);
        dataSource.click();
        CommonFunctions.waitForElementVisible(operationMenuIcon);
        operationMenuIcon.click();
//        CommonFunctions.waitForElementVisible(operationMenu);
        CommonFunctions.waitForElementVisible(editItem);
        editItem.click();
        CommonFunctions.waitForElementVisible(dataSourceConfigDiv);
    }


    public String getRDBParameter() {
        CommonFunctions.waitForElementVisible(dataSourceDetailInfoTbody);
        return dataSourceDetailInfoTbody.getText();
    }





}
