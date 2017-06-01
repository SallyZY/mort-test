package com.bigeyedata.morttest.pages;

import com.bigeyedata.morttest.CommonFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by yingzhang on 10/05/2017.
 */
public class DirectoryPage extends Page {

    @FindBy(id = "mainPageDirectoriesContainer")
    WebElement directoryContainerUl;

    @FindBy(css = "div.add-directory-btn > span:nth-child(2)")
    WebElement addDirectoryButton;

    @FindBy(css = "div.add-directory-window.show")
    WebElement directoryDialog;


    public void clickDirectoryByName(String directoryName) throws InterruptedException {

        CommonFunctions.clickDirectoryByName(directoryContainerUl,directoryName);
    }
}
