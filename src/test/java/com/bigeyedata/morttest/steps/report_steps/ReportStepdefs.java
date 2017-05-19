package com.bigeyedata.morttest.steps.report_steps;

import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.report_pages.ReportPreviewPage;
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

    @Given("^I open report edit page$")
    public void iOpenReportEditPage() throws Throwable {

        ReportPreviewPage reportPreviewPage = PageFactory.initElements(webDriver,ReportPreviewPage.class);
        reportPreviewPage.gotoReportEditPage();
    }

    @When("^I save the report$")
    public void iSaveTheReport() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I return to report preview page$")
    public void iReturnToReportPreviewPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I Should see the style setting is saved$")
    public void iShouldSeeTheStyleSettingIsSaved() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
