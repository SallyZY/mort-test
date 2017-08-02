package com.bigeyedata.morttest.pages.dataset_pages;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sun.misc.Cleaner;

import java.util.Calendar;
import java.util.List;

import static com.bigeyedata.morttest.CommonFunctions.waitForElementVisible;

/**
 * Created by yingzhang on 02/08/2017.
 */
public class VirtualFieldPage extends Page {

    @FindBy(xpath = "//div[@class='ant-modal-content']//div[@class='types']//label[1]")
    WebElement decimalTypeRadioButton;

    @FindBy(xpath = "//div[@class='ant-modal-content']//div[@class='types']//label[2]")
    WebElement textTypeRadioButton;

    @FindBy(xpath = "//div[@class='ant-modal-content']//div[@class='types']//label[3]")
    WebElement dateTimeTypeRadioButton;

    @FindBy(xpath = "//div[@class='ant-modal-content']//div[@class='name']//input")
    WebElement nameInput;

    @FindBy(xpath = "//div[@class='ant-modal-content']//div[@class='code-preview']//textarea")
    WebElement expressionInput;

    @FindBy(xpath = "//div[@class='ant-modal-content']//div[@class='code-preview']//button")
    WebElement syntaxValidateButton;

    @FindBy(xpath = "//div[@class='ant-modal-content']//div[@class='ant-modal-footer']//button[2]")
    WebElement saveButton;

    @FindBy(xpath = "//div[@class='ant-modal-content']//div[@class='preview-container']//tbody")
    WebElement previewResultTable;


    public void setVirtualFieldType(String type) {

        switch (type.toLowerCase()) {
            case "decimal":
                decimalTypeRadioButton.click();
                break;
            case "text":
                textTypeRadioButton.click();
                break;
            case "datetime":
                dateTimeTypeRadioButton.click();
                break;
        }
    }

    public void setVirtualFieldName(String name){

        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void setExpression(String expression){

        expression=expression.replace("'","\"");
        expressionInput.clear();
        expressionInput.sendKeys(expression);
    }

    public void validateSyntaxOfExpression(){

        syntaxValidateButton.click();
    }

    public Boolean isValidateResultDisplayed() throws InterruptedException {

        waitForElementVisible(previewResultTable);
        List<WebElement> trList = WebDriverManager.getDriver().findElements(By.xpath("//div[@class='ant-modal-content']//div[@class='preview-container']//tbody/tr"));
        return trList.size() > 0 ? true : false;
    }
}
