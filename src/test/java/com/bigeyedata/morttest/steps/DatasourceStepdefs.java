package com.bigeyedata.morttest.steps;

import com.bigeyedata.morttest.pages.DataSourcePage;
import com.bigeyedata.morttest.pages.panels.ResourceItemsPanel;
import com.bigeyedata.morttest.pages.datasource_pages.DatasourceConfigPage;
import com.bigeyedata.morttest.pages.panels.ResourceItemOperatorPanel;
import com.bigeyedata.morttest.pages.panels.datasource.*;
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


    @And("^I create a RDB dataSource with configuration as following$")
    public void iCreateARDBDatasourceWithConfigurationAsFollowing(List<Map<String,String>> rdbConfigList) throws Throwable {

        DataSourceEditorPanel dataSourceEditorPanel = onPage(DataSourcePage.class).dataSourceEditorPanel;
        dataSourceEditorPanel.createNewDataResource();
        dataSourceEditorPanel.selectRDBType();

        RDBDataSourceEditorPanel rdbDataSourceEditorPanel = dataSourceEditorPanel.specificEditorPanel(RDBDataSourceEditorPanel.class);
        rdbDataSourceEditorPanel.createRDBDataSource(rdbConfigList);
    }

    @When("^I saved (?:RDB|HDFS|ES) dataSource$")
    public void iSavedDataSource() throws Throwable {
        onPage(DataSourcePage.class).dataSourceEditorPanel.confirmCreateDataSource();
    }

    @And("^I create a HDFS DataSource with configuration as following$")
    public void iCreateAHDFSDatasourceWithConfigurationAsFollowing(List<Map<String,String>> HDFSConfigList) throws Throwable {

        DataSourceEditorPanel editorPanel =onPage(DataSourcePage.class).dataSourceEditorPanel;
        editorPanel.createNewDataResource();
        editorPanel.selectHDFSType();

        HDFSDataSourceEditorPanel hdfsEditorPanel = editorPanel.specificEditorPanel(HDFSDataSourceEditorPanel.class);
        hdfsEditorPanel.createHDFSDataSource(HDFSConfigList);
    }

    @And("^I \"([^\"]*)\" dataSource \"([^\"]*)\"$")
    public void iOperateDataSource(String menuItemName, String dataSourceName) throws Throwable {
        DataSourcePage dataSourcePage = onPage(DataSourcePage.class);
        dataSourcePage.resourcePanel.locateItem(dataSourceName);

        ResourceItemOperatorPanel itemOperatorPanel =initPanel(ResourceItemOperatorPanel.class);
        itemOperatorPanel.showDataSourceOperatorMenu();

        DataSourceItemOperatorPanel dataSourceItemOperatorPanel =itemOperatorPanel.specificOperatorPanel();
        dataSourceItemOperatorPanel.selectMenuItem(menuItemName);
    }

    @And("^I create a ES DataSource with configuration as following$")
    public void iCreateAESDataSourceWithConfigurationAsFollowing(List<Map<String,String>> ESConfigList) throws Throwable {
        DataSourceEditorPanel editorPanel =onPage(DataSourcePage.class).dataSourceEditorPanel;
        editorPanel.createNewDataResource();
        editorPanel.selectESType();

        ESDataSourceEditorPanel esEditorPanel=editorPanel.specificEditorPanel(ESDataSourceEditorPanel.class);
        esEditorPanel.createESDataSource(ESConfigList);
        esEditorPanel.openWanSwitch();
    }

    @And("^I modified RDB dataSource with configuration as following$")
    public void iModifiedRDBDataSourceWithConfigurationAsFollowing(List<Map<String,String>> RDBConfigList) throws Throwable {
        onPage(DataSourcePage.class).dataSourceEditorPanel.specificEditorPanel(RDBDataSourceEditorPanel.class).modifyRDBDataSource(RDBConfigList);
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
        assertThat(currentPage().resourcePanel.isResourceExisted(dataSourceName),is(false));
    }
}
