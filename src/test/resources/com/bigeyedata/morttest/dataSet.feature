Feature: Create Dataset
  as a user, I want to create and view RDB, CSV, Excel dataset from existed datasource

  Background:
    Given I open browser and login to Mort Web
      | UserName                 | Password |
      | zhangying@bigeyedata.com | password123    |

#  Scenario Outline: Create a new file dataset from a specified datasource
  Scenario: Create a new file dataset from a specified datasource

    Given I access to "datasource" module
    And I select datasource as following
      |  DirectoryName  |  ResourceFileName     |
      |  测试数据源目录   |  测试CSV数据源         |
    And I click create new dataset button on datasource page
    And I modify the alias of fields for dataset as following
      | FieldName     | AliasName   |
      | 客户编号       | 编号         |
      | 空文本字段     | 空文本       |
      | 流失股基净佣金  | 净佣金       |
    And I modify the type of fields for dataset as following
      | FieldName     | FieldType |
      | 年龄          | 数值       |
      | 空日期字段     | 日期       |
      | 测试日期       | 日期       |
      | 测试数值字段    | 数值       |
      | 流失资产       | 数值       |
      | 流失股基净佣金  | 数值       |
    And I click date fields preview table
    And I set the date format for date filed as following
      |FieldName      |DateFormat         |
      |测试日期        |yyyyMMdd HH:mm:ss  |
      |空日期字段      |yyyyMMdd           |
    And I give the name of dataset is "测试CSV数据集"
    And I select the saved directory of dataset is "测试数据集目录"
    When I create the dataset
    Then I should see the dataset created successfully
    And I should see the number of dataset fields is correct
    And I should see the ailas of dataset fields displayed correctly
    And I should see the type of dataset fields displayed correctly
    And I should see the initial import record is displayed
    And I should NOT see the related report displayed
#    And I should see the record number of dataset is ""
#    Examples:
#      | DatasetName     | ResourceFileName  |
#      | 测试CSV数据集    | 测试CSV数据源       |
#      | 测试xls数据集    | 测试xls数据源       |
#      | 测试xlsx数据集   | 测试xlsx数据源      |


  Scenario: Locate and view datasource from dataset
    Given I select dataset as following
      |  DirectoryName  |  ResourceFileName     |
      |  测试数据集目录   |  测试CSV数据集         |
    When  I click "View Datasource" item from other operation menu
    Then  I should locate to the datasource "datasource name"
    And   I should see the related dataset as following
      |  数据集名称    |  创建人  |  创建时间    |
      |  测试CSV数据集 |  ?      |  ?          |


  Scenario Outline: Add data to an existed dataset
    Given I select dataset as following
      |  DirectoryName  |  ResourceFileName     |
      |  测试数据集目录   |  测试CSV数据集         |
    And  I click "Add Data" item from other operation menu
    And  I input the data description ""
    And  I select “<Type>” option
    And  I upload data file
    When I click the confirm button
    And  I go to import record tab
    Then I should see a new import record is added as following
      |  导入说明    |  导入人  | 导入类型  |
      |             |         |          |
    Examples:
      | Type       |
      | add data   |
      | cover data |




