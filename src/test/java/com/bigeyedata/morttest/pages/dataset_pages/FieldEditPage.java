package com.bigeyedata.morttest.pages.dataset_pages;

import com.bigeyedata.morttest.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

import static com.bigeyedata.morttest.CommonFunctions.waitForElementVisibleAndLocated;

/**
 * Created by yingzhang on 11/05/2017.
 */
public class FieldEditPage extends Page {

    @FindBy(css = "#addDataSetPreview > div > div > div > div > div > div > div > table")
    WebElement FieldViewTable;

    @FindBy(id = "createDataSetNextStep")
    WebElement nextStepButton;

    public void setFieldsAlias(List<Map<String,String>> fieldsAliasList) throws InterruptedException {

        waitForElementVisibleAndLocated(By.cssSelector("#addDataSetPreview > div > div > div > div > div > div > div > table"));


        List<WebElement> fieldNameLabelList = FieldViewTable.findElements(By.cssSelector("div.DataSetFieldsEditorField > span"));
        List<WebElement> fieldAliasInputList = FieldViewTable.findElements(By.cssSelector("div.DataSetFieldsEditorField > div > input"));

        String fieldName = "";
        String fieldAlias = "";
        for (int i = 0; i < fieldsAliasList.size(); i++) {
            fieldName = fieldsAliasList.get(i).get("FieldName").toString();

            for (int j=0; j<fieldNameLabelList.size();j++){
                if(fieldName.equals(fieldNameLabelList.get(j).getText())){
                    fieldAlias = fieldsAliasList.get(i).get("AliasName").toString();
                    fieldAliasInputList.get(j).clear();
                    fieldAliasInputList.get(j).sendKeys(fieldAlias);
                    break;
                }
            }
        }
    }

    public void setFieldsType(List<Map<String, String>> FieldTypeList){

        List<WebElement> fieldNameLabelList = FieldViewTable.findElements(By.cssSelector("div.DataSetFieldsEditorField > span"));
        List<WebElement> fieldTypeSelectList = FieldViewTable.findElements(By.cssSelector("div.DataSetFieldsEditorField > div > select"));

        String fieldName = "";
        String fieldType = "";
        Select select;
        for (int i = 0; i < FieldTypeList.size(); i++) {
            fieldName = FieldTypeList.get(i).get("FieldName").toString();

            for (int j=0; j<fieldTypeSelectList.size();j++){
                if(fieldName.equals(fieldNameLabelList.get(j).getText())){
                    fieldType=FieldTypeList.get(i).get("FieldType").toString();
                    select = new Select(fieldTypeSelectList.get(j));
                    select.selectByVisibleText(fieldType);
                    break;
                }
            }
        }
    }

    public void gotoNextPage(){

        nextStepButton.click();
    }



}
