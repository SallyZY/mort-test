package com.bigeyedata.morttest.pages.panels.datasource;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.pages.Panel;
import com.bigeyedata.morttest.pages.panels.datasource.specificPanel.DataSourceSpecificEditorPanel;
import com.bigeyedata.morttest.types.DataSourceType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

import static com.bigeyedata.morttest.SeeThruUtils.initPanel;
import static com.bigeyedata.morttest.types.DataSourceType.ES;
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

    public void selectDataSourceType(DataSourceType selectType) throws InterruptedException {
        dataSourceType = selectType;

        PanelInfo panelInfo = mapInfo().get(selectType);
        CommonFunctions.waitForElementVisible(panelInfo.typeLink);
        panelInfo.typeLink.click();
        editorPanel = initPanel(panelInfo.panel);
    }

    public void confirmCreateDataSource(){
        DataSourceSaveButton.click();
    }

    public <T extends DataSourceSpecificEditorPanel> T specificEditorPanel() {
        return (T)editorPanel;
    }

    private class PanelInfo {
        WebElement typeLink;
        Class<? extends DataSourceSpecificEditorPanel> panel;

        public PanelInfo(WebElement typeLink, Class<? extends DataSourceSpecificEditorPanel> panel) {
            this.typeLink = typeLink;
            this.panel = panel;
        }
    }

    private Map<DataSourceType, PanelInfo> mapInfo() {
        Map<DataSourceType, PanelInfo> map = new HashMap();
        map.put(RDB, new PanelInfo(RDBTypeLink, RDBDataSourceEditorPanel.class));
        map.put(HDFS, new PanelInfo(HDFSTypeLink, HDFSDataSourceEditorPanel.class));
        map.put(ES, new PanelInfo(ESTypeLink, ESDataSourceEditorPanel.class));

        return map;
    }
}
