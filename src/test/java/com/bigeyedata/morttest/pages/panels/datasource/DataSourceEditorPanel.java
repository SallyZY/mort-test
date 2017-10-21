package com.bigeyedata.morttest.pages.panels.datasource;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.pages.Panel;
import com.bigeyedata.morttest.pages.panels.datasource.specificPanel.DataSourceSpecificEditorPanel;
import com.bigeyedata.morttest.types.DataSourceType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.bigeyedata.morttest.SeeThruUtils.initPanel;
import static com.bigeyedata.morttest.types.DataSourceType.HDFS;
import static com.bigeyedata.morttest.types.DataSourceType.RDB;

/**
 * Created by yingzhang on 19/10/2017.
 */
public class DataSourceEditorPanel extends Panel {

    @FindBy(id = "addNewDataSourceLink")
    WebElement createNewDataResourceLink;

    @FindBy(id = "newDataSourceDropDownMenu")
    WebElement dataSourceTypeUl;

    @FindBy(xpath = "//ul[@id='newDataSourceDropDownMenu']//span[text()='RDB']")
    WebElement RDBTypeLink;

    @FindBy(xpath = "//ul[@id='newDataSourceDropDownMenu']//span[text()='HDFS']")
    WebElement HDFSTypeLink;

    @FindBy(xpath = "//ul[@id='newDataSourceDropDownMenu']//span[text()='ES']")
    WebElement ESTypeLink;

    @FindBy(css = "div.ant-modal-footer > button:nth-child(2)")
    WebElement DataSourceSaveButton;

    private DataSourceType dataSourceType;

    private DataSourceSpecificEditorPanel editorPanel;

    public void createNewDataResource() throws InterruptedException {
        createNewDataResourceLink.click();
        CommonFunctions.waitForElementVisible(dataSourceTypeUl);
    }

    public void selectRDBType() throws InterruptedException {
        dataSourceType = RDB;
        CommonFunctions.waitForElementClickable(RDBTypeLink);
        RDBTypeLink.click();
        editorPanel = initPanel(RDBDataSourceEditorPanel.class);
    }

    public void selectHDFSType(){
        dataSourceType = HDFS;
        HDFSTypeLink.click();
        editorPanel = initPanel(HDFSDataSourceEditorPanel.class);
    }

    public void selectESType() throws InterruptedException {
        CommonFunctions.waitForElementVisible(ESTypeLink);
        ESTypeLink.click();
    }

    public void confirmCreateDataSource(){
        DataSourceSaveButton.click();
    }

    public <T extends DataSourceSpecificEditorPanel> T specificEditorPanel() {
        return (T)editorPanel;
    }
}
