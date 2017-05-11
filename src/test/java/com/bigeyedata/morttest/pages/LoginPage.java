package com.bigeyedata.morttest.pages;

import gherkin.lexer.Pa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by yingzhang on 08/05/2017.
 */
public class LoginPage extends Page {

    @FindBy (id = "email")
    private WebElement userNameInput;

    @FindBy(id = "pass")
    private WebElement passwordInput;

    @FindBy(xpath = "//form/filedset[2]/button")
    private WebElement loginButton;

    public void Login(String userName, String password){

        userNameInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
