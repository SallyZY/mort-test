package com.bigeyedata.morttest.steps;

import com.bigeyedata.morttest.pages.DataSourcePage;
import com.bigeyedata.morttest.pages.panels.ResourceItemOperatorPanel;
import com.bigeyedata.morttest.pages.panels.datasource.*;
import com.bigeyedata.morttest.types.DataSourceType;
import cucumber.api.DataTable;
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

        DataSourceEditorPanel dataSourceEditorPanel = ((DataSourcePage)currentPage()).editorPanel;
        dataSourceEditorPanel.createNewDataResource();
        dataSourceEditorPanel.selectDataSourceType(DataSourceType.RDB);
        dataSourceEditorPanel.specificEditorPanel().createDataSource(rdbConfigList.get(0));
    }

    @When("^I saved (?:RDB|HDFS|ES) dataSource$")
    public void iSavedDataSource() throws Throwable {
        ((DataSourcePage)currentPage()).editorPanel.confirmCreateDataSource();
    }

    @And("^I create a HDFS DataSource with configuration as following$")
    public void iCreateAHDFSDatasourceWithConfigurationAsFollowing(List<Map<String,String>> hdfsConfigList) throws Throwable {
        DataSourceEditorPanel editorPanel =((DataSourcePage)currentPage()).editorPanel;
        editorPanel.createNewDataResource();
        editorPanel.selectDataSourceType(DataSourceType.HDFS);
        editorPanel.specificEditorPanel().createDataSource(hdfsConfigList.get(0));
    }

    @And("^I \"([^\"]*)\" dataSource \"([^\"]*)\"$")
    public void iOperateDataSource(String menuItemName, String dataSourceName) throws Throwable {
        DataSourcePage dataSourcePage = ((DataSourcePage)currentPage());
        dataSourcePage.resourcePanel.locateItem(dataSourceName);
        dataSourcePage.itemOperatorPanel.displayDataSourceOperatorMenu();
        dataSourcePage.itemOperatorPanel.specificOperatorPanel().selectMenuItem(menuItemName);
    }

    @And("^I create a ES DataSource with configuration as following$")
    public void iCreateAESDataSourceWithConfigurationAsFollowing(List<Map<String,String>> esConfigList) throws Throwable {
        DataSourceEditorPanel editorPanel =onPage(DataSourcePage.class).editorPanel;
        editorPanel.createNewDataResource();
        editorPanel.selectDataSourceType(DataSourceType.ES);
        editorPanel.specificEditorPanel().createDataSource(esConfigList.get(0));

//        ESDataSourceEditorPanel esEditorPanel=editorPanel.specificEditorPanel(ESDataSourceEditorPanel.class);
//        esEditorPanel.createESDataSource(ESConfigList);
//        esEditorPanel.openWanSwitch();
    }

    @And("^I modified RDB dataSource with configuration as following$")
    public void iModifiedRDBDataSourceWithConfigurationAsFollowing(List<Map<String,String>> RDBConfigList) throws Throwable {
        ((DataSourcePage)currentPage()).editorPanel.specificEditorPanel().modifyRDBDataSource(RDBConfigList.get(0));
    }

    @And("^I should see the DataSource configuration displayed correctly as following$")
    public void iShouldSeeTheDataSourceConfigurationDisplayedCorrectlyAsFollowing(DataTable configTable) throws Throwable {
        ((DataSourcePage)currentPage()).detailPanel.checkConfigDetail(configTable);
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
