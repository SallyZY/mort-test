package com.bigeyedata.morttest.pages.panels.datasource;

import com.bigeyedata.morttest.pages.panels.datasource.specificPanel.DataSourceSpecificEditorPanel;
import com.bigeyedata.morttest.types.DataSourceType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.bigeyedata.morttest.CommonFunctions.fillData;
import static com.bigeyedata.morttest.types.DataSourceType.ES;

/**
 * Created by yingzhang on 21/10/2017.
 */
public class ESDataSourceEditorPanel extends DataSourceSpecificEditorPanel {
    @FindBy(xpath = "//div[@id='editDataSourceModal']//input[@id='name']")
    WebElement dataSourceNameInput;

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

    public void openWanSwitch(){

        esWanSwitch.click();

    }

    @Override
    public DataSourceType dataSourceType() {
        return ES;
    }


    @Override
    public void createDataSource(Map<String, String> esConfigList) throws InterruptedException {
        fillData(esConfigList,keysMap());
    }

    private Map<String,WebElement> keysMap() {
        Map<String, WebElement> map = new HashMap();
        map.put("DataSourceName", dataSourceNameInput);
        map.put("Nodes", esNodesInput);
        map.put("Index", esIndexInput);
        map.put("Type", esTypeInput);
        map.put("Port", esPortInput);

        return map;
    }

    @Override
    public void modifyRDBDataSource(Map<String, String> dbConfigList) {

    }
}
