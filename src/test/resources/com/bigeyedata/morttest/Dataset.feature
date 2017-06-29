Feature: Create,view DataSet

    Background:
    Given I open browser and login to Mort Web
      | UserName                 | Password     |
      | zhangying@bigeyedata.com | password123  |


  Scenario: Create a new file DataSet from a specified DataSource
    Given I access to "DataSource" module
    And I select DataSource as following
      |  DirectoryName  |  ResourceFileName     |
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
    And I click date fields preview table
    And I set the date format for date filed as following
      |FieldName      |DateFormat         |
      |测试日期        |yyyyMMdd HH:mm:ss  |
      |空日期字段      |yyyyMMdd           |
    And I give the name of DataSet is "测试CSV数据集"
    And I select the saved directory of DataSet is "测试数据集目录"
    When I create the DataSet
    Then I should see the DataSet "测试CSV数据集" displayed in directory
    And I should see the number of DataSet fields is "16"
    And I should see the ailas of DataSet fields displayed correctly
    And I should see the type of DataSet fields displayed correctly
    And I should see the initial import record is displayed


    Scenario: Locate and view DataSource from DataSet
      Given I access to "DataSet" module
      And I select DataSet as following
        |  DirectoryName  |  ResourceFileName     |
        |  测试数据集目录   |  测试CSV数据集         |
      When  I click "ViewDataSource" item from other operation dropdown menu
      Then  I should locate to the DataSource "测试CSV数据源"
      And   I should see the related DataSet as following
        |  DatasetName    |
        |  测试CSV数据集   |

  Scenario: view SQL from DataSet
    Given I access to "DataSource" module
    And I select DataSource as following
      |  DirectoryName  |  ResourceFileName     |
      |  测试数据源目录   |  测试MySQL数据源        |
    And I click create new DataSet button on DataSource page
    And I give the name of DataSet is "测试MySQL数据集-查看sql"
    And I select the saved directory of DataSet is "测试数据集目录"
    And I select "导入" mode
    And I input a right SQL is "select * from user"
    And I click preview button to preview table
    And I click goToNextPage button of fieldEditPage
    And I select "立即导入"
    And I create the DataSet
    When  I click "ViewSql" item from other operation dropdown menu
    Then  I should see the sql of RDBDataSet



  Scenario: Create a new RDB DataSet from a specified DataSource with imported by default mode
    Given I access to "DataSource" module
    And I select DataSource as following
      |  DirectoryName  |  ResourceFileName     |
      |  测试数据源目录   |  测试MySQL数据源        |
    And I click create new DataSet button on DataSource page
    And I give the name of DataSet is "测试MySQL数据集-立即导入"
    And I select the saved directory of DataSet is "测试数据集目录"
    And I select "导入" mode
    And I input a right SQL is "select * from user"
    And I click preview button to preview table
    And I click goToNextPage button of fieldEditPage
    And I select "立即导入"
    When I create the DataSet
    Then I should see the DataSet "测试MySQL数据集" displayed in directory
    And I should see the number of DataSet fields is "45"
    And I should see the initial import record is displayed

  Scenario: Create a new RDB DataSet from a specified DataSource imported by customize mode
    Given I access to "DataSource" module
    And I select DataSource as following
      |  DirectoryName  |  ResourceFileName     |
      |  测试数据源目录   |  测试MySQL数据源        |
    And I click create new DataSet button on DataSource page
    And I give the name of DataSet is "测试MySQL数据集-自定义导入"
    And I select the saved directory of DataSet is "测试数据集目录"
    And I select "导入" mode
    And I input a right SQL is "select * from user"
    And I click preview button to preview table
    And I click goToNextPage button of fieldEditPage
    And I select "自定义"
    And I set import date and time
    When I create the DataSet
    Then I should see the DataSet "测试MySQL数据集" displayed in directory
    And I should see the number of DataSet fields is "45"
    And I should wait 1 minute
    And I should see the initial import record is displayed

  Scenario: Create a new RDB DataSet from a specified DataSource by direct connection
    Given I access to "DataSource" module
    And I select DataSource as following
      |  DirectoryName  |  ResourceFileName     |
      |  测试数据源目录   |  测试MySQL数据源        |
    And I click create new DataSet button on DataSource page
    And I give the name of DataSet is "测试MySQL数据集-直连"
    And I select the saved directory of DataSet is "测试数据集目录"
    And I select "直连" mode
    And I input a right SQL is "select * from user"
    And I click preview button to preview table
    And I click goToNextPage button of fieldEditPage
    And I can't modify the type of fields for DataSet
    When I create the DataSet
    Then I should see the DataSet "测试MySQL数据集" displayed in directory
    And  I shouldn't see number of records after the dataset name
    And I should see the number of DataSet fields is "45"


  Scenario: Create a new RDB DataSet from a specified DataSource and Add field
    Given I access to "DataSource" module
    And I select DataSource as following
      |  DirectoryName  |  ResourceFileName     |
      |  测试数据源目录   |  测试MySQL数据源        |
    And I click create new DataSet button on DataSource page
    And I give the name of DataSet is "测试MySQL数据集-追加"
    And I select the saved directory of DataSet is "测试数据集目录"
    And I select "导入" mode
    And I input a right SQL is "select Host,User from user"
    And I click preview button to preview table
    And I click goToNextPage button of fieldEditPage
    And I select "立即导入"
    And I create the DataSet
    And I should see the DataSet "测试MySQL数据集-追加" displayed in directory
    And I should see the number of DataSet fields is "2"
    And I should see the initial import record is displayed
    And I click "AppendFields" item from other operation dropdown menu
    And I can't modify the dataset name and he saved directory of DataSet
    And I input a right SQL is "select Host,User,plugin from user"
    And I click preview button to preview table
    And I can't modify the alias and the type of previous data
    And I modify the alias of fields for DataSet as following
      | FieldName     | AliasName             |
      | plugin        | plugin-modify         |
    And I modify the type of fields for DataSet as following
      | FieldName     | FieldType |
      | plugin        | 数值       |
    When I add field to the Dataset
    Then I should see the DataSet "测试MySQL数据集-追加" displayed in directory
    And I should see the number of DataSet fields is "3"
    And I should see the add field import record is displayed




