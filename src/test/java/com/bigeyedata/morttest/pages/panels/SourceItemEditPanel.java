package com.bigeyedata.morttest.pages.panels;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.pages.Panel;
import org.openqa.selenium.WebElement;

import static com.bigeyedata.morttest.CommonFunctions.getElementByXpath;

/**
 * Created by yingzhang on 20/10/2017.
 */
public class SourceItemEditPanel extends Panel {

    public void selectMenuItem(String itemName) throws InterruptedException {
        switch (itemName){
            case "edit":
                itemName="编辑";
                break;
        }

        WebElement menuItem= getElementByXpath("//div[@class='ant-dropdown ant-dropdown-placement-bottomLeft']//li[text()='" +itemName+"']");
        CommonFunctions.waitForElementVisible(menuItem);
        menuItem.click();
    }
}
