package com.bigeyedata.morttest.pages.management_pages;

import com.bigeyedata.morttest.pages.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by liaoyuxue on 2017/6/9.
 */
public class UserDetailPage extends Page {

    @FindBy(css = "#app > div > div.DefaultLayout > div.resource-page > div > div.manageOperation > button")
    WebElement createUserButton;

    @FindBy(css = "#app > div > div.DefaultLayout > div.resource-page > ul > div.menu-tree > div:nth-child(1) > ul > a > span")
    WebElement userManagementMenu;

    @FindBy(css = "#app > div > div.DefaultLayout > div.resource-page > ul > div.menu-tree > div:nth-child(1) > ul > li > ul > div:nth-child(3) > li > a")
    WebElement groupMenuItem;

    @FindBy(css = "#app > div > div.DefaultLayout > div.resource-page > div > div > div.manageOperation > button > span")
    WebElement createGroupButton;





    public void createUser(){

        createUserButton.click();

    }

    public void selectGroupMenuItem(){

//        userManagementMenu.click();
//        userManagementMenu.click();
        groupMenuItem.click();

    }

    public  void createGroup(){
        createGroupButton.click();
    }













}
