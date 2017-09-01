package com.bigeyedata.morttest.tests;

import com.bigeyedata.morttest.WebDriverManager;
import com.bigeyedata.morttest.pages.LoginPage;
import junit.framework.TestCase;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.awt.print.Pageable;

import static com.bigeyedata.morttest.SeeThruUtils.*;

/**
 * Created by yingzhang on 05/05/2017.
 */
public class test extends TestCase {

    @Test
    public  void testPage(){

        onPage(PageA.class).getPageName();
        onPage(PageB.class).getPageName();
        onPage(PageA.class).getPageName();
        onPage(PageA.class).getPageName();
//        onPage(PageA.class).getPageName();

    }

    public void testDrag() throws InterruptedException {


        WebDriver webDriver = WebDriverManager.getDriver();

        webDriver.navigate().to("http://localhost:3000");

        LoginPage loginPage = PageFactory.initElements(webDriver, LoginPage.class);
        loginPage.login("zhangying@bigeyedata.com", "password123");

//
//        WebElement element = webDriver.findElement(By.id("email"));
//        element.sendKeys("zhangying@bigeyedata.com");
//
//        element = webDriver.findElement(By.id("pass"));
//        element.sendKeys("password123");
//
//        element = webDriver.findElement(By.cssSelector("form > filedset:nth-child(4) > button"));
//        element.click();
//
//        Thread.sleep(3000);
//        element = webDriver.findElement(By.id("datasets"));
//        element.click();
//        Thread.sleep(2000);
//
//        element = webDriver.findElement(By.xpath("//ul[@id='mainPageDirectoriesContainer']/li[1]/span"));
//        element.click();
//        Thread.sleep(2000);
//
//        element = webDriver.findElement(By.xpath("(//div[@id='resourceListItemsContainer']//div[@class='content'])[1]"));
//        element.click();
//        Thread.sleep(2000);
//
//        element = webDriver.findElement(By.id("addNewReport"));
//        element.click();
//        Thread.sleep(10000);
//
////        WebElement elementFrom = webDriver.findElement(By.xpath("//div[@id='reportDataSetCollection']//ul[@class='data-set-list'][1]//li[2]"));
////        WebElement elementTo = webDriver.findElement(By.xpath("(//div[@id='reportBindingsContainer']//div[@class='Content'])[2]"));
//        WebElement elementFrom = webDriver.findElement(By.xpath("(//div[@id='reportBindingsContainer']//div[@class='Content'])[1]/span[2]"));
//        WebElement elementTo = webDriver.findElement(By.xpath("(//div[@id='reportBindingsContainer']//div[@class='Content'])[1]"));
//
////        (new Actions(webDriver)).dragAndDrop(elementFrom, elementTo).perform();
//
//        Actions action = new Actions(webDriver);
//        action.clickAndHold(elementFrom).moveToElement(elementTo,0,0).perform();
//        Thread.sleep(1000);
//        action.release().perform();
//
////        Actions builder = new Actions(webDriver);
////        Action dragAndDrop = builder.clickAndHold(elementFrom)
////                .moveToElement(elementTo)
////                .release(elementTo)
////                .build();
////        dragAndDrop.perform();
//
    }

}
