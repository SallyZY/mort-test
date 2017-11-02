package com.bigeyedata.morttest.pages.panels.datasource.specificPanel;

import com.bigeyedata.morttest.pages.Panel;
import com.bigeyedata.morttest.types.DataSourceType;

import java.util.List;
import java.util.Map;

/**
 * Created by yingzhang on 19/10/2017.
 */
public abstract class DataSourceSpecificEditorPanel extends Panel {

    public abstract DataSourceType dataSourceType();
    public abstract void createDataSource(Map<String,String> dbConfigList) throws InterruptedException;
    public abstract void modifyRDBDataSource(Map<String,String> dbConfigList);
}
