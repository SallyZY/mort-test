package com.bigeyedata.morttest.pages.panels.dataset.datasetEditor;

import com.bigeyedata.morttest.pages.Panel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.bigeyedata.morttest.CommonFunctions.waitForElementVisible;

/**
 * Created by yingzhang on 28/11/2017.
 */
public class MoreOperationPanel implements Panel {
    @FindBy(id = "dataSetOtherOperationMenu")
    WebElement otherOperationMenu;

    @FindBy(id = "showJoinDataSet")
    WebElement editJoinDataSetMenuItem;

    @FindBy(id = "showUnionDataSet")
    WebElement editUnionDataSetMenuItem;

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
            case "EDITUNION":
                waitForElementVisible(editUnionDataSetMenuItem);
                editUnionDataSetMenuItem.click();
                break;
        }
    }
}
