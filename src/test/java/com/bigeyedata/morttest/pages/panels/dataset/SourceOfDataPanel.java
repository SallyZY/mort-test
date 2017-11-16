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
public class SourceOfDataPanel extends DataSetSpecificDetailPanel {
    @Override
    public void verifyDetail(DataTable expectedDetailsTable) {
        List<WebElement> dataSetNameList = findListByXpath("//div[@id='reportRelatedDataSet']//table//td[1]");
        List<WebElement> createrList = findListByXpath("//div[@id='reportRelatedDataSet']//table//td[2]");
        List<WebElement> statusList = findListByXpath("//div[@id='reportRelatedDataSet']//table//td[4]");

        List<List<WebElement>> colLists = new ArrayList<>();
        colLists.add(dataSetNameList);
        colLists.add(createrList);
        colLists.add(statusList);

        compareDataTable(expectedDetailsTable,colLists);
    }
}
