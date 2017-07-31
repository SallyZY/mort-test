package com.bigeyedata.morttest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Created by yingzhang on 12/05/2017.
 */
public class CommonFunctions {

    public static void clickDirectoryByName(String directoryName) throws InterruptedException {

        WebDriverManager.getDriver().findElement(By.xpath("//ul[@id='directoriesMenu']/li/span/span[text()='"+directoryName+"']")).click();
    }

    public static void clickSavedDirectoryByName(String directoryName) throws InterruptedException {

        WebDriverManager.getDriver().findElement(By.xpath("//ul[@class='ant-select-tree']/li/span[2]/span[text()='" + directoryName + "']")).click();
    }

    public static void waitForElementVisible(WebElement element) throws InterruptedException {

        Thread.sleep(Hooks.getThreadSleepTime());
        new WebDriverWait(WebDriverManager.getDriver(), Hooks.getTimeOutInSeconds()).until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementInvisible(WebElement element) throws InterruptedException {

        Thread.sleep(Hooks.getThreadSleepTime());
        new WebDriverWait(WebDriverManager.getDriver(), Hooks.getTimeOutInSeconds()).until(ExpectedConditions.invisibilityOf(element));
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
        long currentTimeMillis = System.currentTimeMillis();
        currentTimeMillis += 60 * 1000;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String currentTime = dateFormat.format(new Date(currentTimeMillis));
        return currentTime;

    }


    public static void refresh(){

        WebDriverManager.getDriver().navigate().refresh();
    }

    public static void waitAShortTime() throws InterruptedException {
        Thread.sleep(Hooks.getThreadSleepTime());
    }

    public static void waitALongTime() throws InterruptedException {
        Thread.sleep(Hooks.getThreadSleepLongTime());
    }


    public static void logout() throws InterruptedException {

        WebDriver driver =WebDriverManager.getDriver();
        WebElement userIcon = driver.findElement(By.cssSelector("#app > div > div.DefaultLayout > div.header > ul.rightBar.pull-right > li.user > a > i"));
        WebElement logoutLink = driver.findElement(By.linkText("退出"));

        Actions actions = new Actions(driver);
        CommonFunctions.waitForElementVisible(userIcon);
        actions.moveToElement(userIcon).clickAndHold().perform();
//        focusElement(logoutLink);
        CommonFunctions.waitForElementVisible(logoutLink);
        actions.moveToElement(logoutLink);
        logoutLink.click();




    }


}
