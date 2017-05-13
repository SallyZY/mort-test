package com.bigeyedata.morttest;

import org.apache.bcel.generic.NEW;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by yingzhang on 12/05/2017.
 */
public class CommonFunctions {

    public static void clickDirectoryByName(WebElement directoryContainer, String directoryName){

        waitForElementVisible(directoryContainer);

        List<WebElement> directoryList = directoryContainer.findElements(By.cssSelector("li > span"));

        String elementText;
        for(WebElement element:directoryList) {
            elementText = element.findElement(By.cssSelector("a.directory-name > div > span")).getText();

            if (elementText.equals(directoryName)) {
                element.click();   //error handle: directory is not existed
                break;
            }
        }
    }

    public static void waitForElementVisible(WebElement element){

        new WebDriverWait(WebDriverManager.getDriver(),Hook.gettimeOutInSeconds()).until(ExpectedConditions.visibilityOf(element));
    }

}
