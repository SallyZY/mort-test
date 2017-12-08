package com.bigeyedata.morttest.pages.dataset_pages;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.bigeyedata.morttest.CommonFunctions.waitForElementInvisible;
import static com.bigeyedata.morttest.CommonFunctions.waitForElementVisible;

/**
 * Created by yingzhang on 02/08/2017.
 */
public class DataSetListPage extends Page {

    public static int n;

    @FindBy(id = "reportDataSetCollection")
    WebElement dataSetListDiv;

    @FindBy(xpath = "//ul[@role='menu']//li[text()='虚拟字段']")
    WebElement virtualDimensionMenuLi;

    @FindBy(xpath = "//ul[@role='menu']//li[text()='虚拟指标']")
    WebElement virtualMeasureMenuLi;

    @FindBy(className = "ant-modal-content")
    WebElement virtualFieldDialog;

    @FindBy(className = "ant-modal-content")
    WebElement virtualMeasureDialog;

    public void openVirtualDimensionDialog(String dataSetName) throws InterruptedException {


        waitForElementVisible(dataSetListDiv);

        List<WebElement> rows = dataSetListDiv.findElements(By.xpath("ul/li//span[@class='title-left']/span[@class='name ellipsis']"));

        for (int i=0;i<rows.size();i++){
            String text = rows.get(i).getText();
            if (text.contains(dataSetName)) {
                n = i + 1;
                CommonFunctions.mouseOverAtCoordinates(dataSetListDiv.findElement(By.xpath("ul//span[@title='" + dataSetName + "']")),60,14);
                CommonFunctions.waitForShortTime();
                dataSetListDiv.findElement(By.xpath("ul/li[" + n + "]/span[2]/span/span/i[2]")).click();
                break;
            }

        }

        waitForElementVisible(virtualDimensionMenuLi);
        virtualDimensionMenuLi.click();

        waitForElementVisible(virtualFieldDialog);

    }



    public String getFieldList(){
        String FieldListText;
        FieldListText = dataSetListDiv.findElement(By.xpath("ul/li[" + n + "]/div/div/ul")).getText();
        return FieldListText;
    }


    public void openVirtualMeasureDialog(String dataSetName) throws InterruptedException {


        waitForElementVisible(dataSetListDiv);

        List<WebElement> rows = dataSetListDiv.findElements(By.xpath("ul/li//span[@class='dataSet-title']/span[@class='dataSet-name ellipsis']"));

        for (int i=0;i<rows.size();i++){
            String text = rows.get(i).getText();
            if (text.contains(dataSetName)) {
                n = i + 1;
                CommonFunctions.mouseOverAtCoordinates(dataSetListDiv.findElement(By.xpath("ul//span[@title='" + dataSetName + "']")),60,14);
                CommonFunctions.waitForShortTime();
                dataSetListDiv.findElement(By.xpath("ul/li[" + n + "]/span[2]/span/span/i[2]")).click();
                break;
            }

        }

        waitForElementVisible(virtualMeasureMenuLi);
        virtualMeasureMenuLi.click();

        waitForElementVisible(virtualMeasureDialog);

    }



}
