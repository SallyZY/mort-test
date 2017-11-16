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
public class DataPreviewPanel extends DataSetSpecificDetailPanel {
    @Override
    public void verifyDetail(DataTable expectedDetailsTable) {
        compareDataTable(expectedDetailsTable, getLists());
    }

    private List<List<WebElement>> getLists() {
        List<WebElement> tableHeaders = findListByXpath("//div[@id='dataSetDataPreview']//table//th");
        List<List<WebElement>> colLists = new ArrayList<>();

        int columnNo = 0;
        for (int i = 0; i < tableHeaders.size(); i++) {
            columnNo = i + 1;
            colLists.add(findListByXpath("//div[@id='dataSetDataPreview']//table//td[" + columnNo + "]"));
        }

//        List<WebElement> data_ActualIncome = findListByXpath("//div[@id='dataSetDataPreview']//table//td[1]//span[2]");
//        List<WebElement> ActualIncome = findListByXpath("//div[@id='dataSetDataPreview']//table//td[2]//span");
//        List<WebElement> data_ActualCost = findListByXpath("//div[@id='dataSetDataPreview']//table//td[3]//span");
//        List<WebElement> ActualCost = findListByXpath("//div[@id='dataSetDataPreview']//table//td[4]//span");
//        List<WebElement> data_ExpectedIncome = findListByXpath("//div[@id='dataSetDataPreview']//table//td[5]//span");
//        List<WebElement> ExpectedIncome = findListByXpath("//div[@id='dataSetDataPreview']//table//td[6]//span");
//
//
//        colLists.add(data_ActualIncome);
//        colLists.add(ActualIncome);
//        colLists.add(data_ActualCost);
//        colLists.add(ActualCost);
//        colLists.add(data_ExpectedIncome);
//        colLists.add(ExpectedIncome);

        return colLists;
    }
}
