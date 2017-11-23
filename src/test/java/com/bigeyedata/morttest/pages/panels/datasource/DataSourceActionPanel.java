package com.bigeyedata.morttest.pages.panels.datasource;

import com.bigeyedata.morttest.pages.DataSetPage;
import com.bigeyedata.morttest.pages.Panel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.bigeyedata.morttest.SeeThruUtils.onPage;

/**
 * Created by yingzhang on 23/11/2017.
 */
public class DataSourceActionPanel extends Panel {
    @FindBy(id = "addNewDataSet")
    WebElement createNewDatasetButton;

    public void CreateNewDatasetFromDatasource(){

        createNewDatasetButton.click();
        onPage(DataSetPage.class);
    }
}
