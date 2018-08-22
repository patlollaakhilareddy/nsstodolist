package todolist;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ModifyTaskPage extends BasePage {
    private WebDriver driver;

    static By INPUT_TASK_NAME = By.name("data");
    static By BUTTON_UPDATE = By.cssSelector("input[value='Update']");

    public ModifyTaskPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public ModifyTaskPage typeUpdateTaskName(String taskName){
        WebElement element = findElement(INPUT_TASK_NAME, 5);
        element.clear();
        element.sendKeys(taskName);
        return this;
    }

    public ToDoList clickUpdate() throws InterruptedException {
        findElement(BUTTON_UPDATE, 5).click();
        Thread.sleep(1000);
        return new ToDoList(driver, false);
    }
    }
