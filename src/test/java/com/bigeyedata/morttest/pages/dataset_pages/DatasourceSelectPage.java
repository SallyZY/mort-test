package com.bigeyedata.morttest.pages.dataset_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by yingzhang on 10/05/2017.
 */
public class DatasourceSelectPage {

    @FindBy(css = "button.ant-btn.ant-btn-primary")
    WebElement nextStepButton;

    public void gotoNextStep(){

        nextStepButton.click();
    }
}
