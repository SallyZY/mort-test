package com.bigeyedata.morttest.pages.panels.datasource;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.pages.Panel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by yingzhang on 19/10/2017.
 */
public class RDBDataSourceDetailPanel implements Panel {

    @FindBy(css = "#app > div > div.DefaultLayout > div.resource-page > div > div.ant-layout > div > div > div.ant-layout > div > div > div.data-source-config > div > div > div > div > div > div > table > tbody")
    WebElement dataSourceDetailInfoTbody;

    public String getRDBParameter() throws InterruptedException {
        CommonFunctions.waitForElementVisible(dataSourceDetailInfoTbody);
        return dataSourceDetailInfoTbody.getText();
    }




//    String rdbParameter = ((DataSourcePage)currentPage()).rdbDetailPanel.getRDBParameter();
//    assertTrue(rdbParameter.contains(RDBConfigList.get(0).get("Host")));
//    assertTrue(rdbParameter.contains(RDBConfigList.get(0).get("Port")));
//    assertTrue(rdbParameter.contains(RDBConfigList.get(0).get("User")));
//    assertTrue(rdbParameter.contains(RDBConfigList.get(0).get("DataSourceType")));
//    assertTrue(rdbParameter.contains(RDBConfigList.get(0).get("Database")));
}

