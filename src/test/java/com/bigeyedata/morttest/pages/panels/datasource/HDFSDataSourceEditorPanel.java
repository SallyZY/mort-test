package com.bigeyedata.morttest.pages.panels.datasource;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.pages.panels.datasource.specificPanel.DataSourceSpecificEditorPanel;
import com.bigeyedata.morttest.types.DataSourceType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

import static com.bigeyedata.morttest.CommonFunctions.fillData;
import static com.bigeyedata.morttest.CommonFunctions.findByXpath;
import static com.bigeyedata.morttest.types.DataSourceType.HDFS;

/**
 * Created by yingzhang on 19/10/2017.
 */
public class HDFSDataSourceEditorPanel extends DataSourceSpecificEditorPanel {
    @FindBy(xpath = "//div[@id='editDataSourceModal']//input[@id='name']")
    WebElement dataSourceNameInput;

    @FindBy(xpath = "//div[@id='editDataSourceModal']//input[@id='path']")
    WebElement hdfsPathInput;

    @FindBy(xpath = "//div[@class='ant-select-lg ant-select ant-select-enabled']")
    WebElement dataSourceTypeSelect;

    private void selectDataSourceType(String typeName) throws InterruptedException {
        dataSourceTypeSelect.click();
        WebElement dataSourceType = findByXpath("//div/ul[@class='ant-select-dropdown-menu ant-select-dropdown-menu-vertical  ant-select-dropdown-menu-root']/li[text()='" + typeName + "']");
        CommonFunctions.waitForElementVisible(dataSourceType);
        dataSourceType.click();
    }

    @Override
    public DataSourceType dataSourceType() {
        return HDFS;
    }

    @Override
    public void createDataSource(Map<String, String> hdfsConfigList) throws InterruptedException {
        fillData(hdfsConfigList, keysMap());
        selectDataSourceType(hdfsConfigList.get("DataSourceType").toString());
    }

    private Map<String,WebElement> keysMap() {
        Map<String, WebElement> map = new HashMap();
        map.put("DataSourceName", dataSourceNameInput);
        map.put("FileName", hdfsPathInput);

        return map;
    }

    @Override
    public void modifyRDBDataSource(Map<String, String> dbConfigList) {

    }
}
