package com.bigeyedata.morttest.pages;

import cucumber.api.DataTable;

/**
 * Created by yingzhang on 01/12/2017.
 */
public interface ValidationPanel extends Panel {

    public void validate(DataTable data);
}
