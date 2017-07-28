package com.bigeyedata.morttest.steps.management_steps;

import com.bigeyedata.morttest.CommonFunctions;
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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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
        String phone = userBasicInfoList.get(0).get("Phone").toString();
        userConfigPage.setUsersBasicInformation(userName,email,phone);
    }

    @And("^I set role is 管理员$")
    public void iSetRoleIs() throws Throwable {
        userConfigPage.setRole();
    }

    @And("^I set group is group$")
    public void iSetGroupIs() throws Throwable {
        userConfigPage.setGroup();
    }


    @Then("^I should see the Email is \"([^\"]*)\"$")
    public void iShouldSeeTheUserDisplayedCorrectly(String email) throws Throwable {
        assertTrue(userDetailPage.getUserBaseInfo().contains(email));
    }

    @And("^I access to set password page of email is \"([^\"]*)\"$")
    public void iAccessToSetPasswordPageOfEmailIs(String password) throws Throwable {
        userDetailPage.goToSetPasswordPage(password);
    }

    @And("^I set a new password \"([^\"]*)\"$")
    public void iSetANewPassword(String password) throws Throwable {
        userConfigPage.setNewPassword(password);
    }

    @When("^I save the new password$")
    public void iSaveTheNewPassword() throws Throwable {
        userConfigPage.saveNewPassword();
    }

    @Then("^I should use the new password successful login  as following$")
    public void iShouldUseTheNewPasswordSuccessfulLoginAsFollowing(List<Map<String, String>> userLoginInfoList) throws Throwable {
        userDetailPage.logout();
        userDetailPage.login(userLoginInfoList);
    }

    @And("^I click create new group button on group page$")
    public void iClickCreateNewGroupButtonOnGroupPage() throws Throwable {

        userDetailPage.createGroup();

    }

    @And("^I input group name is \"([^\"]*)\"$")
    public void iInputGroupNameIs(String groupName) throws Throwable {

        userConfigPage.setGroupName(groupName);

    }

    @When("^I create the (?:group|role|user)$")
    public void iCreateTheGroup() throws Throwable {

        userConfigPage.clickConfirmButton();

    }


    @And("^I select role menuItem$")
    public void iSelectRoleMenuItem() throws Throwable {
        userDetailPage.selectRoleMenuItem();
    }

    @And("^I click create new role button on role page$")
    public void iClickCreateNewRoleButtonOnRolePage() throws Throwable {
        userDetailPage.createRole();
    }

    @And("^I input role name is \"([^\"]*)\"$")
    public void iInputRoleNameIs(String roleName) throws Throwable {
        userConfigPage.setRoleName(roleName);
    }

    @And("^I allocate all resource permissions$")
    public void iAllocateAllResourcePermissions() throws Throwable {
        userConfigPage.allocateResourcePermissions();
    }


    @Then("^I should see the role name is \"([^\"]*)\"$$")
    public void iShouldSeeTheRoleDisplayedCorrectly(String roleName) throws Throwable {
        assertTrue(userDetailPage.getRoleInfo().contains(roleName));
    }

    @And("^I access to edit page of group name is \"([^\"]*)\"$")
    public void iAccessToEditPageOfGroupNameIs(String groupName) throws Throwable {
        userDetailPage.gotoEditGroupPage(groupName);
    }

    @And("^And I modify the group name to \"([^\"]*)\"$")
    public void andIModifyTheGroupNameTo(String groupName) throws Throwable {
        userConfigPage.renameGroupName(groupName);
    }


    @Then("^I should see the group name is \"([^\"]*)\"$")
    public void iShouldSeeTheGroupNameIs(String groupName) throws Throwable {
        assertTrue(userDetailPage.getRoleInfo().contains(groupName));
    }


    @And("^I access to edit page of role name is \"([^\"]*)\"$")
    public void iAccessToEditPageOfRoleNameIs(String roleName) throws Throwable {
        userDetailPage.gotoEditRolePage(roleName);
    }

    @And("^I modify the role name to \"([^\"]*)\"$")
    public void IModifyTheRoleNameTo(String rolrName) throws Throwable {
        userConfigPage.renameRoleName(rolrName);
    }


    @When("^I delete the group named \"([^\"]*)\"$")
    public void iDeleteTheGroupNamed(String groupName) throws Throwable {
        userDetailPage.deleteGroup(groupName);
    }

    @Then("^I shouldn't see the group name is \"([^\"]*)\"$")
    public void iShouldnTSeeTheGroupNameIs(String groupName) throws Throwable {
        assertFalse(userDetailPage.getGroupInfo().contains(groupName));
    }

    @When("^I delete the role named \"([^\"]*)\"$")
    public void iDeleteTheRoleNamed(String roleName) throws Throwable {
        userDetailPage.deleteRole(roleName);
    }

    @Then("^I shouldn't see the role name is \"([^\"]*)\"$")
    public void iShouldnTSeeTheRoleNameIs(String roleName) throws Throwable {
        assertFalse(userDetailPage.getRoleInfo().contains(roleName));
    }

    @And("^I access to edit page of email is \"([^\"]*)\"$")
    public void iAccessToEditPageOfEmailIs(String email) throws Throwable {
        userDetailPage.goToEditUserPage(email);
    }

    @And("^I modify the user basic information as following$")
    public void iModifyTheUserBasicInformationAsFollowing(List<Map<String, String>> userBasicInfoList) throws Throwable {
        String userName = userBasicInfoList.get(0).get("UserName").toString();
        String  email = userBasicInfoList.get(0).get("Email").toString();
        userConfigPage.reSetUsersBasicInformation(userName,email);
    }

    @When("^I save the (?:user|group|role)$")
    public void iSaveTheUser() throws Throwable {
        userConfigPage.saveEditPage();
    }

    @Then("^I should see the email is \"([^\"]*)\"$")
    public void iShouldSeeTheEmailIs(String email) throws Throwable {
        assertTrue(userDetailPage.getUserBaseInfo().contains(email));
    }

    @Then("^I should see the prompt is \"([^\"]*)\"$")
    public void iShouldSeeThePromptIs(String prompt) throws Throwable {
        assertTrue(userConfigPage.getMessageNotice().equals(prompt));
    }


    @And("^I access to add user page of group name is \"([^\"]*)\"$")
    public void iAccessToAddUserPageOfGroupNameIs(String groupName) throws Throwable {
       userDetailPage.goToViewUserGroupPage(groupName);
    }

    @When("^I add user to group$")
    public void iAddUserToGroup() throws Throwable {
        userConfigPage.addUserToGroup();
    }

    @Then("^I should see the user displayed correctly$")
    public void iShouldSeeTheUserDisplayedCorrectly() throws Throwable {
        assertTrue(userConfigPage.getUserOfGroup().contains("support@bigeyedata.com"));
        userConfigPage.closeViewUserGroupModalContent();
    }

    @When("^I Delete user from group$")
    public void iDeleteUserFromGroup() throws Throwable {
        userConfigPage.deleteUserFromGroup();
    }

    @Then("^I should see no data in the list$")
    public void iShouldSeeNoDataInTheList() throws Throwable {
        assertTrue(userConfigPage.getPlaceholderMessage().contains("暂无数据"));
        userConfigPage.closeViewUserGroupModalContent();
    }

    @And("^I input user name is \"([^\"]*)\" to searchInput$")
    public void iInputUserNameIsToSearchInput(String userName) throws Throwable {
       userDetailPage.searchByUserOrEmail(userName);
    }

    @When("^I click search button$")
    public void iClickSearchButton() throws Throwable {
       userDetailPage.search();
    }

    @Then("^I should see the user name is \"([^\"]*)\"$")
    public void iShouldSeeTheUserNameIs(String userName) throws Throwable {
        assertTrue(userDetailPage.getUserBaseInfo().contains(userName));
    }

    @And("^I input email is \"([^\"]*)\" to searchInput$")
    public void iInputEmailIsToSearchInput(String email) throws Throwable {
        userDetailPage.searchByUserOrEmail(email);
    }

    @And("^I input group name is \"([^\"]*)\" to searchInput$")
    public void iInputGroupNameIsToSearchInput(String groupName) throws Throwable {
        userDetailPage.searchByGroupName(groupName);
    }
}
