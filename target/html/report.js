$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("dataSet.feature");
formatter.feature({
  "line": 1,
  "name": "Create Dataset",
  "description": "as a user, I want to create and view RDB, CSV, Excel dataset from existed datasource",
  "id": "create-dataset",
  "keyword": "Feature"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I open browser and login to Mort Web",
  "rows": [
    {
      "cells": [
        "UserName",
        "Password"
      ],
      "line": 6
    },
    {
      "cells": [
        "zhangying@bigeyedata.com",
        "password123"
      ],
      "line": 7
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "CommonStepdefs.iOpenBrowserAndLoginToMortWeb(String,String\u003e\u003e)"
});
formatter.result({
  "duration": 5589843877,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 9,
      "value": "#  Scenario Outline: Create a new file dataset from a specified datasource"
    }
  ],
  "line": 10,
  "name": "Create a new file dataset from a specified datasource",
  "description": "",
  "id": "create-dataset;create-a-new-file-dataset-from-a-specified-datasource",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 12,
  "name": "I access to \"datasource\" module",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "I select datasource as following",
  "rows": [
    {
      "cells": [
        "DirectoryName",
        "ResourceFileName"
      ],
      "line": 14
    },
    {
      "cells": [
        "测试数据源目录",
        "测试CSV数据源"
      ],
      "line": 15
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "I click create new dataset button on datasource page",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "I modify the alias of fields for dataset as following",
  "rows": [
    {
      "cells": [
        "FieldName",
        "AliasName"
      ],
      "line": 18
    },
    {
      "cells": [
        "客户编号",
        "编号"
      ],
      "line": 19
    },
    {
      "cells": [
        "空文本字段",
        "空文本"
      ],
      "line": 20
    },
    {
      "cells": [
        "流失股基净佣金",
        "净佣金"
      ],
      "line": 21
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "I modify the type of fields for dataset as following",
  "rows": [
    {
      "cells": [
        "FieldName",
        "FieldType"
      ],
      "line": 23
    },
    {
      "cells": [
        "年龄",
        "数值"
      ],
      "line": 24
    },
    {
      "cells": [
        "空日期字段",
        "日期"
      ],
      "line": 25
    },
    {
      "cells": [
        "测试日期",
        "日期"
      ],
      "line": 26
    },
    {
      "cells": [
        "测试数值字段",
        "数值"
      ],
      "line": 27
    },
    {
      "cells": [
        "流失资产",
        "数值"
      ],
      "line": 28
    },
    {
      "cells": [
        "流失股基净佣金",
        "数值"
      ],
      "line": 29
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "I click date fields preview table",
  "keyword": "And "
});
formatter.step({
  "line": 31,
  "name": "I set the date format for date filed as following",
  "rows": [
    {
      "cells": [
        "FieldName",
        "DateFormat"
      ],
      "line": 32
    },
    {
      "cells": [
        "测试日期",
        "yyyyMMdd HH:mm:ss"
      ],
      "line": 33
    },
    {
      "cells": [
        "空日期字段",
        "yyyyMMdd"
      ],
      "line": 34
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "I give the name of dataset is \"测试CSV数据集\"",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "I select the saved directory of dataset is \"测试数据集目录\"",
  "keyword": "And "
});
formatter.step({
  "line": 37,
  "name": "I create the dataset",
  "keyword": "When "
});
formatter.step({
  "line": 38,
  "name": "I should see the created dataset \"测试CSV数据集\" displayed in directory",
  "keyword": "Then "
});
formatter.step({
  "line": 39,
  "name": "I should see the number of dataset fields is \"12\"",
  "keyword": "And "
});
formatter.step({
  "line": 40,
  "name": "I should see the ailas of dataset fields displayed correctly",
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 41,
      "value": "#    And I should see the type of dataset fields displayed correctly"
    }
  ],
  "line": 42,
  "name": "I should see the initial import record is displayed",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "datasource",
      "offset": 13
    }
  ],
  "location": "CommonStepdefs.iAccessToModule(String)"
});
formatter.result({
  "duration": 1808290284,
  "status": "passed"
});
formatter.match({
  "location": "CommonStepdefs.iSelectDatasourceAsFollowing(String,String\u003e\u003e)"
});
formatter.result({
  "duration": 1892216130,
  "status": "passed"
});
formatter.match({
  "location": "DatasetStepdefs.iClickCreateNewDatasetButtonOnDatasourcePage()"
});
formatter.result({
  "duration": 1969552315,
  "status": "passed"
});
formatter.match({
  "location": "DatasetStepdefs.iModifyTheAliasOfFieldsForDatasetAsFollowing(String,String\u003e\u003e)"
});
formatter.result({
  "duration": 1708722374,
  "error_message": "org.openqa.selenium.StaleElementReferenceException: stale element reference: element is not attached to the page document\n  (Session info: chrome\u003d58.0.3029.110)\n  (Driver info: chromedriver\u003d2.25.426935 (820a95b0b81d33e42712f9198c215f703412e1a1),platform\u003dMac OS X 10.12.3 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 1.62 seconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/stale_element_reference.html\nBuild info: version: \u00273.4.0\u0027, revision: \u0027unknown\u0027, time: \u0027unknown\u0027\nSystem info: host: \u0027Yings-MBP.lan\u0027, ip: \u0027fe80:0:0:0:c11:fd88:f5a9:a759%en0\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.12.3\u0027, java.version: \u00271.8.0_101\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, mobileEmulationEnabled\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d2.25.426935 (820a95b0b81d33e42712f9198c215f703412e1a1), userDataDir\u003d/var/folders/zs/vnyk813s6f32y9gq0bw_8xq80000gn/T/.org.chromium.Chromium.EFmmbh}, takesHeapSnapshot\u003dtrue, pageLoadStrategy\u003dnormal, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, hasTouchScreen\u003dfalse, version\u003d58.0.3029.110, platform\u003dMAC, browserConnectionEnabled\u003dfalse, nativeEvents\u003dtrue, acceptSslCerts\u003dtrue, locationContextEnabled\u003dtrue, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 96b5b72f6658533ed13d592f441329c2\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:215)\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:167)\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:671)\n\tat org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:272)\n\tat org.openqa.selenium.remote.RemoteWebElement.isDisplayed(RemoteWebElement.java:313)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:498)\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:51)\n\tat com.sun.proxy.$Proxy15.isDisplayed(Unknown Source)\n\tat org.openqa.selenium.support.ui.ExpectedConditions.elementIfVisible(ExpectedConditions.java:302)\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$100(ExpectedConditions.java:44)\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:288)\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:285)\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:209)\n\tat com.bigeyedata.morttest.CommonFunctions.waitForElementVisible(CommonFunctions.java:35)\n\tat com.bigeyedata.morttest.pages.dataset_pages.FieldEditPage.setFieldsAlias(FieldEditPage.java:26)\n\tat com.bigeyedata.morttest.steps.DatasetStepdefs.iModifyTheAliasOfFieldsForDatasetAsFollowing(DatasetStepdefs.java:52)\n\tat ✽.And I modify the alias of fields for dataset as following(dataSet.feature:17)\n",
  "status": "failed"
});
formatter.match({
  "location": "DatasetStepdefs.iModifyTheTypeOfFieldsForDatasetAsFollowing(String,String\u003e\u003e)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "DatasetStepdefs.iGoToDateFieldsPreviewTable()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "DatasetStepdefs.iSetTheDateFormatForDateFiledAsFollowing(String,String\u003e\u003e)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "测试CSV数据集",
      "offset": 31
    }
  ],
  "location": "DatasetStepdefs.iGiveTheNameOfDatasetIs(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "测试数据集目录",
      "offset": 44
    }
  ],
  "location": "DatasetStepdefs.iSelectTheSavedDirectoryOfDatasetIs(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "DatasetStepdefs.iCreateTheDataset()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "测试CSV数据集",
      "offset": 34
    }
  ],
  "location": "DatasetStepdefs.iShouldSeeTheCreatedDatasetDisplayedInDirectory(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "12",
      "offset": 46
    }
  ],
  "location": "DatasetStepdefs.iShouldSeeTheNumberOfDatasetFieldsIs(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "DatasetStepdefs.iShouldSeeTheAilasOfDatasetFieldsDisplayedCorrectly()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "DatasetStepdefs.iShouldSeeTheInitialImportRecordIsDisplayed()"
});
formatter.result({
  "status": "skipped"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I open browser and login to Mort Web",
  "rows": [
    {
      "cells": [
        "UserName",
        "Password"
      ],
      "line": 6
    },
    {
      "cells": [
        "zhangying@bigeyedata.com",
        "password123"
      ],
      "line": 7
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "CommonStepdefs.iOpenBrowserAndLoginToMortWeb(String,String\u003e\u003e)"
});
formatter.result({
  "duration": 7189130783,
  "error_message": "java.lang.NullPointerException\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:498)\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:51)\n\tat com.sun.proxy.$Proxy15.sendKeys(Unknown Source)\n\tat com.bigeyedata.morttest.pages.LoginPage.Login(LoginPage.java:23)\n\tat com.bigeyedata.morttest.steps.CommonStepdefs.iOpenBrowserAndLoginToMortWeb(CommonStepdefs.java:37)\n\tat ✽.Given I open browser and login to Mort Web(dataSet.feature:5)\n",
  "status": "failed"
});
formatter.scenario({
  "comments": [
    {
      "line": 43,
      "value": "#    And I should NOT see the related report displayed"
    },
    {
      "line": 44,
      "value": "#    And I should see the record number of dataset is \"\""
    },
    {
      "line": 45,
      "value": "#    Examples:"
    },
    {
      "line": 46,
      "value": "#      | DatasetName     | ResourceFileName  |"
    },
    {
      "line": 47,
      "value": "#      | 测试CSV数据集    | 测试CSV数据源       |"
    },
    {
      "line": 48,
      "value": "#      | 测试xls数据集    | 测试xls数据源       |"
    },
    {
      "line": 49,
      "value": "#      | 测试xlsx数据集   | 测试xlsx数据源      |"
    },
    {
      "line": 52,
      "value": "#  Scenario: Delete dataset"
    },
    {
      "line": 53,
      "value": "#"
    },
    {
      "line": 54,
      "value": "#    Given I access to \"dataset\" module"
    },
    {
      "line": 55,
      "value": "#    And I select dataset as following"
    },
    {
      "line": 56,
      "value": "#      |  DirectoryName  |  ResourceFileName     |"
    },
    {
      "line": 57,
      "value": "#      |  测试数据集目录   |  测试CSV数据集         |"
    },
    {
      "line": 58,
      "value": "#    When I click \"Delete\" item from dropdown menu of \"测试CSV数据集\""
    },
    {
      "line": 59,
      "value": "#    Then I should NOT see deleted resource file \"测试CSV数据集\" in directory"
    }
  ],
  "line": 62,
  "name": "Locate and view datasource from dataset",
  "description": "",
  "id": "create-dataset;locate-and-view-datasource-from-dataset",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 64,
  "name": "I access to \"dataset\" module",
  "keyword": "Given "
});
formatter.step({
  "line": 65,
  "name": "I select dataset as following",
  "rows": [
    {
      "cells": [
        "DirectoryName",
        "ResourceFileName"
      ],
      "line": 66
    },
    {
      "cells": [
        "测试数据集目录",
        "测试CSV数据集"
      ],
      "line": 67
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 68,
  "name": "I click \"ViewDatasource\" item from other operation dropdown menu",
  "keyword": "When "
});
formatter.step({
  "line": 69,
  "name": "I should locate to the datasource \"测试CSV数据源\"",
  "keyword": "Then "
});
formatter.step({
  "line": 70,
  "name": "I should see the related dataset as following",
  "rows": [
    {
      "cells": [
        "DatasetName"
      ],
      "line": 71
    },
    {
      "cells": [
        "测试CSV数据集"
      ],
      "line": 72
    }
  ],
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "dataset",
      "offset": 13
    }
  ],
  "location": "CommonStepdefs.iAccessToModule(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CommonStepdefs.iSelectDatasourceAsFollowing(String,String\u003e\u003e)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "ViewDatasource",
      "offset": 9
    }
  ],
  "location": "DatasetStepdefs.iClickItemFromOtherOperationDropdownMenu(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "测试CSV数据源",
      "offset": 35
    }
  ],
  "location": "DatasetStepdefs.iShouldLocateToTheDatasource(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "DatasetStepdefs.iShouldSeeTheRelatedDatasetAsFollowing(String,String\u003e\u003e)"
});
formatter.result({
  "status": "skipped"
});
});