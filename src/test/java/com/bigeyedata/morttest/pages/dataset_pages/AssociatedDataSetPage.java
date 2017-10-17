package com.bigeyedata.morttest.pages.dataset_pages;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AssociatedDataSetPage extends Page {

    @FindBy(css = " div > span > span > span.ant-select-selection__rendered > span")
    WebElement selectDirectorySpan;

    @FindBy(css = "body > div:nth-child(15) > div > div > div")
    WebElement directoryListDiv;

    @FindBy(xpath = "//div/span/span/input")
    WebElement directorySelectorInput;

    @FindBy(xpath = "//div/ul/li/span[2]/span")
    WebElement selectedDirectorySpan;

    @FindBy(css = "div > ul > li:nth-child(1) > div > span > span > span")
    WebElement source;

    @FindBy(css = "div > div.ant-card-body > div > div > div > div:nth-child(1) > div")
    WebElement target;

    public void selectDirectory(String directoryName) throws InterruptedException {
        selectDirectorySpan.click();
//        CommonFunctions.waitForElementVisible(directoryListDiv);
        directorySelectorInput.click();
        directorySelectorInput.sendKeys(directoryName);
        selectedDirectorySpan.click();
        Thread.sleep(1000);
    }

    public void dragAndDrop(){

        Actions actions = new Actions(WebDriverManager.getDriver());
        actions.dragAndDrop(source,target).perform();
        actions.clickAndHold(source).moveToElement(target).release(target).perform();
    }






















}
