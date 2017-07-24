package com.bigeyedata.morttest.pages.datasource_pages;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.Page;
import cucumber.api.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

    @FindBy(css = "ul#newDataSourceDropDownMenu > li:nth-child(1)")
    WebElement localFileTypeLink;

    @FindBy(css = "ul#newDataSourceDropDownMenu > li:nth-child(2)")
    WebElement RDBTypeLink;

    @FindBy(css = "ul#newDataSourceDropDownMenu > li:nth-child(3)")
    WebElement HDFSTypeLink;

    @FindBy(css = "ul#newDataSourceDropDownMenu > li:nth-child(4)")
    WebElement ESTypeLink;

    @FindBy(xpath = "")
    WebElement dataSourceTypeSelect;

    @FindBy(xpath = "//div[@id='editDataSourceModal']//input[@id='name']")
    WebElement rdbDatasourceNameInput;

    @FindBy(xpath = "//div[@id='editDataSourceModal']//input[@id='host']")
    WebElement hostInput;

    @FindBy(xpath = "//div[@id='editDataSourceModal']//input[@id='port']")
    WebElement portInput;

    @FindBy(xpath = "//div[@id='editDataSourceModal']//input[@id='username']")
    WebElement userInput;

    @FindBy(xpath = "//div[@id='editDataSourceModal']//input[@id='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//div[@id='editDataSourceModal']//input[@id='database']")
    WebElement databaseInput;

    @FindBy(css = "div.ant-modal-footer > button:nth-child(2)")
    WebElement RDBSaveLink;

    @FindBy(css = "div > div.fields > dl > dd:nth-child(1) > input")
    WebElement hdfsDatasourceNameInput;

    @FindBy(css = "div.fields > dl > dd:nth-child(2) > div > div > div > div > div")
    WebElement hdfsTypeSelect;

    @FindBy(xpath = "//div/ul[@class='ant-select-dropdown-menu ant-select-dropdown-menu-vertical  ant-select-dropdown-menu-root']/li[last()-1]")
    WebElement hdfsParquet;


    @FindBy(xpath = "//div/ul[@class='ant-select-dropdown-menu ant-select-dropdown-menu-vertical  ant-select-dropdown-menu-root']/li[last()]")
    WebElement hadsOrc;

    @FindBy(css = "div.fields > dl > dd:nth-child(2) > div > input")
    WebElement hdfsPathInput;

    @FindBy(css = "form > div > div.buttons.clearfix > a:nth-child(4)")
    WebElement HDFSsaveLink;


    public void selectRDBType() throws InterruptedException {

        CommonFunctions.waitForElementClickable(RDBTypeLink);
        RDBTypeLink.click();
    }


    public void setRDBParameter(List<Map<String,String>> RDBConfigList) {

        rdbDatasourceNameInput.sendKeys(RDBConfigList.get(0).get("DatasourceName").toString());
        hostInput.sendKeys(RDBConfigList.get(0).get("Host").toString());
        portInput.sendKeys(RDBConfigList.get(0).get("Port").toString());
        userInput.sendKeys(RDBConfigList.get(0).get("User").toString());
        passwordInput.sendKeys(RDBConfigList.get(0).get("Password").toString());
        databaseInput.sendKeys(RDBConfigList.get(0).get("Database").toString());
    }

    public void createRDBSource(){

        RDBSaveLink.click();
    }


    public void selectHDFSType(){

        HDFSTypeLink.click();
    }

    public  void setHDFSParameter(List<Map<String,String>> HDFSConfigList) throws InterruptedException {

        hdfsDatasourceNameInput.sendKeys(HDFSConfigList.get(0).get("DatasourceName").toString());
        hdfsTypeSelect.click();
        hdfsParquet.click();
        hdfsPathInput.sendKeys(HDFSConfigList.get(0).get("Path").toString());

    }

    public void createHDFSSource(){

        HDFSsaveLink.click();

    }

}
