package com.bigeyedata.morttest.steps.report_steps;

import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.report_pages.ChartBindingItemPage;
import com.bigeyedata.morttest.pages.report_pages.ChartSettingPage;
import com.bigeyedata.morttest.pages.report_pages.ReportWorkSpacePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

import static com.bigeyedata.morttest.SeeThruUtils.onPage;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by yingzhang on 19/05/2017.
 */
public class ChartStepdefs {

    @Given("^I select the (?:Column|Pie|MixLineBar|Line|Doughnut|AreaStack|Funnel|KPI) chart$")
    public void iSelectTheColumnChart() throws Throwable {
        onPage(ReportWorkSpacePage.class).selectSingleChart();
    }

    @Given("^I open style setting panel$")
    public void iOpenStyleSettingPanel() throws Throwable {
        onPage(ChartSettingPage.class).gotoSettingPanel("style");
    }

    @Given("^I set the title of chart as following$")
    public void iSetTheTitleOfChartAsFollowing(List<Map<String, String>> chartTitleList) throws Throwable {
        onPage(ChartSettingPage.class).setChartTitle(chartTitleList);
    }

    @Given("^I set the title of X-axis of chart is display$")
    public void iSetTheTitleOfXAxisOfChartIsDisplay() throws Throwable {
        onPage(ChartSettingPage.class).DisplayChartDimensionTitle();
    }

    @Given("^I set (?:Y-axis|left-Y-axis) of chart as following$")
    public void iSetYAxisOfChartAsFollowing(List<Map<String, String>> measureStyleList) throws Throwable {
        onPage(ChartSettingPage.class).setChartMeasureStyle(measureStyleList);
    }

    @And("^I set right-Y-axis of chart as following$")
    public void iSetRightYAxisOfChartAsFollowing(List<Map<String, String>> measureStyleList) throws Throwable {
        onPage(ChartSettingPage.class).setChartRightMeasureStyle(measureStyleList);
    }

    @Given("^I set the legend of chart as following$")
    public void iSetTheLegendOfChartAsFollowing(List<Map<String, String>> legendStyleList) throws Throwable {
        onPage(ChartSettingPage.class).setChartLegendStyle(legendStyleList);
    }

    @Given("^I set the data label of chart as following$")
    public void iSetTheDataLabelOfChartAsFollowing(List<Map<String, String>> dataLabelStyleList) throws Throwable {
        onPage(ChartSettingPage.class).setChartDataLabelStyle(dataLabelStyleList);
    }

    @And("^I delete the \"([^\"]*)\" BindingItem of (?:Pie|Line) chart$")
    public void iDeleteTheBindingItemOfChart(String itemName) throws Throwable {
        onPage(ChartBindingItemPage.class).deleteBindingItem(itemName);
    }

    @Then("^I should see the \"([^\"]*)\" BindingItem of (?:Pie|Line) chart is empty$")
    public void iShouldSeeTheBindingItemOfPieChartIsEmpty(String itemName) throws Throwable {

        assertThat(onPage(ChartBindingItemPage.class).isBindingItemEmpty(itemName),is(true));
    }

    @When("^I delete the (?:Line|Pie) chart with index is \"([^\"]*)\"$")
    public void iDeleteTheLineChartWithIndexIs(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
