package com.bigeyedata.morttest.pages.dataset_pages;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.Page;
import cucumber.api.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.*;

import static com.bigeyedata.morttest.CommonFunctions.*;

public class AssociatedDataSetPage extends Page {

    @FindBy(css = " div > span > span > span.ant-select-selection__rendered > span")
    WebElement selectDirectorySpan;

    @FindBy(css = "body > div:nth-child(15) > div > div > div")
    WebElement directoryListDiv;

    @FindBy(xpath = "//div/span/span/input")
    WebElement directorySelectorInput;

    @FindBy(xpath = "//div/ul/li/span[2]/span")
    WebElement selectedDirectorySpan;

    @FindBy(css = "div > ul > li:nth-child(1) > div > span > span > span")
    WebElement source;

    @FindBy(css = "div > div.ant-card-body > div > div > div > div:nth-child(1) > div")
    WebElement target;

    @FindBy(css = "#fieldsDisplay > div > div > div > div > div > div > table > tbody")
    WebElement FieldViewTable;

    @FindBy(xpath = "//*[@id=\"app\"]//div[text()='数据预览']")
    WebElement previewDataDiv;

    @FindBy(xpath = "//*[@id=\"app\"]//div[text()='数据来源']")
    WebElement sourceOfDataDiv;

    @FindBy(css = "#dataSetDataPreview > div > div > div > div > div > div > div > table > tbody")
    WebElement previewDataTable;

    @FindBy(xpath ="//div[@id='fieldsDisplay']//table//tr")
    List<WebElement> fieldDetailRows;

    @FindBy(xpath ="//div[@id='dataSetDataPreview']//table//tr")
    List<WebElement> previewDataRows;

    @FindBy(xpath ="//div[@id='dataSetDataPreview']//table//tr")
    List<WebElement> sourceOfDataRows;

    @FindBy(xpath = "//button/span[text()='下一步']")
    WebElement nextStep;



    public void selectDirectory(String directoryName) throws InterruptedException {
        selectDirectorySpan.click();
//        CommonFunctions.waitForElementVisible(directoryListDiv);
        directorySelectorInput.click();
        directorySelectorInput.sendKeys(directoryName);
        selectedDirectorySpan.click();
        Thread.sleep(1000);
    }

    public void dragAndDrop(){

        Actions actions = new Actions(WebDriverManager.getDriver());
        actions.dragAndDrop(source,target).perform();
        actions.clickAndHold(source).moveToElement(target).release(target).perform();
    }

    public List getLists(List<List<WebElement>> lists){
//        Boolean flg = true;
//        for(int i=0;i<lists.size();i++){
//            if (lists.get(0).size()==lists.get(i).size()){
//                continue;
//            }else {
//                flg = false;
//                break;
//            }
//        }

        List<List<String>> newlists = new ArrayList<>();
        for(int i = 0; i < lists.get(0).size(); i++){
            List<String> list = new ArrayList<>();
            newlists.add(list);
        }

        for(int i=0;i<lists.size();i++){
            for(int j = 0; j <  lists.get(i).size(); j++){
                newlists.get(j).add(lists.get(i).get(j).getText());
            }
        }
        return newlists;

    }

    public List getFields() {
        List<WebElement> fieldAliasNameList = FieldViewTable.findElements(By.xpath("//td[2]/div/span"));
        List<WebElement> fieldNameList = FieldViewTable.findElements(By.xpath("//td[3]"));
        List<WebElement> fieldTypeList = FieldViewTable.findElements(By.xpath("//td[4]/span/span"));

        List<List<WebElement>> newlists = new ArrayList<>();
        newlists.add(fieldAliasNameList);
        newlists.add(fieldNameList);
        newlists.add(fieldTypeList);
        return newlists;
    }


    public Boolean checkFields(DataTable dataInfo) {
//        List<List<String>> lists1 = oldLists;
        List<List<String>> lists1 = getLists(getFields());
        List<List<String>> lists2 = dataInfo.asLists(String.class);

        boolean checkFieldsFlg = true;
        if(lists2.size()==lists1.size()){
            for(int i=0; i< lists2.size();i++) {
                if (lists1.get(i).size()==lists2.get(i).size()){
                    for(int j=0;j<lists2.get(i).size();j++){
                        if (lists1.get(i).get(j).equals(lists2.get(i).get(j))){

                        }else{
                            System.out.println(false +"："+lists1.get(i).get(j)+"不等于"+(lists2.get(i).get(j)));
                            checkFieldsFlg = false;
                            break;
                        }
                    }
                }else {
                    System.out.println("lists1.get(i).size() != lists2.get(i).size()");
                    checkFieldsFlg = false;
                }
            }
        }else{
            System.out.println("lists1.size() != lists2.size()");
            checkFieldsFlg = false;
        }

        return checkFieldsFlg;

    }




    public void clickPreviewData(){
        previewDataDiv.click();
    }

    public void clickSourceOfData(){
        sourceOfDataDiv.click();
    }

    public void checkFieldDetail(DataTable expectedDetailsTable){
        List<WebElement> fieldAliasNameList = findListByXpath("//div[@id='fieldsDisplay']//table//td[2]");
        List<WebElement> fieldNameList = findListByXpath("//div[@id='fieldsDisplay']//table//td[3]");
        List<WebElement> fieldTypeList = findListByXpath("//div[@id='fieldsDisplay']//table//td[4]");

        List<List<WebElement>> colLists = new ArrayList<>();
        colLists.add(fieldAliasNameList);
        colLists.add(fieldNameList);
        colLists.add(fieldTypeList);

        compareDataTable(expectedDetailsTable,colLists);
    }

//  check previewdata of "三表关联-导入"
    public void checkPreviewDataOfThreeTable(DataTable expectedDetailsTable){
        List<WebElement> data_ActualIncome = findListByXpath("//div[@id='dataSetDataPreview']//table//td[1]//span[2]");
        List<WebElement> ActualIncome = findListByXpath("//div[@id='dataSetDataPreview']//table//td[2]//span");
        List<WebElement> data_ActualCost = findListByXpath("//div[@id='dataSetDataPreview']//table//td[3]//span");
        List<WebElement> ActualCost = findListByXpath("//div[@id='dataSetDataPreview']//table//td[4]//span");
        List<WebElement> data_ExpectedIncome = findListByXpath("//div[@id='dataSetDataPreview']//table//td[5]//span");
        List<WebElement> ExpectedIncome = findListByXpath("//div[@id='dataSetDataPreview']//table//td[6]//span");

        List<List<WebElement>> colLists = new ArrayList<>();
        colLists.add(data_ActualIncome);
        colLists.add(ActualIncome);
        colLists.add(data_ActualCost);
        colLists.add(ActualCost);
        colLists.add(data_ExpectedIncome);
        colLists.add(ExpectedIncome);

        compareDataTable(expectedDetailsTable,colLists);
    }

    public void checkSourceOfData(DataTable expectedDetailsTable){
        List<WebElement> dataSetNameList = findListByXpath("//div[@id='reportRelatedDataSet']//table//td[1]");
        List<WebElement> createrList = findListByXpath("//div[@id='reportRelatedDataSet']//table//td[2]");
        List<WebElement> statusList = findListByXpath("//div[@id='reportRelatedDataSet']//table//td[4]");

        List<List<WebElement>> colLists = new ArrayList<>();
        colLists.add(dataSetNameList);
        colLists.add(createrList);
        colLists.add(statusList);

        compareDataTable(expectedDetailsTable,colLists);
    }


    public void checkJoinDataSet(DataTable expectedDataSetTable){
        WebElement dataSetName1 = findByXpath("//div//span[text()='ActualIncome-导入']");
        WebElement dataSetName2 = findByXpath("//div//span[text()='ActualCost-直连']");
        WebElement dataSetName3 = findByXpath("//div//span[text()='ExpectedIncome-导入']");

        List<WebElement> list = new ArrayList<>();
        list.add(dataSetName1);
        list.add(dataSetName2);
        list.add(dataSetName3);

       List<List<WebElement>> colLists = new ArrayList<>();
       colLists.add(list);

       compareDataTable(expectedDataSetTable,colLists);
    }

    public void checkJoinType(DataTable expectedJoinTypeTable){
        List<WebElement> joinTypeList = findListByXpath("//div[@class='relation-icon']/*[name()='svg']");

        List<List<WebElement>> colLists = new ArrayList<>();
        colLists.add(joinTypeList);

        compareDataTable(expectedJoinTypeTable,colLists);
    }

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


    public void checkCheckedField(DataTable expectedJoinTypeTable) throws InterruptedException {
        List<List<String>> colLists = new ArrayList<>();

        findByXpath("//div[@class='joining-data-set']//span[text()='ActualIncome-导入']").click();
        List<WebElement> list1 = findListByXpath("//div[@class='ant-checkbox-group']//label/span[2]");
        List<String> list2 =new ArrayList<>();
        for(int i=0;i<list1.size();i++){
            int j = i + 1;
            if (findByXpath("//div[@class='ant-checkbox-group']//li[" + j +"]/label/span[1]").getAttribute("class").contains("ant-checkbox-checked")){

                String element = findByXpath("//div[@class='ant-checkbox-group']//li[" + j + "]/label/span[2]/span").getText();
                list2.add(element);


            }

        }
        colLists.add(list2);

        findByXpath("//div[@class='joining-data-set']//span[text()='ActualCost-直连']").click();
        List<WebElement> list3 = findListByXpath("//div[@class='ant-checkbox-group']//label/span[2]");
        List<String> list4 =new ArrayList<>();
        for(int i=0;i<list3.size();i++){

            int j = i + 1;

            if (findByXpath("//div[@class='ant-checkbox-group']//li[" + j +"]/label/span[1]").getAttribute("class").contains("ant-checkbox-checked")){

                String element = findByXpath("//div[@class='ant-checkbox-group']//li[" + j + "]/label/span[2]/span").getText();
                list4.add(element);


            }
        }
        colLists.add(list4);


        findByXpath("//div[@class='joining-data-set']//span[text()='ExpectedIncome-导入']").click();
        List<WebElement> list5 = findListByXpath("//div[@class='ant-checkbox-group']//label/span[2]");
        List<String> list6 =new ArrayList<>();
        for(int i=0;i<list5.size();i++){

            int j = i + 1;

            if (findByXpath("//div[@class='ant-checkbox-group']//li[" + j +"]/label/span[1]").getAttribute("class").contains("ant-checkbox-checked")){

                String element = findByXpath("//div[@class='ant-checkbox-group']//li[" + j + "]/label/span[2]/span").getText();
                list6.add(element);


            }
        }
        colLists.add(list6);


        compareDataTableOfText(expectedJoinTypeTable,colLists);

    }


    public void checkPreviewTableOfHeader(DataTable expectedDetailsTable) throws InterruptedException {

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

        compareDataTableOfText(expectedDetailsTable,colLists);
    }

    public void nextStep(){
        nextStep.click();
    }



























}
