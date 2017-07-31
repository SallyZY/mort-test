package com.bigeyedata.morttest.pages.management_pages;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.Hooks;
import com.bigeyedata.morttest.pages.Page;
import org.openqa.selenium.By;
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

//    @FindBy(css = "div.ant-modal-footer > button.ant-btn.ant-btn-primary.ant-btn-lg > span")
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

    @FindBy(xpath = "//ul/li[@title=\"管理员\"]")
    WebElement admin;

    @FindBy(xpath = "//ul/li[@title=\"group\"]")
    WebElement group;

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

    @FindBy(xpath = "//div/ul/li[@title=\"admin support@bigeyedata.com\"]")
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

    public void setUsersBasicInformation(String userName,String email,String phone) throws InterruptedException {
        CommonFunctions.waitForElementVisible(userFrom);
        userNameInput.clear();
        userNameInput.sendKeys(userName);
        CommonFunctions.waitAShortTime();
        emailInput.clear();
        emailInput.sendKeys(email);
        CommonFunctions.waitAShortTime();
        phoneInput.clear();
        phoneInput.sendKeys(phone);


    }

    public void reSetUsersBasicInformation(String userName,String email) throws InterruptedException {
        CommonFunctions.waitForElementVisible(userFrom);
        userNameInput.clear();
        userNameInput.sendKeys(userName);
        CommonFunctions.waitAShortTime();
        emailInput.clear();
        emailInput.sendKeys(email);
        CommonFunctions.waitAShortTime();


    }

    public void clickConfirmButton() throws InterruptedException {
        CommonFunctions.waitForElementVisible(confirmButton);
        confirmButton.click();
    }

    public void setGroupName(String groupName) {
        groupNameInput.clear();
        groupNameInput.sendKeys(groupName);
    }

    public void setRoleName(String roleName){
        roleNameInput.sendKeys(roleName);
    }

    public void renameGroupName(String groupName) throws InterruptedException {
        CommonFunctions.waitAShortTime();
        groupNameInput.clear();
        groupNameInput.sendKeys(groupName);
    }

    public void saveEditPage(){
        editconfirmButton.click();
    }

    public void renameRoleName(String roleName) throws InterruptedException {
        CommonFunctions.waitAShortTime();
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

    public void setRole() throws InterruptedException {
        roleSelector.click();
        CommonFunctions.waitAShortTime();
        admin.click();
        CommonFunctions.waitAShortTime();
        phoneLab.click();
        CommonFunctions.waitAShortTime();
    }

    public void setGroup() throws InterruptedException {
        groupSelector.click();
        CommonFunctions.waitAShortTime();
        group.click();
        phoneLab.click();
        CommonFunctions.waitAShortTime();
    }

    public void setNewPassword(String password) throws InterruptedException {
        passwordModifyModalNewPasswordInput.sendKeys(password);
        CommonFunctions.waitAShortTime();
        passwordModifyModalConfirmNewPasswordInput.sendKeys(password);
        CommonFunctions.waitAShortTime();

    }

    public void saveNewPassword(){
        passwordModifyConfirmButton.click();
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

    public void deleteUserFromGroup() throws InterruptedException {
        waitForElementVisible(userOfGroupTab);
        List<WebElement> rows = userOfGroupTab.findElements(By.tagName("tr"));
        for (int i=0;i<rows.size();i++){
            System.out.println(i);
            String text = rows.get(i).getText();
            System.out.println(text);
            if (text.contains("support@bigeyedata.com")) {
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








}
