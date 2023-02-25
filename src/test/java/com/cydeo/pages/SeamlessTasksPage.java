package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SeamlessTasksPage {
    public SeamlessTasksPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//a[@href='/index.php/apps/tasks/'])[1]")
    public WebElement tasksBtn;

    @FindBy(xpath = "//span[@title='Add List…']")
    public WebElement addListBtn;

    @FindBy(id = "newListInput")
    public WebElement addListInputBox;

    @FindBy(xpath = "//input[@id='newListInput']/following-sibling::*[2]")
    public WebElement addListSaveBtn;

    @FindBy(xpath = "//div[@class='draggable-container']//a//span")
    public List<WebElement> listOfTasks;

    @FindBy(xpath = "//input[@class='transparent reactive']")
    public WebElement addTaskInputBox;

    @FindBy(xpath = "//div[@class='task-list']//li//div/div/span[contains(text(),'')]")
    public List<WebElement> listOfSubTask;

    public WebElement taskDisplayed(String taskName){
        String locator = "//div[@class='draggable-container']//a//span[contains(text(),'"+taskName+"')]";
        WebElement webElement = Driver.getDriver().findElement(By.xpath(locator));
        return webElement;
    }
}
