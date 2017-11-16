package com.bigeyedata.morttest.pages.panels.dataset;

import com.bigeyedata.morttest.pages.panels.dataset.specificPanel.DataSetSpecificDetailPanel;
import cucumber.api.DataTable;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.bigeyedata.morttest.CommonFunctions.compareDataTable;
import static com.bigeyedata.morttest.CommonFunctions.findListByXpath;

/**
 * Created by yingzhang on 16/11/2017.
 */
public class FieldPanel extends DataSetSpecificDetailPanel {

    @Override
    public void verifyDetail(DataTable expectedDetailsTable) {
        compareDataTable(expectedDetailsTable,getLists());
    }

    private List<List<WebElement>> getLists(){
        List<WebElement> fieldAliasNameList = findListByXpath("//div[@id='fieldsDisplay']//table//td[2]");
        List<WebElement> fieldNameList = findListByXpath("//div[@id='fieldsDisplay']//table//td[3]");
        List<WebElement> fieldTypeList = findListByXpath("//div[@id='fieldsDisplay']//table//td[4]");

        List<List<WebElement>> colLists = new ArrayList<>();
        colLists.add(fieldAliasNameList);
        colLists.add(fieldNameList);
        colLists.add(fieldTypeList);

        return colLists;
    }
}