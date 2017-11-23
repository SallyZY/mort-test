package com.bigeyedata.morttest.pages.panels.dataset;

import com.bigeyedata.morttest.pages.panels.dataset.specificPanel.DataSetSpecificDetailPanel;
import cucumber.api.DataTable;

import java.util.List;

import static com.bigeyedata.morttest.CommonFunctions.compareDataTable;
import static com.bigeyedata.morttest.CommonFunctions.extractDynamicPaths;

/**
 * Created by yingzhang on 16/11/2017.
 */
public class ImportPanel extends DataSetSpecificDetailPanel {

    @Override
    public void verifyDetail(DataTable expectedDetailsTable) {
        List<String> paths = extractDynamicPaths("//div[@id='dataSetImportHistory']//table", 3,4,5,6);
        compareDataTable(
                expectedDetailsTable,
                paths
        );
    }
}
