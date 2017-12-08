package com.bigeyedata.morttest.pages.panels;

import com.bigeyedata.morttest.pages.Panel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.bigeyedata.morttest.CommonFunctions.findByXpath;
import static com.bigeyedata.morttest.CommonFunctions.waitForElementVisible;

/**
 * Created by yingzhang on 08/12/2017.
 */
public class DirectoryEditorPanel implements Panel {

    @FindBy(xpath = "//div[@class='ant-menu-item-group-title']//i[@title='新建目录']")
    WebElement newDirIcon;

    @FindBy(xpath = "//form//div//span")
    WebElement dirExpandSpan;

    @FindBy(xpath = "//div//span[text()='根目录']")
    WebElement rootDirItem;

    @FindBy(xpath = "//div/ul/li/ul")
    WebElement dirList;

    @FindBy(id = "name")
    WebElement dirName;

    @FindBy(xpath = "//div/button[2]/span")
    WebElement confirmButton;

    public void createDir() {
        waitForElementVisible(newDirIcon);
        newDirIcon.click();
    }

    public void selectParentDir(String dirName) {
        waitForElementVisible(dirExpandSpan);
        dirExpandSpan.click();
        waitForElementVisible(rootDirItem);

        if (dirName.equals("根目录"))
            rootDirItem.click();

        else {
            findByXpath("//ul[@class='ant-select-tree']/li/span[1]").click();
            findByXpath("//div/ul/li/ul/li//span[@title='" + dirName + "']").click();
//            List<WebElement> directoryList = dirList.findElements(By.tagName("li"));
//            for (int i = 0; i < directoryList.size(); i++) {
//                String dirText = directoryList.get(i).getText();
//                if (dirText.equals(dirName)) {
//                    int n = i + 1;
//                    findByXpath("//div/ul/li/ul/li[" + n + "]/span[2]/span");
//                    break;
//                }
//            }
        }
    }


    public void setDirName(String directoryName){
        waitForElementVisible(dirName);
        dirName.clear();
        dirName.sendKeys(directoryName);
    }

    public void confirmCreatDir(){
        confirmButton.click();
    }
}
