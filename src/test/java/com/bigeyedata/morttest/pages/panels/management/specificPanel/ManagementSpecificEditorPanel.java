package com.bigeyedata.morttest.pages.panels.management.specificPanel;

import com.bigeyedata.morttest.pages.Panel;

import java.util.Map;

public abstract class ManagementSpecificEditorPanel extends Panel {

    public abstract void createUser(Map<String,String> userBasicInfoList) throws InterruptedException;
    public abstract void modifyUser(Map<String,String> userBasicInfoList);

}
