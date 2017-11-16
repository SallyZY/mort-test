package com.bigeyedata.morttest.pages.panels;

import com.bigeyedata.morttest.pages.Panel;
import javafx.scene.layout.Pane;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by yingzhang on 16/11/2017.
 */
public class AuthorityPanel extends Panel {

    @FindBy(xpath = "//*[@id=\"app\"]//div[text()='权限']")
    WebElement authorityTab;

}
