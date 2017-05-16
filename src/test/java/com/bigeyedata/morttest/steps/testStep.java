package com.bigeyedata.morttest.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.nl.En;
import cucumber.api.java8.*;

/**
 * Created by yingzhang on 06/05/2017.
 */
public class testStep{

    @Given("^I open the Baidu website$")
    public void i_open_the_Baidu_website() throws Throwable{
        System.out.println("\n Given-1 \n");
    }

    @When("^I search (.*) in Baidu$")
    public void i_search_in_Baidu(String keyword) throws Throwable {
        System.out.println("\n when-1: " + keyword + " \n");
    }

    @Then("^I should see the search result displayed$")
    public void i_should_see_the_search_result_displayed() throws Throwable{
        System.out.println("\n Then-1 \n");
    }

    @Then("^Scenario(\\d+) then$")
    public void scenarioThen(int arg0) throws Throwable {

        System.out.println("\n Then-2 \n");
    }


    @When("^Scenario(\\d+) when$")
    public void scenarioWhen(int arg0) throws Throwable {

        System.out.println("\n when-2 \n");
    }


    @Given("^Scenario(\\d+) given$")
    public void scenarioGiven(int arg0) throws Throwable {

        System.out.println("\n Given-2 \n");
    }
}
