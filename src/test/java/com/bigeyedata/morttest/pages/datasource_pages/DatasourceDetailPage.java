package com.bigeyedata.morttest.pages.datasource_pages;

import com.bigeyedata.morttest.pages.Page;
import gherkin.lexer.Pa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by yingzhang on 10/05/2017.
 */
public class DatasourceDetailPage extends Page {

    @FindBy(id = "addNewDataSet")
    WebElement createNewDatasetButton;

    public void CreateNewDatasetFromDatasource(){

        createNewDatasetButton.click();
    }
}
