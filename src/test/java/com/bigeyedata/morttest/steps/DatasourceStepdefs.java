package com.bigeyedata.morttest.steps;

import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.ResourceFileListPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by yingzhang on 17/05/2017.
 */
public class DatasourceStepdefs {

    WebDriver webDriver= WebDriverManager.getDriver();

    @And("^I want to create a RDB datasource with configuration as following$")
    public void iWantToCreateARDBDatasourceWithConfigurationAsFollowing(List<List<String>> RDBParameterList) throws Throwable {

        ResourceFileListPage resourceFileListPage= PageFactory.initElements(webDriver,ResourceFileListPage.class);
        resourceFileListPage.createNewResource();

    }

    @When("^I click save button on RDB datasource configuration page$")
    public void iClickSaveButtonOnRDBDatasourceConfigurationPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
