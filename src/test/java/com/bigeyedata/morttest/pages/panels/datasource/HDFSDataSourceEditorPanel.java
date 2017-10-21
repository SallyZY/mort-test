package com.bigeyedata.morttest.pages.panels.datasource;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.pages.panels.datasource.specificPanel.DataSourceSpecificEditorPanel;
import com.bigeyedata.morttest.types.DataSourceType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

import static com.bigeyedata.morttest.CommonFunctions.findByXpath;
import static com.bigeyedata.morttest.CommonFunctions.getTestResourceFilePath;
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

    public void createHDFSDataSource(List<Map<String,String>> HDFSConfigList) throws InterruptedException {

        dataSourceNameInput.sendKeys(HDFSConfigList.get(0).get("DataSourceName").toString().trim());
//        hdfsPathInput.sendKeys(HDFSConfigList.get(0).get("Path").toString());
        selectDataSourceType(HDFSConfigList.get(0).get("DataSourceType").toString());
        hdfsPathInput.sendKeys(getTestResourceFilePath(HDFSConfigList.get(0).get("FileName").toString()));

    }

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
}
