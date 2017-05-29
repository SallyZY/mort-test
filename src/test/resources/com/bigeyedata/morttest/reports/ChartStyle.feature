Feature: set the style of all kinds of general chart

  Background:
    Given I open browser and login to Mort Web
      | UserName                 | Password     |
      | zhangying@bigeyedata.com | password123  |


  Scenario: Set the style of Column chart
    Given I access to "report" module
    And I select Report as following
      | DirectoryName   |ResourceFileName|
      | 测试报表目录      |回归测试报表     |
    And I open report edit page
    And I select the Column chart
    And I open style setting panel
    And I set the title of chart as following
      | TitleText     | TitleAlign  | TitleSize   |
      | 柱状图         | center      | 20         |
    And I set the title of X-axis of chart is display
    And I set Y-axis of chart as following
      | IsTitleDisplay | Alias               | Unit  | NumberOfDecimal | IsThousandSeparatorDisplay |
      | true           | 流失股票基础交易量总和 | 千     | 无              | true                       |
    And I set the legend of chart as following
      | Location    | FontSize  |
      | 上部居中     | 14        |
    And I set the data label of chart as following
      | Location    | FontSize  | Unit  | PostFix   | NumberOfDecimal | IsThousandSeparatorDisplay |
      | 内部居中     | 14        | 万     | 元        | 2               | false                      |
    When I save the report
    And I return to report preview page
#    Then I Should see the style setting is saved


  Scenario: Set the style of Pie chart
    Given I access to "report" module
    And I select Report as following
      | DirectoryName   |ResourceFileName|
      | 测试报表目录      |回归测试报表     |
    And I open report edit page
    And I go to the report page "第2页"
    And I select the Pie chart
    And I open style setting panel
    And I set the title of chart as following
      | TitleText     | TitleAlign  | TitleSize   |
      | 柱状图         | left        | 20          |
    And I set the legend of chart as following
      | Location    | FontSize  |
      | 左部居中     | 14        |
    And I set the data label of chart as following
      | Location  | FontSize  | Unit  | PostFix   | NumberOfDecimal | IsThousandSeparatorDisplay |
      | 上        | 16         | 自动  |           | 2               | true                       |
    When I save the report
    And I return to report preview page


  Scenario: Set the style of mixLineBar chart
    Given I access to "report" module
    And I select Report as following
      | DirectoryName   |ResourceFileName|
      | 测试报表目录      |回归测试报表     |
    And I open report edit page
    And I go to the report page "第3页"
    And I select the MixLineBar chart
    And I open style setting panel
    And I set the title of chart as following
      | TitleText     | TitleAlign  | TitleSize   |
      | 柱状折线图      | center     | 20          |
    And I set the title of X-axis of chart is display
    And I set left-Y-axis of chart as following
      | IsTitleDisplay | Alias               | Unit  | NumberOfDecimal | IsThousandSeparatorDisplay |
      | true           | 流失资产总和-柱状图    | 百万  | 自动             | false                      |
    And I set right-Y-axis of chart as following
      | IsTitleDisplay | Alias              | Unit  | NumberOfDecimal | IsThousandSeparatorDisplay |
      | true           | 流失资产综合-折线图   | 百万  | 自动             | false                      |
    And I set the legend of chart as following
      | Location    | FontSize  |
      | 上部居中     | 14        |
    And I set the data label of chart as following
      | Location  | FontSize  | Unit  | PostFix   | NumberOfDecimal | IsThousandSeparatorDisplay |
      | 内部居中   | 16        | 万     | RMB       | 2               | true                       |
    When I save the report
    And I return to report preview page


  Scenario: Set the style of Line chart
    Given I access to "report" module
    And I select Report as following
      | DirectoryName   |ResourceFileName|
      | 测试报表目录      |回归测试报表     |
    And I open report edit page
    And I go to the report page "第4页"
    And I select the Line chart
    And I open style setting panel
    And I set the title of chart as following
      | TitleText     | TitleAlign  | TitleSize   |
      | 双轴折线图      | center     | 20          |
    And I set the title of X-axis of chart is display
    And I set left-Y-axis of chart as following
      | IsTitleDisplay | Alias               | Unit | NumberOfDecimal | IsThousandSeparatorDisplay |
      | true           | 流失资产总和-柱状图    | 千   | 自动             | true                      |
    And I set right-Y-axis of chart as following
      | IsTitleDisplay | Alias              | Unit | NumberOfDecimal | IsThousandSeparatorDisplay |
      | true           | 流失资产综合-折线图   | 千   | 自动             | false                      |
    And I set the legend of chart as following
      | Location    | FontSize  |
      | 上部居中     | 14        |
    And I set the data label of chart as following
      | Location  | FontSize  | Unit  | PostFix   | NumberOfDecimal | IsThousandSeparatorDisplay |
      | 上        | 16        | 万     | 元        | 2               | fasle                       |
#    When I save the report
#    And I return to report preview page


  Scenario: Set the style of Doughnut chart
    Given I access to "report" module
    And I select Report as following
      | DirectoryName   |ResourceFileName|
      | 测试报表目录      |回归测试报表     |
    And I open report edit page
    And I go to the report page "第5页"
    And I select the Doughnut chart
    And I open style setting panel
    And I set the title of chart as following
      | TitleText     | TitleAlign  | TitleSize   |
      | 环形饼图       | right       | 20          |
    And I set the legend of chart as following
      | Location    | FontSize  |
      | 右部居中     | 14        |
    And I set the data label of chart as following
      | Location  | FontSize  | Unit  | PostFix   | NumberOfDecimal | IsThousandSeparatorDisplay |
      | 上        | 16        | 自动   | years old | 自动             | fasle                       |
#    When I save the report
#    And I return to report preview page


  Scenario: Set the style of AreaStack chart
    Given I access to "report" module
    And I select Report as following
      | DirectoryName   |ResourceFileName|
      | 测试报表目录      |回归测试报表     |
    And I open report edit page
    And I go to the report page "第6页"
    And I select the AreaStack chart
    And I open style setting panel
    And I set the title of chart as following
      | TitleText     | TitleAlign  | TitleSize   |
      | 区域堆叠图      | center     | 20          |
    And I set the title of X-axis of chart is display
    And I set Y-axis of chart as following
      | IsTitleDisplay | Alias      | Unit  | NumberOfDecimal | IsThousandSeparatorDisplay |
      | true           | 净佣金总和   | 千     | 无             | fasle                      |
    And I set the legend of chart as following
      | Location    | FontSize  |
      | 上部居中     | 14        |
    And I set the data label of chart as following
      | Location  | FontSize  | Unit  | PostFix   | NumberOfDecimal | IsThousandSeparatorDisplay |
      | 内部居中   | 16        | 自动   |           | 自动             | true                      |
#    When I save the report
#    And I return to report preview page


  Scenario: Set the style of Funnel chart
    Given I access to "report" module
    And I select Report as following
      | DirectoryName   |ResourceFileName|
      | 测试报表目录      |回归测试报表     |
    And I open report edit page
    And I go to the report page "第7页"
    And I select the Funnel chart
    And I open style setting panel
    And I set the title of chart as following
      | TitleText   | TitleAlign  | TitleSize   |
      | 漏斗图       | center      | 20          |
    And I set the legend of chart as following
      | Location    | FontSize  |
      | 下部居中     | 14        |
    And I set the data label of chart as following
      | Location  | FontSize  | Unit  | PostFix   | NumberOfDecimal | IsThousandSeparatorDisplay |
      | 上        | 16        | 万     |           | 3             | fasle                       |
#    When I save the report
#    And I return to report preview page


  Scenario: Set the style of KPI chart
    Given I access to "report" module
    And I select Report as following
      | DirectoryName   |ResourceFileName|
      | 测试报表目录      |回归测试报表     |
    And I open report edit page
    And I go to the report page "第8页"
    And I select the KPI chart
    And I open style setting panel


