package com.bigeyedata.morttest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by yingzhang on 10/05/2017.
 */
public class DirectoryPage extends Page {

    @FindBy(id = "mainPageDirectoriesContainer")
    WebElement directoryContainerUl;

    public void clickDirectoryByName(String directoryName) {

        CommonFunctions.clickDirectoryByName(directoryContainerUl,directoryName);
    }
}
