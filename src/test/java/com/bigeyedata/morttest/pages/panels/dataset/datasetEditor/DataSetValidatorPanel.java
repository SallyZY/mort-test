package com.bigeyedata.morttest.pages.panels.dataset.datasetEditor;

import com.bigeyedata.morttest.pages.Panel;
import com.bigeyedata.morttest.pages.panels.dataset.datasetEditor.subPanel.BasicInfoPanel;
import com.bigeyedata.morttest.pages.panels.dataset.datasetEditor.subPanel.FieldPreviewPanel;
import com.bigeyedata.morttest.pages.panels.dataset.datasetEditor.subPanel.SourceDataSetPanel;
import cucumber.api.DataTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.bigeyedata.morttest.SeeThruUtils.initPanel;

/**
 * Created by yingzhang on 01/12/2017.
 */
public class DataSetValidatorPanel implements Panel {
    @FindBy(xpath = "//button/span[text()='下一步']")
    WebElement nextStep;

    private SourceDataSetPanel sourceDataSetPanel;
    private FieldPreviewPanel previewPanel;
    private BasicInfoPanel basicInfoPanel;

    public DataSetValidatorPanel() {
        System.out.println("DataSetValidatorPanel");
        sourceDataSetPanel = initPanel(SourceDataSetPanel.class);
        previewPanel = initPanel(FieldPreviewPanel.class);
        basicInfoPanel = initPanel(BasicInfoPanel.class);
    }

    public void verifySourceDataSet(DataTable exceptedTable){
        sourceDataSetPanel.validate(exceptedTable);
    }

    public void verifyPreviewFiled(DataTable exceptedTable){
        previewPanel.validate(exceptedTable);
    }

    public void verifyBasicInfo(DataTable exceptedTable){
        basicInfoPanel.validate(exceptedTable);
    }

    public void nextStep(){
        nextStep.click();
    }

}
