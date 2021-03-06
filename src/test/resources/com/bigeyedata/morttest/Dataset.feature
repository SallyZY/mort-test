Feature: Create,view DataSet

    Background:
    Given I open browser and login to Mort Web
      | UserName              | Password     |
      | zhangy@fullsample.com | password123  |


  Scenario: Create a new file DataSet from a specified DataSource
    Given I access to "DataSource" module
    And I expand the DataSource directory
    And I select DataSource as following
      |  DirectoryName   |  ResourceFileName     |
      |  测试数据源目录   |  测试CSV数据源         |
    And I click create new DataSet button on DataSource page
    And I modify the alias of fields for DataSet as following
      | FieldName     | AliasName   |
      | 客户编号       | 编号         |
      | 空文本字段     | 空文本       |
      | 流失股基净佣金  | 净佣金       |
    And I modify the type of fields for DataSet as following
      | FieldName     | FieldType |
      | 年龄          | 数值       |
      | 空日期字段     | 日期       |
      | 测试日期       | 日期       |
      | 流失日期       | 日期       |
      | 测试数值字段    | 数值       |
      | 流失资产       | 数值       |
      | 流失股基净佣金  | 数值       |
      | 空数值字段     | 数值       |
      | 流失股基交易量   |数值       |
    And I go to DataSet import preview page
    And I click date fields preview table
    And I set the date format for date filed as following
      |FieldName      |DateFormat         |
      |测试日期        |yyyyMMdd HH:mm:ss  |
      |空日期字段      |yyyyMMdd           |
    And I give the name of DataSet is "测试CSV数据集"
    And I select the saved directory of DataSet is "测试数据集目录"
    When I save the new DataSet
    Then I should see the DataSet "测试CSV数据集" displayed in directory
    And I should see the number of DataSet fields is "16"
    And I should see the field detail displayed correctly as following
      | AliasName   | FieldName    | Type |
      | 空日期字段   | 空日期字段     | 日期  |
      | 测试日期     | 测试日期      | 日期 |
      | 流失日期     | 流失日期      | 日期 |
      | 编号        | 客户编号       | 文本 |
      | 客户姓名     | 客户姓名      | 文本  |
      | 性别         | 性别         | 文本  |
      | 学历         | 学历         | 文本  |
      | 空文本       | 空文本字段    | 文本  |
      | 开户渠道     | 开户渠道      | 文本  |
      | 经纪人       | 经纪人       | 文本  |
      | 年龄         | 年龄         | 数值  |
      | 空数值字段    | 空数值字段    | 数值  |
      | 测试数值字段  | 测试数值字段    |数值   |
      | 流失资产      | 流失资产      | 数值  |
      | 流失股基交易量 | 流失股基交易量 | 数值  |
      | 净佣金        | 流失股基净佣金 | 数值  |
    And I should see the import record displayed as following
      | Description | TriggeredBy | ImportType | Status  |
      | 初始化导入   | 张莹         | 全量        | 导入成功 |

    When  I click "ViewDataSource" item from other operation dropdown menu
    Then  I should locate to the DataSource "测试CSV数据源"
    And   I should see the related DataSet as following
      |  DatasetName    |
      |  测试CSV数据集   |


  Scenario: Create a new ES DataSet from a specified DataSource
    Given I access to "DataSource" module
    And I expand the DataSource directory
    And I select DataSource as following
      |  DirectoryName  |  ResourceFileName     |
      |  测试数据源目录   |  测试ES数据源         |
    And I click create new DataSet button on DataSource page
    And I go to DataSet import preview page
    And I click date fields preview table
    And I give the name of DataSet is "测试ES数据集"
    And I select the saved directory of DataSet is "测试数据集目录"
    When I save the new DataSet
    Then I should see the DataSet "测试ES数据集" displayed in directory
    And I should see the number of DataSet fields is "11"

    When  I click "ViewDataSource" item from other operation dropdown menu
    Then  I should locate to the DataSource "测试ES数据源"
    And   I should see the related DataSet as following
      |  DatasetName    |
      |  测试ES数据集    |


  Scenario: Create a new HDFS DataSet from a specified DataSource
    Given I access to "DataSource" module
    And I expand the DataSource directory
    And I select DataSource as following
      |  DirectoryName  |  ResourceFileName     |
      |  测试数据源目录   |  测试HDFS_parquet数据源|
    And I click create new DataSet button on DataSource page
    And I go to DataSet import preview page
    And I click date fields preview table
    And I give the name of DataSet is "测试HDFS_parquet数据集"
    And I select the saved directory of DataSet is "测试数据集目录"
    When I save the new DataSet
    Then I should see the DataSet "测试HDFS_parquet数据集" displayed in directory
    And I should see the number of DataSet fields is "7"

    And I access to "DataSource" module
    And I expand the DataSource directory
    And I select DataSource as following
      |  DirectoryName  |  ResourceFileName     |
      |  测试数据源目录   |  测试HDFS_orc数据源     |
    And I click create new DataSet button on DataSource page
    And I go to DataSet import preview page
    And I click date fields preview table
    And I give the name of DataSet is "测试HDFS_orc数据源"
#    And I select the saved directory of DataSet is "测试数据集目录"
    When I save the new DataSet
    Then I should see the DataSet "测试HDFS_orc数据源" displayed in directory
    And I should see the number of DataSet fields is "29"



  Scenario: Create RDB DataSet from a specified DataSource with import connection mode
    Given I access to "DataSource" module
    And I expand the DataSource directory
    And I select DataSource as following
      |  DirectoryName  |  ResourceFileName     |
      |  测试数据源目录   |  测试MySQL数据源        |
    And I click create new DataSet button on DataSource page
    And I give the name of DataSet is "测试MySQL数据集_导入"
    And I select the saved directory of DataSet is "测试数据集目录"
    And I set the DataSet connection mode is "导入"
    And I input SQL is "select * from tab_production"
    When I preview the query result of SQL
    Then I can modify the field type of DataSet
    And I go to DataSet import preview page
    And I set the DataSet import mode is "立即导入"
    When I save the new DataSet
    Then I should see the DataSet "测试MySQL数据集_导入" displayed in directory

    When  I click "ViewSql" item from other operation dropdown menu
    Then  I should see the sql of RDBDataSet


  Scenario: Create a new RDB DataSet from a specified DataSource with direct connection mode
    Given I access to "DataSource" module
    And I expand the DataSource directory
    And I select DataSource as following
      |  DirectoryName  |  ResourceFileName     |
      |  测试数据源目录   |  测试MySQL数据源        |
    And I click create new DataSet button on DataSource page
    And I give the name of DataSet is "测试MySQL数据集_直连"
    And I select the saved directory of DataSet is "测试数据集目录"
    And I set the DataSet connection mode is "直连"
    And I input SQL is "select * from bank_records"
    When I preview the query result of SQL
    Then I can NOT modify the field type of DataSet
    And I go to DataSet import preview page
    When I save the new DataSet
    Then I should see the DataSet "测试MySQL数据集_直连" displayed in directory
    And  I should NOT see the amount of DataSet records
    And I should see the number of DataSet fields is "7"


  Scenario: Create a new RDB DataSet from a specified DataSource with customize import mode
    Given I access to "DataSource" module
    And I expand the DataSource directory
    And I select DataSource as following
      |  DirectoryName  |  ResourceFileName     |
      |  测试数据源目录   |  测试MySQL数据源        |
    And I click create new DataSet button on DataSource page
    And I give the name of DataSet is "测试MySQL数据集-自定义导入"
    And I select the saved directory of DataSet is "测试数据集目录"
    And I set the DataSet connection mode is "导入"
    And I input SQL is "select * from bank_records"
    And I preview the query result of SQL
    And I go to DataSet import preview page
    And I set the DataSet import mode is "自定义"
    And I set import time is 1 minute later current time
    When I save the new DataSet
    Then I should see the DataSet "测试MySQL数据集-自定义导入" displayed in directory
    And I should see the number of DataSet fields is "7"
    And I should wait 1 minute
    And I should see the import record displayed as following
      | Description | TriggeredBy | ImportType | Status  |
      | 初始化导入   | 张莹         | 全量        | 导入成功 |


  Scenario: Create a new RDB DataSet from a specified DataSource and Add field
    Given I access to "DataSource" module
    And I expand the DataSource directory
    And I select DataSource as following
      |  DirectoryName  |  ResourceFileName     |
      |  测试数据源目录   |  测试MySQL数据源        |
    And I click create new DataSet button on DataSource page
    And I give the name of DataSet is "测试MySQL数据集_追加字段"
    And I select the saved directory of DataSet is "测试数据集目录"
    And I set the DataSet connection mode is "导入"
    And I input SQL is "select CDate,PROVINCE from bank_records"
    And I preview the query result of SQL
    And I go to DataSet import preview page
    And I set the DataSet import mode is "立即导入"
    When I save the new DataSet
    Then I should see the DataSet "测试MySQL数据集_追加字段" displayed in directory
    And I should see the number of DataSet fields is "2"

    When I click "ModifySQL" item from other operation dropdown menu
#    And I can NOT modify the DataSet name and saved directory
    And I input SQL is "select CDate,STATE_DATE,PROVINCE,SALES_CHANNEL_NAME,PREM from bank_records"
    And I preview the query result of SQL
#    And I can't modify the alias and the type of previous data
    And I modify the alias of fields for DataSet as following
      | FieldName           | AliasName   |
      | SALES_CHANNEL_NAME  | 销售渠道      |
      | PREM                | 保额         |
    And I go to DataSet import preview page

    When I add field to the DataSet
    Then I should see the number of DataSet fields is "5"
    And I should see the import record displayed as following
      | Description     | TriggeredBy | ImportType | Status  |
      | 修改SQL信息导入   | 张莹         | 全量        | 导入成功 |


  Scenario: Rename the DataSet AND Modify the alias of fields
    Given I access to "DataSource" module
    And I expand the DataSource directory
    And I select DataSource as following
      |  DirectoryName  |  ResourceFileName     |
      |  测试数据源目录   |  测试MySQL数据源        |
    And I click create new DataSet button on DataSource page
    And I give the name of DataSet is "测试MySQL数据集"
    And I select the saved directory of DataSet is "测试数据集目录"
    And I set the DataSet connection mode is "直连"
    And I input SQL is "select * from bank_records"
    And I preview the query result of SQL
    And I go to DataSet import preview page
    And I save the new DataSet

    When I rename the DataSet name "测试MySQL数据集_ 重命名"
    Then I should see the DataSet "测试MySQL数据集_ 重命名" displayed in directory

    When I modify the alias of field for DataSet on detail page "CDate_AliasName"
    Then I should see the alias of field for DataSet is "CDate_AliasName"








