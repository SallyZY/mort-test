package com.bigeyedata.morttest.steps;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.pages.DataSetPage;
import com.bigeyedata.morttest.pages.DataSourcePage;
import com.bigeyedata.morttest.pages.dataset_pages.*;
import com.bigeyedata.morttest.pages.datasource_pages.DataSourceDetailPage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.sk.A;

import java.util.List;
import java.util.Map;

import static com.bigeyedata.morttest.SeeThruUtils.currentPage;
import static com.bigeyedata.morttest.SeeThruUtils.onPage;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by yingzhang on 09/05/2017.
 */
public class DataSetStepdefs {


    List<Map<String, String>> savedFieldAliasList;
    List<Map<String, String>> savedFieldTypeList;
    String rdbDataSetPreviewSQL ="";

    @Given("^I click create new DataSet button on DataSource page$")
    public void iClickCreateNewDataSetButtonOnDatasourcePage() throws Throwable {
        onPage(DataSourceDetailPage.class).CreateNewDatasetFromDatasource();
        onPage(DataSourceSelectPage.class).gotoNextStep();
    }

    @Given("^I modify the alias of fields for DataSet as following$")
    public void iModifyTheAliasOfFieldsForDataSetAsFollowing(List<Map<String, String>> fieldAliasList) throws Throwable {
        onPage(FieldEditPage.class).setFieldsAlias(fieldAliasList);
        savedFieldAliasList = fieldAliasList;
    }

    @And("^I modify the type of fields for DataSet as following$")
    public void iModifyTheTypeOfFieldsForDataSetAsFollowing(List<Map<String, String>> fieldTypeList) throws Throwable {

        onPage(FieldEditPage.class).setFieldsType(fieldTypeList);
        savedFieldTypeList =fieldTypeList;
    }

    @And("^I click date fields preview table$")
    public void iGoToDateFieldsPreviewTable() throws Throwable {
        onPage(ImportPreviewPage.class).gotoDateFieldPreviewTab();
    }

    @And("^I set the date format for date filed as following$")
    public void iSetTheDateFormatForDateFiledAsFollowing(List<Map<String, String>> dateFormatList) throws Throwable {
        onPage(ImportPreviewPage.class).setDateFormatForDateField(dateFormatList);
    }

    @And("^I give the name of DataSet is \"([^\"]*)\"$")
    public void iGiveTheNameOfDatasetIs(String datasetName) throws Throwable {

        onPage(ImportPreviewPage.class).inputDatasetName(datasetName);
    }

    @And("^I select the saved directory of DataSet is \"([^\"]*)\"$")
    public void iSelectTheSavedDirectoryOfDatasetIs(String directoryName) throws Throwable {
        currentPage().dirPanel.selectSavedDirectoryByName(directoryName);
    }

    @When("^I save the new DataSet$")
    public void iSaveTheNewDataset() throws Throwable {
        onPage(ImportPreviewPage.class).createDataset();
    }

    @Then("^I should see the (?:DataSource|DataSet|Report) \"([^\"]*)\" displayed in directory$")
    public void iShouldSeeThereSourceFileDisplayedInDirectory(String datasetName) throws Throwable {
        assertThat(currentPage().resourcePanel.isResourceExisted(datasetName),is(true));
    }

    @And("^I should see the number of DataSet fields is \"([^\"]*)\"$")
    public void iShouldSeeTheNumberOfDatasetFieldsIs(String fieldCount) throws Throwable {
        assertThat(onPage(DataSetDetailsPage.class).getFieldCountOfDataset(),is(Integer.parseInt(fieldCount)));
    }

    @And("^I should see the import record displayed as following$")
    public void iShouldSeeTheImportRecordDisplayedAsFollowing(DataTable importTable) throws Throwable {
        ((DataSetPage)currentPage()).detailPanel.selectTab("import");
        ((DataSetPage)currentPage()).detailPanel.specificDetailPanel().verifyDetail(importTable);
    }
    
    @Then("^I should locate to the DataSource \"([^\"]*)\"$")
    public void iShouldLocateToTheDatasource(String datasourceName) throws Throwable {

        assertThat(currentPage().resourcePanel.isResourceExisted(datasourceName),is(true));
    }

    @When("^I click \"([^\"]*)\" item from other operation dropdown menu$")
    public void iClickItemFromOtherOperationDropdownMenu(String itemName) throws Throwable {

        CommonFunctions.refresh();
        onPage(DataSetDetailsPage.class).clickOtherOptionsMenuItem(itemName);
    }

    @And("^I should see the related DataSet as following$")
    public void iShouldSeeTheRelatedDataSetAsFollowing(List<Map<String,String>> datasetNameList) throws Throwable {

        onPage(DataSourceDetailPage.class).isDataSetNameDisplayed(datasetNameList);
    }


    @And("^I preview the query result of SQL$")
    public void iClickPreviewButtonToPreviewTable() throws Throwable {
        onPage(RDBPreviewPage.class).clickPreviewButton();

    }


    @And("^I set the DataSet connection mode is \"([^\"]*)\"$")
    public void iSetDataSetImportMode(String importMode) throws Throwable {

        onPage(RDBPreviewPage.class).setDataSetConnectionMode(importMode);

    }

    @And("^I input SQL is \"([^\"]*)\"$")
    public void iInputSQLIs(String sql) throws Throwable {

        onPage(RDBPreviewPage.class).inputPreviewSQL(sql);
        rdbDataSetPreviewSQL = sql;
    }



    @And("^I set the DataSet import mode is \"([^\"]*)\"$")
    public void iSetTheDataSetImportMode(String importMode) throws Throwable {
        onPage(RDBPreviewPage.class).setDataSetImportMode(importMode);
    }

    @And("^I set import time is 1 minute later current time$")
    public void iSetImportDateAndTime() throws Throwable {

        onPage(RDBPreviewPage.class).setCustomizeImportDate();

    }

    @And("^I should wait (\\d+) minute$")
    public void iShouldWaitMinute(int arg0) throws Throwable {
        Thread.sleep(60*1000);
    }

    @And("^I can modify the field type of DataSet$")
    public void iCanModifyTheFieldTypeOfDataSet() throws Throwable {
        assertThat(onPage(RDBPreviewPage.class).isFieldTypeOfDataSetEditable(),is(true));
    }

    @And("^I can NOT modify the field type of DataSet$")
    public void iCanNOTModifyTheFieldTypeOfDataSet() throws Throwable {
        assertThat(onPage(RDBPreviewPage.class).isFieldTypeSelectDisplayed(),is(true));
    }

    @And("^I should NOT see the amount of DataSet records$")
    public void iShouldnTSeeNumberOfRecordsAfterTheDatasetName() throws Throwable {
        assert onPage(RDBPreviewPage.class).assertRecordNumber();
    }

    @And("^I can't modify the alias and the type of previous data$")
    public void iCanTModifyTheAliasAndTheTypeOfPreviousData() throws Throwable {
        assertThat(onPage(RDBPreviewPage.class).countDisabledFieldsAlias(),is(2));
        assertThat(onPage(RDBPreviewPage.class).countDisabledFieldsType(),is(2));
    }


    @When("^I add field to the DataSet$")
    public void iAddFieldToTheDataset() throws Throwable {
        onPage(ImportPreviewPage.class).createDataset();
        CommonFunctions.refresh();
    }

    @And("^I can NOT modify the DataSet name and saved directory$")
    public void iCanTModifyTheDatasetNameAndHeSavedDirectoryOfDataSet() throws Throwable {
        assertThat(onPage(RDBPreviewPage.class).isDataSetNameEnabled(),is(false));
        assertThat(onPage(RDBPreviewPage.class).isDataSetSavedDirectoryEnabled(),is(false ));
    }

    @And("^I go to DataSet import preview page$")
    public void iClickGoToNextPageButtonOfFieldEditPage() throws Throwable {
        onPage(FieldEditPage.class).gotoNextPage();
    }

    @Then("^I should see the sql of RDBDataSet$")
    public void iShouldSeeTheSqlOfRDBDataSet() throws Throwable {
        assertThat(onPage(DataSetDetailsPage.class).getSqlofRDBDataSet(),is(rdbDataSetPreviewSQL));
    }

    @And("^I go to new report page from DataSet detail page$")
    public void iGoToNewReportPageFromDataSetDetailPage() throws Throwable {
        onPage(DataSetDetailsPage.class).createNewReport();
    }

    @When("^I want to create a new virtual dimension for DataSet \"([^\"]*)\"$")
    public void iWantToCreateANewVirtualDimension(String dataSetName) throws Throwable {
        onPage(DataSetListPage.class).openVirtualDimensionDialog(dataSetName);
    }

    @And("^I set the name of virtual (?:dimension|measure) is \"([^\"]*)\"$")
    public void iSetTheNameOfVirtualDimensionIs(String name) throws Throwable {
        onPage(VirtualFieldPage.class).setVirtualFieldName(name);
    }

    @And("^I set the type of virtual dimension is \"([^\"]*)\"$")
    public void iSetTheTypeOfVirtualDimensionIs(String type) throws Throwable {
        onPage(VirtualFieldPage.class).setVirtualFieldType(type);
    }

    @And("^I set the expression of virtual (?:dimension|measure) as following$")
    public void iSetTheExpressionOfVirtualDimensionIs(List<Map<String,String>> expressionList) throws Throwable {
        String expression = expressionList.get(0).get("Expression").toString();
        onPage(VirtualFieldPage.class).setExpression(expression);
    }

    @And("^I validate the syntax of expression$")
    public void iValidateTheSyntaxOfExpression() throws Throwable {
        onPage(VirtualFieldPage.class).validateSyntaxOfExpression();
    }

    @Then("^I should see the result of validation displayed$")
    public void iShouldSeeTheResultOfValidationContains() throws Throwable {
        assertThat(onPage(VirtualFieldPage.class).isValidateResultDisplayed(),is(true));
    }

    @When("^I save the new virtual (?:dimension|measure)$")
    public void iSaveTheNewVirtualDimension() throws Throwable {
        onPage(VirtualFieldPage.class).saveVirtualDimension();

    }

    @Then("^I should see the new virtual (?:dimension|measure) \"([^\"]*)\" displayed in DataSet field list$")
    public void iShouldSeeTheNewVirtualDimensionDisplayedInDataSetFieldList(String fieldName) throws Throwable {
        assertTrue(onPage(DataSetListPage.class).getFieldList().contains(fieldName));
    }

    @When("^I rename the DataSet name \"([^\"]*)\"$")
    public void iRenameTheDataSetName(String newDataSetName) throws Throwable {
        onPage(DataSetDetailsPage.class).reNameDataSet(newDataSetName);
    }

    @When("^I modify the alias of field for DataSet on detail page \"([^\"]*)\"$")
    public void iModifyTheAliasOfFieldsForDataSetOnDetailPage(String fieldsAlias) throws Throwable {
        onPage(DataSetDetailsPage.class).modifyFieldAlias(fieldsAlias);
    }
//
//    @Then("^I should see the alias of fields for DataSet is \"([^\"]*)\"$")
//    public void iShouldSeeTheAliasOfFieldsForDataSetIs(String fieldsAlias) throws Throwable {
//        assertTrue(onPage(DataSetDetailsPage.class).checkFieldsAlias(fieldsAlias));

//        onPage(DataSetDetailsPage.class).modifyFieldAlias(fieldsAlias);
//    }

    @Then("^I should see the alias of field for DataSet is \"([^\"]*)\"$")
    public void iShouldSeeTheAliasOfFieldsForDataSetIs(String fieldAlias) throws Throwable {
        assertThat(onPage(DataSetDetailsPage.class).getFieldAlias(),is(fieldAlias));
    }

    @When("^I want to create a new virtual measure for DataSet \"([^\"]*)\"$")
    public void iWantToCreateANewVirtualMeasureForDataSet(String dataSetName) throws Throwable {
        onPage(DataSetListPage.class).openVirtualMeasureDialog(dataSetName);
    }

    @Then("^I should see the new virtual dimension \"([^\"]*)\" displayed in DataSet field table$")
    public void iShouldSeeTheNewVirtualDimensionDisplayedInDataSetFieldTable(String arg0) throws Throwable {
        assertTrue(onPage(DataSetDetailsPage.class).getFieldList(arg0));
    }

    @And("^I click create new DataSet button on DataSet page$")
    public void iClickCreateNewDataSetButtonOnDataSetPage() throws Throwable {
        currentPage().resourcePanel.createNewDataSetResource();
    }

    @And("^I click cereate new Associated button$")
    public void iClickCereateNewAssociatedButton() throws Throwable {
        currentPage().resourcePanel.createAssociatedDataSet();
    }

    @And("^I select the directory \"([^\"]*)\" on associated DataSet page$")
    public void iSelectTheDirectoryOnAssociatedDataSetPage(String directoryName) throws Throwable {
        onPage(AssociatedDataSetPage.class).selectDirectory(directoryName);

    }

    @And("^I drag and drop dataset$")
    public void iDragAndDropDataset() throws Throwable {
        onPage(AssociatedDataSetPage.class).dragAndDrop();
    }

    @Then("^I should see the field detail displayed correctly as following$")
    public void iShouldSeeDataSetFiledDisplayedCorrectlyAsFollowing(DataTable fieldTable) throws Throwable {
        (onPage(DataSetPage.class)).detailPanel.selectTab("field");
        ((DataSetPage)currentPage()).detailPanel.specificDetailPanel().verifyDetail(fieldTable);
    }

    @And("^I should see the preview data of DataSet displayed correctly as following$")
    public void iShouldSeeTheDataSetOfPreviewDataDisplayedCorrectlyAsFollowing(DataTable previewDataTable) throws Throwable {
        ((DataSetPage)currentPage()).detailPanel.selectTab("dataPreview");
        ((DataSetPage)currentPage()).detailPanel.specificDetailPanel().verifyDetail(previewDataTable);
    }

    @And("^I should see the (?:join|union|extract) source of DataSet displayed correctly as following$")
    public void iShouldSeeSourceOfDataDisplayedCorrectlyAsFollowing(DataTable sourceOfDataTable) throws Throwable {
//        onPage(AssociatedDataSetPage.class).clickSourceOfData();
//        onPage(AssociatedDataSetPage.class).checkSourceOfData(sourceOfDataTable);
        ((DataSetPage)currentPage()).detailPanel.selectTab("sourceOfData");
        ((DataSetPage)currentPage()).detailPanel.specificDetailPanel().verifyDetail(sourceOfDataTable);
    }


    @Then("^I should see the joinDataSet displayed correctly as following$")
    public void iShouldSeeTheJoinDataSetDisplayedCorrectlyAsFollowing(DataTable sourceOfDataTable) throws Throwable {
        onPage(AssociatedDataSetPage.class).checkJoinDataSet(sourceOfDataTable);
        ((DataSetPage)currentPage()).detailPanel.specificDetailPanel().verifyDetail(sourceOfDataTable);
    }

    @When("^I view the detail of join DataSet$")
    public void iViewTheDetailOfJoinDataSet() throws Throwable {
        onPage(DataSetDetailsPage.class).clickOtherOptionsMenuItem("showJoinDataSet");
    }


    @And("^I should see the join type displayed correctly$")
    public void iShouldSeeTheJoinTypeDisplayedCorrectly() throws Throwable {
        assertTrue(onPage(AssociatedDataSetPage.class).checkRightJoin());
        assertTrue(onPage(AssociatedDataSetPage.class).checkLeftJoin());
    }

    @And("^I should see the Checked field displayed correctly as following$")
    public void iShouldSeeTheCheckedFieldDisplayedCorrectlyAsFollowing(DataTable expectedJoinTypeTable) throws Throwable {
        onPage(AssociatedDataSetPage.class).checkCheckedField(expectedJoinTypeTable);
    }

    @And("^I should see the preview table of header displayed correctly as following$")
    public void iShouldSeeThePreviewTableOfHeaderDisplayedCorrectlyAsFollowing(DataTable expectedDetailsTable) throws Throwable {
        onPage(AssociatedDataSetPage.class).nextStep();
        onPage(AssociatedDataSetPage.class).checkPreviewTableOfHeader(expectedDetailsTable);
    }

    @And("^I should see the basic information of joinDataSet as following$")
    public void iShouldSeeTheBasicInformationOfJoinDataSetAsFollowing(DataTable expectedDetailsTable) throws Throwable {
        onPage(AssociatedDataSetPage.class).nextStep();
        onPage(AssociatedDataSetPage.class).checkBaseInfo(expectedDetailsTable);
    }

    @When("^I delete the dataSet$")
    public void iDeleteJoinDatasetOfSourceDataSet() throws Throwable {
        ((DataSetPage)(currentPage())).sourceItemMenuPanel.deleteDataSet();
    }
}
