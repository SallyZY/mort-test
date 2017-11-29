package com.bigeyedata.morttest.pages.panels.dataset.datasetOperator;

import com.bigeyedata.morttest.pages.Panel;
import cucumber.api.DataTable;

import java.util.List;

/**
 * Created by yingzhang on 29/11/2017.
 */
public abstract class DataSetSpecificEditPanel extends Panel {

    public abstract void verifySourceDataSet(List<String> datasetList);
    public abstract void verifySourceDataSetField(DataTable expectedFieldTable);
    public abstract void verifyDataSetFiled(DataTable expectedFieldTable);
}
