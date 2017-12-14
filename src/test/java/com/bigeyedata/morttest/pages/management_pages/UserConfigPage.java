package com.bigeyedata.morttest.pages.management_pages;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

import static com.bigeyedata.morttest.CommonFunctions.waitForElementVisible;

/**
 * Created by liaoyuxue on 2017/6/9.
 */
public class UserConfigPage extends Page{

    @FindBy(id = "name")
    WebElement userNameInput;

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "phone")
    WebElement phoneInput;

    @FindBy(css = "form > div:nth-child(4) > div.ant-col-16.ant-form-item-control-wrapper > div > div > div > div")
    WebElement roleSelector;

    @FindBy(css = "form > div:nth-child(5) > div.ant-col-16.ant-form-item-control-wrapper > div > div > div > div")
    WebElement groupSelector;

    @FindBy(css = "div.ant-modal-content > div.ant-modal-footer > button.ant-btn.ant-btn-primary.ant-btn-lg > span")
    WebElement confirmButton;

    @FindBy(css = "div.ant-modal-content > div.ant-modal-body > div > div > p > input" )
    WebElement groupNameInput;

    @FindBy(css = "div.ant-modal-content > div.ant-modal-body > div.role-name > input")
    WebElement roleNameInput;

    @FindBy(id = "passwordModifyModalOkButton")
    WebElement passwordModifyConfirmButton;

    @FindBy(css = "div.ant-modal-content > div.ant-modal-footer > button.ant-btn.ant-btn-primary.ant-btn-lg > span")
    WebElement editconfirmButton;

    @FindBy(css = "table > tbody > tr:nth-child(1) > td:nth-child(2) > span")
    WebElement datasourcePermissions;

    @FindBy(css = "table > tbody > tr:nth-child(2) > td:nth-child(2) > span")
    WebElement datasetPermissions;

    @FindBy(css = "table > tbody > tr:nth-child(3) > td:nth-child(2) > span")
    WebElement reportPermissions;

    @FindBy(css = "table > tbody > tr:nth-child(4) > td:nth-child(2) > span")
    WebElement dashboardPermissions;

    @FindBy(css = "table > tbody > tr:nth-child(5) > td:nth-child(2) > span")
    WebElement managementPermissions;

    @FindBy(xpath = "//div/label[@title=\"角色\"]")
    WebElement roleNameLab;

    @FindBy(xpath = "//div/label[@title=\"联系方式\"]")
    WebElement phoneLab;

    @FindBy(id = "password")
    WebElement passwordModifyModalNewPasswordInput;

    @FindBy(id = "confirmedPassword")
    WebElement passwordModifyModalConfirmNewPasswordInput;

    @FindBy(css = "div.ant-select-selection__placeholder")
    WebElement userSelectorDiv;

    @FindBy(xpath = "//div/ul/li[@title=\"admin seethru@fullsample.com\"]")
    WebElement adminUser;

    @FindBy(css = "div.add-user-toolbar > button > span")
    WebElement addUserButton;

    @FindBy(css = "div.clearBoth > div > div > div > div > div > div > table > tbody")
    WebElement userOfGroupTab;

    @FindBy(css = "div.ant-table-placeholder")
    WebElement tablePlaceholderDiv;

    @FindBy(css = "div.ant-modal-content > div.ant-modal-footer > button > span")
    WebElement closeViewUserGroupButton;

    @FindBy(css = "div.ant-message > span > div.ant-message-notice > div.ant-message-notice-content > div.ant-message-custom-content.ant-message-error > span")
    WebElement messageNotice;

    @FindBy(css = "div.ant-modal-content > div.ant-modal-body > form")
    WebElement userFrom;

    @FindBy(xpath = "//div/ul")
    WebElement userListUl;

    public void setUsersBasicInformation(String userName,String email,String phone) throws InterruptedException {
        CommonFunctions.waitForElementVisible(userFrom);
        userNameInput.clear();
        userNameInput.sendKeys(userName);
        CommonFunctions.waitForShortTime();
        emailInput.clear();
        emailInput.sendKeys(email);
        CommonFunctions.waitForShortTime();
        phoneInput.clear();
        phoneInput.sendKeys(phone);


    }

    public void reSetUsersBasicInformation(String userName,String email) throws InterruptedException {
        CommonFunctions.waitForElementVisible(userFrom);
        userNameInput.clear();
        userNameInput.sendKeys(userName);
        CommonFunctions.waitForShortTime();
        emailInput.clear();
        emailInput.sendKeys(email);
        CommonFunctions.waitForShortTime();


    }

    public void clickConfirmButton() throws InterruptedException {
        CommonFunctions.waitForElementVisible(confirmButton);
        confirmButton.click();
    }

    public void setGroupName(String groupName) throws InterruptedException {
        CommonFunctions.waitForElementVisible(groupNameInput);
        groupNameInput.clear();
        groupNameInput.sendKeys(groupName);
    }

    public void setRoleName(String roleName){
        roleNameInput.sendKeys(roleName);
    }

    public void renameGroupName(String groupName) throws InterruptedException {
        CommonFunctions.waitForElementVisible(groupNameInput);
        groupNameInput.clear();
        groupNameInput.sendKeys(groupName);
    }

    public void saveEditPage(){
        editconfirmButton.click();
    }

    public void renameRoleName(String roleName) throws InterruptedException {
        CommonFunctions.waitForShortTime();
        roleNameInput.clear();
        roleNameInput.sendKeys(roleName);
    }

    public void allocateResourcePermissions(){
        datasourcePermissions.click();
        datasetPermissions.click();
        reportPermissions.click();
        dashboardPermissions.click();
        managementPermissions.click();

    }

    public void setRole(String roleTitle) throws InterruptedException {
        WebDriver webDriver = WebDriverManager.getDriver();
        CommonFunctions.waitForElementVisible(roleSelector);
        roleSelector.click();
        WebElement role = webDriver.findElement(By.xpath("//ul/li[@title='"+roleTitle+"']"));
        CommonFunctions.waitForElementVisible(role);
        role.click();
        phoneLab.click();
    }

    public void setGroup(String groupTitle) throws InterruptedException {
        WebDriver webDriver = WebDriverManager.getDriver();
        CommonFunctions.waitForElementVisible(groupSelector);
        groupSelector.click();
        WebElement group = webDriver.findElement(By.xpath("//ul/li[@title='"+groupTitle+"']"));
        CommonFunctions.waitForElementVisible(group);
        group.click();
        phoneLab.click();
        CommonFunctions.waitForShortTime();
    }

    public void setNewPassword(String password) throws InterruptedException {
        CommonFunctions.waitForElementVisible(passwordModifyModalNewPasswordInput);
        passwordModifyModalNewPasswordInput.sendKeys(password);
        CommonFunctions.waitForElementVisible(passwordModifyModalConfirmNewPasswordInput);
        passwordModifyModalConfirmNewPasswordInput.sendKeys(password);
        CommonFunctions.waitForShortTime();

    }

    public void saveNewPassword() throws InterruptedException {
        passwordModifyConfirmButton.click();
        CommonFunctions.waitForShortTime();
    }

    public void addUserToGroup() throws InterruptedException {
        CommonFunctions.waitForElementVisible(userSelectorDiv);
        userSelectorDiv.click();
        CommonFunctions.waitForElementVisible(adminUser);
        adminUser.click();
        addUserButton.click();

    }

    public String getUserOfGroup() throws InterruptedException {
        CommonFunctions.waitForElementVisible(userOfGroupTab);
        return userOfGroupTab.getText();
    }

//    public void deleteUserFromGroup() throws InterruptedException {
//        waitForElementVisible(userOfGroupTab);
//        List<WebElement> rows = userOfGroupTab.findElements(By.tagName("tr"));
//        for (int i=0;i<rows.size();i++){
////            System.out.println(i);
//            String text = rows.get(i).getText();
////            System.out.println(text);
//            if (text.contains("seethru@fullsample.com")) {
//                int n = i + 1;
//                userOfGroupTab.findElement(By.cssSelector( "tr:nth-child("+n+") > td:nth-child(3) > a")).click();
//                break;
//            }else {
//                System.out.println("false");
//            }
//
//        }
//    }

    public void deleteUserFromGroupOrRole(List<Map<String, String>> userInfo) throws InterruptedException {
        waitForElementVisible(userOfGroupTab);
        List<WebElement> rows = userOfGroupTab.findElements(By.tagName("tr"));
        for (int i=0;i<rows.size();i++){
//            System.out.println(i);
            String text = rows.get(i).getText();
//            System.out.println(text);
            if (text.contains(userInfo.get(0).get("Email").toString())) {
                int n = i + 1;
                userOfGroupTab.findElement(By.cssSelector( "tr:nth-child("+n+") > td:nth-child(3) > a")).click();
                break;
            }else {
                System.out.println("false");
            }

        }
    }

    public String getPlaceholderMessage(){
        return tablePlaceholderDiv.getText();
    }

    public void closeViewUserGroupModalContent(){
        closeViewUserGroupButton.click();
    }

    public String getMessageNotice() throws InterruptedException {
        String message = messageNotice.getText();
        return message;

    }

    public void waitForMessageNoticeInvisible() throws InterruptedException {
        CommonFunctions.waitForElementInvisible(messageNotice);
    }

    public void addUserToRole(List<Map<String, String>> userList) throws InterruptedException {
        CommonFunctions.waitForElementVisible(userSelectorDiv);
        userSelectorDiv.click();
        String userName= userList.get(0).get("UserName").toString();
        String email = userList.get(0).get("Email").toString();
        WebDriver driver =WebDriverManager.getDriver();
        WebElement user = driver.findElement(By.xpath("//div/ul/li[@title='"+ userName +" "+ email +"']"));
        CommonFunctions.waitForElementVisible(user);
        user.click();
        addUserButton.click();

    }








}
