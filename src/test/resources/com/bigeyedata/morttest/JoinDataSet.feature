Feature: Create,view DataSet

    Background:
    Given I open browser and login to Mort Web
      | UserName              | Password     |
      | zhangy@fullsample.com | password123  |


  Scenario:  Verify the result of join dataset
    Given I access to "DataSet" module
    And I expand the DataSet directory
    And I select DataSet directory "测试关联数据集目录"

    When I select the DataSet "三表关联-导入"
    Then I should see the field detail displayed correctly as following
    | 字段名               | 	原始字段名                      | 类型  |
    | 日期-ActualIncome    | ActualIncome-导入.SalesMonth       | 文本  |
    | 日期-ActualCost      | ActualCost-直连.SalesMonth         | 文本  |
    | 日期-ExpectedIncome  | ExpectedIncome-导入.SalesMonth     | 文本  |
    | ActualIncome         | ActualIncome-导入.ActualIncome     | 数值  |
    | ActualCost           | ActualCost-直连.ActualCost         | 数值  |
    | ExpectedIncome       | ExpectedIncome-导入.ExpectedIncome | 数值  |

    And I should see the preview data of DataSet displayed correctly as following
    | 日期-ActualIncome	| ActualIncome	 | 日期-ActualCost	| ActualCost| 日期-ExpectedIncome  | ExpectedIncome  |
    | 2014-1-1	        | null	         | 2014-1-1	        | null	    | null	               | null            |
    | 2017-1-1      	| 7500.0	     | 2017-1-1       	| 800.0		| 2017-1-1	           | 5500.0          |
    | 2017-2-1	        | 5100.0         | 2017-2-1         | 2100.0	| 2017-2-1	           | 6100.0          |
    | 2017-3-1      	| 5700.0         | 2017-3-1         | 1800.0	| 2017-3-1	           | 5700.0          |
    | 2017-4-1	        | 7000.0         | 2017-4-1         | 2800.0	| 2017-4-1             | 6000.0          |
    | 2017-5-1      	| 5000.0         | 2017-5-1         | 800.0	    | 2017-5-1             | 5000.0          |
    | 2017-6-1      	| 5000.0         | 2017-6-1	        | 2300.0	| 2017-6-1	           | 5300.0   	     |
    | null	            | null           | 2017-7-1	        | 1500.0    | null		           | null	         |
    | null	            | null           | 2017-8-1         | 1000.0    | null		           | null	         |
    | null	            | null           | 2017-9-1         | 2600.0	| null		           | null	         |

    And I should see the join source of DataSet displayed correctly as following
    | 数据集               | 创建人   | 状态  |
    | ActualIncome-导入    | 张莹    | 正常  |
    | ActualCost-直连      | 张莹	    | 正常  |
    | ExpectedIncome-导入  | 张莹	    | 正常  |


  Scenario:  Verify the join detail of dataset
    Given I access to "DataSet" module
    And I expand the DataSet directory
    And I select DataSet directory "测试关联数据集目录"
    And I select the DataSet "三表关联-导入"

    When I edit join DataSet
    Then I should see the source DataSets displayed correctly as following
      | 数据集               |
      | ActualIncome-导入    |
      | ActualCost-直连      |
      | ExpectedIncome-导入  |
#    And I should see the join type displayed correctly
    And I should see the selected field of source dataset displayed correctly as following
      | ActualIncome-导入  | ActualCost-直连 | ExpectedIncome-导入  |
      | SalesMonth         | SalesMonth     | SalesMonth           |
      | ActualIncome       | ActualCost     | ExpectedIncome       |
    And I should see the field of join dataset displayed correctly as following
     | 类型 | 字段名                |
     | 数值 | ActualIncome         |
     | 文本 | 日期-ActualIncome    |
     | 数值 | ActualCost           |
     | 文本 | 日期-ActualCost      |
     | 数值 | ExpectedIncome      |
     | 文本 | 日期-ExpectedIncome  |
    And I should see the basic information of joinDataSet as following
     | 名称         | 目录             | 数据 |
     | 三表关联-导入 | 测试关联数据集目录 | 导入 |


  Scenario:  delete the join source of DataSet
    Given I access to "DataSet" module
    And I expand the DataSet directory
    And I select DataSet directory "测试原始数据集目录"
    When I select the DataSet "ActualCost-直连"
    And I delete the dataSet
    Then I should see the notice message "无法删除数据集,含有关联的数据集"
    When I refresh current page
    And I select the DataSet "ActualIncome-导入"
    And I delete the dataSet
    Then I should see the notice message "无法删除数据集,含有关联的数据集"
    When I refresh current page
    And I select the DataSet "ExpectedIncome-导入"
    And I delete the dataSet
    Then I should see the notice message "无法删除数据集,含有关联的数据集"
