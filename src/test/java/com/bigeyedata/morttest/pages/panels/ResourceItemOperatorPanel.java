package com.bigeyedata.morttest.pages.panels;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.pages.Panel;
import com.bigeyedata.morttest.pages.panels.datasource.DataSourceItemOperatorPanel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.bigeyedata.morttest.SeeThruUtils.initPanel;

/**
 * Created by yingzhang on 20/10/2017.
 */
public class ResourceItemOperatorPanel extends Panel {
    @FindBy(css = "#resourceListMenuContainerMenu > li.ant-menu-item-selected.ant-menu-item > div > span > span.item-right")
    WebElement dataSourceMenuIcon;

    private ResourceItemOperatorPanel operatorPanelPanel;

    public void showDataSourceOperatorMenu() throws InterruptedException {
        CommonFunctions.waitForElementVisible(dataSourceMenuIcon);
        dataSourceMenuIcon.click();
        operatorPanelPanel = initPanel(DataSourceItemOperatorPanel.class);
    }

//    public void showDataSetOperatorMenu(){}
//
//    public void showReportOperatorMenu(){}


    public <T extends ResourceItemOperatorPanel> T specificOperatorPanel(){
        return (T) operatorPanelPanel;
    }
}
