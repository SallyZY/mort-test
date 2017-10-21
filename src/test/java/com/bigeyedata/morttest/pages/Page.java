package com.bigeyedata.morttest.pages;

import com.bigeyedata.morttest.pages.panels.DirectoryPanel;
import com.bigeyedata.morttest.pages.panels.NavigationPanel;
import com.bigeyedata.morttest.pages.panels.ResourceItemsPanel;

import static com.bigeyedata.morttest.SeeThruUtils.initPanel;

/**
 * Created by yingzhang on 06/05/2017.
 */
public class Page {

    public NavigationPanel navPanel = initPanel(NavigationPanel.class);

    public DirectoryPanel dirPanel = initPanel(DirectoryPanel.class);

    public ResourceItemsPanel resourcePanel = initPanel(ResourceItemsPanel.class);
}
