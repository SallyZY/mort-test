Feature: Verify detail of union DataSet

  Background:
    Given I open browser and login to Mort Web
      | UserName              | Password    |
      | zhangy@fullsample.com | password123 |


  Scenario: Verify the result of union dataset
    Given I access to "DataSet" module
    And I expand the DataSet directory
    And I select DataSet directory "测试关联数据集目录"
    When I select the DataSet "第一季度-Union-直连"
    Then I should see the field detail displayed correctly as following
      | 字段名            | 原始字段名 | 类型  |
      | 源表              | -        | 文本  |
      | 日期-ActualCost   | -        | 文本  |
      | ActualIncome     | -        | 数值  |
      | ActualCost       | -        | 数值  |
      | ExpectedIncome   | -        | 数值  |
      | ExpectedCost     | -        | 数值  |
    And I should see the preview data of DataSet displayed correctly as following
      | 源表              | ActualIncome | 日期-ActualCost |  ActualCost |  ExpectedIncome | ExpectedCost |
      | 三表关联-导入      | 7500.0       | 2017-1-1        |  800.0      | 5500.0          | null         |
      | 三表关联-导入      | 5700.0       | 2017-3-1        | 1800.0      | 5700.0          | null         |
      | Cost_2016-直连    | null         | 2016-1-1        | 1000.0      | null            | 800.0        |
      | Cost_2016-直连    | null         | 2016-2-1        | 2500.0      | null            | 2100.0       |
      | Cost_2016-直连    | null         | 2016-3-1        | 1500.0      | null            | 1800.0       |
      | Income_2016-导入  | 7500.0       | 2016-1-1        | null        | 7500.0          | null         |
      | Income_2016-导入  | 4900.0       | 2016-2-1        | null        | 5100.0          | null         |
      | Income_2016-导入  | 5900.0       | 2016-3-1        | null        | 5700.0          | null         |
    And I should see the union source of DataSet displayed correctly as following
      | 数据集            | 创建人 | 状态 |
      | Income_2016-导入  | 张莹  | 正常 |
      | 三表关联-导入      | 张莹  | 正常 |
      | Cost_2016-直连    | 张莹  | 正常 |


  Scenario: Delete the union source of DataSet
    Given I access to "DataSet" module
    And I expand the DataSet directory
    And I select DataSet directory "测试原始数据集目录"
    When I select the DataSet "Cost_2016-直连"
    And I delete the dataSet
    Then I should see the notice message "无法删除数据集,含有关联的数据联合数据集"
    When I refresh current page
    And I select the DataSet "Income_2016-导入"
    And I delete the dataSet
    Then I should see the notice message "无法删除数据集,含有关联的数据联合数据集"
    When I refresh current page
    And I expand the DataSet directory
    And I select DataSet directory "测试关联数据集目录"
    And I select the DataSet "三表关联-导入"
    And I delete the dataSet
    Then I should see the notice message "无法删除数据集,含有关联的数据联合数据集"
