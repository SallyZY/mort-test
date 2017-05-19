package com.bigeyedata.morttest.pages.datasource_pages;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.Page;
import cucumber.api.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yingzhang on 17/05/2017.
 */
public class DatasourceConfigPage extends Page {

    WebDriver webDriver= WebDriverManager.getDriver();

    @FindBy(css = "div.AddDataSourceTypes > div > div.AddDataSourceTypesItem:nth-child(1)")
    WebElement localFileTypeLink;

    @FindBy(css = "div.AddDataSourceTypes > div > div.AddDataSourceTypesItem:nth-child(2)")
    WebElement RDBTypeLink;

    @FindBy(css = "div.AddDataSourceTypes > div > div.AddDataSourceTypesItem:nth-child(3)")
    WebElement HDFSTypeLink;

    @FindBy(xpath = "//form/div/div[2]/dl/dd[1]/select")
    WebElement datasourceTypeSelect;

    @FindBy(xpath = "//form/div/div[2]/dl/dd[2]/input")
    WebElement datasourceNameInput;

    @FindBy(css = " div.fields > dl > div.nameInput > dd:nth-child(1) > input:nth-child(2)")
    WebElement hostInput;

    @FindBy(css = "div.fields > dl > div.nameInput > dd:nth-child(2) > input:nth-child(2)")
    WebElement portInput;

    @FindBy(css = " div.fields > dl > div.nameInput > dd:nth-child(3) > input:nth-child(2)")
    WebElement userInput;

    @FindBy(css = "div.fields > dl > div.nameInput > dd:nth-child(4) > input:nth-child(2)")
    WebElement passwordInput;

    @FindBy(css = "div.fields > dl > div.nameInput > dd:nth-child(5) > input:nth-child(2)")
    WebElement databaseInput;

    @FindBy(css = "div > form > div > div.buttons.clearfix > a:nth-child(4)")
    WebElement saveLink;

    @FindBy(css = "div.fiedls")
    WebElement rdbFieldsDiv;


    public void selectRDBType(){
        RDBTypeLink.click();
    }


    public void setRDBParameter(List<Map<String,String>> RDBConfigList){

        Select select = new Select(datasourceTypeSelect);

        select.selectByVisibleText(RDBConfigList.get(0).get("DatasourceType").toString());

        datasourceNameInput.sendKeys(RDBConfigList.get(0).get("DatasourceName").toString());
        hostInput.sendKeys(RDBConfigList.get(0).get("Host").toString());
        portInput.sendKeys(RDBConfigList.get(0).get("Port").toString());
        userInput.sendKeys(RDBConfigList.get(0).get("User").toString());
        passwordInput.sendKeys(RDBConfigList.get(0).get("Password").toString());
        databaseInput.sendKeys(RDBConfigList.get(0).get("Database").toString());

    }

    public void createRDBSource(){
        saveLink.click();
    }

}
