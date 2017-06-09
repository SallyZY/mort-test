package com.bigeyedata.morttest.steps;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.DirectoryPage;
import com.bigeyedata.morttest.pages.ResourceFileListPage;
import com.bigeyedata.morttest.pages.dataset_pages.*;
import com.bigeyedata.morttest.pages.datasource_pages.DatasourceDetailPage;
import cucumber.api.PendingException;
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
        fieldEditPage.gotoNextPage();
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

    @When("^I create the DataSet$")
    public void iCreateTheDataset() throws Throwable {

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

        datasetDetailsPage.clickMenuItem(itemName);
    }

    @And("^I should see the related DataSet as following$")
    public void iShouldSeeTheRelatedDatasetAsFollowing(List<Map<String,String>> datasetNameList) throws Throwable {

        datasourceDetailPage.isDatasetNameDisplayed(datasetNameList);
    }


    @And("^I click preview button to preview table$")
    public void iClickPreviewButtonToPreviewTable() throws Throwable {

        rdbPreviewPage.clickPreviewButton();

    }


    @And("^I select \"([^\"]*)\" mode$")
    public void iSelectMimportMode(String importMode) throws Throwable {

        rdbPreviewPage.selectedImportMode(importMode);

    }

    @And("^I input a right SQL is \"([^\"]*)\"$")
    public void iInputARightSQLIs(String sql) throws Throwable {

        rdbPreviewPage.setSQLTextarea(sql);

    }



    @And("^I select \"([^\"]*)\"$")
    public void iSelectimportTime(String importTime) throws Throwable {
        rdbPreviewPage.selectImportTime(importTime);
    }

    @And("^I set import date and time$")
    public void iSetImportDateAndTime() throws Throwable {

        rdbPreviewPage.setCustomizeImportDate();

    }

    @And("^I should wait (\\d+) minute$")
    public void iShouldWaitMinute(int arg0) throws Throwable {
        Thread.sleep(60*1000);
    }

    @And("^I can't modify the type of fields for DataSet$")
    public void iCanTModifyTheTypeOfFieldsForDataSet() throws Throwable {
        assert rdbPreviewPage.assertTypeTagNameOfDirectConnection();
    }

    @And("^I shouldn't see number of records after the dataset name$")
    public void iShouldnTSeeNumberOfRecordsAfterTheDatasetName() throws Throwable {
        assert rdbPreviewPage.assertRecordNumber();
    }

    @And("^I can't modify the alias and the type of previous data$")
    public void iCanTModifyTheAliasAndTheTypeOfPreviousData() throws Throwable {
        assertThat(rdbPreviewPage.countDisabledFieldsAlias(),is(2));
        assertThat(rdbPreviewPage.countDisabledFieldsType(),is(2));
    }


    @When("^I add field to the Dataset$")
    public void iAddFieldToTheDataset() throws Throwable {
        importPreviewPage.createDataset();
        Thread.sleep(10*1000);
        CommonFunctions.refresh();
        Thread.sleep(10*1000);

    }

    @And("^I should see the add field import record is displayed$")
    public void iShouldSeeTheAddFieldImportRecordIsDisplayed() throws Throwable {
        assertThat(datasetDetailsPage.getDescriptionOfNewestImportHistory(),is("追加字段导入"));
    }


    @And("^I can't modify the dataset name and he saved directory of DataSet$")
    public void iCanTModifyTheDatasetNameAndHeSavedDirectoryOfDataSet() throws Throwable {
        assertThat(rdbPreviewPage.isDisabledDataSetInput(),is(false));
        assertThat(rdbPreviewPage.isDisabledSaveDirectory(),is(false ));
    }

    @And("^I click goToNextPage button of fieldEditPage$")
    public void iClickGoToNextPageButtonOfFieldEditPage() throws Throwable {
        fieldEditPage.gotoNextPage();
    }

    @Then("^I should see the sql of RDBDataSet$")
    public void iShouldSeeTheSqlOfRDBDataSet() throws Throwable {
        assertThat(datasetDetailsPage.getSqlofRDBDataSet(),is("select * from user"));
    }
}
