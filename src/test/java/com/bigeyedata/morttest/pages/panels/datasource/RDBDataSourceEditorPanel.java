package com.bigeyedata.morttest.pages.panels.datasource;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.panels.datasource.specificPanel.DataSourceSpecificEditorPanel;
import com.bigeyedata.morttest.types.DataSourceType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.bigeyedata.morttest.CommonFunctions.fillData;
import static com.bigeyedata.morttest.CommonFunctions.findByXpath;
import static com.bigeyedata.morttest.types.DataSourceType.RDB;

/**
 * Created by yingzhang on 19/10/2017.
 */
public class RDBDataSourceEditorPanel extends DataSourceSpecificEditorPanel {

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

    public void createRDBDataSource(List<Map<String, String>> RDBConfigList) throws InterruptedException {
        dataSourceNameInput.sendKeys(RDBConfigList.get(0).get("DataSourceName").toString());
        hostInput.sendKeys(RDBConfigList.get(0).get("Host").toString());
        portInput.sendKeys(RDBConfigList.get(0).get("Port").toString());
        userInput.sendKeys(RDBConfigList.get(0).get("User").toString());
        passwordInput.sendKeys(RDBConfigList.get(0).get("Password").toString());
        databaseInput.sendKeys(RDBConfigList.get(0).get("Database").toString());
        selectDataSourceType(RDBConfigList.get(0).get("DataSourceType").toString());
    }


    private void selectDataSourceType(String typeName) throws InterruptedException {
        dataSourceTypeSelect.click();
        WebElement dataSourceType = findByXpath("//div/ul[@class='ant-select-dropdown-menu ant-select-dropdown-menu-vertical  ant-select-dropdown-menu-root']/li[text()='" + typeName + "']");
        CommonFunctions.waitForElementVisible(dataSourceType);
        dataSourceType.click();
    }

    @Override
    public DataSourceType dataSourceType() {
        return RDB;
    }

    @Override
    public void createDataSource(Map<String, String> rdbConfigList) throws InterruptedException {
        fillData(rdbConfigList, keysMap());
        selectDataSourceType(rdbConfigList.get("DataSourceType").toString());
    }

    private Map<String, WebElement> keysMap() {
        Map<String, WebElement> map = new HashMap();
        map.put("DataSourceName", dataSourceNameInput);
        map.put("Host", hostInput);
        map.put("Port", portInput);
        map.put("User", userInput);
        map.put("Password", passwordInput);
        map.put("Database", databaseInput);

        return map;
    }

    @Override
    public void modifyRDBDataSource(Map<String, String> RDBConfigList) {
        fillData(RDBConfigList, keysMap());
    }
}
