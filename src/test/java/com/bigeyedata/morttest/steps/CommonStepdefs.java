package com.bigeyedata.morttest.steps;

import com.bigeyedata.morttest.Hooks;
import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.DirectoryPage;
import com.bigeyedata.morttest.pages.LoginPage;
import com.bigeyedata.morttest.pages.NavigationPage;
import com.bigeyedata.morttest.pages.ResourceFileListPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by yingzhang on 09/05/2017.
 */
public class CommonStepdefs {

    WebDriver webDriver= WebDriverManager.getDriver();
    DirectoryPage directoryPage = PageFactory.initElements(webDriver, DirectoryPage.class);

    @Given("^I open browser and login to Mort Web$")
    public void iOpenBrowserAndLoginToMortWeb(List<Map<String, String>> userLoginInfoList) throws Throwable {

        String userName= userLoginInfoList.get(0).get("UserName").toString();
        String password=userLoginInfoList.get(0).get("Password").toString();

        webDriver.navigate().to(Hooks.getMortWebUrl());
        LoginPage loginPage= PageFactory.initElements(webDriver, LoginPage.class);
        loginPage.Login(userName,password);

    }

    @Given("^I access to \"([^\"]*)\" module$")
    public void iAccessToModule(String module) throws Throwable {

        NavigationPage navigationPage = PageFactory.initElements(webDriver,NavigationPage.class);
        navigationPage.AccessToModule(module);
    }

    @Given("^I select (?:DataSource|DataSet|Report) as following$")
    public void iSelectDatasourceAsFollowing(List<Map<String,String>> sourceInfoList) throws Throwable {

        String directoryName = sourceInfoList.get(0).get("DirectoryName").toString();
        String sourceFileName=sourceInfoList.get(0).get("ResourceFileName").toString();

        DirectoryPage directoryPage = PageFactory.initElements(webDriver,DirectoryPage.class);
        directoryPage.clickDirectoryByName(directoryName);

        ResourceFileListPage resourceFileListPage=PageFactory.initElements(webDriver,ResourceFileListPage.class);
        resourceFileListPage.clickResourceByName(sourceFileName);

    }

    @When("^I click \"([^\"]*)\" item from dropdown menu of \"([^\"]*)\"$")
    public void iClickItemFromOperationMenuOf(String menuItem, String fileName) throws Throwable {

        ResourceFileListPage resourceFileListPage = PageFactory.initElements(webDriver,ResourceFileListPage.class);
        resourceFileListPage.clickOptionMenuOfResourceFile(fileName);
    }

    @Then("^I should NOT see deleted resource file \"([^\"]*)\" in directory$")
    public void iShouldNOTSeeDeletedResourceFileInDirectory(String fileName) throws Throwable {

        ResourceFileListPage resourceFileListPage = PageFactory.initElements(webDriver,ResourceFileListPage.class);
        assertThat(resourceFileListPage.isResourceFileExistedInList(fileName),is(false));
    }

    @And("^I select (?:DataSource|DataSet|Report) directory \"([^\"]*)\"$")
    public void iSelectDirectory(String directoryName) throws Throwable {

        directoryPage.clickDirectoryByName(directoryName);
    }
}
