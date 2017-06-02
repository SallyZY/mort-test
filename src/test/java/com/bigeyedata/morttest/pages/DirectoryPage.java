package com.bigeyedata.morttest.pages;

import com.bigeyedata.morttest.CommonFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by yingzhang on 10/05/2017.
 */
public class DirectoryPage extends Page {

    @FindBy(id = "mainPageDirectoriesContainer")
    WebElement mainDirectoryContainerUl;

    @FindBy(css = "div.add-directory-btn > span:nth-child(2)")
    WebElement addDirectoryButton;

    @FindBy(css = "div.add-directory-window.show")
    WebElement directoryDialog;

    @FindBy(css = "div.choose-directory > input")
    WebElement dataSetDirectoryInput;

    @FindBy(id = "chooseDirectoryDirectoriesContainer")
    WebElement directoryContainerUl;


    public void clickDirectoryByName(String directoryName) throws InterruptedException {

        CommonFunctions.clickDirectoryByName(mainDirectoryContainerUl,directoryName);
    }

    public void selectSavedDirectoryByName(String directoryName) throws InterruptedException {

        dataSetDirectoryInput.click();
        CommonFunctions.clickDirectoryByName(directoryContainerUl,directoryName);
    }

}
