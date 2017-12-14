package com.bigeyedata.morttest.pages.panels.management;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.pages.Panel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.bigeyedata.morttest.CommonFunctions.findByLinkText;
import static com.bigeyedata.morttest.CommonFunctions.waitForElementVisible;

public class ManagementItemsPanel implements Panel{
    @FindBy(xpath = "//div//button[2]")
    WebElement deleteConfirmButton;

    public void selectMenuItem(String itemName) throws InterruptedException {
        switch (itemName) {
            case "edit":
                itemName = "编辑";
                break;
            case "modifyPassword":
                itemName = "修改密码";
                break;
            case "view":
                itemName = "查看";
                break;
            case "delete":
                itemName = "删除";
                break;
        }

        WebElement menuItem = findByLinkText(itemName);
        CommonFunctions.waitForElementVisible(menuItem);
        menuItem.click();

        if(itemName.equals("删除")){
            waitForElementVisible(deleteConfirmButton);
            deleteConfirmButton.click();
        }
    }
}
