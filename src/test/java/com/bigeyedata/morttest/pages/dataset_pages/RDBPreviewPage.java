package com.bigeyedata.morttest.pages.dataset_pages;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by liaoyuxue on 2017/6/1.
 */
public class RDBPreviewPage extends Page {

    @FindBy(css = "div#addDataSetAlive > div > label:nth-child(1) > span.ant-radio > input")
    WebElement importRadio;

    @FindBy(css = "div#addDataSetAlive > div > label:nth-child(2) > span.ant-radio > input")
//    @FindBy(xpath = "//*[@id=\"addDataSetAlive\"]/div/label[2]/span[1]/input")
    WebElement directConnectionRadio;

    @FindBy(id = "brace-editor")
    WebElement sqlTexDiv;

    @FindBy(css = "#brace-editor > textarea")
    WebElement sqlTextarea;

    @FindBy(id = "addDataSetRdbSqlBoxButton")
    WebElement sqlPreviewButton;

    @FindBy(css = "#addDataSetPolicyImportType > div > label:nth-child(1) > span.ant-radio > input")
    WebElement immediatelyImportRadio;

    @FindBy(css = "#addDataSetPolicyImportType > div > label:nth-child(2) > span.ant-radio > input")
    WebElement customizeRadio;

    @FindBy(id = "createDataSetNextStep")
    WebElement nextStepbutton;

    @FindBy(xpath = "//div[@class='import-policy-form-bar']//span[@class='ant-calendar-picker']//input")
    WebElement triggerCalenderInput;

    @FindBy(css = "div.ant-calendar-input-wrap > div > input")
    WebElement importDateInput;

//    @FindBy(css = "div.inline-block.form-control > span.ant-time-picker > input")
    @FindBy(css = "div.inline-block.form-control > span.ant-time-picker > span")
    WebElement triggerTimeInput;

    @FindBy(css = "div.ant-time-picker-panel-input-wrap > input")
    WebElement importTimeInput;

    @FindBy(css = "table")
    WebElement FieldAttributeTable;

    @FindBy(css = "#app > div > div.DefaultLayout > div.resource-page > div:nth-child(3) > div > div.resource-action-bar.clearfix > div.title")
    WebElement recordNumberText;

    @FindBy(id = "addDataSetName")
    WebElement dataSetNameInput;

    @FindBy(css = "div.directory-selector > span.ant-select.ant-select-disabled")
    WebElement dataSetDirectorySpan;

    @FindBy(css = "#addDataSetPreview > div > div > div > div > div > div > div > table")
    WebElement FieldViewTable;

    public void setDataSetConnectionMode(String importMode){

        switch (importMode){
            case "导入":
                importRadio.click();
                break;
            case "直连":
                directConnectionRadio.click();
                break;
        }

    }

    public void inputPreviewSQL(String sql) throws InterruptedException {

        CommonFunctions.waitForElementVisible(sqlTexDiv);
        sqlTextarea.clear();
        sqlTextarea.sendKeys(sql);
    }

    public void clickPreviewButton() throws Throwable {

        sqlPreviewButton.click();
        CommonFunctions.waitForElementVisibleAndLocated(By.cssSelector("#addDataSetPreview > div > div > div > div > div > div > div > table"));
    }

    public void setDataSetImportMode(String importMode){
        switch (importMode){
            case"立即导入":
                immediatelyImportRadio.click();
                break;
            case "自定义":
                customizeRadio.click();
                break;
        }

    }


    public  void setCustomizeImportDate() throws InterruptedException {

        String[] str=CommonFunctions.customizeImportDate().split("\\s+");

        triggerCalenderInput.click();
        CommonFunctions.waitForElementVisible(importDateInput);
        importDateInput.click();
        importDateInput.sendKeys(str[0]);

        triggerTimeInput.click();
        CommonFunctions.waitForElementVisible(importTimeInput);
        importTimeInput.click();
        System.out.println(str[1]);
        importTimeInput.sendKeys(str[1]);
    }



    public boolean isFieldTypeOfDataSetEditable()throws InterruptedException {

        CommonFunctions.waitForElementVisibleAndLocated(By.cssSelector("table"));
        List<WebElement> fieldTypeList = FieldAttributeTable.findElements(By.xpath("//div[@class='DataSetFieldsEditorField']//select"));

        return fieldTypeList.size() > 0 ? true : false;
    }

    public boolean isFieldTypeSelectDisplayed()throws InterruptedException {

        CommonFunctions.waitForElementVisibleAndLocated(By.cssSelector("table"));
        List<WebElement> fieldTypeList = FieldAttributeTable.findElements(By.xpath("//div[@class='DataSetFieldsEditorField']/div/div/span"));

        return fieldTypeList.size() > 0 ? true : false;
    }

    public boolean assertRecordNumber(){
        boolean flg = recordNumberText.getText().contains("条记录");
        if(flg){
            flg = false;
        }else {
            flg = true;
        }
        return flg;

    }


    public boolean isDataSetNameEnabled(){

        return dataSetNameInput.isEnabled();
    }

    public boolean isDataSetSavedDirectoryEnabled(){
        return !dataSetDirectorySpan.isDisplayed();
    }

    public int countDisabledFieldsAlias()throws InterruptedException {

        CommonFunctions.waitForElementVisibleAndLocated(By.cssSelector("#addDataSetPreview > div > div > div > div > div > div > div > table"));

        List<WebElement> fieldAliasInputList = FieldViewTable.findElements(By.cssSelector("div.DataSetFieldsEditorField > div > input"));

        int count=0;
        boolean flg;
        for(int i=0;i<fieldAliasInputList.size();i++){
            flg = fieldAliasInputList.get(i).isEnabled();
            if (!flg){
                count++;
            }
        }
        return count;
    }


    public int countDisabledFieldsType()throws InterruptedException {

        CommonFunctions.waitForElementVisibleAndLocated(By.cssSelector("#addDataSetPreview > div > div > div > div > div > div > div > table"));

        List<WebElement> fieldTypeSelectList = FieldViewTable.findElements(By.cssSelector("div.DataSetFieldsEditorField > div > select"));

        int count = 0;
        boolean flg;
        for (int i = 0; i < fieldTypeSelectList.size(); i++) {
            flg = fieldTypeSelectList.get(i).isEnabled();
            if (!flg) {
                count++;
            }
        }
        return count;
    }
}
