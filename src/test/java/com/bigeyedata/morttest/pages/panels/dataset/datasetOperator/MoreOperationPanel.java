package com.bigeyedata.morttest.pages.panels.dataset.datasetOperator;

import com.bigeyedata.morttest.pages.Panel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

import static com.bigeyedata.morttest.CommonFunctions.waitForElementVisible;
import static com.bigeyedata.morttest.SeeThruUtils.initPanel;

/**
 * Created by yingzhang on 28/11/2017.
 */
public class MoreOperationPanel extends Panel {
    @FindBy(id = "dataSetOtherOperationMenu")
    WebElement otherOperationMenu;

    @FindBy(id = "showJoinDataSet")
    WebElement editJoinDataSetMenuItem;

    @FindBy(css = "#checkSqlButton")
    WebElement viewSqlMenuItem;

    @FindBy(id = "appendFieldsButton")
    WebElement modifySQLMenuItem;

    @FindBy(css = "ul#dataSetAllMenu > li:nth-child(3)")
    WebElement appendDataMenuItem;

    @FindBy(css = "#dataSource > a")
    WebElement locateToDatasourceMenuItem;


    public void selectMenu(String item) throws InterruptedException {
        waitForElementVisible(otherOperationMenu);
        otherOperationMenu.click();

        switch (item){
            case "LINKTODATASOURCE":
                locateToDatasourceMenuItem.click();
                break;
            case "APPENDDATA":
                appendDataMenuItem.click();
                break;
            case "MODIFYSQL":
                waitForElementVisible(modifySQLMenuItem);
                modifySQLMenuItem.click();
                break;
            case "VIEWSQL":
                waitForElementVisible(viewSqlMenuItem);
                viewSqlMenuItem.click();
                break;
            case "EDITJOIN":
                waitForElementVisible(editJoinDataSetMenuItem);
                editJoinDataSetMenuItem.click();
                break;
        }
    }
}
