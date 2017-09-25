package com.bigeyedata.morttest.pages;

import gherkin.lexer.Pa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by yingzhang on 08/05/2017.
 */
public class LoginPage extends Page {

    @FindBy (id = "userName")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/form/div[3]/div/div/button")
    private WebElement loginButton;

    public void login(String userName, String password){

        userNameInput.clear();
        userNameInput.sendKeys(userName);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
