package com.bigeyedata.morttest.pages.panels.dataset.datasetEditor.subPanel;

import com.bigeyedata.morttest.pages.ValidationPanel;
import cucumber.api.DataTable;

import java.util.ArrayList;
import java.util.List;

import static com.bigeyedata.morttest.CommonFunctions.compareDataTableByText;
import static com.bigeyedata.morttest.CommonFunctions.findByXpath;
import static com.bigeyedata.morttest.CommonFunctions.findListByXpath;

/**
 * Created by yingzhang on 02/12/2017.
 */
public class BasicInfoPanel implements ValidationPanel {
    @Override
    public void validate(DataTable expectedTable) {
        List<String> nameList = new ArrayList<>();
        List<String> directoryList = new ArrayList<>();
        List<String> dataList = new ArrayList<>();

        String name = findByXpath("//div/input[@id='name']").getAttribute("value");
        nameList.add(name);

        String directory = findByXpath("//form//span[@class='ant-select-selection-selected-value']").getText();
        directoryList.add(directory);

        for (int i=0;i<findListByXpath("//div[@class='ant-radio-group ant-radio-group-large']/label").size();i++){
            int j = i + 1 ;
            String classAttribute = findByXpath("//div[@class='ant-radio-group ant-radio-group-large']/label["+j+"]").getAttribute("class");
            if (classAttribute.contains("ant-radio-wrapper-checked")){
                String element = findByXpath("//div[@class='ant-radio-group ant-radio-group-large']/label["+j+"]").getText();
                dataList.add(element);
            }
        }

        List<List<String>> colLists = new ArrayList<>();
        colLists.add(nameList);
        colLists.add(directoryList);
        colLists.add(dataList);

        compareDataTableByText(expectedTable,colLists);
    }
}
