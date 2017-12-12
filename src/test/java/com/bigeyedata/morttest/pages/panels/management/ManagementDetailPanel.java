package com.bigeyedata.morttest.pages.panels.management;

import com.bigeyedata.morttest.pages.Panel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.bigeyedata.morttest.CommonFunctions.waitForElementVisible;

public class ManagementDetailPanel extends Panel{

    @FindBy(tagName = "tbody")
    WebElement infoTab;


    public String getInformation() throws InterruptedException {

        waitForElementVisible(infoTab);
        return infoTab.getText();
    }


}
