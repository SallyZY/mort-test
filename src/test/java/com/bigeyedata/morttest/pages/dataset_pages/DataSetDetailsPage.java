package com.bigeyedata.morttest.pages.dataset_pages;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

import static com.bigeyedata.morttest.CommonFunctions.refresh;
import static com.bigeyedata.morttest.CommonFunctions.waitForElementVisible;

/**
 * Created by yingzhang on 12/05/2017.
 */
public class DataSetDetailsPage extends Page {

    @FindBy(xpath = "//div[@role='tab'][1]")
    WebElement fieldTab;

    @FindBy(xpath = "//div[@role='tab'][2]")
    WebElement dataPreviewTab;

    @FindBy(xpath = "//div[@role='tab'][3]")
    WebElement relatedReportTab;

    @FindBy(xpath = "//div[@role='tab'][5]")
    WebElement importHistoryTab;

    @FindBy(xpath = "//div[@id='fieldsDisplay']//table")
    WebElement FieldAttributeTable;

    @FindBy(xpath = "//div[@id='dataSetImportHistory']//table")
    WebElement importHistoryTable;

    @FindBy(id = "dataSetOtherOperationMenu")
    WebElement otherOperationMenu;

    @FindBy(css = "#dataSource > a")
    WebElement locateToDatasourceMenuItem;

    @FindBy(id = "appendFieldsButton")
    WebElement modifySQLMenuItem;

    @FindBy(css = "ul#dataSetAllMenu > li:nth-child(3)")
    WebElement appendDataMenuItem;

    @FindBy(css = "#checkSqlButton")
    WebElement checkSqlMenuItem;

    @FindBy(id = "showJoinDataSet")
    WebElement showJoinDataSetMenuItem;

//    @FindBy(css = "#brace-editor > div.ace_scroller > div")
//    WebElement viewSql;


    @FindBy(xpath = "//*[@id='brace-editor']//div[@class='ace_line']")
    WebElement viewSQLDiv;

    @FindBy(id = "addNewReport")
    WebElement addNewReportButton;

    @FindBy(css = "#resourceListMenuContainerMenu > li.ant-menu-item-selected.ant-menu-item > div > span > span.item-left > span > input")
    WebElement dataSetNameInput;

    @FindBy(css = "#resourceListMenuContainerMenu > li.ant-menu-item-selected.ant-menu-item > div > span > span.item-right > i.iconfont.icon-vertical-menu.operation-menu-trigger.ant-dropdown-trigger")
    WebElement operationMenuIcon;

    @FindBy(css = "#resourceListMenuContainerMenu > li.ant-menu-item-selected.ant-menu-item > div > span > span.item-right")
    WebElement operationMenuspan;

//    @FindBy(css = "body > div:nth-child(10) > div > div > ul > li:nth-child(1)")
    @FindBy(css = "ul.ant-dropdown-menu.ant-dropdown-menu-vertical.data-sets-resource-list-item-operation-menu.ant-dropdown-menu-light.ant-dropdown-menu-root > li:nth-child(1)")
    WebElement reNameIcon;

    @FindBy(css = "#fieldsDisplay > div > div > div > div > div > div > table")
    WebElement FieldViewTable;

    @FindBy(css = "div.ant-popover-inner > div > div.ant-popover-inner-content > div > input")
    WebElement fieldsAliasInput;

    @FindBy(css = "div.ant-popover-inner > div > div.ant-popover-inner-content > div > div > button.ant-btn.ant-btn-primary.ant-btn-sm > span")
    WebElement fieldsAliasConfirmButton;

    @FindBy(tagName = "tbody")
    WebElement fieldViewTbody;

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
            case "ModifySQL":
                waitForElementVisible(modifySQLMenuItem);
                modifySQLMenuItem.click();
                break;
            case "ViewSql":
                waitForElementVisible(checkSqlMenuItem);
                checkSqlMenuItem.click();
                break;
            case "showJoinDataSet":
                waitForElementVisible(showJoinDataSetMenuItem);
                showJoinDataSetMenuItem.click();
                break;

        }
    }

    public void createNewReport() throws InterruptedException {

        waitForElementVisible(addNewReportButton);
        addNewReportButton.click();
    }

    public int getFieldCountOfDataset() {
        List<WebElement> trList = FieldAttributeTable.findElements(By.cssSelector("tbody > tr"));
        return trList.size();
    }

    public String getSqlofRDBDataSet() throws InterruptedException {

        waitForElementVisible(viewSQLDiv);
        return viewSQLDiv.getText();
    }


    public void reNameDataSet(String newName) throws InterruptedException {
        CommonFunctions.mouseOverAtCoordinates(operationMenuspan,18,21);
        CommonFunctions.waitForElementVisible(operationMenuIcon);
        operationMenuIcon.click();
        CommonFunctions.waitForElementVisible(reNameIcon);
        reNameIcon.click();
        dataSetNameInput.clear();
        dataSetNameInput.sendKeys(newName);
        dataSetNameInput.sendKeys(Keys.ENTER);
    }

    public void modifyFieldAlias(String fieldsAlias) throws InterruptedException {

        CommonFunctions.waitForElementVisible(FieldViewTable);

        WebElement CDate = FieldViewTable.findElement(By.cssSelector("tbody > tr:nth-child(1) > td:nth-child(2)"));


        CommonFunctions.mouseOverAtCoordinates(CDate,30,15);
        CDate.findElement(By.cssSelector("div > i")).click();
        CommonFunctions.waitForElementVisible(fieldsAliasInput);
        fieldsAliasInput.clear();
        fieldsAliasInput.sendKeys(fieldsAlias);
        CommonFunctions.waitForShortTime();
        fieldsAliasConfirmButton.click();

        refresh();
    }

    public String getFieldAlias() throws InterruptedException {
        waitForElementVisible(FieldViewTable);
        return FieldViewTable.findElement(By.cssSelector("tbody > tr:nth-child(1) > td:nth-child(2)")).getText();
    }

    public boolean getFieldList(String name){
        List<WebElement> fieldList = fieldViewTbody.findElements(By.tagName("tr"));
        boolean flg = false;
        for(int i=0;i<fieldList.size();i++){
            fieldList.get(i).getText();
            int n= i+1;
            String aliasName =  fieldViewTbody.findElement(By.xpath("tr[" + n + "]/td[2]/div/span")).getText();
            if(aliasName.equals(name)){
                flg = true;
                break;
            }
        }
        return flg;


    }

}
