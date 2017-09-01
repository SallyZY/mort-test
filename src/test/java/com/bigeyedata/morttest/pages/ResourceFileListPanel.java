package com.bigeyedata.morttest.pages;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.bigeyedata.morttest.CommonFunctions.waitForElementVisible;
import static com.bigeyedata.morttest.CommonFunctions.waitForElementVisibleAndLocated;

/**
 * Created by yingzhang on 10/05/2017.
 */
public class ResourceFileListPanel extends Panel {

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


    public void createNewResource() throws InterruptedException {

        createNewResourceLink.click();
        CommonFunctions.waitForElementVisible(dataSourceTypeUl);
    }

    public void createNewDataResource() throws InterruptedException {

        createNewDataResourceLink.click();
        CommonFunctions.waitForElementVisible(dataSourceTypeUl);
    }

    public void clickResourceByName(String resourceName) throws InterruptedException {

        waitForElementVisible(resourceFileListContainerDiv);
        WebDriverManager.getDriver().findElement(By.xpath("//ul[@id='resourceListMenuContainerMenu']/li//span[@class='item-left']/span[text()='" + resourceName + "']")).click();
    }

    public void clickOptionMenuOfResourceFile(String resourceName) throws InterruptedException {

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

    public boolean isResourceFileExistedInList(String fileName) throws InterruptedException {

        waitForElementVisible(resourceFileListContainerDiv);
        return resourceFileListContainerDiv.getText().contains(fileName);

    }

}
