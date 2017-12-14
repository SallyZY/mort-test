package com.bigeyedata.morttest.pages.panels.management;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.pages.Panel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManagementOperatorPanel implements Panel{

    @FindBy( xpath = "//*[@id='app']//div/button/span[text()='创建用户']")
    WebElement createUserButton;

    @FindBy(xpath = "//*[@id='app']//div/button/span[text()='创建用户组']")
    WebElement createGroupButton;

    @FindBy(xpath = "//*[@id='app']//div/button/span[text()='创建角色']")
    WebElement createRoleButton;

    @FindBy(xpath = "//*[@id='app']//div[2]//span/input")
    WebElement searchInput;

    @FindBy(css = "div.action-section > div > span > span > i")
    WebElement searchicon;

    public void createUser() throws InterruptedException {
        CommonFunctions.waitForElementVisible(createUserButton);
        createUserButton.click();
    }

    public void createRole() throws InterruptedException {
        CommonFunctions.waitForElementVisible(createRoleButton);
        createRoleButton.click();
    }

    public void createGroup() throws InterruptedException {
        CommonFunctions.waitForElementVisible(createGroupButton);
        CommonFunctions.waitForShortTime();
        createGroupButton.click();
    }

    public void  searchUserAndUserGroup(String keyWord) throws InterruptedException {
        searchInput.clear();
        searchInput.sendKeys(keyWord);
        searchicon.click();
//        CommonFunctions.waitForShortTime();

    }




}
