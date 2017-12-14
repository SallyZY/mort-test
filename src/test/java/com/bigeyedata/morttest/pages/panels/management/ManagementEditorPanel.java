package com.bigeyedata.morttest.pages.panels.management;

import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.panels.management.specificPanel.ManagementSpecificEditorPanel;
import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.pages.Panel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.FindsByXPath;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.bigeyedata.morttest.CommonFunctions.*;

public class ManagementEditorPanel extends ManagementSpecificEditorPanel {

    @FindBy(css = "div.ant-modal-content > div.ant-modal-body > form")
    WebElement userFrom;

    @FindBy(id = "name")
    WebElement userNameInput;

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "phone")
    WebElement phoneInput;

    @FindBy(id = "roles")
    WebElement rolesInput;

    @FindBy(id = "groups")
    WebElement groupsInput;

    @FindBy(id = "superDataAuthority")
    WebElement superDataAuthoritySpan;

    @FindBy(css = "form > div:nth-child(4) > div.ant-col-16.ant-form-item-control-wrapper > div > div > div > div")
    WebElement roleSelector;

    @FindBy(xpath = "//div/label[@title=\"联系方式\"]")
    WebElement phoneLab;

    @FindBy(css = "form > div:nth-child(5) > div.ant-col-16.ant-form-item-control-wrapper > div > div > div > div")
    WebElement groupSelector;

    @FindBy(css = "div.ant-modal-content > div.ant-modal-footer > button.ant-btn.ant-btn-primary.ant-btn-lg > span")
    WebElement confirmButton;

    @FindBy(css = "div.ant-modal-content > div.ant-modal-body > div.role-name > input")
    WebElement roleNameInput;

    @FindBy(css = "div.ant-modal-content > div.ant-modal-body > div > div > p > input" )
    WebElement groupNameInput;

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

    @FindBy(id = "password")
    WebElement passwordModifyModalNewPasswordInput;

    @FindBy(id = "confirmedPassword")
    WebElement passwordModifyModalConfirmNewPasswordInput;

    @FindBy(id = "passwordModifyModalOkButton")
    WebElement passwordModifyConfirmButton;

    @FindBy(css = "div.ant-select-selection__placeholder")
    WebElement userSelectorDiv;

    @FindBy(css = "div.add-user-toolbar > button > span")
    WebElement addUserButton;

    @FindBy(css = "div.clearBoth > div > div > div > div > div > div > table > tbody")
    WebElement userOfGroupTab;

    @FindBy(css = "div.ant-modal-content > div.ant-modal-footer > button > span")
    WebElement closeViewUserGroupButton;

    @FindBy(css = "div.ant-table-placeholder")
    WebElement tablePlaceholderDiv;

    @FindBy(xpath = "//div//button[2]")
    WebElement deleteConfirmButton;

//    @FindBy(css = "div.ant-confirmCreatDir-btns > button.ant-btn.ant-btn-primary.ant-btn-lg")
//    WebElement deleteConfirmButton;


    private Map<String,WebElement> keysMap() {
        Map<String, WebElement> map = new HashMap();
        map.put("UserName", userNameInput);
        map.put("Email", emailInput);
        map.put("Phone", phoneInput);

        return map;
    }


    @Override
    public void createUser(Map<String,String> userBasicInfoList) throws InterruptedException{
        fillData(userBasicInfoList,keysMap());
    }


    @Override
    public void modifyUser(Map<String, String> userBasicInfoList) {
        fillData(userBasicInfoList,keysMap());
    }

    public void setRole(String roleTitle) throws InterruptedException {
        CommonFunctions.waitForElementVisible(roleSelector);
        roleSelector.click();
        WebElement role = findByXpath("//ul/li[@title='"+roleTitle+"']");
        CommonFunctions.waitForElementVisible(role);
        role.click();
        phoneLab.click();
    }

    public void setGroup(String groupTitle) throws InterruptedException {
        CommonFunctions.waitForElementVisible(groupSelector);
        groupSelector.click();
        WebElement group = findByXpath("//ul/li[@title='"+groupTitle+"']");
        CommonFunctions.waitForElementVisible(group);
        group.click();
        phoneLab.click();
        CommonFunctions.waitForShortTime();
    }

    public void setSuperDataAuthority(){
        superDataAuthoritySpan.click();
    }

    public void clickConfirmButton() throws InterruptedException {
        CommonFunctions.waitForElementVisible(confirmButton);
        confirmButton.click();
        waitForShortTime();
    }

    public void setRoleName(String roleName){
        roleNameInput.clear();
        roleNameInput.sendKeys(roleName);
    }

//    public void allocateResourcePermissions(WebElement... resousourceItem){
//        for(WebElement temp:resousourceItem){
//            temp.click();
//        }
//
//    }

    public void allocateResourcePermissions(){
        datasourcePermissions.click();
        datasetPermissions.click();
        reportPermissions.click();
        dashboardPermissions.click();
        managementPermissions.click();

    }

    public void setGroupName(String groupName) throws InterruptedException {
        CommonFunctions.waitForElementVisible(groupNameInput);
        groupNameInput.clear();
        groupNameInput.sendKeys(groupName);
    }


    public void setNewPassword(String password) throws InterruptedException {
        CommonFunctions.waitForElementVisible(passwordModifyModalNewPasswordInput);
        passwordModifyModalNewPasswordInput.sendKeys(password);
        CommonFunctions.waitForElementVisible(passwordModifyModalConfirmNewPasswordInput);
        passwordModifyModalConfirmNewPasswordInput.sendKeys(password);
        CommonFunctions.waitForShortTime();

    }


    public void saveNewPassword(){
        passwordModifyConfirmButton.click();
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

    public String getUserOfGroup() throws InterruptedException {
        CommonFunctions.waitForElementVisible(userOfGroupTab);
        return userOfGroupTab.getText();
    }

    public void closeViewUserGroupModalContent(){
        closeViewUserGroupButton.click();
    }

    public void deleteUserFromGroupOrRole(List<Map<String, String>> userInfo) throws InterruptedException {
        waitForElementVisible(userOfGroupTab);
        List<WebElement> rows = userOfGroupTab.findElements(By.tagName("tr"));
        for (int i=0;i<rows.size();i++){
            String text = rows.get(i).getText();
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

    public void deleteConfirm(){
        waitForElementVisible(deleteConfirmButton);
        deleteConfirmButton.click();
    }
}
