package com.bigeyedata.morttest.pages.panels;

import com.bigeyedata.morttest.pages.ManagementPage;
import com.bigeyedata.morttest.pages.Panel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.bigeyedata.morttest.CommonFunctions.waitForElementVisible;
import static com.bigeyedata.morttest.SeeThruUtils.onPage;

public class LeftNavigationPanel implements Panel{
    @FindBy(xpath = "//*[@id='app']//div//span[text()='用户管理']")
    WebElement userMenu;

    @FindBy(xpath = "//*[@id='app']//div//span[text()='配置']")
    WebElement configMenu;

    @FindBy(xpath = "//*[@id='app']//div//span[text()='监控管理']")
    WebElement monitorMenu;

    @FindBy(linkText = "用户")
    WebElement userLink;

    @FindBy(linkText = "用户组")
    WebElement userGroupLink;

    @FindBy(linkText = "角色")
    WebElement roleLink;

    public void accessToMenuItem(String item) throws InterruptedException {

//        waitForElementVisible(userMenu);
//        userMenu.click();
        switch (item){
            case "User":
                userLink.click();
                onPage(ManagementPage.class);
                break;
            case "UserGroup":
                userGroupLink.click();
                onPage(ManagementPage.class);
                break;
            case "Role":
                roleLink.click();
                onPage(ManagementPage.class);
                break;

        }
    }



}
