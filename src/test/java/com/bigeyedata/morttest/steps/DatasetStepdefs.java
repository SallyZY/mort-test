package com.bigeyedata.morttest.steps;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.DirectoryPage;
import com.bigeyedata.morttest.pages.ResourceFileListPage;
import com.bigeyedata.morttest.pages.dataset_pages.*;
import com.bigeyedata.morttest.pages.datasource_pages.DatasourceDetailPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by yingzhang on 09/05/2017.
 */
public class DatasetStepdefs {

    WebDriver webDriver= WebDriverManager.getDriver();
    FieldEditPage fieldEditPage = PageFactory.initElements(webDriver,FieldEditPage.class);
    ImportPreviewPage importPreviewPage =  PageFactory.initElements(webDriver,ImportPreviewPage.class);
    ResourceFileListPage resourceFileListPage = PageFactory.initElements(webDriver,ResourceFileListPage.class);
    DatasetDetailsPage datasetDetailsPage = PageFactory.initElements(webDriver,DatasetDetailsPage.class);
    DatasourceDetailPage datasourceDetailPage=PageFactory.initElements(webDriver,DatasourceDetailPage.class);
    RDBPreviewPage rdbPreviewPage=PageFactory.initElements(webDriver,RDBPreviewPage.class);

    List<Map<String, String>> savedFieldAliasList;
    List<Map<String, String>> savedFieldTypeList;
    String rdbDataSetPreviewSQL ="";

    @Given("^I click create new DataSet button on DataSource page$")
    public void iClickCreateNewDatasetButtonOnDatasourcePage() throws Throwable {

        DatasourceDetailPage datasourceDetailPage= PageFactory.initElements(webDriver,DatasourceDetailPage.class);
        datasourceDetailPage.CreateNewDatasetFromDatasource();

        DatasourceSelectPage datasourceSelectPage = PageFactory.initElements(webDriver,DatasourceSelectPage.class);
        datasourceSelectPage.gotoNextStep();
    }

    @Given("^I modify the alias of fields for DataSet as following$")
    public void iModifyTheAliasOfFieldsForDatasetAsFollowing(List<Map<String, String>> fieldAliasList) throws Throwable {

        fieldEditPage.setFieldsAlias(fieldAliasList);
        savedFieldAliasList = fieldAliasList;
    }

    @And("^I modify the type of fields for DataSet as following$")
    public void iModifyTheTypeOfFieldsForDatasetAsFollowing(List<Map<String, String>> fieldTypeList) throws Throwable {

        fieldEditPage.setFieldsType(fieldTypeList);
        savedFieldTypeList =fieldTypeList;
    }

    @And("^I click date fields preview table$")
    public void iGoToDateFieldsPreviewTable() throws Throwable {

        importPreviewPage.gotoDateFieldPreviewTab();
    }

    @And("^I set the date format for date filed as following$")
    public void iSetTheDateFormatForDateFiledAsFollowing(List<Map<String, String>> dateFormatList) throws Throwable {

        importPreviewPage.setDateFormatForDateField(dateFormatList);
    }

    @And("^I give the name of DataSet is \"([^\"]*)\"$")
    public void iGiveTheNameOfDatasetIs(String datasetName) throws Throwable {

        importPreviewPage.inputDatasetName(datasetName);
    }

    @And("^I select the saved directory of DataSet is \"([^\"]*)\"$")
    public void iSelectTheSavedDirectoryOfDatasetIs(String directoryName) throws Throwable {

        DirectoryPage directoryPage = PageFactory.initElements(webDriver,DirectoryPage.class);
        directoryPage.selectSavedDirectoryByName(directoryName);
    }

    @When("^I save the new DataSet$")
    public void iSaveTheNewDataset() throws Throwable {

        importPreviewPage.createDataset();
    }

    @Then("^I should see the (?:DataSource|DataSet|Report) \"([^\"]*)\" displayed in directory$")
    public void iShouldSeeTheSourceFileDisplayedInDirectory(String datasetName) throws Throwable {

        assertThat(resourceFileListPage.isResourceFileExistedInList(datasetName),is(true));
    }

    @And("^I should see the number of DataSet fields is \"([^\"]*)\"$")
    public void iShouldSeeTheNumberOfDatasetFieldsIs(String fieldCount) throws Throwable {

        assertThat(datasetDetailsPage.getFieldCountOfDataset(),is(Integer.parseInt(fieldCount)));
    }

    @And("^I should see the ailas of DataSet fields displayed correctly$")
    public void iShouldSeeTheAilasOfDatasetFieldsDisplayedCorrectly() throws Throwable {

        assertThat(datasetDetailsPage.compareFieldAlias(savedFieldAliasList),is(true));
    }

    @And("^I should see the type of DataSet fields displayed correctly$")
    public void iShouldSeeTheTypeOfDatasetFieldsDisplayedCorrectly() throws Throwable {

        assertThat(datasetDetailsPage.compareFieldType(savedFieldTypeList),is(true));
    }

    @And("^I should see the initial import record is displayed$")
    public void iShouldSeeTheInitialImportRecordIsDisplayed() throws Throwable {

        assertThat(datasetDetailsPage.getDescriptionOfNewestImportHistory(),is("初始化导入"));
    }
    
    @Then("^I should locate to the DataSource \"([^\"]*)\"$")
    public void iShouldLocateToTheDatasource(String datasourceName) throws Throwable {

        assertThat(resourceFileListPage.isResourceFileExistedInList(datasourceName),is(true));
    }

    @When("^I click \"([^\"]*)\" item from other operation dropdown menu$")
    public void iClickItemFromOtherOperationDropdownMenu(String itemName) throws Throwable {

        CommonFunctions.refresh();
        datasetDetailsPage.clickOtherOptionsMenuItem(itemName);
    }

    @And("^I should see the related DataSet as following$")
    public void iShouldSeeTheRelatedDatasetAsFollowing(List<Map<String,String>> datasetNameList) throws Throwable {

        datasourceDetailPage.isDatasetNameDisplayed(datasetNameList);
    }


    @And("^I preview the query result of SQL$")
    public void iClickPreviewButtonToPreviewTable() throws Throwable {

        rdbPreviewPage.clickPreviewButton();

    }


    @And("^I set the DataSet connection mode is \"([^\"]*)\"$")
    public void iSetDataSetImportMode(String importMode) throws Throwable {

        rdbPreviewPage.setDataSetConnectionMode(importMode);

    }

    @And("^I input SQL is \"([^\"]*)\"$")
    public void iInputSQLIs(String sql) throws Throwable {

        rdbPreviewPage.inputPreviewSQL(sql);
        rdbDataSetPreviewSQL = sql;
    }



    @And("^I set the DataSet import mode is \"([^\"]*)\"$")
    public void iSetTheDataSetImportMode(String importMode) throws Throwable {
        rdbPreviewPage.setDataSetImportMode(importMode);
    }

    @And("^I set import time is 1 minute later current time$")
    public void iSetImportDateAndTime() throws Throwable {

        rdbPreviewPage.setCustomizeImportDate();

    }

    @And("^I should wait (\\d+) minute$")
    public void iShouldWaitMinute(int arg0) throws Throwable {
        Thread.sleep(60*1000);
    }

    @And("^I can modify the field type of DataSet$")
    public void iCanModifyTheFieldTypeOfDataSet() throws Throwable {
        assertThat(rdbPreviewPage.isFieldTypeOfDataSetEditable(),is(true));
    }

    @And("^I can NOT modify the field type of DataSet$")
    public void iCanNOTModifyTheFieldTypeOfDataSet() throws Throwable {
        assertThat(rdbPreviewPage.isFieldTypeSelectDisplayed(),is(true));
    }

    @And("^I should NOT see the amount of DataSet records$")
    public void iShouldnTSeeNumberOfRecordsAfterTheDatasetName() throws Throwable {
        assert rdbPreviewPage.assertRecordNumber();
    }

    @And("^I can't modify the alias and the type of previous data$")
    public void iCanTModifyTheAliasAndTheTypeOfPreviousData() throws Throwable {
        assertThat(rdbPreviewPage.countDisabledFieldsAlias(),is(2));
        assertThat(rdbPreviewPage.countDisabledFieldsType(),is(2));
    }


    @When("^I add field to the DataSet$")
    public void iAddFieldToTheDataset() throws Throwable {
        importPreviewPage.createDataset();
        CommonFunctions.refresh();
    }

    @And("^I should see the add field import record is displayed$")
    public void iShouldSeeTheAddFieldImportRecordIsDisplayed() throws Throwable {
        assertThat(datasetDetailsPage.getDescriptionOfNewestImportHistory(),is("修改SQL信息导入"));
    }


    @And("^I can NOT modify the DataSet name and saved directory$")
    public void iCanTModifyTheDatasetNameAndHeSavedDirectoryOfDataSet() throws Throwable {
        assertThat(rdbPreviewPage.isDataSetNameEnabled(),is(false));
        assertThat(rdbPreviewPage.isDataSetSavedDirectoryEnabled(),is(false ));
    }

    @And("^I go to DataSet import preview page$")
    public void iClickGoToNextPageButtonOfFieldEditPage() throws Throwable {
        fieldEditPage.gotoNextPage();
    }

    @Then("^I should see the sql of RDBDataSet$")
    public void iShouldSeeTheSqlOfRDBDataSet() throws Throwable {
        assertThat(datasetDetailsPage.getSqlofRDBDataSet(),is(rdbDataSetPreviewSQL));
    }
}
