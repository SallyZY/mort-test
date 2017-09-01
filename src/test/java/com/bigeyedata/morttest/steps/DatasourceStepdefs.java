package com.bigeyedata.morttest.steps;

import com.bigeyedata.morttest.SeeThruUtils;
import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.ResourceFileListPanel;
import com.bigeyedata.morttest.pages.datasource_pages.DatasourceConfigPage;
import com.bigeyedata.morttest.pages.datasource_pages.DataSourceDetailPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by yingzhang on 17/05/2017.
 */
public class DatasourceStepdefs {

    WebDriver webDriver= WebDriverManager.getDriver();
    DatasourceConfigPage datasourceConfigPage= PageFactory.initElements(webDriver,DatasourceConfigPage.class);
    DataSourceDetailPage datasourceDetailPage= PageFactory.initElements(webDriver,DataSourceDetailPage.class);

    @And("^I want to create a RDB dataSource with configuration as following$")
    public void iWantToCreateARDBDatasourceWithConfigurationAsFollowing(List<Map<String,String>> RDBConfigList) throws Throwable {


        ResourceFileListPanel resourceFileListPanel = PageFactory.initElements(webDriver,ResourceFileListPanel.class);
        resourceFileListPanel.createNewDataResource();
        datasourceConfigPage.selectRDBType();
        datasourceConfigPage.setRDBParameter(RDBConfigList);

    }

    @When("^I click save button on (?:RDB|HDFS|ES) dataSource configuration page$")
    public void iClickSaveButtonOnDatasourceConfigurationPage() throws Throwable {

        datasourceConfigPage.createDataSource();

    }

    @And("^I want to create a HDFS DataSource with configuration as following$")
    public void iWantToCreateAHDFSDatasourceWithConfigurationAsFollowing(List<Map<String,String>> HDFSConfigList) throws Throwable {

        ResourceFileListPanel resourceFileListPanel = PageFactory.initElements(webDriver,ResourceFileListPanel.class);
        resourceFileListPanel.createNewResource();
        datasourceConfigPage.selectHDFSType();
        datasourceConfigPage.setHDFSParameter(HDFSConfigList);

    }

    @And("^I access to edit page of dataSourceName \"([^\"]*)\"$")
    public void iAccessToEditPageOfDataSourceName(String title) throws Throwable {
        datasourceDetailPage.goToRDBEditPage(title);
    }

    @And("^I want to create a ES DataSource with configuration as following$")
    public void iWantToCreateAESDataSourceWithConfigurationAsFollowing(List<Map<String,String>> ESConfigList) throws Throwable {
        ResourceFileListPanel resourceFileListPanel = PageFactory.initElements(webDriver,ResourceFileListPanel.class);
        resourceFileListPanel.createNewDataResource();
        datasourceConfigPage.selectESType();
        datasourceConfigPage.setESParameter(ESConfigList);
        datasourceConfigPage.openWanSwitch();
    }

    @And("^I want to modify RDB dataSource with configuration as following$")
    public void iWantToModifyRDBDataSourceWithConfigurationAsFollowing(List<Map<String,String>> RDBConfigList) throws Throwable {
        datasourceConfigPage.modifyRDBParameter(RDBConfigList);
    }

    @And("^I should see the DataSource configuration displayed correctly as following$")
    public void iShouldSeeTheDataSourceConfigurationDisplayedCorrectlyAsFollowing(List<Map<String,String>> RDBConfigList) throws Throwable {

        assertTrue(datasourceDetailPage.getRDBParameter().contains(RDBConfigList.get(0).get("Host")));
        assertTrue(datasourceDetailPage.getRDBParameter().contains(RDBConfigList.get(0).get("Port")));
        assertTrue(datasourceDetailPage.getRDBParameter().contains(RDBConfigList.get(0).get("User")));
        assertTrue(datasourceDetailPage.getRDBParameter().contains(RDBConfigList.get(0).get("DataSourceType")));
        assertTrue(datasourceDetailPage.getRDBParameter().contains(RDBConfigList.get(0).get("Database")));

    }
}
