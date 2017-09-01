package com.bigeyedata.morttest.pages;

import com.bigeyedata.morttest.CommonFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by yingzhang on 10/05/2017.
 */
public class DirectoryPanel extends Panel {

    @FindBy(id = "directoriesMenu")
    WebElement mainDirectoryContainerUl;

    @FindBy(css = "div.add-directory-btn > span:nth-child(2)")
    WebElement addDirectoryButton;

    @FindBy(css = "div.add-directory-window.show")
    WebElement directoryDialog;

    @FindBy(css = "div.directory-selector")
    WebElement dataSetDirectoryDiv;

    @FindBy(xpath = "//ul[@class='ant-select-tree']")
    WebElement directoryContainerUl;

    @FindBy(id="directoryContainerFolderIcon")
    WebElement dicExpandIcon;

    public void clickDicExpandIcon() throws InterruptedException {

        dicExpandIcon.click();
        CommonFunctions.waitForElementVisible(mainDirectoryContainerUl);
    }

    public void clickDirectoryByName(String directoryName) throws InterruptedException {

        CommonFunctions.waitForElementVisible(mainDirectoryContainerUl);
        CommonFunctions.clickDirectoryByName(directoryName);
    }

    public void selectSavedDirectoryByName(String directoryName) throws InterruptedException {

        CommonFunctions.waitForElementVisible(dataSetDirectoryDiv);
        dataSetDirectoryDiv.click();
        CommonFunctions.waitForElementVisible(directoryContainerUl);
        CommonFunctions.clickSavedDirectoryByName(directoryName);
    }

}
