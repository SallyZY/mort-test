package com.bigeyedata.morttest.pages.panels.dataset.datasetEditor.subPanel;

import com.bigeyedata.morttest.pages.Panel;
import com.bigeyedata.morttest.pages.ValidationPanel;
import cucumber.api.DataTable;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.bigeyedata.morttest.CommonFunctions.*;

/**
 * Created by yingzhang on 01/12/2017.
 */
public class JoinTypePanel implements ValidationPanel {

    @Override
    public void validate(DataTable data) {
        List<WebElement> joinTypeList = findListByXpath("//div[@class='relation-icon']/*[name()='svg']");
        joinTypeList.get(0).click();
//        Boolean flg = findByXpath("//div[@class='ant-radio-group ant-radio-group-large']/label[3]").getAttribute("class" ).contains("checked");
        List<List<String>> colLists = new ArrayList<>();
        List<String> list = new ArrayList<>();
//        for (WebElement element : joinTypeList) {
//            element.click();
        for(int i = 0;i<joinTypeList.size();i++){
            joinTypeList.get(i).click();
//            System.out.println(joinTypeList.size());
            System.out.println(i);


            for (int j = 1; j <= 4; j++) {
                Boolean flg = findByXpath("//div[@class='ant-radio-group ant-radio-group-large']/label[" + j + "]").getAttribute("class").contains("checked");
                if (flg) {
                    switch (j) {
                        case 1:
                            System.out.println("1");
                            list.add("Inner Join");
                            continue;
                        case 2:
                            System.out.println("2");
                            list.add("Left Join");
                            continue;
                        case 3:
                            System.out.println("3");
                            list.add("Right Join");
                            continue;
                        case 4:
                            System.out.println("4");
                            list.add("Full Join");
                            continue;
                    }
                }
            }
        }
        System.out.println(list);
        colLists.add(list);
        System.out.println(colLists);

        compareDataTableByText(data, colLists);
    }




    public void getJoinLink(DataTable data){
        List<List<String>> colLists = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<WebElement> joinTypeList = findListByXpath("//div[@class='relation-icon']/*[name()='svg']");
        for(int i = 0;i<joinTypeList.size();i++){
            joinTypeList.get(i).click();
            List<WebElement> fieldsList = findListByXpath("//div[@class='join-setting-panel']//table/tbody/tr");
            for(int j=1;j<=fieldsList.size();j++ ){
                String str1 = findByXpath("//table/tbody/tr["+j+"]/td[1]//div[@class='ant-select-selection-selected-value']/span").getText();
                String str2 = findByXpath("//table/tbody/tr["+j+"]/td[3]//div[@class='ant-select-selection-selected-value']/span").getText();
                    list1.add(str1);
                    list2.add(str2);
            }

        }
        colLists.add(list1);
        colLists.add(list2);
        compareDataTableByText(data, colLists);
    }
}
