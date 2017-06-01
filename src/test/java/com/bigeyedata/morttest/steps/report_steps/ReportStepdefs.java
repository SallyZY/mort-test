package com.bigeyedata.morttest.steps.report_steps;

import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.report_pages.ReportPreviewPage;
import com.bigeyedata.morttest.pages.report_pages.ReportWorkSpacePage;
import com.google.common.annotations.GwtIncompatible;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

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

    @And("^I copy the chart with chart index is \"([^\"]*)\"$")
    public void iCopyTheLineChart(String chartIndex) throws Throwable {

        reportWorkSpacePage.copyChart(chartIndex);
    }

    @And("^I move the chart with chart index is \"([^\"]*)\" to report page \"([^\"]*)\"$")
    public void iMoveTheCopiedChartToReportPage(String chartIndex, String pageName) throws Throwable {

        reportWorkSpacePage.moveChart(chartIndex,pageName);
    }

    @And("^I create a new report page$")
    public void iCreateANewReportPage() throws Throwable {

        reportWorkSpacePage.addNewReportPage();
    }

    @And("^I rename the report page \"([^\"]*)\" to \"([^\"]*)\"$")
    public void iRenameTheReportPageTo(String originName, String newName) throws Throwable {

        reportWorkSpacePage.renameReportPage(originName, newName);
    }
}
