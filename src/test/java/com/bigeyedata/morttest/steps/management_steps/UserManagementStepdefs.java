package com.bigeyedata.morttest.steps.management_steps;

import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.management_pages.UserConfigPage;
import com.bigeyedata.morttest.pages.management_pages.UserDetailPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by liaoyuxue on 2017/6/9.
 */
public class UserManagementStepdefs {

    WebDriver webDriver= WebDriverManager.getDriver();
    UserDetailPage userDetailPage = PageFactory.initElements(webDriver,UserDetailPage.class);
    UserConfigPage userConfigPage = PageFactory.initElements(webDriver,UserConfigPage.class);

    @And("^I select group menuItem$")
    public void iSelectUserMenuItemAsFollowing() throws Throwable {

        Thread.sleep(10*1000);
        userDetailPage.selectGroupMenuItem();
        Thread.sleep(10*1000);

    }

    @And("^I click create new user button on user page$")
    public void iClickCreateNewUserButtonOnUserPage() throws Throwable {
        userDetailPage.createUser();
    }

    @And("^I input users basic information as following$")
    public void iInputUsersBasicInformationAsFollowing(List<Map<String, String>> userBasicInfoList) throws Throwable {
        String userName = userBasicInfoList.get(0).get("UserName").toString();
        String  email = userBasicInfoList.get(0).get("Email").toString();
        userConfigPage.setUsersBasicInformation(userName,email);
    }

    @When("^I create the user$")
    public void iCreateTheUser() throws Throwable {
//        Thread.sleep(1000);
        userConfigPage.createUser();
    }

    @Then("^I should see the user displayed correctly$")
    public void iShouldSeeTheUserDisplayedCorrectly() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I click create new group button on group page$")
    public void iClickCreateNewGroupButtonOnGroupPage() throws Throwable {

        userDetailPage.createGroup();

    }

    @And("^I input group name is \"([^\"]*)\"$")
    public void iInputGroupNameIs(String groupName) throws Throwable {

        userConfigPage.setGroupName(groupName);

    }

    @When("^I create the group$")
    public void iCreateTheGroup() throws Throwable {

        userConfigPage.createUser();

    }

    @Then("^I should see the group displayed correctly$")
    public void iShouldSeeTheGroupDisplayedCorrectly() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
