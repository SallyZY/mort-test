package com.bigeyedata.morttest.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.bigeyedata.morttest.SeeThruUtils.currentPage;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DirectoryStepdefs {

    @And("^I want to create a new directory$")
    public void iCreateNewDirectory() throws Throwable {
        Thread.sleep(2000);
         currentPage().dirEditorPanel.createDir();
    }

    @And("^I select the parent directory \"([^\"]*)\"$")
    public void iSelectTheParentDirectory(String dirName) throws Throwable {
        currentPage().dirEditorPanel.selectParentDir(dirName);
    }

    @And("^I input directory name is \"([^\"]*)\"$")
    public void iInputDirectoryNameIs(String directoryName) throws Throwable {
        currentPage().dirEditorPanel.setDirName(directoryName);
    }

    @When("^I save the new directory$")
    public void iSaveTheNewDirectory() throws Throwable {
        currentPage().dirEditorPanel.confirmCreatDir();
        Thread.sleep(2000);
    }

    @Then("^I should see the directory \"([^\"]*)\" displayed correctly in directory Container")
    public void iShouldSeeTheDirectoryDisplayedCorrectlyInDirectoryList(String directoryName) throws Throwable {
        assertThat(currentPage().dirContainerPanel.isDirNameDisplayed(directoryName),is(true));
    }


    @When("^I select directory \"([^\"]*)\"$")
    public void iSelectDirectory(String directoryName) throws Throwable {
        currentPage().dirContainerPanel.selectDirByName(directoryName);
    }

    @And("^I select sub-directory \"([^\"]*)\"$")
    public void iSelectDataSourceSubdirectories(String directoryName) throws Throwable {
        currentPage().dirContainerPanel.selectSubDirByName(directoryName);
    }

    @When("^I rename the directory name from \"([^\"]*)\" to \"([^\"]*)\"$")
    public void iRenameTheDirectoryName(String originName, String targetName) throws Throwable {
        currentPage().dirContainerPanel.renameDir(originName,targetName);
    }


    @When("^I delete the directory \"([^\"]*)\"$")
    public void iDeleteTheDirectory(String directoryName) throws Throwable {
        Thread.sleep(2000);
        currentPage().dirContainerPanel.deleteDirectoryByName(directoryName);
    }

    @When("^I delete the multi-level directory name \"([^\"]*)\"$")
    public void iDeleteTheMultiLevelDirectoryName(String directoryName) throws Throwable {
//        currentPage().dirContainerPanel.deleteDirectoryByName();
    }

    @Then("^I should NOT see the directory \"([^\"]*)\" displayed in directory Container")
    public void iShouldNOTSeeTheDirectoryDisplayedInDirectoryContainer(String directoryName) throws Throwable {
        assertThat(currentPage().dirContainerPanel.isDirNameDisplayed(directoryName),is(false));
    }

    @When("^I move the mouse to DataSource directory \"([^\"]*)\"$")
    public void iMoveTheMouseToDataSourceDirectory(String directoryName) throws Throwable {
        currentPage().dirContainerPanel.moveToDirectory(directoryName);
    }

    @Then("^I should NOT see the directory \"([^\"]*)\" displayed in resource list$")
    public void iShouldNOTSeeTheDirectoryDisplayedInResourceList(String directoryName) throws Throwable {
        assertThat(currentPage().dirContainerPanel.getDirName().equals(directoryName),is(true));

    }

    @When("^I select favorite directory$")
    public void iSelectFavoriteDirectory() throws Throwable {
        currentPage().dirContainerPanel.clickFavoriteDir();
    }
}
