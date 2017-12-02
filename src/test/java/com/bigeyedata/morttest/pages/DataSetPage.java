package com.bigeyedata.morttest.pages;

import com.bigeyedata.morttest.pages.panels.NoticeMessagePanel;
import com.bigeyedata.morttest.pages.panels.dataset.*;
import com.bigeyedata.morttest.pages.panels.dataset.datasetEditor.DataSetValidatorPanel;
import com.bigeyedata.morttest.pages.panels.dataset.datasetEditor.JoinDataSetEditPanel;
import com.bigeyedata.morttest.pages.panels.dataset.datasetEditor.MoreOperationPanel;
import com.bigeyedata.morttest.pages.panels.dataset.datasetEditor.UnionDataSetEditPanel;

import static com.bigeyedata.morttest.SeeThruUtils.initPanel;

/**
 * Created by yingzhang on 09/11/2017.
 */
public class DataSetPage extends Page {

    public DataSetDetailPanel detailPanel = initPanel(DataSetDetailPanel.class);
    public NoticeMessagePanel noticePanel = initPanel(NoticeMessagePanel.class);
    public SourceItemMenuPanel sourceItemMenuPanel = initPanel(SourceItemMenuPanel.class);
    public MoreOperationPanel moreOperationPanel = initPanel(MoreOperationPanel.class);
    public JoinDataSetEditPanel joinEditPanel = initPanel(JoinDataSetEditPanel.class);
    public UnionDataSetEditPanel unionEditPanel = initPanel(UnionDataSetEditPanel.class);
    public DataSetValidatorPanel validatorPanel = initPanel(DataSetValidatorPanel.class);
}
