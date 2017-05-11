package com.bigeyedata.morttest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

/**
 * Created by yingzhang on 06/05/2017.
 */
public class Hook {

    private static final String MortWeb_URL = "http://localhost:3000";

    @Before
    public void setup(){

        WebDriverManager.getDriver().manage().deleteAllCookies();
    }

    @After
    public void teardown(){

        WebDriverManager.getDriver().quit();
        WebDriverManager.deleteWebDriver();
    }

    public static String getMortWebUrl(){return MortWeb_URL;}
}
