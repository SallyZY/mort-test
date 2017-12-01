package com.bigeyedata.morttest.pages.panels.dataset.datasetEditor;

import com.bigeyedata.morttest.pages.Panel;
import com.bigeyedata.morttest.pages.panels.dataset.datasetEditor.subPanel.JoinTypePanel;
import com.bigeyedata.morttest.pages.panels.dataset.datasetEditor.subPanel.SourceDataSetPanel;
import cucumber.api.DataTable;

import java.util.List;

import static com.bigeyedata.morttest.SeeThruUtils.initPanel;

/**
 * Created by yingzhang on 29/11/2017.
 */
public class UnionDataSetEditPanel implements Panel {

    private SourceDataSetPanel sourceDataSetPanel;

    public UnionDataSetEditPanel() {
        sourceDataSetPanel = initPanel(SourceDataSetPanel.class);
    }

    public void verifyJoinSourceDataset(DataTable exceptedTable){
        sourceDataSetPanel.validate(exceptedTable);
    }

}
