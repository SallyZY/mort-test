package com.bigeyedata.morttest.steps;

import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.ResourceFileListPage;
import com.bigeyedata.morttest.pages.datasource_pages.DatasourceConfigPage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by yingzhang on 17/05/2017.
 */
public class DatasourceStepdefs {

    WebDriver webDriver= WebDriverManager.getDriver();
    DatasourceConfigPage datasourceConfigPage= PageFactory.initElements(webDriver,DatasourceConfigPage.class);

    @And("^I want to create a RDB datasource with configuration as following$")
    public void iWantToCreateARDBDatasourceWithConfigurationAsFollowing(List<Map<String,String>> RDBConfigList) throws Throwable {

        ResourceFileListPage resourceFileListPage= PageFactory.initElements(webDriver,ResourceFileListPage.class);
        resourceFileListPage.createNewDataResource();
        datasourceConfigPage.selectRDBType();
        datasourceConfigPage.setRDBParameter(RDBConfigList);

    }

    @When("^I click save button on RDB datasource configuration page$")
    public void iClickSaveButtonOnRDBDatasourceConfigurationPage() throws Throwable {

        datasourceConfigPage.createRDBSource();

    }

    @And("^I want to create a HDFS DataSource with configuration as following$")
    public void iWantToCreateAHDFSDatasourceWithConfigurationAsFollowing(List<Map<String,String>> HDFSConfigList) throws Throwable {

        ResourceFileListPage resourceFileListPage= PageFactory.initElements(webDriver,ResourceFileListPage.class);
        resourceFileListPage.createNewResource();
        datasourceConfigPage.selectHDFSType();
        datasourceConfigPage.setHDFSParameter(HDFSConfigList);

    }

    @When("^I click save button on HDFS DataSource configuration page$")
    public void iClickSaveButtonOnHDFSDatasourceConfigurationPage() throws Throwable {

        datasourceConfigPage.createHDFSSource();

    }
}
