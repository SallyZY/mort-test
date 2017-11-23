package com.bigeyedata.morttest.pages.panels.dataset;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.pages.panels.dataset.specificPanel.DataSetSpecificDetailPanel;
import cucumber.api.DataTable;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.bigeyedata.morttest.CommonFunctions.compareDataTable;
import static com.bigeyedata.morttest.CommonFunctions.extractDynamicPaths;
import static com.bigeyedata.morttest.CommonFunctions.findListByXpath;

/**
 * Created by yingzhang on 16/11/2017.
 */
public class SourceOfDataPanel extends DataSetSpecificDetailPanel {

    @Override
    public void verifyDetail(DataTable expectedDetailsTable) {
        compareDataTable(expectedDetailsTable, extractDynamicPaths("//div[@id='reportRelatedDataSet']//table", 1,2,4));
    }
}
