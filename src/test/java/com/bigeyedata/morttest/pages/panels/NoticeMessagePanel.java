package com.bigeyedata.morttest.pages.panels;

import com.bigeyedata.morttest.pages.Panel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.bigeyedata.morttest.CommonFunctions.*;

/**
 * Created by yingzhang on 17/11/2017.
 */
public class NoticeMessagePanel implements Panel {

    @FindBy(xpath ="//div[@class='ant-notification-notice-message']" )
    WebElement noticeMsg;

    @FindBy(xpath = "//span[@class='ant-notification-notice-close-x']")
    WebElement noticeCloseIcon;

    public String getNoticeMessage()  {
        waitForElementVisible(noticeMsg);
        String msg = noticeMsg.getText();
        noticeCloseIcon.click();
        return msg;
    }
}
