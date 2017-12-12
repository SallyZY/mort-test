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
import java.util.Map;

import static com.bigeyedata.morttest.CommonFunctions.fillData;
import static com.bigeyedata.morttest.CommonFunctions.findByXpath;

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
    }

    public void setRoleName(String roleName){
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












}
