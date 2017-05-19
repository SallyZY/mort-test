package com.bigeyedata.morttest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
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


    public static void waitForElementInvisible(WebElement element){

        new WebDriverWait(WebDriverManager.getDriver(), Hooks.gettimeOutInSeconds()).until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitForElementVisible(WebElement element){

        new WebDriverWait(WebDriverManager.getDriver(), Hooks.gettimeOutInSeconds()).until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementVisibleAndLocated(By by){

        new WebDriverWait(WebDriverManager.getDriver(), Hooks.gettimeOutInSeconds()).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void focusElement(WebElement element){

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) WebDriverManager.getDriver();
        javascriptExecutor.executeScript("arguments[0].focus",element);
    }

    public static void clickElementAtCoordinates(WebElement element, int xOffset, int yOffset){

        Actions actions = new Actions(WebDriverManager.getDriver());
        actions.moveToElement(element);
        actions.moveByOffset(xOffset, yOffset);
        actions.click().perform();
    }








}
