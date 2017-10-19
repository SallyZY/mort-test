package com.bigeyedata.morttest.steps;

import com.bigeyedata.morttest.Hooks;
import com.bigeyedata.morttest.pages.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.Map;

import static com.bigeyedata.morttest.SeeThruUtils.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by yingzhang on 09/05/2017.
 */
public class CommonStepdefs {

    @Given("^I open browser and login to Mort Web$")
    public void iOpenBrowserAndLoginToMortWeb(List<Map<String, String>> userLoginInfoList) throws Throwable {

        String userName= userLoginInfoList.get(0).get("UserName").toString();
        String password=userLoginInfoList.get(0).get("Password").toString();

        navigateTo(Hooks.getMortWebUrl());
        LoginPage curPage = onPage(LoginPage.class);
        curPage.login(userName,password);

    }

    @Given("^I access to \"([^\"]*)\" module$")
    public void iAccessToModule(String module) throws Throwable {

        currentPage().navPanel.accessToModule(module);
    }

    @Given("^I select (?:DataSource|DataSet|Report) as following$")
    public void iSelectDatasourceAsFollowing(List<Map<String,String>> sourceInfoList) throws Throwable {

        String directoryName = sourceInfoList.get(0).get("DirectoryName").toString();
        String sourceFileName=sourceInfoList.get(0).get("ResourceFileName").toString();

        currentPage().dirPanel.clickDirectoryByName(directoryName);
        currentPage().resourcePanel.clickResourceByName(sourceFileName);

    }

    @When("^I click \"([^\"]*)\" item from dropdown menu of \"([^\"]*)\"$")
    public void iClickItemFromOperationMenuOf(String menuItem, String fileName) throws Throwable {

        currentPage().resourcePanel.clickOptionMenuOfResourceFile(fileName);
    }

    @Then("^I should NOT see deleted resource file \"([^\"]*)\" in directory$")
    public void iShouldNOTSeeDeletedResourceFileInDirectory(String fileName) throws Throwable {

        assertThat(currentPage().resourcePanel.isResourceFileExistedInList(fileName),is(false));
    }

    @And("^I select (?:DataSource|DataSet|Report) directory \"([^\"]*)\"$")
    public void iSelectDirectory(String directoryName) throws Throwable {
        currentPage().dirPanel.clickDirectoryByName(directoryName);
    }

    @And("^I select the directory \"([^\"]*)\"$")
    public void iSelectTheDirectory(String dicName) throws Throwable {

        currentPage().dirPanel.clickDirectoryByName(dicName);
    }

    @When("^I select the (?:DataSource|DataSet|Report) \"([^\"]*)\"$")
    public void iSelectTheResourceFile(String fileName) throws Throwable {

        currentPage().resourcePanel.clickResourceByName(fileName);
    }

    @And("^I expand the (?:DataSource|DataSet|Report) directory$")
    public void iExpandTheDataSourceDirectory() throws Throwable {
        currentPage().dirPanel.clickDicExpandIcon();
    }
}
