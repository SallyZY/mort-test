Feature: The general operation of chart and report

  Background:
    Given I open browser and login to Mort Web
      | UserName                 | Password     |
      | zhangying@bigeyedata.com | password123  |


  Scenario: Copy and move a chart from current report page to a new report page
    Given I access to "Report" module
    And I select Report as following
      | DirectoryName   |ResourceFileName  |
      | 测试报表目录      |复制移动测试报表    |
    And I open report edit page
    And I create a new report page
    And I go to the report page "第1页"
    And I select the Line chart
    And I open style setting panel
    And I set the title of chart as following
      | TitleText     | TitleAlign  | TitleSize   |
      | 双轴折线图      | center     | 20          |
    And I set the title of X-axis of chart is display
    And I set left-Y-axis of chart as following
      | IsTitleDisplay | Alias       | Unit | NumberOfDecimal | IsThousandSeparatorDisplay |
      | true           | 净佣金总和   | 千   | 自动             | false                      |
    And I set right-Y-axis of chart as following
      | IsTitleDisplay | Alias        | Unit | NumberOfDecimal | IsThousandSeparatorDisplay |
      | true           | 流失资产总和   | 万   | 自动             | false                      |
    And I set the legend of chart as following
      | Location    | FontSize  |
      | 上部居中     | 14        |
    And I set the data label of chart as following
      | Location  | FontSize  | Unit  | PostFix   | NumberOfDecimal | IsThousandSeparatorDisplay |
      | 上        | 16        | 万     | 元        | 2               | fasle                      |
    And I copy the chart with index is "1"
    And I move the chart with index is "2" to report page "第2页"
    When I save the report
    And I return to report preview page
#    Then I Should see the style setting is saved


#  Scenario: Rename,save as and delete report
#    Given I access to "Report" module
#    And I select Report as following
#      | DirectoryName   |ResourceFileName  |
#      | 测试报表目录      |仪表盘报表         |
#    And I open report edit page
#    And I save as the report as following
#      |  ReportName   |  Directory        |
#      |  仪表盘报表副本 |  测试报表目录_移动  |
#    When I return to report preview page
#    And I select the directory "测试报表目录_移动"
#    Then I should see the Report "仪表盘报表副本" displayed in directory
#
#    When I select the Report "仪表盘报表副本"
#    And I open report edit page
#    And I modify the name of Report to "仪表盘报表副本_重命名"
#    And I save the report
#    And I return to report preview page
#    Then I should see the Report "仪表盘报表副本_重命名" displayed in directory


  Scenario: Delete BindingItem, chart and report page
    Given I access to "Report" module
    And I select Report as following
      | DirectoryName   | ResourceFileName  |
      | 测试报表目录      | 删除视图测试报表    |
    And I open report edit page
    And I go to the report page "第2页"
    And I select the chart with index is "2"
    And I delete the "Legend" BindingItem of Pie chart
    And I delete the "Measure" BindingItem of Pie chart


#    And I delete the chart with index is "2"
#    And I delete the report page "第3页"
