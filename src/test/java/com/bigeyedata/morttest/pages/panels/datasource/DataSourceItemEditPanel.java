package com.bigeyedata.morttest.pages.panels.datasource;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.pages.panels.SourceItemEditPanel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.bigeyedata.morttest.CommonFunctions.getElementByXpath;

/**
 * Created by yingzhang on 20/10/2017.
 */
public class DataSourceItemEditPanel extends SourceItemEditPanel {
    @FindBy(css = "#resourceListMenuContainerMenu > li.ant-menu-item-selected.ant-menu-item > div > span > span.item-right")
    WebElement operationMenuIcon;

    public void showEditMenu() throws InterruptedException {
        CommonFunctions.waitForElementVisible(operationMenuIcon);
        operationMenuIcon.click();
    }

}
