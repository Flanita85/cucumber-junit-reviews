package com.cydeo.step_definitions;

import com.cydeo.pages.SeamlessLoginPage;
import com.cydeo.pages.SeamlessTasksPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class CreateList_step_Defs {
    SeamlessLoginPage seamlessLoginPage = new SeamlessLoginPage();
    SeamlessTasksPage seamlessTasksPage = new SeamlessTasksPage();

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        seamlessLoginPage.txt_username.sendKeys(ConfigurationReader.getProperty("seamless.username"));
        seamlessLoginPage.txt_password.sendKeys(ConfigurationReader.getProperty("seamless.password"));
        seamlessLoginPage.btn_log_in.click();
    }

    @When("user can click task icon")
    public void user_can_click_task_icon() {
        seamlessTasksPage.tasksBtn.click();
        BrowserUtils.sleep(2);

    }

    @When("Click Add to list")
    public void click_add_to_list() {
        seamlessTasksPage.addListBtn.click();
    }

    @When("Enter {string} task and click save")
    public void enter_task_and_click_save(String taskName) {
        seamlessTasksPage.addListInputBox.sendKeys(taskName);
        seamlessTasksPage.addListSaveBtn.click();
        BrowserUtils.sleep(3);
    }

    @Then("User cans see left drop down menu {string} appear in the School list")
    public void user_cans_see_left_drop_down_menu_appear_in_the_list(String taskName) {

        String actualResult = seamlessTasksPage.taskDisplayed(taskName).getText();
        Assert.assertTrue(actualResult.equals(taskName));

    }

    @And("Enter your task {string}")
    public void enterYourTask(String subTask) {
        seamlessTasksPage.addTaskInputBox.sendKeys(subTask + Keys.ENTER);
        Driver.getDriver().navigate().refresh();

    }


    @Then("User can see created task {string} in the {string} list")
    public void userCanSeeCreatedTaskInTheList(String subTask, String task) {
        for (WebElement each : seamlessTasksPage.listOfTasks) {
            if (each.getText().equals(task)) {
                System.out.println("each.getText() = " + each.getText());
                each.click();

            }

        }
        for (WebElement eachTask : seamlessTasksPage.listOfSubTask) {
            if (eachTask.getText().equals(subTask)) {
                eachTask.isDisplayed();
                System.out.println("eachTask.getText() = " + eachTask.getText());
            }
        }


    }

}

