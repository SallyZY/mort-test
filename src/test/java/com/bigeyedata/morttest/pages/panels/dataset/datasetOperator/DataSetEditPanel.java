package com.bigeyedata.morttest.pages.panels.dataset.datasetOperator;

import com.bigeyedata.morttest.pages.Panel;
import com.bigeyedata.morttest.types.DataSetType;

import java.util.HashMap;
import java.util.Map;

import static com.bigeyedata.morttest.SeeThruUtils.initPanel;
import static com.bigeyedata.morttest.types.DataSetType.JOIN;
import static com.bigeyedata.morttest.types.DataSetType.UNION;

/**
 * Created by yingzhang on 29/11/2017.
 */
public class DataSetEditPanel extends Panel {

    private DataSetSpecificEditPanel editPanel;
    private DataSetType dataSetType;

    public void setDataSetType(DataSetType type){
        dataSetType = type;
        PanelInfo panelInfo=mapInfo().get(type);
        editPanel=initPanel(panelInfo.panel);
    }

    public <T extends DataSetSpecificEditPanel> T specificEditPanel(){
        return (T)editPanel;
    }

    private Map<DataSetType, PanelInfo> mapInfo() {
        Map<DataSetType, DataSetEditPanel.PanelInfo> map = new HashMap();
        map.put(JOIN, new PanelInfo(JoinDataSetEditPanel.class));
        map.put(UNION, new PanelInfo(UnionDataSetEditPanel.class));

        return map;
    }

    private class PanelInfo {
        Class<? extends DataSetSpecificEditPanel> panel;

        public PanelInfo(Class<? extends DataSetSpecificEditPanel> panel) {
            this.panel = panel;
        }
    }

}
