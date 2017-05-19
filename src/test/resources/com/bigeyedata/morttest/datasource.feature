Feature: Datasource

  Background:
    Given I open browser and login to Mort Web
      | UserName                 | Password     |
      | zhangying@bigeyedata.com | password123  |

  Scenario: Create a new RDB datasource
    Given I access to "datasource" module
    And I select datasource directory "测试数据源目录"
    And I want to create a RDB datasource with configuration as following
      | Parameters      | Values           |
      | DatasourceType  | MySQL            |
      | Host            | 127.0.0.1        |
      | Port            | 3306             |
      | User            | root             |
      | Password        |                  |
      | Database        | customerdata_dev |
      | DatasourceName  | 测试MySQL数据源    |
    When I click save button on RDB datasource configuration page
    Then I should see the created datasource "测试MySQL数据源" displayed in directory

