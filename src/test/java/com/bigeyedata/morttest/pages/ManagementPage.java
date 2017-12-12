package com.bigeyedata.morttest.pages;

import com.bigeyedata.morttest.pages.panels.management.ManagementDetailPanel;
import com.bigeyedata.morttest.pages.panels.management.ManagementEditorPanel;
import com.bigeyedata.morttest.pages.panels.management.ManagementOperatorPanel;

import static com.bigeyedata.morttest.SeeThruUtils.initPanel;

public class ManagementPage extends Page{
    public ManagementOperatorPanel managementOperatorPanel = initPanel(ManagementOperatorPanel.class);
    public ManagementEditorPanel managementEditorPanel = initPanel(ManagementEditorPanel.class);
    public ManagementDetailPanel managementDetailPanel = initPanel(ManagementDetailPanel.class);
}
