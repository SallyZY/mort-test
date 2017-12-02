package com.bigeyedata.morttest.pages.panels.dataset;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.pages.Panel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.bigeyedata.morttest.CommonFunctions.mouseOverAtCoordinates;
import static com.bigeyedata.morttest.CommonFunctions.waitForElementVisible;

/**
 * Created by yingzhang on 17/11/2017.
 */
public class SourceItemMenuPanel implements Panel {

    @FindBy(css = "#resourceListMenuContainerMenu > li.ant-menu-item-selected.ant-menu-item > div > span > span.item-right")
    WebElement operationMenuspan;

    @FindBy(css = "#resourceListMenuContainerMenu > li.ant-menu-item-selected.ant-menu-item > div > span > span.item-right > i.iconfont.icon-vertical-menu.operation-menu-trigger.ant-dropdown-trigger")
    WebElement operationMenuIcon;

    @FindBy(xpath = "//div/ul/li[text()='删除']")
    WebElement deleteIcon;

    @FindBy(xpath = "//button/span[text()='确 定']")
    WebElement confirmButton;


    public void deleteDataSet() {
        mouseOverAtCoordinates(operationMenuspan,18,21);
        waitForElementVisible(operationMenuIcon);
        operationMenuIcon.click();
        waitForElementVisible(deleteIcon);
        deleteIcon.click();
        waitForElementVisible(confirmButton);
        confirmButton.click();
    }
}
