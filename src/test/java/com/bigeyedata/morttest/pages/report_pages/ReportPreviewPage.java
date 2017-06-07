package com.bigeyedata.morttest.pages.report_pages;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.bigeyedata.morttest.CommonFunctions.waitForElementVisibleAndLocated;

/**
 * Created by yingzhang on 19/05/2017.
 */
public class ReportPreviewPage extends Page {

    @FindBy(id = "reportEdit")
    WebElement reportEditButton;

    @FindBy(className = "grid")
    List<WebElement> chartDivList;

    @FindBy(id = "circleLoadingInMask")
    WebElement loadingMaskDiv;

    public void gotoReportEditPage() throws InterruptedException {

        Thread.sleep(5000);
        reportEditButton.click();
        waitForElementVisibleAndLocated(By.className("Chart"));
    }
}
