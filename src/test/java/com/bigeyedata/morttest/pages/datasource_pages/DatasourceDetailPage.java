package com.bigeyedata.morttest.pages.datasource_pages;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.pages.Page;
import gherkin.lexer.Pa;
import org.junit.Before;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

/**
 * Created by yingzhang on 10/05/2017.
 */
public class DatasourceDetailPage extends Page {

    @FindBy(id = "addNewDataSet")
    WebElement createNewDatasetButton;

    @FindBy(css = "div.related-data-sets > div > div >div > div >div > div > table")
    WebElement relatedDatasetTable;

    public boolean isDatasetNameDisplayed(List<Map<String,String>> datasetNameList) throws InterruptedException {

        CommonFunctions.waitForElementVisible(relatedDatasetTable);

        boolean isFindDatasetName = false;
        for (int i = 0; i < datasetNameList.size(); i++) {
            isFindDatasetName = relatedDatasetTable.getText().contains(datasetNameList.get(i).get("DatasetName").toString());
        }

        return isFindDatasetName;
    }

    public void CreateNewDatasetFromDatasource(){

        createNewDatasetButton.click();
    }
}
