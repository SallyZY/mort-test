package com.bigeyedata.morttest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Created by yingzhang on 12/05/2017.
 */
public class CommonFunctions {

    public static void clickDirectoryByName(WebElement directoryContainer, String directoryName) throws InterruptedException {

        waitForElementVisible(directoryContainer);

        List<WebElement> directoryList = directoryContainer.findElements(By.cssSelector("li > span"));

        String elementText;
        for(WebElement element:directoryList) {
            elementText = element.findElement(By.cssSelector("span")).getText();

            if (elementText.equals(directoryName)) {
                element.click();   //error handle: directory is not existed
                break;
            }
        }
    }


    public static void waitForElementVisible(WebElement element) throws InterruptedException {

        Thread.sleep(Hooks.getThreadSleepTime());
        new WebDriverWait(WebDriverManager.getDriver(), Hooks.getTimeOutInSeconds()).until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementVisibleAndLocated(By by) throws InterruptedException {

        Thread.sleep(Hooks.getThreadSleepTime());
        new WebDriverWait(WebDriverManager.getDriver(), Hooks.getTimeOutInSeconds()).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementClickable(WebElement element) throws InterruptedException {

        Thread.sleep(Hooks.getThreadSleepTime());
        new WebDriverWait(WebDriverManager.getDriver(), Hooks.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(element));

    }

    public static void focusElement(WebElement element){

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) WebDriverManager.getDriver();
        javascriptExecutor.executeScript("arguments[0].focus",element);
    }

    public static void blurElement(WebElement element){

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) WebDriverManager.getDriver();
        javascriptExecutor.executeScript("arguments[0].focus",element);
    }

    public static void clickElementAtCoordinates(WebElement element, int xOffset, int yOffset){

        Actions actions = new Actions(WebDriverManager.getDriver());
        actions.moveToElement(element);
        actions.moveByOffset(xOffset, yOffset);
        actions.click().perform();
    }


    public static void mouseOverAtCoordinates(WebElement element, int xOffset, int yOffset){

        Actions actions = new Actions(WebDriverManager.getDriver());
        actions.moveToElement(element,xOffset,yOffset).perform();
    }


    public static void doubleClick(WebElement element){

        Actions actions = new Actions(WebDriverManager.getDriver());
        actions.doubleClick(element).clickAndHold(element).perform();
    }

    public static void executeJs(String JSString){

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) WebDriverManager.getDriver();
        javascriptExecutor.executeScript(JSString);
    }


    public static String customizeImportDate(){
        String currentTime;
        long curren = System.currentTimeMillis();
        curren += 60 * 1000;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        currentTime = dateFormat.format(new Date(curren));
        return currentTime;

    }


    public static void refresh(){

        WebDriverManager.getDriver().navigate().refresh();
    }


}
