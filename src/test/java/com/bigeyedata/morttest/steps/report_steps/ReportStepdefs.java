package com.bigeyedata.morttest.steps.report_steps;

import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.DirectoryPage;
import com.bigeyedata.morttest.pages.report_pages.ReportPreviewPage;
import com.bigeyedata.morttest.pages.report_pages.ReportWorkSpacePage;
import com.google.common.annotations.GwtIncompatible;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.it.Ma;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by yingzhang on 19/05/2017.
 */
public class ReportStepdefs {

    WebDriver webDriver= WebDriverManager.getDriver();
    ReportWorkSpacePage reportWorkSpacePage=PageFactory.initElements(webDriver,ReportWorkSpacePage.class);

    @Given("^I open report edit page$")
    public void iOpenReportEditPage() throws Throwable {

        ReportPreviewPage reportPreviewPage = PageFactory.initElements(webDriver,ReportPreviewPage.class);
        reportPreviewPage.gotoReportEditPage();
    }

    @When("^I save the report$")
    public void iSaveTheReport() throws Throwable {

        reportWorkSpacePage.saveReport();
    }

    @When("^I return to report preview page$")
    public void iReturnToReportPreviewPage() throws Throwable {

        reportWorkSpacePage.backToPreviewReport();
    }

    @Then("^I Should see the style setting is saved$")
    public void iShouldSeeTheStyleSettingIsSaved() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I go to the report page \"([^\"]*)\"$")
    public void iGoToTheReportPage(String pageName) throws Throwable {

        reportWorkSpacePage.gotoReportPageByName(pageName);
    }

    @And("^I copy the chart with index is \"([^\"]*)\"$")
    public void iCopyTheLineChart(String chartIndex) throws Throwable {

        reportWorkSpacePage.copyChart(Integer.parseInt(chartIndex));
    }

    @And("^I move the chart with index is \"([^\"]*)\" to report page \"([^\"]*)\"$")
    public void iMoveTheCopiedChartToReportPage(String chartIndex, String pageName) throws Throwable {

        reportWorkSpacePage.moveChart(Integer.parseInt(chartIndex),pageName);
    }

    @And("^I create a new report page$")
    public void iCreateANewReportPage() throws Throwable {

        reportWorkSpacePage.addNewReportPage();
    }

    @And("^I rename the report page \"([^\"]*)\" to \"([^\"]*)\"$")
    public void iRenameTheReportPageTo(String originName, String newName) throws Throwable {

        reportWorkSpacePage.renameReportPage(originName, newName);
    }

    @And("^I select the chart with index is \"([^\"]*)\"$")
    public void iSelectTheChartWithIndexIs(String chartIndex) throws Throwable {

        reportWorkSpacePage.selectChartByIndex(Integer.parseInt(chartIndex));
    }

    @And("^I save as the report as following$")
    public void iSaveAsTheReportAsFollowing(List<Map<String, String>> reportInfoList) throws Throwable {

        reportWorkSpacePage.inputReportSavedName(reportInfoList.get(0).get("ReportName").toString());
        DirectoryPage directoryPage = PageFactory.initElements(webDriver,DirectoryPage.class);
        directoryPage.selectSavedDirectoryByName(reportInfoList.get(0).get("Directory").toString());
    }
}
