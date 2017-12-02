package com.bigeyedata.morttest.pages.panels;

import com.bigeyedata.morttest.pages.DataSetPage;
import com.bigeyedata.morttest.pages.DataSourcePage;
import com.bigeyedata.morttest.pages.Panel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.bigeyedata.morttest.CommonFunctions.waitForElementVisible;
import static com.bigeyedata.morttest.SeeThruUtils.onPage;

/**
 * Created by yingzhang on 10/05/2017.
 */
public class NavigationPanel implements Panel {

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

    public void accessToModule(String module) {

        waitForElementVisible(mainMenuUl);

        switch (module){
            case "DataSource":
                datasourcesModuleLink.click();
                onPage(DataSourcePage.class);
                break;
            case "DataSet":
                datasetsModuleLink.click();
                onPage(DataSetPage.class);
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
