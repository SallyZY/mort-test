package com.bigeyedata.morttest.pages.datasource_pages;

import com.bigeyedata.morttest.pages.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

/**
 * Created by yingzhang on 17/05/2017.
 */
public class DatasourceConfigPage extends Page {

    @FindBy(css = "div.AddDataSourceTypes > div.AddDataSourceTypesItem:nth-child(1)")
    WebElement localFileTypeLink;

    @FindBy(css = "div.AddDataSourceTypes > div.AddDataSourceTypesItem:nth-child(2)")
    WebElement RDBTypeLink;

    @FindBy(css = "div.AddDataSourceTypes > div.AddDataSourceTypesItem:nth-child(3)")
    WebElement HDFSTypeLink;
}
