package com.bigeyedata.morttest.steps;

import com.bigeyedata.morttest.pages.DataSourcePage;
import com.bigeyedata.morttest.pages.ResourceItemsPanel;
import com.bigeyedata.morttest.pages.datasource_pages.DatasourceConfigPage;
import com.bigeyedata.morttest.pages.panel.DataSourceEditorPanel;
import com.bigeyedata.morttest.pages.panel.RDBDataSourceEditorPanel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.Map;

import static com.bigeyedata.morttest.SeeThruUtils.currentPage;
import static com.bigeyedata.morttest.SeeThruUtils.initPanel;
import static com.bigeyedata.morttest.SeeThruUtils.onPage;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by yingzhang on 17/05/2017.
 */
public class DatasourceStepdefs {


    @And("^I want to create a RDB dataSource with configuration as following$")
    public void iWantToCreateARDBDatasourceWithConfigurationAsFollowing(List<Map<String,String>> rdbConfigList) throws Throwable {

        DataSourceEditorPanel dataSourceEditorPanel = onPage(DataSourcePage.class).dataSourceEditorPanel;
        dataSourceEditorPanel.createNewDataResource();
        dataSourceEditorPanel.selectRDBType();

        RDBDataSourceEditorPanel rdbDataSourceEditorPanel = dataSourceEditorPanel.specificEditorPanel(RDBDataSourceEditorPanel.class);
        rdbDataSourceEditorPanel.setRDBParameter(rdbConfigList);
    }

    @When("^I click save button on (?:RDB|HDFS|ES) dataSource configuration page$")
    public void iClickSaveButtonOnDatasourceConfigurationPage() throws Throwable {
        onPage(DataSourcePage.class).dataSourceEditorPanel.createDataSource();

    }

    @And("^I want to create a HDFS DataSource with configuration as following$")
    public void iWantToCreateAHDFSDatasourceWithConfigurationAsFollowing(List<Map<String,String>> HDFSConfigList) throws Throwable {

        ResourceItemsPanel resourceItemsPanel = initPanel(ResourceItemsPanel.class);
        resourceItemsPanel.createNewResource();
        onPage(DatasourceConfigPage.class).selectHDFSType();
        onPage(DatasourceConfigPage.class).setHDFSParameter(HDFSConfigList);

    }

    @And("^I access to edit page of dataSourceName \"([^\"]*)\"$")
    public void iAccessToEditPageOfDataSourceName(String title) throws Throwable {
        onPage(DataSourcePage.class).resourcePanel.editItem(title);
    }

    @And("^I want to create a ES DataSource with configuration as following$")
    public void iWantToCreateAESDataSourceWithConfigurationAsFollowing(List<Map<String,String>> ESConfigList) throws Throwable {
        ResourceItemsPanel resourceItemsPanel = initPanel(ResourceItemsPanel.class);
        resourceItemsPanel.createNewDataResource();
        onPage(DatasourceConfigPage.class).selectESType();
        onPage(DatasourceConfigPage.class).setESParameter(ESConfigList);
        onPage(DatasourceConfigPage.class).openWanSwitch();
    }

    @And("^I want to modify RDB dataSource with configuration as following$")
    public void iWantToModifyRDBDataSourceWithConfigurationAsFollowing(List<Map<String,String>> RDBConfigList) throws Throwable {
        onPage(DataSourcePage.class).dataSourceEditorPanel.specificEditorPanel(RDBDataSourceEditorPanel.class).setRDBParameter(RDBConfigList);
    }

    @And("^I should see the DataSource configuration displayed correctly as following$")
    public void iShouldSeeTheDataSourceConfigurationDisplayedCorrectlyAsFollowing(List<Map<String,String>> RDBConfigList) throws Throwable {
        String rdbParameter = onPage(DataSourcePage.class).rdbDetailPanel.getRDBParameter();
        assertTrue(rdbParameter.contains(RDBConfigList.get(0).get("Host")));
        assertTrue(rdbParameter.contains(RDBConfigList.get(0).get("Port")));
        assertTrue(rdbParameter.contains(RDBConfigList.get(0).get("User")));
        assertTrue(rdbParameter.contains(RDBConfigList.get(0).get("DataSourceType")));
        assertTrue(rdbParameter.contains(RDBConfigList.get(0).get("Database")));

    }

    @When("^I delete the dataSource \"([^\"]*)\"$")
    public void iDeleteTheDataSource(String sourceFileName) throws Throwable {
        currentPage().resourcePanel.clickResourceByName(sourceFileName);
        currentPage().resourcePanel.deleteDateSourceResourceFile();
    }

    @Then("^I shoud NOT see the DataSource \"([^\"]*)\" displayed in directory$")
    public void iShoudNOTSeeTheDataSourceDisplayedInDirectory(String dataSourceName) throws Throwable {
        assertThat(currentPage().resourcePanel.isResourceFileExistedInList(dataSourceName),is(false));
    }
}
