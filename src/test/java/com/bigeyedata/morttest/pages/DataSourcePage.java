package com.bigeyedata.morttest.pages;

import com.bigeyedata.morttest.pages.panel.DataSourceEditorPanel;
import com.bigeyedata.morttest.pages.panel.RDBDataSourceDetailPanel;

import static com.bigeyedata.morttest.SeeThruUtils.initPanel;

/**
 * Created by yingzhang on 19/10/2017.
 */
public class DataSourcePage extends Page {

    public DataSourceEditorPanel dataSourceEditorPanel = initPanel(DataSourceEditorPanel.class);
    public RDBDataSourceDetailPanel rdbDetailPanel = initPanel(RDBDataSourceDetailPanel.class);
}
