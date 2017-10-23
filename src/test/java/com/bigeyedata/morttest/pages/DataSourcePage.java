package com.bigeyedata.morttest.pages;

import com.bigeyedata.morttest.pages.panels.ResourceItemOperatorPanel;
import com.bigeyedata.morttest.pages.panels.datasource.DataSourceEditorPanel;
import com.bigeyedata.morttest.pages.panels.datasource.DataSourceItemOperatorPanel;
import com.bigeyedata.morttest.pages.panels.datasource.RDBDataSourceDetailPanel;
import org.apache.regexp.RE;

import static com.bigeyedata.morttest.SeeThruUtils.initPanel;

/**
 * Created by yingzhang on 19/10/2017.
 */
public class DataSourcePage extends Page {

    public DataSourceEditorPanel editorPanel = initPanel(DataSourceEditorPanel.class);
    public ResourceItemOperatorPanel itemOperatorPanel =initPanel(ResourceItemOperatorPanel.class);
    public RDBDataSourceDetailPanel rdbDetailPanel = initPanel(RDBDataSourceDetailPanel.class);
}
