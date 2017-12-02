package com.bigeyedata.morttest.pages.panels.dataset.datasetEditor.subPanel;

import com.bigeyedata.morttest.pages.Panel;
import com.bigeyedata.morttest.pages.ValidationPanel;
import cucumber.api.DataTable;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.bigeyedata.morttest.CommonFunctions.compareDataTableByText;
import static com.bigeyedata.morttest.CommonFunctions.findListByXpath;

/**
 * Created by yingzhang on 01/12/2017.
 */
public class FieldPreviewPanel implements ValidationPanel {
    @Override
    public void validate(DataTable expectedTable) {
        List<String> typeList = new ArrayList<>();
        List<String> fieldsList = new ArrayList<>();

        List<WebElement>  allType = findListByXpath("//tr[2]/th/span");
        for(int i=0;i<allType.size();i++){
            String type = findListByXpath("//tr[2]/th/span").get(i).getText();
            typeList.add(type);
        }

        List<WebElement>  allField = findListByXpath("//tr[3]/th/span/div/input");
        for(int i=0;i<allField.size();i++){
            String field =findListByXpath("//tr[3]/th/span/div/input").get(i).getAttribute("value").toString();
            fieldsList.add(field);
        }

        List<List<String>> colLists = new ArrayList<>();
        colLists.add(typeList);
        colLists.add(fieldsList);

        compareDataTableByText(expectedTable,colLists);
    }
}
