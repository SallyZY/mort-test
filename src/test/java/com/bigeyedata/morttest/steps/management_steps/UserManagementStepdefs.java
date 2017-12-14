package com.bigeyedata.morttest.steps.management_steps;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.pages.ManagementPage;
import com.bigeyedata.morttest.pages.management_pages.UserConfigPage;
import com.bigeyedata.morttest.pages.management_pages.UserDetailPage;
import com.google.common.base.Verify;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.Map;

import static com.bigeyedata.morttest.SeeThruUtils.currentPage;
import static com.bigeyedata.morttest.SeeThruUtils.onPage;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by liaoyuxue on 2017/6/9.
 */
public class UserManagementStepdefs {


    @And("^I select group menuItem$")
    public void iSelectUserMenuItemAsFollowing() throws Throwable {
        onPage(UserDetailPage.class).selectGroupMenuItem();

    }

    @And("^I click create new user button on user page$")
    public void iClickCreateNewUserButtonOnUserPage() throws Throwable {
//        onPage(UserDetailPage.class).createUser();
        ((ManagementPage)currentPage()).managementOperatorPanel.createUser();
    }

    @And("^I input users basic information as following$")
    public void iInputUsersBasicInformationAsFollowing(List<Map<String, String>> userBasicInfoList) throws Throwable {
//        String userName = userBasicInfoList.get(0).get("UserName").toString();
//        String  email = userBasicInfoList.get(0).get("Email").toString();
//        String phone = userBasicInfoList.get(0).get("Phone").toString();
//        onPage(UserConfigPage.class).setUsersBasicInformation(userName,email,phone);

        ((ManagementPage)currentPage()).managementEditorPanel.createUser(userBasicInfoList.get(0));
    }


    @Then("^I should see the Email \"([^\"]*)\" in search result$")
    public void iShouldSeeTheUserDisplayedCorrectly(String email) throws Throwable {
//        assertTrue(onPage(UserDetailPage.class).getUserBaseInfo().contains(email));
        assertTrue(((ManagementPage)currentPage()).managementDetailPanel.getInformation().contains(email));
    }

    @And("^I access to set password page of email is \"([^\"]*)\"$")
    public void iAccessToSetPasswordPageOfEmailIs(String password) throws Throwable {
        onPage(UserDetailPage.class).goToSetPasswordPage(password);
    }

    @And("^I set a new password \"([^\"]*)\"$")
    public void iSetANewPassword(String password) throws Throwable {
//        onPage(UserConfigPage.class).setNewPassword(password);
        ((ManagementPage)currentPage()).managementEditorPanel.setNewPassword(password);
    }

    @When("^I save the new password$")
    public void iSaveTheNewPassword() throws Throwable {
//        onPage(UserConfigPage.class).saveNewPassword();
        ((ManagementPage)currentPage()).managementEditorPanel.saveNewPassword();
    }

//    @Then("^I should use the new password successful login as following$")
//    public void iShouldUseTheNewPasswordSuccessfulLoginAsFollowing(List<Map<String, String>> userLoginInfoList) throws Throwable {
//        onPage(UserDetailPage.class).logout();
//        onPage(UserDetailPage.class).login(userLoginInfoList);
//
//    }

    @And("^I click create new group button on group page$")
    public void iClickCreateNewGroupButtonOnGroupPage() throws Throwable {

//        onPage(UserDetailPage.class).createGroup();
        ((ManagementPage)currentPage()).managementOperatorPanel.createGroup();

    }

    @And("^I set group name is \"([^\"]*)\"$")
    public void iSetGroupNameIs(String groupName) throws Throwable {

//        onPage(UserConfigPage.class).setGroupName(groupName);
        ((ManagementPage)currentPage()).managementEditorPanel.setGroupName(groupName);

    }

    @When("^I create the (?:group|role|user)$")
    public void iCreateTheGroup() throws Throwable {
//        onPage(UserConfigPage.class).clickConfirmButton();
        ((ManagementPage)currentPage()).managementEditorPanel.clickConfirmButton();
     }

    @And("^I click create new role button on role page$")
    public void iClickCreateNewRoleButtonOnRolePage() throws Throwable {
//        onPage(UserDetailPage.class).createRole();
        ((ManagementPage)currentPage()).managementOperatorPanel.createRole();
    }

    @And("^I set role name is \"([^\"]*)\"$")
    public void iInputRoleNameIs(String roleName) throws Throwable {
//        onPage(UserConfigPage.class).setRoleName(roleName);
        ((ManagementPage)currentPage()).managementEditorPanel.setRoleName(roleName);
    }

    @And("^I grant all function permissions$")
    public void iGrantAllFunctionPermissions() throws Throwable {
//        onPage(UserConfigPage.class).allocateResourcePermissions();
        ((ManagementPage)currentPage()).managementEditorPanel.allocateResourcePermissions();
    }


    @Then("^I should see the role name is \"([^\"]*)\"$$")
    public void iShouldSeeTheRoleDisplayedCorrectly(String roleName) throws Throwable {
//        assertTrue(onPage(UserDetailPage.class).getRoleInfo().contains(roleName));
        assertTrue(((ManagementPage)currentPage()).managementDetailPanel.getInformation().contains(roleName));
    }

    @And("^I access to edit page of group name \"([^\"]*)\"$")
    public void iAccessToEditPageOfGroupNameIs(String groupName) throws Throwable {
        onPage(UserDetailPage.class).gotoEditGroupPage(groupName);

    }

    @And("^I modify the group name to \"([^\"]*)\"$")
    public void iModifyTheGroupNameTo(String groupName) throws Throwable {
//        onPage(UserConfigPage.class).renameGroupName(groupName);
        ((ManagementPage)currentPage()).managementEditorPanel.setGroupName(groupName);
    }



    @Then("^I should see the group name \"([^\"]*)\" in group list$")
    public void iShouldSeeTheGroupNameIs(String groupName) throws Throwable {
//        assertTrue(onPage(UserDetailPage.class).getRoleInfo().contains(groupName));
        assertTrue(((ManagementPage)currentPage()).managementDetailPanel.getInformation().contains(groupName));
    }


    @And("^I access to edit page of role name \"([^\"]*)\"$")
    public void iAccessToEditPageOfRoleNameIs(String roleName) throws Throwable {
        onPage(UserDetailPage.class).gotoEditRolePage(roleName);
    }

    @And("^I modify the role name to \"([^\"]*)\"$")
    public void IModifyTheRoleNameTo(String rolrName) throws Throwable {
//        onPage(UserConfigPage.class).renameRoleName(rolrName);
        ((ManagementPage)currentPage()).managementEditorPanel.setRoleName(rolrName);
    }


    @When("^I \"([^\"]*)\" the group named \"([^\"]*)\"$")
    public void iDeleteTheGroupNamed(String itemMenu,String groupName) throws Throwable {
//        onPage(UserDetailPage.class).deleteGroup(groupName);
        ((ManagementPage)currentPage()).managementItemOperatorPanel.localteGroupAndRoleItem(groupName);
        ((ManagementPage)currentPage()).managementItemsPanel.selectMenuItem(itemMenu);

    }

    @Then("^I should NOT see the group name \"([^\"]*)\" in group list$")
    public void iShouldnTSeeTheGroupNameIs(String groupName) throws Throwable {
//        assertFalse(onPage(UserDetailPage.class).getGroupInfo().contains(groupName));
        assertFalse((((ManagementPage)currentPage()).managementDetailPanel.getInformation().contains(groupName)));
    }

    @When("^I delete the role named \"([^\"]*)\"$")
    public void iDeleteTheRoleNamed(String roleName) throws Throwable {
        onPage(UserDetailPage.class).deleteRole(roleName);
    }

    @Then("^I should NOT see the role name is \"([^\"]*)\"$")
    public void iShouldnTSeeTheRoleNameIs(String roleName) throws Throwable {
//        assertFalse(onPage(UserDetailPage.class).getRoleInfo().contains(roleName));
        assertFalse(((ManagementPage)currentPage()).managementDetailPanel.getInformation().contains(roleName));

    }

    @And("^I \"([^\"]*)\" user's email \"([^\"]*)\"$")
    public void iUserSEmail(String menuItemName, String email) throws Throwable {
//        onPage(UserDetailPage.class).goToEditUserPage(email);
        ((ManagementPage)currentPage()).managementItemOperatorPanel.locateUserItem(email);
        ((ManagementPage)currentPage()).managementItemsPanel.selectMenuItem(menuItemName);
    }

    @And("^I modify the user basic information as following$")
    public void iModifyTheUserBasicInformationAsFollowing(List<Map<String, String>> userBasicInfoList) throws Throwable {
//        String userName = userBasicInfoList.get(0).get("UserName").toString();
//        String  email = userBasicInfoList.get(0).get("Email").toString();
//        onPage(UserConfigPage.class).reSetUsersBasicInformation(userName,email);
        ((ManagementPage)currentPage()).managementEditorPanel.modifyUser(userBasicInfoList.get(0));
    }

    @When("^I save the (?:user|group|role)$")
    public void iSaveTheUser() throws Throwable {
//        onPage(UserConfigPage.class).saveEditPage();
        ((ManagementPage)currentPage()).managementEditorPanel.clickConfirmButton();
    }

    @Then("^I should see the email \"([^\"]*)\" in user list$")
    public void iShouldSeeTheEmailIs(String email) throws Throwable {
//        assertTrue(onPage(UserDetailPage.class).getUserBaseInfo().contains(email));
        assertTrue(((ManagementPage)currentPage()).managementDetailPanel.getInformation().contains(email));
    }

    @Then("^I should see the prompt message is \"([^\"]*)\"$")
    public void iShouldSeeThePromptIs(String prompt) throws Throwable {
        assertTrue(onPage(UserConfigPage.class).getMessageNotice().equals(prompt));
        CommonFunctions.waitForShortTime();
    }


    @And("^I access to add user page of group name is \"([^\"]*)\"$")
    public void iAccessToAddUserPageOfGroupNameIs(String groupName) throws Throwable {
        onPage(UserDetailPage.class).goToViewUserGroupPage(groupName);
    }


    @Then("^I should see no data in the list$")
    public void iShouldSeeNoDataInTheList() throws Throwable {
//        assertTrue(onPage(UserConfigPage.class).getPlaceholderMessage().contains("暂无数据"));
//        onPage(UserConfigPage.class).closeViewUserGroupModalContent();

        ((ManagementPage)currentPage()).managementEditorPanel.getPlaceholderMessage().contains("暂无数据");
        ((ManagementPage)currentPage()).managementEditorPanel.closeViewUserGroupModalContent();

    }

//    @And("^I input the keyword \"([^\"]*)\" to user search box")
//    public void iInputUserNameIsToSearchInput(String keyWord) throws Throwable {
    @When("^I search the user \"([^\"]*)\"$")
    public void iSearchTheUser(String keyWord) throws Throwable {
//       onPage(UserDetailPage.class).searchByUserOrEmail(keyWord);
        ((ManagementPage)currentPage()).managementOperatorPanel.searchUserAndUserGroup(keyWord);
    }



    @Then("^I should see the user name \"([^\"]*)\" in search result$")
    public void iShouldSeeTheUserNameIs(String userName) throws Throwable {
//        assertTrue(onPage(UserDetailPage.class).getUserBaseInfo().contains(userName));
        assertTrue(((ManagementPage)currentPage()).managementDetailPanel.getInformation().contains(userName));
    }

    @And("^I input group name is \"([^\"]*)\" to searchInput$")
    public void iInputGroupNameIsToSearchInput(String groupName) throws Throwable {
        onPage(UserDetailPage.class).searchByGroupName(groupName);
    }

    @When("^I search the group name \"([^\"]*)\"$")
    public void iSearchTheGroupName(String groupName) throws Throwable {
        ((ManagementPage)currentPage()).managementOperatorPanel.searchUserAndUserGroup(groupName);
    }

    @When("^I select user menuItem$")
    public void iSelectUserMenuItem() throws Throwable {
        onPage(UserDetailPage.class).selectUserMenuItem();
    }

    @And("^I should see the user name \"([^\"]*)\" in user list$")
    public void iShouldSeeTheUserNameInUserList(String userName) throws Throwable {
//        assertTrue(onPage(UserDetailPage.class).getUserBaseInfo().contains(userName));
        assertTrue(((ManagementPage)currentPage()).managementDetailPanel.getInformation().contains(userName));
    }

    @And("^I set role is \"([^\"]*)\"$")
    public void iSetRoleIs(String roleTitle) throws Throwable {
//        onPage(UserConfigPage.class).setRole(roleTitle);
        ((ManagementPage)currentPage()).managementEditorPanel.setRole(roleTitle);
    }

    @And("^I set group is \"([^\"]*)\"$")
    public void iSetGroupIs(String groupTitle) throws Throwable {
//        onPage(UserConfigPage.class).setGroup(groupTitle);
        ((ManagementPage)currentPage()).managementEditorPanel.setGroup(groupTitle);
    }

    @When("^I access to view page of role name is \"([^\"]*)\"$")
    public void iAccessToViewPageOfRoleNameIs(String roleName) throws Throwable {
        onPage(UserDetailPage.class).gotoViewRolePage(roleName);
    }

    @And("^I add users to (?:group|role) as following$")
    public void iAddUsersToRoleAsFollowing(List<Map<String, String>> userList) throws Throwable {
//        onPage(UserConfigPage.class).addUserToRole(userList);
        ((ManagementPage)currentPage()).managementEditorPanel.addUserToRole(userList);
    }

    @Then("^I should see users displayed correctly as following$")
    public void iShouldSeeUsersDisplayedCorrectlyAsFollowing(List<Map<String, String>> userInfo) throws Throwable {
//        assertTrue(onPage(UserConfigPage.class).getUserOfGroup().contains(userInfo.get(0).get("Email").toString()));
//        onPage(UserConfigPage.class).closeViewUserGroupModalContent();

        assertTrue(((ManagementPage)currentPage()).managementEditorPanel.getUserOfGroup().contains(userInfo.get(0).get("Email").toString()));
        ((ManagementPage)currentPage()).managementEditorPanel.closeViewUserGroupModalContent();
    }

    @And("^I Delete users from (?:group|role) as following$")
    public void iDeleteUsersFromRoleAsFollowing(List<Map<String, String>> userInfo) throws Throwable {
//        onPage(UserConfigPage.class).deleteUserFromGroupOrRole(userInfo);
        ((ManagementPage)currentPage()).managementEditorPanel.deleteUserFromGroupOrRole(userInfo);
    }

    @And("^I select \"([^\"]*)\" menuItem$")
    public void iSelectMenuItem(String item) throws Throwable {
        currentPage().leftNavigationPanel.accessToMenuItem(item);
    }

    @When("^I search the email \"([^\"]*)\"$")
    public void iSearchTheEmail(String email) throws Throwable {
        ((ManagementPage)currentPage()).managementOperatorPanel.searchUserAndUserGroup(email);
    }

    @Then("^I should see the email \"([^\"]*)\" in search result$")
    public void iShouldSeeTheEmailInSearchResult(String email) throws Throwable {
        assertTrue(((ManagementPage)currentPage()).managementDetailPanel.getInformation().contains(email));
    }


    @When("^I \"([^\"]*)\" the group name \"([^\"]*)\"$")
    public void iTheGroupName(String menuItemName, String name) throws Throwable {
        ((ManagementPage)currentPage()).managementItemOperatorPanel.localteGroupAndRoleItem(name);
        ((ManagementPage)currentPage()).managementItemsPanel.selectMenuItem(menuItemName);
    }


    @When("^I \"([^\"]*)\" the role name \"([^\"]*)\"$")
    public void iTheRoleName(String menuItemName, String name) throws Throwable {
        ((ManagementPage)currentPage()).managementItemOperatorPanel.localteGroupAndRoleItem(name);
        ((ManagementPage)currentPage()).managementItemsPanel.selectMenuItem(menuItemName);
    }


}
