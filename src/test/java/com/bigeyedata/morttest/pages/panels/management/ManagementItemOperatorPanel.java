package com.bigeyedata.morttest.pages.panels.management;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.pages.Panel;
import com.bigeyedata.morttest.pages.panels.datasource.DataSourceItemOperatorPanel;
import com.bigeyedata.morttest.pages.panels.specificPanel.ResourceItemOperatorSpecificPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.bigeyedata.morttest.CommonFunctions.*;
import static com.bigeyedata.morttest.SeeThruUtils.initPanel;

public class ManagementItemOperatorPanel implements Panel {

    @FindBy(tagName = "tbody")
    WebElement infoTab;

    @FindBy(css = "#userListActionDropDownMenu > li:nth-child(1) > a")
    WebElement editUserMenuItem;

    @FindBy(id = "userListActionDropDownMenu")
    WebElement userActionDropDownMenu;


    public void locateUserItem(String email){
        waitForElementVisible(infoTab);
        List<WebElement> rows = infoTab.findElements(By.tagName("tr"));
        for (int i=0;i<rows.size();i++){
            System.out.println(i);
            String text = rows.get(i).getText();
            System.out.println(text);
            if (text.contains(email)) {
                int n = i + 1;
                infoTab.findElement(By.cssSelector( "tr:nth-child("+n+") > td:nth-child(5) > i")).click();
                break;
            }else {
                System.out.println("false");
            }

        }
    }

    public void localteGroupAndRoleItem(String groupName) throws InterruptedException {
        waitForElementVisible(infoTab);
        List<WebElement> rows = infoTab.findElements(By.tagName("tr"));
        for (int i=0;i<rows.size();i++){
            String text = rows.get(i).getText();
            if (text.contains(groupName))
            {
                int n = i + 1;
                infoTab.findElement(By.cssSelector( "tr:nth-child("+n+") > td:nth-child(4) > i")).click();
                CommonFunctions.waitForShortTime();
                break;
            }else {
                System.out.println("false");
            }

        }
    }






}
