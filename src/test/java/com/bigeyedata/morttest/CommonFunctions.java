package com.bigeyedata.morttest;

import cucumber.api.DataTable;
import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.bigeyedata.morttest.SeeThruUtils.currentPage;

/**
 * Created by yingzhang on 12/05/2017.
 */
public class CommonFunctions {

    public static void clickDirectoryByName(String directoryName) throws InterruptedException {

        WebDriverManager.getDriver().findElement(By.xpath("//ul[@id='directoriesMenu']/li/span/span[text()='" + directoryName + "']")).click();
    }

    public static void clickSavedDirectoryByName(String directoryName) throws InterruptedException {

        WebDriverManager.getDriver().findElement(By.xpath("//ul[@class='ant-select-tree']/li/span[2]/span[text()='" + directoryName + "']")).click();
    }

    public static void waitForElementVisible(WebElement element) throws InterruptedException {

//        Thread.sleep(Hooks.getThreadSleepTime());
        new WebDriverWait(WebDriverManager.getDriver(), Hooks.getTimeOutInSeconds()).until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementInvisible(WebElement element) throws InterruptedException {

//        Thread.sleep(Hooks.getThreadSleepTime());
        new WebDriverWait(WebDriverManager.getDriver(), Hooks.getTimeOutInSeconds()).until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitForElementVisibleAndLocated(By by) throws InterruptedException {

//        Thread.sleep(Hooks.getThreadSleepTime());
        new WebDriverWait(WebDriverManager.getDriver(), Hooks.getTimeOutInSeconds()).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementClickable(WebElement element) throws InterruptedException {

//        Thread.sleep(Hooks.getThreadSleepTime());
        new WebDriverWait(WebDriverManager.getDriver(), Hooks.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(element));

    }

    public static void focusElement(WebElement element) {

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) WebDriverManager.getDriver();
        javascriptExecutor.executeScript("arguments[0].focus", element);
    }

    public static void blurElement(WebElement element) {

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) WebDriverManager.getDriver();
        javascriptExecutor.executeScript("arguments[0].focus", element);
    }

    public static void clickElementAtCoordinates(WebElement element, int xOffset, int yOffset) {

        Actions actions = new Actions(WebDriverManager.getDriver());
        actions.moveToElement(element);
        actions.moveByOffset(xOffset, yOffset);
        actions.click().perform();
    }


    public static void mouseOverAtCoordinates(WebElement element, int xOffset, int yOffset) {

        Actions actions = new Actions(WebDriverManager.getDriver());
        actions.moveToElement(element, xOffset, yOffset).perform();
    }


    public static void doubleClick(WebElement element) {

        Actions actions = new Actions(WebDriverManager.getDriver());
        actions.doubleClick(element).clickAndHold(element).perform();
    }

    public static void executeJs(String JSString) {

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) WebDriverManager.getDriver();
        javascriptExecutor.executeScript(JSString);
    }


    public static String customizeImportDate() {
        long currentTimeMillis = System.currentTimeMillis();
        currentTimeMillis += 60 * 1000;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String currentTime = dateFormat.format(new Date(currentTimeMillis));
        return currentTime;

    }


    public static void refresh() {

        WebDriverManager.getDriver().navigate().refresh();
    }

    public static void waitForShortTime() throws InterruptedException {
        Thread.sleep(Hooks.getThreadSleepTime());
    }

    public static void waitForLongTime() throws InterruptedException {
        Thread.sleep(Hooks.getThreadSleepLongTime());
    }


    public static void logout() throws InterruptedException {

        WebDriver driver = WebDriverManager.getDriver();
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

    public static String getTestResourceFilePath(String fileName) {
        String classPath = currentPage().getClass().getResource("/").getPath();
        String testFilePath = classPath.substring(0, classPath.length() - 14) + "/test/resources/test-files/" + fileName;
        System.out.println(testFilePath);

        return testFilePath;
    }

    public static WebElement findByXpath(String xpath) {
        WebDriver driver = WebDriverManager.getDriver();
        return driver.findElement(By.xpath(xpath));
    }

    public static List<WebElement> findListByXpath(String xpath) {
        WebDriver driver = WebDriverManager.getDriver();
        return driver.findElements(By.xpath(xpath));
    }

    public static WebElement findById(String id) {
        WebDriver driver = WebDriverManager.getDriver();
        return driver.findElement(By.id(id));
    }

    public static void fillData(Map<String, String> data, Map<String, WebElement> keys) {
        Iterator<Map.Entry<String, String>> iterator = data.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> elementEntry = iterator.next();
            WebElement webElement = keys.get(elementEntry.getKey());
            if (webElement != null) {
                webElement.clear();
                webElement.sendKeys(elementEntry.getValue());
            }
        }
    }

    public static void compareDataTableByWebElement(DataTable expectedTable, List<List<WebElement>> actualTableCols) {
        List<List<String>> actualLists = new ArrayList();
        List<String> list = new ArrayList();

        List<String> titleRow = expectedTable.raw().get(0);
        for (String val : titleRow) {
            list.add(val);
        }
        actualLists.add(list);

        System.out.println("actualTableCols.get(0).size()" + actualTableCols.get(0).size());
        for (int i = 0; i < actualTableCols.get(0).size(); i++) {
            List<String> rowList = new ArrayList<>();
            for (int j = 0; j < actualTableCols.size(); j++) {
                rowList.add(actualTableCols.get(j).get(i).getText().trim());
                System.out.println("content" + actualTableCols.get(j).get(i).getText().trim());
            }
            actualLists.add(rowList);
        }

        System.out.println(actualTableCols.size());
        System.out.println(expectedTable.raw());
        expectedTable.diff(actualLists);
    }

    public static void compareDataTable(DataTable expectedTable, String... paths) {
        compareDataTableByWebElement(expectedTable, Arrays.asList(paths).stream().map(path -> findListByXpath(path)).collect(Collectors.toList()));
    }

    public static void compareDataTable(DataTable expectedTable, List<String> paths) {
        compareDataTableByWebElement(expectedTable, paths.stream().map(path -> findListByXpath(path)).collect(Collectors.toList()));
    }

    public static List<String> extractDynamicPaths(String tablePath, Integer... includes) {
        if (includes.length > 0) {
            return Arrays.asList(includes).stream().map(index -> tablePath + "//td[" + index + "]").collect(Collectors.toList());
        }

        List<WebElement> tableHeaders = findListByXpath(tablePath + "//th");
        List<String> colLists = new ArrayList<>();

        IntStream.range(1, tableHeaders.size() + 1).forEach(index -> {
                    colLists.add(tablePath + "//td[" + index + "]");
                }
        );

        return colLists;
    }

    public static void compareDataTableByText(DataTable expectedTable, List<List<String>> actualTableCols) {
        List<List<String>> actualLists = new ArrayList<List<String>>();
        List<String> list = new ArrayList<String>();

        List<String> titleRow = expectedTable.raw().get(0);
        for (String val : titleRow) {
            list.add(val);
        }
        actualLists.add(list);

        System.out.println("actualTableCols.get(0).size()" + actualTableCols.get(0).size());
        for (int i = 0; i < actualTableCols.get(0).size(); i++) {
            List<String> rowList = new ArrayList<>();
            for (int j = 0; j < actualTableCols.size(); j++) {
                rowList.add(actualTableCols.get(j).get(i).trim());
                System.out.println("content" + actualTableCols.get(j).get(i).trim());
            }
            actualLists.add(rowList);
        }

        System.out.println(actualTableCols.size());
        System.out.println(expectedTable.raw());
        expectedTable.diff(actualLists);
    }
}
