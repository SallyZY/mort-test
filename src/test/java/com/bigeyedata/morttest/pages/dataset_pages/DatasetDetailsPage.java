package com.bigeyedata.morttest.pages.dataset_pages;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

import static com.bigeyedata.morttest.CommonFunctions.waitForElementVisible;

/**
 * Created by yingzhang on 12/05/2017.
 */
public class DatasetDetailsPage extends Page {

    @FindBy(xpath = "//div[@role='tab'][1]")
    WebElement fieldTab;

    @FindBy(xpath = "//div[@role='tab'][2]")
    WebElement dataPreviewTab;

    @FindBy(xpath = "//div[@role='tab'][3]")
    WebElement relatedReportTab;

    @FindBy(xpath = "//div[@role='tab'][4]")
    WebElement importHistoryTab;

    @FindBy(xpath = "//div[@id='fieldsDisplay']//table")
    WebElement FieldAttributeTable;

    @FindBy(xpath = "//div[@id='dataSetImportHistory']//table")
    WebElement importHistoryTable;

    @FindBy(id = "dataSetOtherOperationMenu")
    WebElement otherOperationMenu;

    @FindBy(css = "ul#dataSetAllMenu > li:nth-child(1)")
    WebElement locateToDatasourceMenuItem;

//    @FindBy(css = "ul#dataSetAllMenu > li:nth-child(2)")
    @FindBy(id = "appendFieldsButton" )
    WebElement appendFieldsMenuItem;

    @FindBy(css = "ul#dataSetAllMenu > li:nth-child(3)")
    WebElement appendDataMenuItem;

    @FindBy(css = "ul#dataSetAllMenu > li:nth-child(2)")
    WebElement checkSqlMenuItem;

    @FindBy(xpath = "//div[@class='ant-modal-content']//p")
    WebElement viewSQLDiv;

    public void clickOtherOptionsMenuItem(String item) throws InterruptedException {

        waitForElementVisible(otherOperationMenu);
        otherOperationMenu.click();

        switch (item){
            case "ViewDataSource":
                locateToDatasourceMenuItem.click();
                break;
            case "AppendData":
                appendDataMenuItem.click();
                break;
            case "AppendFields":
                appendFieldsMenuItem.click();
            case "ViewSql":
                waitForElementVisible(checkSqlMenuItem);
                checkSqlMenuItem.click();


        }
    }


    public String getDescriptionOfNewestImportHistory() throws InterruptedException {

        waitForElementVisible(importHistoryTab);
        importHistoryTab.click();
        List<WebElement> descriptionList = importHistoryTable.findElements(By.cssSelector("tbody > tr > td:nth-child(3) > span"));
        return descriptionList.get(0).getText();
    }


    public int getFieldCountOfDataset() {
        List<WebElement> trList = FieldAttributeTable.findElements(By.cssSelector("tbody > tr"));
        return trList.size();
    }

    public boolean compareFieldAlias(List<Map<String, String>> comparedFieldAliasList) {

        List<WebElement> fieldAliasList = FieldAttributeTable.findElements(By.cssSelector("tbody > tr > td:nth-child(3) > div > span"));

        int aliasEqualToSettingCount = 0;
        String fieldAliasName = "";
        for (int i = 0; i < fieldAliasList.size(); i++) {
            fieldAliasName = fieldAliasList.get(i).getText();

            for (int j = 0; j < comparedFieldAliasList.size(); j++) {
                if (fieldAliasName.equals(comparedFieldAliasList.get(j).get("AliasName").toString())) {
                    aliasEqualToSettingCount++;
                    continue;
                }
            }
        }

        return aliasEqualToSettingCount == comparedFieldAliasList.size() ? true : false;
    }

    public boolean compareFieldType(List<Map<String, String>> comparedFieldTypeList) {

        List<WebElement> fieldTypeList = FieldAttributeTable.findElements(By.cssSelector("tbody > tr > td:nth-child(4) > span > span"));
        List<WebElement> fieldNameList = FieldAttributeTable.findElements(By.cssSelector("tbody > tr > td:nth-child(2) > span"));

        int typeEqualToSettingCount = 0;
        String fieldType = "";
        String fieldName="";
        for (int i = 0; i < fieldTypeList.size(); i++) {
            fieldName = fieldNameList.get(i).getText();
            fieldType = fieldTypeList.get(i).getText();

            for (int j = 0; j < comparedFieldTypeList.size(); j++) {
                if (fieldName.equals(comparedFieldTypeList.get(j).get("FieldName").toString()) && fieldType.equals(comparedFieldTypeList.get(j).get("FieldType").toString())) {
                    typeEqualToSettingCount++;
                    continue;
                }
            }
        }

        return typeEqualToSettingCount == comparedFieldTypeList.size() ? true : false;
    }

    public String getSqlofRDBDataSet() throws InterruptedException {

        waitForElementVisible(viewSQLDiv);
        return viewSQLDiv.getText();
    }
}
