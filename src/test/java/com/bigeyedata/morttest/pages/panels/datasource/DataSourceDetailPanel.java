package com.bigeyedata.morttest.pages.panels.datasource;

import com.bigeyedata.morttest.pages.Panel;
import cucumber.api.DataTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

/**
 * Created by yingzhang on 09/11/2017.
 */
public class DataSourceDetailPanel implements Panel {
    @FindBy(xpath = "//div[@class='data-source-config']//tbody//td[position() < last()]")
    public List<WebElement> configDetailsCols;

    @FindBy(xpath = "//div[@class='data-source-config']//tbody//tr")
    public List<WebElement> configDetailsRows;

    public void checkConfigDetail(DataTable expectedDetailsTable) {
//        compareDataTableByWebElement(expectedDetailsTable, configDetailsRows, configDetailsCols);
    }
}
