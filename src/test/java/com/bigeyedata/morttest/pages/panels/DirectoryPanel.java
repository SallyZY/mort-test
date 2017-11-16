package com.bigeyedata.morttest.pages.panels;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.Panel;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by yingzhang on 10/05/2017.
 */
public class DirectoryPanel extends Panel {

    @FindBy(id = "directoriesMenu")
    WebElement mainDirectoryContainerUl;

    @FindBy(css = "div.add-directory-btn > span:nth-child(2)")
    WebElement addDirectoryButton;

    @FindBy(css = "div.add-directory-window.show")
    WebElement directoryDialog;

    @FindBy(css = "div.directory-selector")
    WebElement dataSetDirectoryDiv;

    @FindBy(xpath = "//ul[@class='ant-select-tree']")
    WebElement directoryContainerUl;

    @FindBy(id="directoryContainerFolderIcon")
    WebElement dicExpandIcon;

    @FindBy(xpath = "//div/span[@title='数据源目录']/i[@title='新建目录']")
    WebElement createDirectoryIcon;

//    @FindBy(xpath = "//form//div//span[text()='请选择目录']")
    @FindBy(xpath = "//form//div//span")
    WebElement parentDirectorySelectorSpan;

    @FindBy(xpath = "//div//span[text()='根目录']")
    WebElement rootDirectorySpan;

    @FindBy(id = "name")
    WebElement directoryNameInput;

    @FindBy(xpath = "//div/button[2]/span")
    WebElement confirmButton;

    @FindBy(xpath = "//div/ul/li/ul")
    WebElement directoryListul;

    @FindBy(xpath = "//div/ul/li[text()='重命名']")
    WebElement renameItemLi;

    @FindBy(xpath = "//div/ul/li[text()='删除']")
    WebElement deleteItemLi;

    @FindBy(xpath = "//*[@id='directoriesMenu']/li/span/input")
    WebElement renameInput;

    @FindBy(css = "#app > div > div > div.resource-page > div > div.ant-layout > div > div > div.draggable-sider > div.ant-layout-sider > div > div.sort-container > span")
    WebElement directoryNameSpan;

    public void clickDicExpandIcon() throws InterruptedException {
        Thread.sleep(10000);
        dicExpandIcon.click();
        CommonFunctions.waitForElementVisible(mainDirectoryContainerUl);
    }

    public void clickDirectoryByName(String directoryName) throws InterruptedException {
        CommonFunctions.waitForElementVisible(mainDirectoryContainerUl);
        CommonFunctions.clickDirectoryByName(directoryName);
    }

    public void selectSavedDirectoryByName(String directoryName) throws InterruptedException {
        CommonFunctions.waitForElementVisible(dataSetDirectoryDiv);
        dataSetDirectoryDiv.click();
        CommonFunctions.waitForElementVisible(directoryContainerUl);
        CommonFunctions.clickSavedDirectoryByName(directoryName);
    }

    public void createDirectory() throws InterruptedException {
        CommonFunctions.waitForElementVisible(createDirectoryIcon);
        createDirectoryIcon.click();
    }


    public void selectRootDirectory(String directory) throws InterruptedException {
        CommonFunctions.waitForElementVisible(parentDirectorySelectorSpan);
        parentDirectorySelectorSpan.click();
        if (directory.equals("根目录")) {
            CommonFunctions.waitForElementVisible(rootDirectorySpan);
            rootDirectorySpan.click();
        }else {
            List<WebElement> directoryList = directoryListul.findElements(By.tagName("li")) ;
            for (int i=0;i<directoryList.size();i++){
                String directory1 = directoryList.get(i).getText();
                if(directory1.equals(directory)){
                    int n =i +1;
                    WebDriverManager.getDriver().findElement(By.xpath("//div/ul/li/ul/li[" + n + "]/span[2]/span"));
                    break;
                }else{
                    System.out.println("false");
                }
            }
        }
    }

    public void setDirectoryName(String directoryName) throws InterruptedException {
        CommonFunctions.waitForElementVisible(directoryNameInput);
        directoryNameInput.clear();
        directoryNameInput.sendKeys(directoryName);
    }

    public void saveDirectory(){
        confirmButton.click();
    }

    public boolean getDirectory(String directoryName) throws InterruptedException {
        CommonFunctions.waitForElementVisible(mainDirectoryContainerUl);
        List<WebElement> directoryList = mainDirectoryContainerUl.findElements(By.tagName("li")) ;
//        System.out.println(directoryList.size());
        boolean flg = false;
        for (int i=0;i<directoryList.size();i++){
            String directory = directoryList.get(i).getText();
//            System.out.println(directory);
            if(directory.equals(directoryName)){
                flg = true;
                break;
            }else{
                System.out.println("false");
            }
        }
        return flg;
    }

    public void clickMultiLevelDirectoryByName(String directoryName) throws InterruptedException {
        WebDriverManager.getDriver().findElement(By.xpath("//ul[@id='directoriesMenu']/li/div/span/span[text()='" + directoryName + "']")).click();
    }

    public void clicsubDirectoryByName(String directoryName) throws InterruptedException {
        CommonFunctions.waitForElementVisible(WebDriverManager.getDriver().findElement(By.xpath("//ul[@id='directoriesMenu']/li/ul/li/span/span[@title='" + directoryName + "']")));

        WebDriverManager.getDriver().findElement(By.xpath("//ul[@id='directoriesMenu']/li/ul/li/span/span[@title='" + directoryName + "']")).click();
    }

    public void openDropdownMenu(String directoryName) throws InterruptedException {
        CommonFunctions.waitForElementVisible(mainDirectoryContainerUl);
        List<WebElement> directoryList = mainDirectoryContainerUl.findElements(By.tagName("li")) ;
        for (int i=0;i<directoryList.size();i++){
            String directory = directoryList.get(i).getText();
            if(directory.equals(directoryName)){
                int n = i+1;
                WebDriverManager.getDriver().findElement(By.xpath("//*[@id='directoriesMenu']/li[" + n + "]/span/i")).click();
                break;
            }else{
                System.out.println("false");
            }
        }
    }


    public void openMultiLevelDropdownMenu(String directoryName) throws InterruptedException {
        CommonFunctions.waitForElementVisible(mainDirectoryContainerUl);
        List<WebElement> directoryList = mainDirectoryContainerUl.findElements(By.tagName("li")) ;
        for (int i=0;i<directoryList.size();i++){
            String directory = directoryList.get(i).getText();
            if(directory.contains(directoryName)){
                int n = i+1;
                WebDriverManager.getDriver().findElement(By.xpath("//*[@id='directoriesMenu']/li[" + n + "]/div/span/i")).click();
                break;
            }else{
                System.out.println("false");
            }
        }
    }


    public void goToRnamePage() throws InterruptedException{
        CommonFunctions.waitForElementVisible(renameItemLi);
        renameItemLi.click();
    }

    public void rename(String directoryName){
        renameInput.clear();
        renameInput.sendKeys(directoryName);
        renameInput.sendKeys(Keys.ENTER);
    }

    public void deleteDirectory() throws InterruptedException {
        CommonFunctions.waitForElementVisible(deleteItemLi);
        deleteItemLi.click();
        CommonFunctions.waitForElementVisible(confirmButton);
        confirmButton.click();
    }

    public void moveToDirectory(String directoryName) throws InterruptedException {
        CommonFunctions.waitForElementVisible(mainDirectoryContainerUl);
        Actions actions = new Actions(WebDriverManager.getDriver());
        actions.moveToElement(WebDriverManager.getDriver().findElement(By.xpath("//ul[@id='directoriesMenu']/li/div/span/span[text()='" + directoryName + "']"))).moveByOffset(10,3).build().perform();

    }

    public String getDrectoryName(){
        return directoryNameSpan.getText();
    }



}
