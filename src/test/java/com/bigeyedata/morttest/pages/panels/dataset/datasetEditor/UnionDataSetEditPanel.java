package com.bigeyedata.morttest.pages.panels.dataset.datasetEditor;

import com.bigeyedata.morttest.pages.Panel;
import com.bigeyedata.morttest.pages.panels.dataset.datasetEditor.subPanel.JoinTypePanel;
import com.bigeyedata.morttest.pages.panels.dataset.datasetEditor.subPanel.SourceDataSetPanel;
import cucumber.api.DataTable;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.bigeyedata.morttest.CommonFunctions.compareDataTableByText;
import static com.bigeyedata.morttest.CommonFunctions.findByXpath;
import static com.bigeyedata.morttest.CommonFunctions.findListByXpath;
import static com.bigeyedata.morttest.SeeThruUtils.initPanel;

/**
 * Created by yingzhang on 29/11/2017.
 */
public class UnionDataSetEditPanel implements Panel {

    private SourceDataSetPanel sourceDataSetPanel;

    public UnionDataSetEditPanel() {
        sourceDataSetPanel = initPanel(SourceDataSetPanel.class);
    }

    public void verifySourceDataSet(DataTable exceptedTable){
        List<List<String>> colLists = new ArrayList<>();
        List<WebElement> datasetList = findListByXpath("//div[@class='union-data-sets']/div");

        List<String> nameList = new ArrayList<>();
        List<String> valueList = new ArrayList<>();
        for (WebElement element : datasetList) {
            element.click();

            int j = 0;
            List<WebElement> fieldList = findListByXpath("//div[@class='ant-checkbox-group']//li/label");
            for (int i = 0; i < fieldList.size(); i++) {
                j = i + 1;
                WebElement checkboxElement = findByXpath("//div[@class='ant-checkbox-group']//li[" + j + "]/label/span[1]");
                if (checkboxElement.getAttribute("class").contains("ant-checkbox-checked")) {
                    nameList.add(element.getText());
                    valueList.add(findByXpath("//div[@class='ant-checkbox-group']//li[" + j + "]/label/span[2]/span").getText());
                }
            }
        }
        colLists.add(nameList);
        colLists.add(valueList);

        compareDataTableByText(exceptedTable,colLists);
    }

}
