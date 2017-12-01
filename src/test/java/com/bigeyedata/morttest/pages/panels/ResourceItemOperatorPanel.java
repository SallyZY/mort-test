package com.bigeyedata.morttest.pages.panels;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.pages.Panel;
import com.bigeyedata.morttest.pages.panels.datasource.DataSourceItemOperatorPanel;
import com.bigeyedata.morttest.pages.panels.specificPanel.ResourceItemOperatorSpecificPanel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.bigeyedata.morttest.SeeThruUtils.initPanel;

/**
 * Created by yingzhang on 20/10/2017.
 */
public class ResourceItemOperatorPanel implements Panel {
    @FindBy(css = "#resourceListMenuContainerMenu > li.ant-menu-item-selected.ant-menu-item > div > span > span.item-right")
    WebElement dataSourceMenuIcon;

    private ResourceItemOperatorSpecificPanel operatorSpecificPanel;

    public void displayDataSourceOperatorMenu() throws InterruptedException {
        CommonFunctions.waitForElementVisible(dataSourceMenuIcon);
        dataSourceMenuIcon.click();
        operatorSpecificPanel=initPanel(DataSourceItemOperatorPanel.class);
    }

    public <T extends ResourceItemOperatorSpecificPanel> T specificOperatorPanel(){
        return (T)operatorSpecificPanel;
    }
}
