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

    public void clickDirectoryByName(String directoryName) {

        CommonFunctions.clickDirectoryByName(directoryContainerUl,directoryName);
    }
}
