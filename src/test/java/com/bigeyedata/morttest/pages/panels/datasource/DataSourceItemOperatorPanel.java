package com.bigeyedata.morttest.pages.panels.datasource;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.pages.panels.ResourceItemOperatorPanel;
import org.openqa.selenium.WebElement;

import static com.bigeyedata.morttest.CommonFunctions.findByXpath;

/**
 * Created by yingzhang on 20/10/2017.
 */
public class DataSourceItemOperatorPanel extends ResourceItemOperatorPanel {

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
