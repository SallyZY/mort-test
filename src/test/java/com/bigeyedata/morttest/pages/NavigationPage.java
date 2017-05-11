package com.bigeyedata.morttest.pages;

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

    public void AccessToModule(String module){

        switch (module){
            case "datasource":
                datasourcesModuleLink.click();
                break;
            case "dataset":
                datasetsModuleLink.click();
                break;
            case "report":
                reportsModuleLink.click();
                break;
            case "dashboard":
                dashboardsModuleLink.click();
                break;
            case "management":
                managementModuleLink.click();
                break;
        }
    }
}
