package com.bigeyedata.morttest.steps.report_steps;

import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.report_pages.ChartSettingPage;
import com.bigeyedata.morttest.pages.report_pages.ReportWorkSpacePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by yingzhang on 19/05/2017.
 */
public class ChartStepdefs {

    WebDriver webDriver = WebDriverManager.getDriver();
    ChartSettingPage chartSettingPage = PageFactory.initElements(webDriver,ChartSettingPage.class);

    @Given("^I select the (?:column|pie|mixLineBar) chart$")
    public void iSelectTheColumnChart() throws Throwable {

        ReportWorkSpacePage reportWorkSpacePage = PageFactory.initElements(webDriver,ReportWorkSpacePage.class);
        reportWorkSpacePage.selectSingleChart();
    }

    @Given("^I open style setting panel$")
    public void iOpenStyleSettingPanel() throws Throwable {

        chartSettingPage.gotoSettingPanel("style");
    }

    @Given("^I set the title of chart as following$")
    public void iSetTheTitleOfChartAsFollowing(List<Map<String, String>> chartTitleList) throws Throwable {

        chartSettingPage.setChartTitle(chartTitleList);
    }

    @Given("^I set the title of X-axis of chart is display$")
    public void iSetTheTitleOfXAxisOfChartIsDisplay() throws Throwable {

        chartSettingPage.DisplayChartDimensionTitle();
    }

    @Given("^I set (?:Y-axis|left-Y-axis) of chart as following$")
    public void iSetYAxisOfChartAsFollowing(List<Map<String, String>> measureStyleList) throws Throwable {

        chartSettingPage.setChartMeasureStyle(measureStyleList);
    }

    @And("^I set right-Y-axis of chart as following$")
    public void iSetRightYAxisOfChartAsFollowing(List<Map<String, String>> measureStyleList) throws Throwable {

        chartSettingPage.setChartRightMeasureStyle(measureStyleList);
    }

    @Given("^I set the legend of chart as following$")
    public void iSetTheLegendOfChartAsFollowing(List<Map<String, String>> legendStyleList) throws Throwable {

        chartSettingPage.setChartLegendStyle(legendStyleList);
    }

    @Given("^I set the data label of chart as following$")
    public void iSetTheDataLabelOfChartAsFollowing(List<Map<String, String>> dataLabelStyleList) throws Throwable {

        chartSettingPage.setChartDataLabelStyle(dataLabelStyleList);
    }

}
