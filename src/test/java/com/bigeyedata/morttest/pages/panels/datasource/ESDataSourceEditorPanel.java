package com.bigeyedata.morttest.pages.panels.datasource;

import com.bigeyedata.morttest.pages.panels.datasource.specificPanel.DataSourceSpecificEditorPanel;
import com.bigeyedata.morttest.types.DataSourceType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

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

    public void createESDataSource(List<Map<String,String>> ESConfigList){



    }

    public void openWanSwitch(){

        esWanSwitch.click();

    }

    @Override
    public DataSourceType dataSourceType() {
        return ES;
    }

    @Override
    public void createDataSource(List<Map<String, String>> esConfigList) throws InterruptedException {
        dataSourceNameInput.sendKeys(esConfigList.get(0).get("DataSourceName").toString());
        esNodesInput.sendKeys(esConfigList.get(0).get("Nodes").toString());
        esIndexInput.sendKeys(esConfigList.get(0).get("Index").toString());
        esTypeInput.sendKeys(esConfigList.get(0).get("Type").toString());
        esPortInput.sendKeys(esConfigList.get(0).get("Port").toString());
    }

    @Override
    public void modifyRDBDataSource(List<Map<String, String>> dbConfigList) {

    }
}
