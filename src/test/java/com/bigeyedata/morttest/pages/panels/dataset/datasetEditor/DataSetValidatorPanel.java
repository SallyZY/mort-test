package com.bigeyedata.morttest.pages.panels.dataset.datasetEditor;

import com.bigeyedata.morttest.pages.Panel;
import com.bigeyedata.morttest.pages.panels.dataset.datasetEditor.subPanel.SourceDataSetPanel;
import cucumber.api.DataTable;

import static com.bigeyedata.morttest.SeeThruUtils.initPanel;

/**
 * Created by yingzhang on 01/12/2017.
 */
public class DataSetValidatorPanel implements Panel {

    private SourceDataSetPanel sourceDataSetPanel;


    public DataSetValidatorPanel() {
        sourceDataSetPanel = initPanel(SourceDataSetPanel.class);
    }

    public void verifySourceDataSet(DataTable exceptedTable){
        sourceDataSetPanel.validate(exceptedTable);
    }

}
