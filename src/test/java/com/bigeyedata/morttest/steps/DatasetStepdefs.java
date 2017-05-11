package com.bigeyedata.morttest.steps;

import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.dataset_pages.DatasourceSelectPage;
import com.bigeyedata.morttest.pages.dataset_pages.FieldEditPage;
import com.bigeyedata.morttest.pages.dataset_pages.ImportPreviewPage;
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

/**
 * Created by yingzhang on 09/05/2017.
 */
public class DatasetStepdefs {

    WebDriver webDriver= WebDriverManager.getDriver();
    FieldEditPage fieldEditPage = PageFactory.initElements(webDriver,FieldEditPage.class);
    ImportPreviewPage importPreviewPage =  PageFactory.initElements(webDriver,ImportPreviewPage.class);

    @Given("^I click create new dataset button on datasource page$")
    public void iClickCreateNewDatasetButtonOnDatasourcePage() throws Throwable {

        Thread.sleep(3);
        DatasourceDetailPage datasourceDetailPage= PageFactory.initElements(webDriver,DatasourceDetailPage.class);
        datasourceDetailPage.CreateNewDatasetFromDatasource();

        DatasourceSelectPage datasourceSelectPage = PageFactory.initElements(webDriver,DatasourceSelectPage.class);
        datasourceSelectPage.gotoNextStep();
    }

    @Given("^I modify the alias of fields for dataset as following$")
    public void iModifyTheAliasOfFieldsForDatasetAsFollowing(List<Map<String, String>> fieldAliasList) throws Throwable {

        Thread.sleep(10);
        fieldEditPage.setFieldsAlias(fieldAliasList);
    }

    @And("^I modify the type of fields for dataset as following$")
    public void iModifyTheTypeOfFieldsForDatasetAsFollowing(List<Map<String, String>> fieldTypeList) throws Throwable {

        fieldEditPage.setFieldsType(fieldTypeList);
        fieldEditPage.gotoNextPage();
    }

    @And("^I click date fields preview table$")
    public void iGoToDateFieldsPreviewTable() throws Throwable {

        importPreviewPage.gotoDateFieldPreviewTab();
    }

    @And("^I set the date format for date filed as following$")
    public void iSetTheDateFormatForDateFiledAsFollowing(List<Map<String, String>> dateFormatList) throws Throwable {

        importPreviewPage.setDateFormatForDateField(dateFormatList);
    }

    @And("^I give the name of dataset is \"([^\"]*)\"$")
    public void iGiveTheNameOfDatasetIs(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I select the saved directory of dataset is \"([^\"]*)\"$")
    public void iSelectTheSavedDirectoryOfDatasetIs(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I create the dataset$")
    public void iCreateTheDataset() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I should see the dataset created successfully$")
    public void iShouldSeeTheDatasetCreatedSuccessfully() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I should see the number of dataset fields is correct$")
    public void iShouldSeeTheNumberOfDatasetFieldsIsCorrect() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I should see the ailas of dataset fields displayed correctly$")
    public void iShouldSeeTheAilasOfDatasetFieldsDisplayedCorrectly() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I should see the type of dataset fields displayed correctly$")
    public void iShouldSeeTheTypeOfDatasetFieldsDisplayedCorrectly() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I should see the initial import record is displayed$")
    public void iShouldSeeTheInitialImportRecordIsDisplayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I should NOT see the related report displayed$")
    public void iShouldNOTSeeTheRelatedReportDisplayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


}
