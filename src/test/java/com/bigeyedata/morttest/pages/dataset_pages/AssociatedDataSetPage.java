package com.bigeyedata.morttest.pages.dataset_pages;

import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

    @FindBy(css = "#dataSetDataPreview > div > div > div > div > div > div > div > table > tbody")
    WebElement previewDataTable;



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

    public List getList(List<List<WebElement>> lists){
        for (int i =0;i<lists.get(0).size();i++){

        }
    }

    public List checkFields(List<Map<String, String>> fieldsList){
        List<WebElement> fieldAliasNameList = FieldViewTable.findElements(By.xpath("//td[2]/div/span"));
        List<WebElement> fieldNameList = FieldViewTable.findElements(By.xpath("//td[3]/span"));
        List<WebElement> fieldTypeList = FieldViewTable.findElements(By.xpath("//td[4]/span/span"));


        boolean fieldAliasNameFlg = true;
        boolean fieldsNameFlg = true;
        boolean fieldTypeFlg = true;

        if(fieldsList.size()==fieldAliasNameList.size()){
            for(int j=0; j< fieldsList.size();j++) {
               String fieldAliasName = fieldsList.get(j).get("AliasName").toString();
               System.out.println("期待的别名："+fieldAliasName);
               System.out.println("实际获取的别名："+fieldAliasNameList.get(j).getText());
               if (fieldAliasName.equals(fieldAliasNameList.get(j).getText())){
                   System.out.println(true);
               }else{
                   System.out.println(false);
                   fieldAliasNameFlg = false;
                   break;
               }
            }
        }else{
            System.out.println("fieldsList.size() != fieldAliasNameList.size()");
            fieldAliasNameFlg = false;
        }


        if(fieldsList.size()==fieldNameList.size()){
            for(int i=0; i< fieldsList.size();i++) {
                String fieldsName = fieldsList.get(i).get("FieldName").toString();
                System.out.println("期待的字段名："+fieldsName);
                System.out.println("实际获取的字段名："+fieldNameList.get(i).getText());
                if (fieldsName.equals(fieldNameList.get(i).getText())){
                    System.out.println(true);
                }else{
                    System.out.println(false);
                    fieldsNameFlg = false;
                    break;
                }
            }
        }else{
            System.out.println("fieldsList.size() != fieldNameList.size()");
            fieldsNameFlg = false;
        }

        if(fieldsList.size()==fieldTypeList.size()){
            for(int i=0; i< fieldsList.size();i++) {
                String fieldType = fieldsList.get(i).get("Type").toString();
                System.out.println("期待的字段类型："+fieldType);
                System.out.println("实际获取的字段类型："+fieldTypeList.get(i).getText());
                if (fieldType.equals(fieldTypeList.get(i).getText())){
                    System.out.println(true);
                }else{
                    System.out.println(false);
                    fieldTypeFlg = true;
                    break;
                }
            }
        }else{
            System.out.println("fieldsList.size() != fieldTypeList.size()");
            fieldTypeFlg = true;
        }

        List<Boolean> list = new ArrayList();
        list.add(fieldAliasNameFlg);
        list.add(fieldsNameFlg);
        list.add(fieldTypeFlg);

        return list;


    }


    public void clickPreviewData(){
        previewDataDiv.click();
    }

    public List checkPreviewData(List<Map<String, String>> fieldsList){
        List<WebElement> idC = previewDataTable.findElements(By.xpath("//td[1]/span[2]"));
        List<WebElement> orderNoCars = previewDataTable.findElements(By.xpath("//td[2]/span"));
        List<WebElement> nameC = previewDataTable.findElements(By.xpath("//td[3]/span"));
        List<WebElement> salesDate = previewDataTable.findElements(By.xpath("//td[4]/span"));
        List<WebElement> idO = previewDataTable.findElements(By.xpath("//td[5]/span"));
        List<WebElement> orderNoOrders = previewDataTable.findElements(By.xpath("//td[6]/span"));
        List<WebElement> idP = previewDataTable.findElements(By.xpath("//td[7]/span"));

        boolean idCFlg = true;
        boolean orderNoCarsFlg = true;
        boolean nameCFlg = true;
        boolean salesDateFlg = true;
        boolean idOFlg = true;
        boolean orderNoOrdersFlg = true;
        boolean idPFlg = true;

        if(fieldsList.size()==idC.size()){
            for(int j=0; j< fieldsList.size();j++) {
                String fieldAliasName = fieldsList.get(j).get("Id_C").toString();
                System.out.println("期待的idC："+fieldAliasName);
                System.out.println("实际获取的idC："+idC.get(j).getText());
                if (fieldAliasName.equals(idC.get(j).getText())){
                    System.out.println(true);
                }else{
                    System.out.println(false);
                    idCFlg = false;
                    break;
                }
            }
        }else{
            System.out.println("fieldsList.size() != idC.size()");
            idCFlg = false;
        }


        if(fieldsList.size()==orderNoCars.size()){
            for(int i=0; i< fieldsList.size();i++) {
                String fieldsName = fieldsList.get(i).get("OrderNo (cars)").toString();
                System.out.println("期待的orderNoCars："+fieldsName);
                System.out.println("实际获取的字段名："+orderNoCars.get(i).getText());
                if (fieldsName.equals(orderNoCars.get(i).getText())){
                    System.out.println(true);
                }else{
                    System.out.println(false);
                    orderNoCarsFlg = false;
                    break;
                }
            }
        }else{
            System.out.println("fieldsList.size() != orderNoCars.size()");
            orderNoCarsFlg = false;
        }

        if(fieldsList.size()==nameC.size()){
            for(int i=0; i< fieldsList.size();i++) {
                String fieldType = fieldsList.get(i).get("Name_C").toString();
                System.out.println("期待的字段类型："+fieldType);
                System.out.println("实际获取的字段类型："+nameC.get(i).getText());
                if (fieldType.equals(nameC.get(i).getText())){
                    System.out.println(true);
                }else{
                    System.out.println(false);
                    nameCFlg = true;
                    break;
                }
            }
        }else{
            System.out.println("fieldsList.size() != nameC.size()");
            nameCFlg = true;
        }

        if(fieldsList.size()==salesDate.size()){
            for(int i=0; i< fieldsList.size();i++) {
                String fieldType = fieldsList.get(i).get("SalesDate").toString();
                System.out.println("期待的字段类型："+fieldType);
                System.out.println("实际获取的字段类型："+salesDate.get(i).getText());
                if (fieldType.equals(salesDate.get(i).getText())){
                    System.out.println(true);
                }else{
                    System.out.println(false);
                    salesDateFlg = true;
                    break;
                }
            }
        }else{
            System.out.println("fieldsList.size() != salesDate.size()");
            salesDateFlg = true;
        }

        if(fieldsList.size()==idO.size()){
            for(int i=0; i< fieldsList.size();i++) {
                String fieldType = fieldsList.get(i).get("Id_O").toString();
                System.out.println("期待的字段类型："+fieldType);
                System.out.println("实际获取的字段类型："+idO.get(i).getText());
                if (fieldType.equals(idO.get(i).getText())){
                    System.out.println(true);
                }else{
                    System.out.println(false);
                    idOFlg = true;
                    break;
                }
            }
        }else{
            System.out.println("fieldsList.size() != idO.size()");
            idOFlg = true;
        }

        if(fieldsList.size()==orderNoOrders.size()){
            for(int i=0; i< fieldsList.size();i++) {
                String fieldType = fieldsList.get(i).get("OrderNo (orders)").toString();
                System.out.println("期待的字段类型："+fieldType);
                System.out.println("实际获取的字段类型："+orderNoOrders.get(i).getText());
                if (fieldType.equals(orderNoOrders.get(i).getText())){
                    System.out.println(true);
                }else{
                    System.out.println(false);
                    orderNoOrdersFlg = true;
                    break;
                }
            }
        }else{
            System.out.println("fieldsList.size() != orderNoOrders.size()");
            orderNoOrdersFlg = true;
        }

        if(fieldsList.size()==idP.size()){
            for(int i=0; i< fieldsList.size();i++) {
                String fieldType = fieldsList.get(i).get("Id_P").toString();
                System.out.println("期待的字段类型："+fieldType);
                System.out.println("实际获取的字段类型："+idP.get(i).getText());
                if (fieldType.equals(idP.get(i).getText())){
                    System.out.println(true);
                }else{
                    System.out.println(false);
                    idPFlg = true;
                    break;
                }
            }
        }else{
            System.out.println("fieldsList.size() != idP.size()");
            idPFlg = true;
        }

        List<Boolean> list = new ArrayList();
        list.add(idCFlg);
        list.add(orderNoCarsFlg);
        list.add(nameCFlg);
        list.add(salesDateFlg);
        list.add(idOFlg);
        list.add(orderNoOrdersFlg);
        list.add(idPFlg);

        return list;


    }




















}
