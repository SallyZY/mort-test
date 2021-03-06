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

import static com.bigeyedata.morttest.CommonFunctions.getTestResourceFilePath;

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

    @FindBy(xpath = "//div[@id='editDataSourceModal']//input[@id='name']")
    WebElement dataSourceNameInput;

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
    WebElement DataSourceSaveButton;

    @FindBy(xpath = "//div[@class='ant-select-lg ant-select ant-select-enabled']")
    WebElement dataSourceTypeSelect;

    @FindBy(xpath = "//div[@id='editDataSourceModal']//input[@id='path']")
    WebElement hdfsPathInput;

    @FindBy(id = "nodes")
    WebElement esNodesInput;

    @FindBy(id = "index")
    WebElement esIndexInput;

    @FindBy(id = "_type")
    WebElement esTypeInput;

    @FindBy(id = "port")
    WebElement esPortInput;

    @FindBy(id = "wan")
    WebElement esWanSwitch;



    public void selectRDBType() throws InterruptedException {

        CommonFunctions.waitForElementClickable(RDBTypeLink);
        RDBTypeLink.click();
    }


    public void selectESType() {
        CommonFunctions.waitForElementVisible(ESTypeLink);
        ESTypeLink.click();
    }


    public void setRDBParameter(List<Map<String,String>> RDBConfigList) throws InterruptedException {

        dataSourceNameInput.sendKeys(RDBConfigList.get(0).get("DataSourceName").toString());
        hostInput.sendKeys(RDBConfigList.get(0).get("Host").toString());
        portInput.sendKeys(RDBConfigList.get(0).get("Port").toString());
        userInput.sendKeys(RDBConfigList.get(0).get("User").toString());
        passwordInput.sendKeys(RDBConfigList.get(0).get("Password").toString());
        databaseInput.sendKeys(RDBConfigList.get(0).get("Database").toString());
        selectDataSourceType(RDBConfigList.get(0).get("DataSourceType").toString());
    }

    public void modifyRDBParameter(List<Map<String,String>> RDBConfigList) throws InterruptedException {
        dataSourceNameInput.clear();
        dataSourceNameInput.sendKeys(RDBConfigList.get(0).get("DataSourceName").toString());
        hostInput.clear();
        hostInput.sendKeys(RDBConfigList.get(0).get("Host").toString());
        portInput.clear();
        portInput.sendKeys(RDBConfigList.get(0).get("Port").toString());
        userInput.clear();
        userInput.sendKeys(RDBConfigList.get(0).get("User").toString());
        passwordInput.clear();
        passwordInput.sendKeys(RDBConfigList.get(0).get("Password").toString());
    }



    public void createDataSource(){
        DataSourceSaveButton.click();
    }


    public void selectHDFSType(){
        HDFSTypeLink.click();
    }

    public void setHDFSParameter(List<Map<String,String>> HDFSConfigList) throws InterruptedException {

        dataSourceNameInput.sendKeys(HDFSConfigList.get(0).get("DataSourceName").toString().trim());
//        hdfsPathInput.sendKeys(HDFSConfigList.get(0).get("Path").toString());
        selectDataSourceType(HDFSConfigList.get(0).get("DataSourceType").toString());
        hdfsPathInput.sendKeys(getTestResourceFilePath(HDFSConfigList.get(0).get("FileName").toString()));

    }

    private void selectDataSourceType(String typeName)  {

        dataSourceTypeSelect.click();
        WebElement dataSourceType = WebDriverManager.getDriver().findElement(By.xpath("//div/ul[@class='ant-select-dropdown-menu ant-select-dropdown-menu-vertical  ant-select-dropdown-menu-root']/li[text()='" + typeName + "']"));
        CommonFunctions.waitForElementVisible(dataSourceType);
        dataSourceType.click();
    }

    public void setESParameter(List<Map<String,String>> ESConfigList){

        dataSourceNameInput.sendKeys(ESConfigList.get(0).get("DataSourceName").toString());
        esNodesInput.sendKeys(ESConfigList.get(0).get("Nodes").toString());
        esIndexInput.sendKeys(ESConfigList.get(0).get("Index").toString());
        esTypeInput.sendKeys(ESConfigList.get(0).get("Type").toString());
        esPortInput.sendKeys(ESConfigList.get(0).get("Port").toString());

    }

    public void openWanSwitch(){

        esWanSwitch.click();

    }

}
