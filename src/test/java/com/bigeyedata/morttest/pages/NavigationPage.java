package com.bigeyedata.morttest.pages;

import com.bigeyedata.morttest.CommonFunctions;
import com.bigeyedata.morttest.pages.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by yingzhang on 10/05/2017.
 */
public class NavigationPage extends Page {

    @FindBy(id = "datasources")
    WebElement datasourcesModuleLink;

    @FindBy(id = "datasets")
    WebElement datasetsModuleLink;

    @FindBy(id = "reports")
    WebElement reportsModuleLink;

    @FindBy(id = "dashboards")
    WebElement dashboardsModuleLink;

    @FindBy(id = "management")
    WebElement managementModuleLink;

    @FindBy(className = "menu")
    WebElement mainMenuUl;

    public void AccessToModule(String module) throws InterruptedException {

        CommonFunctions.waitForElementVisible(mainMenuUl);

        switch (module){
            case "DataSource":
                datasourcesModuleLink.click();
                break;
            case "DataSet":
                datasetsModuleLink.click();
                break;
            case "Report":
                reportsModuleLink.click();
                break;
            case "Dashboard":
                dashboardsModuleLink.click();
                break;
            case "Management":
                managementModuleLink.click();
                break;
        }
    }
}
