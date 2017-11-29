package com.bigeyedata.morttest.pages.panels.dataset.datasetOperator;

import com.bigeyedata.morttest.pages.Panel;
import cucumber.api.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.bigeyedata.morttest.CommonFunctions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by yingzhang on 28/11/2017.
 */
public class JoinDataSetEditPanel extends DataSetSpecificEditPanel {

    @Override
    public void verifySourceDataSet(List<String> datasetList) {
        for (int i=0; i<datasetList.size(); i++){
            WebElement webElement = findByXpath("//div//span[text()='"+datasetList.get(0).toString().trim()+"']");
            assertThat(webElement.isDisplayed(),is(true));
        }
    }

    @Override
    public void verifySourceDataSetField(DataTable expectedFieldTable) {
        List<List<String>> colLists = new ArrayList<>();
        List<WebElement> datasetList = findListByXpath("//div[@class='joining-data-set']");

        for (WebElement element : datasetList) {
            element.click();

            List<WebElement> fieldList = findListByXpath("//div[@class='ant-checkbox-group']//li/label");
            List<String> list = new ArrayList<>();
            int j = 0;
            for (int i = 0; i < fieldList.size(); i++) {
                j = i + 1;
                WebElement checkboxElement = findByXpath("//div[@class='ant-checkbox-group']//li[" + j +"]/label/span[1]");
                if (checkboxElement.getAttribute("class").contains("ant-checkbox-checked"))
                    list.add(findByXpath("//div[@class='ant-checkbox-group']//li[" + j + "]/label/span[2]/span").getText());
            }
            colLists.add(list);
        }
        compareDataTableByText(expectedFieldTable,colLists);
    }

    @Override
    public void verifyDataSetFiled(DataTable expectedFieldTable) {

    }
}
