package com.bigeyedata.morttest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by yingzhang on 04/05/2017.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","json:target/json/output.json","html:target/html/"},
        features = {"src/test/resources/com/bigeyedata/morttest"},
//        tags={"@Smoke"},
        glue={"com/bigeyedata/morttest/steps"}
)

public class RunCukesTest {
}
