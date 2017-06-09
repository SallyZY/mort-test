$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Dataset.feature");
formatter.feature({
  "line": 1,
  "name": "DataSet",
  "description": "",
  "id": "dataset",
  "keyword": "Feature"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "I open browser and login to Mort Web",
  "rows": [
    {
      "cells": [
        "UserName",
        "Password"
      ],
      "line": 5
    },
    {
      "cells": [
        "zhangying@bigeyedata.com",
        "password123"
      ],
      "line": 6
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "CommonStepdefs.iOpenBrowserAndLoginToMortWeb(String,String\u003e\u003e)"
});
formatter.result({
  "duration": 5298578826,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Create a new file DataSet from a specified DataSource",
  "description": "",
  "id": "dataset;create-a-new-file-dataset-from-a-specified-datasource",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "I access to \"DataSource\" module",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "I select DataSource as following",
  "rows": [
    {
      "cells": [
        "DirectoryName",
        "ResourceFileName"
      ],
      "line": 12
    },
    {
      "cells": [
        "测试数据源目录",
        "测试CSV数据源"
      ],
      "line": 13
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "I click create new DataSet button on DataSource page",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "I modify the alias of fields for DataSet as following",
  "rows": [
    {
      "cells": [
        "FieldName",
        "AliasName"
      ],
      "line": 16
    },
    {
      "cells": [
        "客户编号",
        "编号"
      ],
      "line": 17
    },
    {
      "cells": [
        "空文本字段",
        "空文本"
      ],
      "line": 18
    },
    {
      "cells": [
        "流失股基净佣金",
        "净佣金"
      ],
      "line": 19
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "I modify the type of fields for DataSet as following",
  "rows": [
    {
      "cells": [
        "FieldName",
        "FieldType"
      ],
      "line": 21
    },
    {
      "cells": [
        "年龄",
        "数值"
      ],
      "line": 22
    },
    {
      "cells": [
        "空日期字段",
        "日期"
      ],
      "line": 23
    },
    {
      "cells": [
        "测试日期",
        "日期"
      ],
      "line": 24
    },
    {
      "cells": [
        "流失日期",
        "日期"
      ],
      "line": 25
    },
    {
      "cells": [
        "测试数值字段",
        "数值"
      ],
      "line": 26
    },
    {
      "cells": [
        "流失资产",
        "数值"
      ],
      "line": 27
    },
    {
      "cells": [
        "流失股基净佣金",
        "数值"
      ],
      "line": 28
    },
    {
      "cells": [
        "空数值字段",
        "数值"
      ],
      "line": 29
    },
    {
      "cells": [
        "流失股基交易量",
        "数值"
      ],
      "line": 30
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 31,
  "name": "I click date fields preview table",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "I set the date format for date filed as following",
  "rows": [
    {
      "cells": [
        "FieldName",
        "DateFormat"
      ],
      "line": 33
    },
    {
      "cells": [
        "测试日期",
        "yyyyMMdd HH:mm:ss"
      ],
      "line": 34
    },
    {
      "cells": [
        "空日期字段",
        "yyyyMMdd"
      ],
      "line": 35
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "I give the name of DataSet is \"测试CSV数据集\"",
  "keyword": "And "
});
formatter.step({
  "line": 37,
  "name": "I select the saved directory of DataSet is \"测试数据集目录\"",
  "keyword": "And "
});
formatter.step({
  "line": 38,
  "name": "I create the DataSet",
  "keyword": "When "
});
formatter.step({
  "line": 39,
  "name": "I should see the created DataSet \"测试CSV数据集\" displayed in directory",
  "keyword": "Then "
});
formatter.step({
  "line": 40,
  "name": "I should see the number of DataSet fields is \"16\"",
  "keyword": "And "
});
formatter.step({
  "line": 41,
  "name": "I should see the ailas of DataSet fields displayed correctly",
  "keyword": "And "
});
formatter.step({
  "line": 42,
  "name": "I should see the type of DataSet fields displayed correctly",
  "keyword": "And "
});
formatter.step({
  "line": 43,
  "name": "I should see the initial import record is displayed",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "DataSource",
      "offset": 13
    }
  ],
  "location": "CommonStepdefs.iAccessToModule(String)"
});
