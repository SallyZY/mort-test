package com.bigeyedata.morttest.pages.panels.dataset;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.pages.panels.dataset.specificPanel.DataSetSpecificDetailPanel;
import cucumber.api.DataTable;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.bigeyedata.morttest.CommonFunctions.findListByXpath;

/**
 * Created by yingzhang on 16/11/2017.
 */
public class FieldPanel extends DataSetSpecificDetailPanel {

    @Override
    public void verifyDetail(DataTable expectedDetailsTable) {
        List<String> paths = CommonFunctions.extractDynamicPaths("//div[@id='fieldsDisplay']//table", 2, 3, 4);
        CommonFunctions.compareDataTable(
                expectedDetailsTable,
                paths
                );
    }

}
