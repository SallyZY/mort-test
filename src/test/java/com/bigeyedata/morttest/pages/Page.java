package com.bigeyedata.morttest.pages;

import com.bigeyedata.morttest.pages.panels.DirectoryContainerPanel;
import com.bigeyedata.morttest.pages.panels.DirectoryEditorPanel;
import com.bigeyedata.morttest.pages.panels.NavigationPanel;
import com.bigeyedata.morttest.pages.panels.ResourceItemsPanel;

import static com.bigeyedata.morttest.SeeThruUtils.initPanel;

/**
 * Created by yingzhang on 06/05/2017.
 */
public class Page {

    public NavigationPanel navPanel = initPanel(NavigationPanel.class);

    public DirectoryContainerPanel dirContainerPanel = initPanel(DirectoryContainerPanel.class);

    public DirectoryEditorPanel dirEditorPanel = initPanel(DirectoryEditorPanel.class);

    public ResourceItemsPanel resourcePanel = initPanel(ResourceItemsPanel.class);
}
