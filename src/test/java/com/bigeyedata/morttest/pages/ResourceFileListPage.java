package com.bigeyedata.morttest.pages;

import com.bigeyedata.morttest.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by yingzhang on 10/05/2017.
 */
public class ResourceFileListPage extends Page {

    @FindBy(id = "resourceListItemsContainer")
    WebElement resourceFileListContainerDiv;

    @FindBy(css = "div.main-page-list-title > div > h3 > div.wrap-text > span")
    WebElement directoryNameLabel;

    public void clickResourceByName(String resourceName) {

        CommonFunctions.waitForElementVisible(resourceFileListContainerDiv);
        List<WebElement> resourceList = resourceFileListContainerDiv.findElements(By.cssSelector("div.ResourceListItem"));

        String elementText;
        for (WebElement element: resourceList){
            elementText=element.findElement(By.cssSelector("div.head > span")).getText();

            if(elementText.equals(resourceName)){
                element.click();    //error handle: directory is not existed
                break;}
        }
    }

    public void clickOptionMenuOfResourceFile(String resourceName) {

        CommonFunctions.waitForElementVisible(resourceFileListContainerDiv);
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

    public boolean isResourceFileExistedInList(String fileName){

//        CommonFunctions.waitForElementVisible(resourceFileListContainerDiv);
        CommonFunctions.waitForElementVisibleAndLocated(By.id("resourceListItemsContainer"));
        return resourceFileListContainerDiv.getText().contains(fileName);

    }
}
