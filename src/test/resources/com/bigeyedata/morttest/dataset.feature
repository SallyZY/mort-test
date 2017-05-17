Feature: Dataset
  
    Background:
    Given I open browser and login to Mort Web
      | UserName                 | Password |
      | zhangying@bigeyedata.com | password123    |


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
    Then I should see the created dataset "测试CSV数据集" displayed in directory
    And I should see the number of dataset fields is "12"
    And I should see the ailas of dataset fields displayed correctly
    And I should see the type of dataset fields displayed correctly
    And I should see the initial import record is displayed


    Scenario: Locate and view datasource from dataset
      Given I access to "dataset" module
      And I select dataset as following
        |  DirectoryName  |  ResourceFileName     |
        |  测试数据集目录   |  测试CSV数据集         |
      When  I click "ViewDatasource" item from other operation dropdown menu
      Then  I should locate to the datasource "测试CSV数据源"
      And   I should see the related dataset as following
        |  DatasetName    |
        |  测试CSV数据集    |

