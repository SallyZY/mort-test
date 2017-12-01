package com.bigeyedata.morttest.pages.panels.dataset.datasetEditor;

import com.bigeyedata.morttest.pages.Panel;
import com.bigeyedata.morttest.pages.panels.dataset.datasetEditor.subPanel.DataSetPreviewPanel;
import com.bigeyedata.morttest.pages.panels.dataset.datasetEditor.subPanel.JoinTypePanel;
import com.bigeyedata.morttest.pages.panels.dataset.datasetEditor.subPanel.SourceDataSetPanel;
import cucumber.api.DataTable;

import static com.bigeyedata.morttest.SeeThruUtils.initPanel;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by yingzhang on 28/11/2017.
 */
public class JoinDataSetEditPanel extends DataSetValidatorPanel {
    private JoinTypePanel joinTypePanel;

    public JoinDataSetEditPanel() {
        joinTypePanel = initPanel(JoinTypePanel.class);
    }

    public void verifyJoinType(DataTable data){
        joinTypePanel.validate(data);
    }

}
