package com.bigeyedata.morttest;



import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

/**
 * Created by yingzhang on 06/05/2017.
 */
public class Hooks {

    private static final String MortWeb_URL = "http://localhost:3000";
    private static final int Wait_TimeOutInSeconds = 15;

    @Before
    public static void beforeScenario(){

        WebDriverManager.getDriver().manage().deleteAllCookies();
    }

    @After
    public static void afterScenario(){

        WebDriverManager.getDriver().manage().deleteAllCookies();
//        WebDriverManager.getDriver().quit();
//        WebDriverManager.deleteWebDriver();
    }

    public static String getMortWebUrl(){return MortWeb_URL;}

    public static int gettimeOutInSeconds(){return Wait_TimeOutInSeconds;}
}
