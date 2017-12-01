package com.bigeyedata.morttest.pages.panels.dataset;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.pages.Panel;
import com.bigeyedata.morttest.pages.panels.dataset.specificPanel.DataSetSpecificDetailPanel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

import static com.bigeyedata.morttest.SeeThruUtils.initPanel;

/**
 * Created by yingzhang on 16/11/2017.
 */
public class DataSetDetailPanel implements Panel {

    @FindBy(xpath = "//*[@id=\"app\"]//div[text()='字段']")
    WebElement fieldTab;

    @FindBy(xpath = "//*[@id=\"app\"]//div[text()='数据预览']")
    WebElement dataPreviewTab;

    @FindBy(xpath = "//*[@id=\"app\"]//div[text()='相关报表']")
    WebElement reportTab;

    @FindBy(xpath = "//*[@id=\"app\"]//div[text()='数据来源']")
    WebElement sourceOfDataTab;

    @FindBy(xpath = "//*[@id=\"app\"]//div[text()='导入记录']")
    WebElement importTab;

    @FindBy(xpath = "//*[@id=\"app\"]//div[text()='行级权限']")
    WebElement rowAuthorityTab;

    @FindBy(xpath = "//*[@id=\"app\"]//div[text()='衍生数据集']")
    WebElement derivedDataSetTab;

    @FindBy(xpath = "//div[@class='sort-container']")
    WebElement dicNameDiv;

    private DataSetSpecificDetailPanel specificDetailPanel;

    public <T extends DataSetSpecificDetailPanel> T specificDetailPanel(){
        return (T) specificDetailPanel;
    }

    public void selectTab(String tab) throws InterruptedException {
        PanelInfo panelInfo = navBarMapInfo().get(tab);
        dicNameDiv.click();
        CommonFunctions.waitForElementClickable(panelInfo.detailTab);
        panelInfo.detailTab.click();
        specificDetailPanel = initPanel(panelInfo.panel);
    }

    private class PanelInfo{
        WebElement detailTab;
        Class<? extends DataSetSpecificDetailPanel> panel;

        public PanelInfo(WebElement detailTab, Class<? extends DataSetSpecificDetailPanel> panel){
            this.detailTab = detailTab;
            this.panel = panel;
        }
    }

    private Map<String, PanelInfo> navBarMapInfo() {
        Map<String, PanelInfo> map = new HashMap();
        map.put("FIELD", new PanelInfo(fieldTab, FieldPanel.class));
        map.put("PREVIEW", new PanelInfo(dataPreviewTab, DataPreviewPanel.class));
        map.put("REPORT", new PanelInfo(reportTab, RelatedReportPanel.class));
        map.put("IMPORT", new PanelInfo(importTab, ImportPanel.class));
        map.put("SOURCEOFDATA", new PanelInfo(sourceOfDataTab, SourceOfDataPanel.class));
        map.put("DERIVEDDATASET", new PanelInfo(derivedDataSetTab, DerivedDataSetPanel.class));
        map.put("ROWAUTHORITY", new PanelInfo(rowAuthorityTab, RowAuthorityPanel.class));

        return map;
    }
}
