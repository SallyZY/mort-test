package com.bigeyedata.morttest.pages.panels.dataset.datasetEditor.subPanel;

import com.bigeyedata.morttest.pages.Panel;
import com.bigeyedata.morttest.pages.ValidationPanel;
import cucumber.api.DataTable;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.bigeyedata.morttest.CommonFunctions.compareDataTableByText;
import static com.bigeyedata.morttest.CommonFunctions.findByXpath;
import static com.bigeyedata.morttest.CommonFunctions.findListByXpath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by yingzhang on 01/12/2017.
 */
public class SourceDataSetPanel implements ValidationPanel {

//    public void verifySourceDataSet(List<String> datasetList) {
//        for (int i=0; i<datasetList.size(); i++){
//            WebElement webElement = findByXpath("//div//span[text()='"+datasetList.get(0).toString().trim()+"']");
//            assertThat(webElement.isDisplayed(),is(true));
//        }
//    }

    @Override
    public void validate(DataTable data) {
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
        compareDataTableByText(data,colLists);
    }
}
