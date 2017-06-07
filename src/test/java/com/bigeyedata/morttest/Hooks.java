package com.bigeyedata.morttest;



import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

/**
 * Created by yingzhang on 06/05/2017.
 */
public class Hooks {

    private static final String MortWeb_URL = "http://127.0.0.1:3000";
    private static final int Wait_TimeOutInSeconds = 15;
    private static final int Thread_Sleep = 2000;

    @Before
    public static void beforeScenario() {

        WebDriverManager.getDriver().manage().deleteAllCookies();
    }

    @After
    public static void afterScenario() {

        WebDriverManager.getDriver().manage().deleteAllCookies();
//        WebDriverManager.getDriver().quit();
        WebDriverManager.deleteWebDriver();
    }

    public static String getMortWebUrl() {
        return MortWeb_URL;
    }

    public static int getTimeOutInSeconds() {
        return Wait_TimeOutInSeconds;
    }

    public static int getThreadSleepTime(){
        return Thread_Sleep;
    }
}
