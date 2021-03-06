package com.bigeyedata.morttest.pages.management_pages;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.panels.LoginPage;
import com.bigeyedata.morttest.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

import static com.bigeyedata.morttest.CommonFunctions.waitForElementVisible;

/**
 * Created by liaoyuxue on 2017/6/9.
 */
public class UserDetailPage extends Page {

    @FindBy(linkText = "用户")
    WebElement userMenuItem;

    @FindBy(css = "#app > div > div > div.resource-page > div > div.ant-layout > div > div > div.resource-action-bar.space-between > div.action-section > div > button.ant-btn.ant-btn-primary > span")
    WebElement createUserButton;

//    @FindBy(css = "#user\\24 Menu > li:nth-child(2) > a")
    @FindBy(linkText = "用户组")
    WebElement groupMenuItem;

    @FindBy(css = "#app > div > div > div.resource-page > div > div.ant-layout > div > div > div > div.resource-action-bar.space-between > div.action-section > div > button > span")
    WebElement createGroupButton;

    @FindBy(css = "div.ant-table-body > table > tbody")
    WebElement userBaseInfoTab;

    @FindBy(tagName = "tbody")
    WebElement groupInfoTab;

//    @FindBy(css = "#user\\24 Menu > li:nth-child(3) > a")
    @FindBy(linkText = "角色")
    WebElement roleMenuItem;

    @FindBy(css = "#app > div > div > div.resource-page > div > div.ant-layout > div > div > div.resource-action-bar.space-between > div.action-section > div > button > span")
    WebElement createRoleButton;

    @FindBy(tagName = "tbody")
    WebElement roleInfoTab;

    @FindBy(css = "div.ant-confirmCreatDir-btns > button.ant-btn.ant-btn-primary.ant-btn-lg > span")
    WebElement deleteConfirmButton;

    @FindBy(css = "#app > div > div.DefaultLayout > div.header > ul.rightBar.pull-right > li.user > a > div > i")
    WebElement userIcon;

//    @FindBy(css = "#headerRightNavBar > li.ant-dropdown-menu-item >a")
//    @FindBy(xpath = "//a[contains(@href,‘logout’)]")
    @FindBy(linkText = "退出")
    WebElement logoutLink;

    @FindBy(css = "#userListActionDropDownMenu > li:nth-child(1) > a")
    WebElement editUserMenuItem;

    @FindBy(xpath = "//*[@id=\"userListActionDropDownMenu\"]/li[2]/a")
    WebElement modifyPasswordMenuItem;

    @FindBy(css = "#userGroupListActionDropDownMenu > li:nth-child(2) > a")
    WebElement editGroupMenuItem;

    @FindBy(css = "#roleListActionDropDownMenu > li:nth-child(2) > a")
    WebElement editRoleMenuItem;

    @FindBy(css = "#userGroupListActionDropDownMenu > li:nth-child(3) > a")
    WebElement deleteGroupMenuItem;

    @FindBy(css = "#roleListActionDropDownMenu > li:nth-child(3) > a")
    WebElement deleteRoleMenuItem;

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "pass")
    WebElement passwordInput;

    @FindBy(css = "#userGroupListActionDropDownMenu > li:nth-child(1) > a")
    WebElement viewUserMenuItem;

    @FindBy(css = "#app > div > div > div.resource-page > div > div.ant-layout > div > div > div.resource-action-bar.space-between > div.action-section > div > span > input")
    WebElement userSearchInput;

    @FindBy(css = "div.action-section > div > span > span > i")
    WebElement searchicon;

    @FindBy(css = "#app > div > div > div.resource-page > div > div.ant-layout > div > div > div > div.resource-action-bar.space-between > div.action-section > div > span > input")
    WebElement groupSearchInput;

    @FindBy(css = "#roleListActionDropDownMenu > li:nth-child(1) > a")
    WebElement viewRoleMenuItem;


    public void selectUserMenuItem(){

        userMenuItem.click();

    }

    public void createUser(){

        createUserButton.click();

    }

    public String getUserBaseInfo() {

        waitForElementVisible(userBaseInfoTab);
        userBaseInfoTab.click();
        return userBaseInfoTab.getText();
    }

    public void selectGroupMenuItem(){

        groupMenuItem.click();

    }

    public void selectRoleMenuItem(){

        roleMenuItem.click();

    }

    public void createGroup(){
        createGroupButton.click();
    }

    public String getGroupInfo() {

        waitForElementVisible(groupInfoTab);
//        groupInfoTab.click();
        return groupInfoTab.getText();
    }

    public void createRole(){
        createRoleButton.click();
    }

    public String getRoleInfo() {

        waitForElementVisible(roleInfoTab);
//        roleInfoTab.click();
        return roleInfoTab.getText();
    }

    public void gotoEditGroupPage(String groupName) throws InterruptedException {
        waitForElementVisible(groupInfoTab);
        List<WebElement> rows = groupInfoTab.findElements(By.tagName("tr"));
        for (int i=0;i<rows.size();i++){
//            System.out.println(i);
            String text = rows.get(i).getText();
//            System.out.println(text);
            if (text.contains(groupName))
            {
                int n = i + 1;
                groupInfoTab.findElement(By.cssSelector( "tr:nth-child("+n+") > td:nth-child(4) > i")).click();
                CommonFunctions.waitForShortTime();
                editGroupMenuItem.click();
                break;
            }else {
                System.out.println("false");
            }

        }
    }


    public void gotoEditRolePage(String roleName) throws InterruptedException {
        waitForElementVisible(roleInfoTab);
        List<WebElement> rows = roleInfoTab.findElements(By.tagName("tr"));
        for (int i=0;i<rows.size();i++){
//            System.out.println(i);
            String text = rows.get(i).getText();
//            System.out.println(text);
            if (text.contains(roleName))
            {
                int n = i + 1;
                roleInfoTab.findElement(By.cssSelector( "tr:nth-child("+n+") > td:nth-child(4) > i")).click();
                CommonFunctions.waitForShortTime();
                editRoleMenuItem.click();
                break;
            }else {
                System.out.println("false");
            }

        }
    }

    public void gotoViewRolePage(String roleName) throws InterruptedException {
        waitForElementVisible(roleInfoTab);
        List<WebElement> rows = roleInfoTab.findElements(By.tagName("tr"));
        for (int i=0;i<rows.size();i++){
//            System.out.println(i);
            String text = rows.get(i).getText();
//            System.out.println(text);
            if (text.contains(roleName))
            {
                int n = i + 1;
                roleInfoTab.findElement(By.cssSelector( "tr:nth-child("+n+") > td:nth-child(4) > i")).click();
                CommonFunctions.waitForShortTime();
                viewRoleMenuItem.click();
                break;
            }else {
                System.out.println("false");
            }

        }
    }


    public void deleteGroup(String groupName) throws InterruptedException {
        waitForElementVisible(groupInfoTab);
        List<WebElement> rows = groupInfoTab.findElements(By.tagName("tr"));
        for (int i=0;i<rows.size();i++){
            System.out.println(i);
            String text = rows.get(i).getText();
            System.out.println(text);
            if (text.contains(groupName))
            {
                int n = i + 1;
                groupInfoTab.findElement(By.cssSelector( "tr:nth-child("+n+") > td:nth-child(4) > i")).click();
                CommonFunctions.waitForShortTime();
                deleteGroupMenuItem.click();
                CommonFunctions.waitForShortTime();
                deleteConfirmButton.click();
                break;
            }else {
                System.out.println("false");
            }

        }
    }


    public void deleteRole(String roleName) throws InterruptedException {
        waitForElementVisible(groupInfoTab);
        List<WebElement> rows = groupInfoTab.findElements(By.tagName("tr"));
        for (int i=0;i<rows.size();i++){
            System.out.println(i);
            String text = rows.get(i).getText();
            System.out.println(text);
            if (text.contains(roleName))
            {
                int n = i + 1;
                groupInfoTab.findElement(By.cssSelector( "tr:nth-child("+n+") > td:nth-child(4) > i")).click();
                CommonFunctions.waitForShortTime();
                deleteRoleMenuItem.click();
                CommonFunctions.waitForShortTime();
                deleteConfirmButton.click();
                break;
            }else {
                System.out.println("false");
            }

        }
    }


    public void goToEditUserPage(String email) throws InterruptedException {
        waitForElementVisible(userBaseInfoTab);
        List<WebElement> rows = userBaseInfoTab.findElements(By.tagName("tr"));
        for (int i=0;i<rows.size();i++){
            System.out.println(i);
            String text = rows.get(i).getText();
            System.out.println(text);
            if (text.contains(email)) {
                int n = i + 1;
                groupInfoTab.findElement(By.cssSelector( "tr:nth-child("+n+") > td:nth-child(5) > i")).click();
                CommonFunctions.waitForShortTime();
                editUserMenuItem.click();
                break;
            }else {
                System.out.println("false");
            }

        }
    }


    public void goToSetPasswordPage(String email) throws InterruptedException {
        waitForElementVisible(userBaseInfoTab);
        List<WebElement> rows = userBaseInfoTab.findElements(By.tagName("tr"));
        for (int i=0;i<rows.size();i++){
            System.out.println(i);
            String text = rows.get(i).getText();
            System.out.println(text);
            if (text.contains(email)) {
                int n = i + 1;
                groupInfoTab.findElement(By.cssSelector( "tr:nth-child("+n+") > td:nth-child(5) > i")).click();
                CommonFunctions.waitForShortTime();
                modifyPasswordMenuItem.click();
                break;
            }else {
                System.out.println("false");
            }

        }
    }


    public void logout() throws InterruptedException {

        Actions actions = new Actions(WebDriverManager.getDriver());
        CommonFunctions.waitForElementVisible(userIcon);
        actions.moveToElement(userIcon).clickAndHold().perform();
//        focusElement(logoutLink);
        CommonFunctions.waitForElementVisible(logoutLink);
        actions.moveToElement(logoutLink);
        logoutLink.click();

    }


    public void login(List<Map<String, String>> userLoginInfoList){

        WebDriver webDriver= WebDriverManager.getDriver();

        String userName= userLoginInfoList.get(0).get("UserName").toString();
        String password=userLoginInfoList.get(0).get("Password").toString();

        LoginPage loginPage= PageFactory.initElements(webDriver, LoginPage.class);
        loginPage.login(userName,password);



    }


    public void goToViewUserGroupPage(String groupName) throws InterruptedException {
        waitForElementVisible(groupInfoTab);
        List<WebElement> rows = groupInfoTab.findElements(By.tagName("tr"));
        for (int i=0;i<rows.size();i++){
            System.out.println(i);
            String text = rows.get(i).getText();
            System.out.println(text);
            if (text.contains(groupName))
            {
                int n = i + 1;
                groupInfoTab.findElement(By.cssSelector( "tr:nth-child("+n+") > td:nth-child(4) > i")).click();
                CommonFunctions.waitForShortTime();
                viewUserMenuItem.click();
                break;
            }else {
                System.out.println("false");
            }

        }
    }


    public void  searchByUserOrEmail(String keyWord){
        userSearchInput.clear();
        userSearchInput.sendKeys(keyWord);

    }

    public void search(){
        searchicon.click();
    }

    public void searchByGroupName(String groupName){
        groupSearchInput.sendKeys(groupName);
    }



}
