package com.bigeyedata.morttest.pages;

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

        List<WebElement> resourceList = resourceFileListContainerDiv.findElements(By.cssSelector("div.ResourceListItem"));

        String elementText;
        for (WebElement element: resourceList){
            elementText=element.findElement(By.cssSelector("div.head > span")).getText();

            if(elementText.equals(resourceName)){
                element.click();    //error handle: directory is not existed
                break;}
        }
    }

    public boolean isResourceFileExistedInList(String fileName){

        return resourceFileListContainerDiv.getText().contains(fileName);

    }
}
