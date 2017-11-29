package com.bigeyedata.morttest;

import com.bigeyedata.morttest.pages.Page;
import com.bigeyedata.morttest.pages.Panel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by yingzhang on 31/08/2017.
 */
public class SeeThruUtils {

    private static WebDriver webDriver= WebDriverManager.getDriver();

    private static Page curPage;

    public static <T extends Page> T initPage(Class<T> pageClassToProxy) {
        return PageFactory.initElements(webDriver, pageClassToProxy);
    }

    public static <T extends Panel> T  initPanel(Class<T> pageClassToProxy) {
        return PageFactory.initElements(webDriver, pageClassToProxy);
    }

    public static void navigateTo(String url) {
        webDriver.navigate().to(url);
    }

    public static Page currentPage() {
        return curPage;
    }

    public static <T extends Page> T onPage(Class<T> pageClassToProxy) {
        if (curPage==null || !curPage.getClass().equals(pageClassToProxy)) {
            curPage = initPage(pageClassToProxy);
        }
        return (T) curPage;
    }
}
