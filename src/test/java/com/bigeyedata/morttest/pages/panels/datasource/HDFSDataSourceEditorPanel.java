package com.bigeyedata.morttest.pages.panels.datasource;

import com.bigeyedata.morttest.types.DataSourceType;

import static com.bigeyedata.morttest.types.DataSourceType.HDFS;

/**
 * Created by yingzhang on 19/10/2017.
 */
public class HDFSDataSourceEditorPanel extends DataSourceSpecificEditorPanel {
    @Override
    public DataSourceType dataSourceType() {
        return HDFS;
    }
}
