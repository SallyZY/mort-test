package com.bigeyedata.morttest.pages.panels.dataset.datasetEditor.subPanel;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.pages.Panel;
import com.bigeyedata.morttest.pages.ValidationPanel;
import cucumber.api.DataTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.bigeyedata.morttest.CommonFunctions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by yingzhang on 01/12/2017.
 */
public class SourceDataSetPanel implements ValidationPanel {

    @Override
    public void validate(DataTable expectedTable) {
        List<List<String>> colLists = new ArrayList<>();
//        List<WebElement> datasetList = findListByXpath("//div[@class='joining-data-set']");
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

        compareDataTableByText(expectedTable,colLists);
    }
}
