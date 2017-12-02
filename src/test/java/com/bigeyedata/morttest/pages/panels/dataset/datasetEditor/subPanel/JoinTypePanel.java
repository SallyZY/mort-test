package com.bigeyedata.morttest.pages.panels.dataset.datasetEditor.subPanel;

import com.bigeyedata.morttest.pages.Panel;
import com.bigeyedata.morttest.pages.ValidationPanel;
import cucumber.api.DataTable;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.bigeyedata.morttest.CommonFunctions.findByXpath;
import static com.bigeyedata.morttest.CommonFunctions.findListByXpath;

/**
 * Created by yingzhang on 01/12/2017.
 */
public class JoinTypePanel implements ValidationPanel {

    public boolean checkRightJoin(){
        List<WebElement> joinTypeList = findListByXpath("//div[@class='relation-icon']/*[name()='svg']");
        joinTypeList.get(0).click();
        Boolean flg = findByXpath("//div[@class='ant-radio-group ant-radio-group-large']/label[3]").getAttribute("class" ).contains("checked");
        return flg;
    }

    public boolean checkLeftJoin(){
        List<WebElement> joinTypeList = findListByXpath("//div[@class='relation-icon']/*[name()='svg']");
        joinTypeList.get(1).click();
        Boolean flg = findByXpath("//div[@class='ant-radio-group ant-radio-group-large']/label[2]").getAttribute("class" ).contains("checked");
        return flg;
    }

    @Override
    public void validate(DataTable data) {
        List<WebElement> joinTypeList = findListByXpath("//div[@class='relation-icon']/*[name()='svg']");
        joinTypeList.get(0).click();
        Boolean flg = findByXpath("//div[@class='ant-radio-group ant-radio-group-large']/label[3]").getAttribute("class" ).contains("checked");
    }
}
