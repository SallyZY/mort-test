package com.bigeyedata.morttest.pages.panels;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.Panel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.bigeyedata.morttest.CommonFunctions.findByXpath;
import static com.bigeyedata.morttest.CommonFunctions.waitForElementVisible;

/**
 * Created by yingzhang on 10/05/2017.
 */
public class ResourceItemsPanel implements Panel {

    @FindBy(id = "resourceListMenuContainerMenu")
    WebElement resourceFileListContainerDiv;

    @FindBy(css = "div.main-page-list-title > div > h3 > div.wrap-text > span")
    WebElement directoryNameLabel;

    @FindBy(className = "add-new-link")
    WebElement createNewResourceLink;

    @FindBy(id = "addNewDataSourceLink")
    WebElement createNewDataResourceLink;

    @FindBy(id = "newDataSourceDropDownMenu")
    WebElement dataSourceTypeUl;

    @FindBy(css = "#resourceListMenuContainerMenu > li.ant-menu-item-selected.ant-menu-item > div > span > span.item-right > i")
    WebElement dataSourceperateionMenuIcon;

    @FindBy(xpath = "//div/ul/li[text()='删除']")
    WebElement dataSourceDeleteLi;

    @FindBy(xpath = "//div[@class='ant-confirm-btns']/button[2]")
    WebElement confirmButton;

    @FindBy(id = "newDataSetDropDownMenu")
    WebElement dataSetTypeUl;

    @FindBy(css = "#newDataSetDropDownMenu > li:nth-child(2) > span")
    WebElement associatedDataSetSpan;

    @FindBy(className = "ant-modal-content")
    WebElement createAssociatedDataSetDiv;

    public void createNewResource() {

        createNewResourceLink.click();
        CommonFunctions.waitForElementVisible(dataSourceTypeUl);
    }

    public void createNewDataSetResource() {

        createNewResourceLink.click();
        CommonFunctions.waitForElementVisible(dataSetTypeUl);
    }

    public void createAssociatedDataSet() {
        associatedDataSetSpan.click();
        CommonFunctions.waitForElementVisible(createAssociatedDataSetDiv);
    }

    public void createNewDataResource(){

        createNewDataResourceLink.click();
        CommonFunctions.waitForElementVisible(dataSourceTypeUl);
    }

    public void clickResourceByName(String resourceName) {

        waitForElementVisible(resourceFileListContainerDiv);
        WebDriverManager.getDriver().findElement(By.xpath("//ul[@id='resourceListMenuContainerMenu']/li//span[@class='item-left']/span[text()='" + resourceName + "']")).click();

    }

    public void clickOptionMenuOfResourceFile(String resourceName) {

        waitForElementVisible(resourceFileListContainerDiv);
        List<WebElement> resourceList = resourceFileListContainerDiv.findElements(By.cssSelector("div.ResourceListItem"));

        WebElement datasetInfoDiv;
        String elementText;
        int fileIndex = -1;
        for (int i = 0; i < resourceList.size(); i++) {
            datasetInfoDiv = resourceList.get(i).findElement(By.cssSelector("div.head"));
            elementText = datasetInfoDiv.findElement(By.cssSelector("span")).getText();

            if (elementText.equals(resourceName)) {
                datasetInfoDiv.findElement(By.cssSelector("i:nth-child(3)")).click(); //error handle: directory is not existed
                break;
            }
        }
    }

    public void deleteDateSourceResourceFile() {
        CommonFunctions.waitForElementVisible(dataSourceperateionMenuIcon);
        dataSourceperateionMenuIcon.click();
        CommonFunctions.waitForElementVisible(dataSourceDeleteLi);
        dataSourceDeleteLi.click();
        CommonFunctions.waitForElementVisible(confirmButton);
        confirmButton.click();
    }





    public void locateItem(String sourceName){
        WebElement sourceItem = findByXpath("//div/span/span[1]/span[text()='" + sourceName + "']");
        CommonFunctions.waitForElementVisible(sourceItem);
        sourceItem.click();
    }

    public boolean isResourceExisted(String fileName) {
        waitForElementVisible(resourceFileListContainerDiv);
        System.out.println("resourceListMenuContainerMenu："+resourceFileListContainerDiv.getText()+"Boolean:"+resourceFileListContainerDiv.getText().contains(fileName));
        return resourceFileListContainerDiv.getText().contains(fileName);
    }

}
