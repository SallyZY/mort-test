package com.bigeyedata.morttest.pages.dataset_pages;

import com.bigeyedata.morttest.CommonFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by yingzhang on 10/05/2017.
 */
public class DataSourceSelectPage {

    @FindBy(css = "button.ant-btn.ant-btn-primary")
    WebElement nextStepButton;

    public void gotoNextStep() throws InterruptedException {
        CommonFunctions.waitForElementVisible(nextStepButton);
        nextStepButton.click();
    }
}
