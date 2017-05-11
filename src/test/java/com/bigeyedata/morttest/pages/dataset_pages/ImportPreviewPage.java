package com.bigeyedata.morttest.pages.dataset_pages;

import com.bigeyedata.morttest.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

/**
 * Created by yingzhang on 11/05/2017.
 */
public class ImportPreviewPage extends Page {

    @FindBy(xpath = "//div[@class=' ant-tabs-tab'][1]")
    WebElement NumericFieldTab;

    @FindBy(xpath = "//div[@role='tab'][3]")
    WebElement DateFieldTab;

    @FindBy(xpath = "//div[@id='addDataSetPolicyDatetimeFieldsPreview']//table")
    WebElement DateFieldTable;

    public void gotoDateFieldPreviewTab()
    {
        DateFieldTab.click();
    }

    public void setDateFormatForDateField(List<Map<String, String>> dateFormatList) {

        List<WebElement> dateFieldList = DateFieldTable.findElements(By.cssSelector("tbody > tr"));

        String fieldName = "";
        String formatValue = "";
        for (int i = 0; i < dateFormatList.size(); i++) {
            fieldName = dateFormatList.get(i).get("FieldName").toString();

            for (int j = 0; j < dateFieldList.size(); j++) {
                if (fieldName.equals(dateFieldList.get(j).findElement(By.cssSelector("td:nth-child(2) > span")).getText())) {

                    formatValue=dateFormatList.get(i).get("DateFormat").toString();
                    dateFieldList.get(j).findElement(By.cssSelector("td:nth-child(4) > div > i")).click();
                    dateFieldList.get(j).findElement(By.cssSelector("td:nth-child(4) > div > input")).sendKeys(formatValue);
                    break;
                }
            }
        }
    }

}
