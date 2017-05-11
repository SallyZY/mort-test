package com.bigeyedata.morttest.pages;

import com.bigeyedata.morttest.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by yingzhang on 10/05/2017.
 */
public class DirectoryPage extends Page {

    @FindBy(id = "mainPageDirectoriesContainer")
    WebElement directoryContainerUl;

    public void clickDirectoryByName(String directoryName) {

        List<WebElement> directoryList = directoryContainerUl.findElements(By.cssSelector("li > span"));

        String elementText;
        for(WebElement element:directoryList) {
            elementText = element.findElement(By.cssSelector("a.directory-name > div > span")).getText();

            if (elementText.equals(directoryName)) {
                element.click();   //error handle: directory is not existed
                break;
            }
        }
    }
}
