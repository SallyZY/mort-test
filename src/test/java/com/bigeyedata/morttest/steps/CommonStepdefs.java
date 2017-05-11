package com.bigeyedata.morttest.steps;

import com.bigeyedata.morttest.Hook;
import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.DirectoryPage;
import com.bigeyedata.morttest.pages.LoginPage;
import com.bigeyedata.morttest.pages.NavigationPage;
import com.bigeyedata.morttest.pages.ResourceFileListPage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by yingzhang on 09/05/2017.
 */
public class CommonStepdefs {

    WebDriver webDriver= WebDriverManager.getDriver();

    @Given("^I open browser and login to Mort Web$")
    public void iOpenBrowserAndLoginToMortWeb(List<Map<String, String>> userLoginInfoList) throws Throwable {

        String userName= userLoginInfoList.get(0).get("UserName").toString();
        String password=userLoginInfoList.get(0).get("Password").toString();

        webDriver.navigate().to(Hook.getMortWebUrl());
        LoginPage loginPage= PageFactory.initElements(webDriver, LoginPage.class);
        loginPage.Login(userName,password);

    }

    @Given("^I access to \"([^\"]*)\" module$")
    public void iAccessToModule(String module) throws Throwable {

        NavigationPage navigationPage = PageFactory.initElements(webDriver,NavigationPage.class);
        navigationPage.AccessToModule(module);
    }

    @Given("^I select (?:datasource|dataset|report) as following$")
    public void iSelectDatasourceAsFollowing(List<Map<String,String>> sourceInfoList) throws Throwable {

        String directoryName = sourceInfoList.get(0).get("DirectoryName").toString();
        String sourceFileName=sourceInfoList.get(0).get("ResourceFileName").toString();

        DirectoryPage directoryPage = PageFactory.initElements(webDriver,DirectoryPage.class);
        directoryPage.clickDirectoryByName(directoryName);

        ResourceFileListPage resourceFileListPage=PageFactory.initElements(webDriver,ResourceFileListPage.class);
        resourceFileListPage.clickResourceByName(sourceFileName);

    }

}
