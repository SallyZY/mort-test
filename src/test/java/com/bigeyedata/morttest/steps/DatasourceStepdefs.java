package com.bigeyedata.morttest.steps;

import com.bigeyedata.morttest.pages.ResourceFileListPanel;
import com.bigeyedata.morttest.pages.datasource_pages.DatasourceConfigPage;
import com.bigeyedata.morttest.pages.datasource_pages.DataSourceDetailPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Da;

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
    public void iWantToCreateARDBDatasourceWithConfigurationAsFollowing(List<Map<String,String>> RDBConfigList) throws Throwable {


        ResourceFileListPanel resourceFileListPanel = initPanel(ResourceFileListPanel.class);
        resourceFileListPanel.createNewDataResource();
        onPage(DatasourceConfigPage.class).selectRDBType();
        onPage(DatasourceConfigPage.class).setRDBParameter(RDBConfigList);

    }

    @When("^I click save button on (?:RDB|HDFS|ES) dataSource configuration page$")
    public void iClickSaveButtonOnDatasourceConfigurationPage() throws Throwable {

        onPage(DatasourceConfigPage.class).createDataSource();

    }

    @And("^I want to create a HDFS DataSource with configuration as following$")
    public void iWantToCreateAHDFSDatasourceWithConfigurationAsFollowing(List<Map<String,String>> HDFSConfigList) throws Throwable {

        ResourceFileListPanel resourceFileListPanel = initPanel(ResourceFileListPanel.class);
        resourceFileListPanel.createNewResource();
        onPage(DatasourceConfigPage.class).selectHDFSType();
        onPage(DatasourceConfigPage.class).setHDFSParameter(HDFSConfigList);

    }

    @And("^I access to edit page of dataSourceName \"([^\"]*)\"$")
    public void iAccessToEditPageOfDataSourceName(String title) throws Throwable {
        onPage(DataSourceDetailPage.class).goToRDBEditPage(title);
    }

    @And("^I want to create a ES DataSource with configuration as following$")
    public void iWantToCreateAESDataSourceWithConfigurationAsFollowing(List<Map<String,String>> ESConfigList) throws Throwable {
        ResourceFileListPanel resourceFileListPanel = initPanel(ResourceFileListPanel.class);
        resourceFileListPanel.createNewDataResource();
        onPage(DatasourceConfigPage.class).selectESType();
        onPage(DatasourceConfigPage.class).setESParameter(ESConfigList);
        onPage(DatasourceConfigPage.class).openWanSwitch();
    }

    @And("^I want to modify RDB dataSource with configuration as following$")
    public void iWantToModifyRDBDataSourceWithConfigurationAsFollowing(List<Map<String,String>> RDBConfigList) throws Throwable {
        onPage(DatasourceConfigPage.class).modifyRDBParameter(RDBConfigList);
    }

    @And("^I should see the DataSource configuration displayed correctly as following$")
    public void iShouldSeeTheDataSourceConfigurationDisplayedCorrectlyAsFollowing(List<Map<String,String>> RDBConfigList) throws Throwable {

        assertTrue(onPage(DataSourceDetailPage.class).getRDBParameter().contains(RDBConfigList.get(0).get("Host")));
        assertTrue(onPage(DataSourceDetailPage.class).getRDBParameter().contains(RDBConfigList.get(0).get("Port")));
        assertTrue(onPage(DataSourceDetailPage.class).getRDBParameter().contains(RDBConfigList.get(0).get("User")));
        assertTrue(onPage(DataSourceDetailPage.class).getRDBParameter().contains(RDBConfigList.get(0).get("DataSourceType")));
        assertTrue(onPage(DataSourceDetailPage.class).getRDBParameter().contains(RDBConfigList.get(0).get("Database")));

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
