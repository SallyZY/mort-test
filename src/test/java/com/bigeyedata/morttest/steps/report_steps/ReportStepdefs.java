package com.bigeyedata.morttest.steps.report_steps;

import com.bigeyedata.morttest.pages.report_pages.ReportPreviewPage;
import com.bigeyedata.morttest.pages.report_pages.ReportWorkSpacePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.Map;

import static com.bigeyedata.morttest.SeeThruUtils.currentPage;
import static com.bigeyedata.morttest.SeeThruUtils.onPage;

/**
 * Created by yingzhang on 19/05/2017.
 */
public class ReportStepdefs {

    @Given("^I open report edit page$")
    public void iOpenReportEditPage() throws Throwable {
        onPage(ReportPreviewPage.class).gotoReportEditPage();
    }

    @When("^I save the report$")
    public void iSaveTheReport() throws Throwable {

        onPage(ReportWorkSpacePage.class).saveReport();
    }

    @When("^I return to report preview page$")
    public void iReturnToReportPreviewPage() throws Throwable {

        onPage(ReportWorkSpacePage.class).backToPreviewReport();
    }

    @Then("^I Should see the style setting is saved$")
    public void iShouldSeeTheStyleSettingIsSaved() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I go to the report page \"([^\"]*)\"$")
    public void iGoToTheReportPage(String pageName) throws Throwable {

        onPage(ReportWorkSpacePage.class).gotoReportPageByName(pageName);
    }

    @And("^I copy the chart with index is \"([^\"]*)\"$")
    public void iCopyTheLineChart(String chartIndex) throws Throwable {

        onPage(ReportWorkSpacePage.class).copyChart(Integer.parseInt(chartIndex));
    }

    @And("^I move the chart with index is \"([^\"]*)\" to report page \"([^\"]*)\"$")
    public void iMoveTheCopiedChartToReportPage(String chartIndex, String pageName) throws Throwable {

        onPage(ReportWorkSpacePage.class).moveChart(Integer.parseInt(chartIndex),pageName);
    }

    @And("^I create a new report page$")
    public void iCreateANewReportPage() throws Throwable {

        onPage(ReportWorkSpacePage.class).addNewReportPage();
    }

    @And("^I rename the report page \"([^\"]*)\" to \"([^\"]*)\"$")
    public void iRenameTheReportPageTo(String originName, String newName) throws Throwable {

        onPage(ReportWorkSpacePage.class).renameReportPage(originName, newName);
    }

    @And("^I select the (?:Pie|Line) chart with index is \"([^\"]*)\"$")
    public void iSelectTheChartWithIndexIs(String chartIndex) throws Throwable {

        onPage(ReportWorkSpacePage.class).selectChartByIndex(Integer.parseInt(chartIndex));
    }

    @And("^I save as the report as following$")
    public void iSaveAsTheReportAsFollowing(List<Map<String, String>> reportInfoList) throws Throwable {

        onPage(ReportWorkSpacePage.class).clickSaveAsMenu();
        onPage(ReportWorkSpacePage.class).inputReportSavedName(reportInfoList.get(0).get("ReportName").toString());

        currentPage().dirPanel.selectSavedDirectoryByName(reportInfoList.get(0).get("Directory").toString());

        onPage(ReportWorkSpacePage.class).clickSaveReportButtonOnDialog();
    }

    @And("^I give up saving the report$")
    public void iGiveUpSavingTheReport() throws Throwable {
        onPage(ReportWorkSpacePage.class).backToPreviewReport();
        onPage(ReportWorkSpacePage.class).giveUpSaveTheReport();
    }
}
