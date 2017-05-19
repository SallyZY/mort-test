package com.bigeyedata.morttest.steps.report_steps;

import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.report_pages.ReportWorkSpacePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by yingzhang on 19/05/2017.
 */
public class ChartStepdefs {

    WebDriver webDriver = WebDriverManager.getDriver();

    @Given("^I select the column chart$")
    public void iSelectTheColumnChart() throws Throwable {

        ReportWorkSpacePage reportWorkSpacePage = PageFactory.initElements(webDriver,ReportWorkSpacePage.class);
        reportWorkSpacePage.selectSingleChart();
    }

    @Given("^I open style setting panel$")
    public void iOpenStyleSettingPanel() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I set the title of chart as following$")
    public void iSetTheTitleOfChartAsFollowing() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I set the title of X-axis of chart is display$")
    public void iSetTheTitleOfXAxisOfChartIsDisplay() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I set Y-axis of chart as following$")
    public void iSetYAxisOfChartAsFollowing() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I set the legend of chart as following$")
    public void iSetTheLegendOfChartAsFollowing() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I set the data label of chart as following$")
    public void iSetTheDataLabelOfChartAsFollowing() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
