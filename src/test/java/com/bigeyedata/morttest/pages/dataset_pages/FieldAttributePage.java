package com.bigeyedata.morttest.pages.dataset_pages;

import com.bigeyedata.morttest.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by yingzhang on 12/05/2017.
 */
public class FieldAttributePage extends Page {

    @FindBy(css = "div#fieldsDisplay > table")
    WebElement FieldAttributeTable;

    public int getFieldCountOfDataset()
    {
        List<WebElement> trList = FieldAttributeTable.findElements(By.cssSelector("tr"));
        return  trList.size();
    }
}
