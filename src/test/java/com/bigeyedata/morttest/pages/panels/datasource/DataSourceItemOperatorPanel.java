package com.bigeyedata.morttest.pages.panels.datasource;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.pages.panels.specificPanel.ResourceItemOperatorSpecificPanel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.bigeyedata.morttest.CommonFunctions.findByXpath;
import static com.bigeyedata.morttest.SeeThruUtils.initPanel;

/**
 * Created by yingzhang on 20/10/2017.
 */
public class DataSourceItemOperatorPanel extends ResourceItemOperatorSpecificPanel {

    @Override
    public void selectMenuItem(String itemName) throws InterruptedException {
        switch (itemName){
            case "edit":
                itemName="编辑";
                break;
        }

        WebElement menuItem= findByXpath("//div[@class='ant-dropdown ant-dropdown-placement-bottomLeft']//li[text()='" +itemName+"']");
        CommonFunctions.waitForElementVisible(menuItem);
        menuItem.click();
    }

}
