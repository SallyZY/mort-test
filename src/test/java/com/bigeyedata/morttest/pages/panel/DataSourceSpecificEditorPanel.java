package com.bigeyedata.morttest.pages.panel;

import com.bigeyedata.morttest.pages.Panel;
import com.bigeyedata.morttest.types.DataSourceType;

/**
 * Created by yingzhang on 19/10/2017.
 */
abstract class DataSourceSpecificEditorPanel extends Panel {

    public abstract DataSourceType dataSourceType();
}
