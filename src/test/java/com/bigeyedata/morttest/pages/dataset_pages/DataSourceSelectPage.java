package com.bigeyedata.morttest.pages.dataset_pages;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.bigeyedata.morttest.CommonFunctions.waitForElementVisibleAndLocated;

/**
 * Created by yingzhang on 10/05/2017.
 */
public class DataSourceSelectPage extends Page {

    @FindBy(css = "button.ant-btn.ant-btn-primary")
    WebElement nextStepButton;

    public void gotoNextStep() throws InterruptedException {
        CommonFunctions.waitForElementVisible(nextStepButton);
        nextStepButton.click();
        waitForElementVisibleAndLocated(By.id("addDataSetPreview"));
    }
}
