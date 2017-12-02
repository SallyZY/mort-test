package com.bigeyedata.morttest.pages.panels.dataset.datasetEditor;

import com.bigeyedata.morttest.pages.panels.dataset.datasetEditor.subPanel.JoinTypePanel;
import cucumber.api.DataTable;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.bigeyedata.morttest.CommonFunctions.compareDataTableByText;
import static com.bigeyedata.morttest.CommonFunctions.findByXpath;
import static com.bigeyedata.morttest.CommonFunctions.findListByXpath;
import static com.bigeyedata.morttest.SeeThruUtils.initPanel;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by yingzhang on 28/11/2017.
 */
public class JoinDataSetEditPanel extends DataSetValidatorPanel {
    private JoinTypePanel joinTypePanel;

    public JoinDataSetEditPanel() {
        joinTypePanel = initPanel(JoinTypePanel.class);
    }

    public void verifyJoinType(){
        DataTable data = null;
        joinTypePanel.validate(data);
    }

    public void verifySourceDataSet(DataTable exceptedTable){
        List<List<String>> colLists = new ArrayList<>();
        List<WebElement> datasetList = findListByXpath("//div[@class='joining-data-set']");

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
