package com.bigeyedata.morttest.pages.panels.dataset.specificPanel;

import com.bigeyedata.morttest.pages.Panel;
import cucumber.api.DataTable;

/**
 * Created by yingzhang on 16/11/2017.
 */
public abstract class DataSetSpecificDetailPanel implements Panel {

    public abstract void verifyDetail(DataTable expectedDetailsTable);
}
