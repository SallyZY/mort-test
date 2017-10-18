package com.bigeyedata.morttest;



import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by yingzhang on 06/05/2017.
 */
public class Hooks {

    private static final String MortWeb_URL = "http://localhost:3000";
    private static final int Wait_TimeOutInSeconds = 15;
    private static final int Thread_Sleep_Short = 3000;
    private static final int Thread_Sleep_Long =10000;

    @Before
    public static void beforeScenario() {

        WebDriverManager.getDriver().manage().deleteAllCookies();
    }

    @After
    public static void afterScenario() {

//        WebDriverManager.getDriver().manage().deleteAllCookies();
//        WebDriverManager.getDriver().quit();
//        WebDriverManager.deleteWebDriver();
    }

    public static String getMortWebUrl() {
        return MortWeb_URL;
    }

    public static int getTimeOutInSeconds() {
        return Wait_TimeOutInSeconds;
    }

    public static int getThreadSleepTime(){
        return Thread_Sleep_Short;
    }

    public static int getThreadSleepLongTime(){
        return Thread_Sleep_Long;
    }



}
