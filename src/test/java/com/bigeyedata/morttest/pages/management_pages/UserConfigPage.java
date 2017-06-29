package com.bigeyedata.morttest.pages.management_pages;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.Hooks;
import com.bigeyedata.morttest.pages.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

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

//    @FindBy(css = "div.ant-modal-content > div.ant-modal-footer > button.ant-btn.ant-btn-primary.ant-btn-lg > span")
//    @FindBy(css = "body > div:nth-child(7) > div > div.ant-modal-wrap > div > div.ant-modal-content > div.ant-modal-footer > button.ant-btn.ant-btn-primary.ant-btn-lg")
    @FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[1]/div[3]/button[2]/span")
    WebElement confirmButton;

    @FindBy(css = "body > div:nth-child(7) > div > div.ant-modal-wrap > div > div.ant-modal-content > div.ant-modal-body > div > div > p > input" )
    WebElement groupNameInput;

//    @FindBy(css = "body > div:nth-child(7) > div > div.ant-modal-wrap > div > div.ant-modal-content > div.ant-modal-footer > button.ant-btn.ant-btn-primary.ant-btn-lg > span")
//    WebElement groupConfirmButton;



    public void setUsersBasicInformation(String userName,String email) throws InterruptedException {
//        CommonFunctions.focusElement(userNameInput);
//        userNameInput.sendKeys(userName);
//        CommonFunctions.focusElement(emailInput);
//        CommonFunctions.executeJs("document.getElementById('email').value ='123@126.com'");

        CommonFunctions.focusElement(userNameInput);
        Thread.sleep(5000);
        userNameInput.sendKeys(userName);
//        CommonFunctions.executeJs("document.getElementById('name').value ='ddd'");
        Thread.sleep(5000);
        CommonFunctions.blurElement(userNameInput);
        Thread.sleep(5000);
        CommonFunctions.focusElement(emailInput);
        Thread.sleep(5000);
        emailInput.sendKeys(email);
        Thread.sleep(5000);
        CommonFunctions.blurElement(emailInput);
        Thread.sleep(5000);


    }

    public void createUser(){
        Hooks.getThreadSleepTime();
        confirmButton.click();
    }

    public void setGroupName(String groupName){
        groupNameInput.sendKeys(groupName);
    }





}
