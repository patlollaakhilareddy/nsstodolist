package todolist;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class ToDoList extends BasePage {

    private WebDriver driver;
    private String baseUrl;

    private final By INPUT_TASK_NAME = By.name("data");
    private final By BUTTON_ADD = By.cssSelector("input[value='Add']");
    private final By BUTTON_REMOVE = By.cssSelector("input[value='Remove']");
    private final By ALL_TASK_NAMES = By.cssSelector("div#todos-content ul>li");
    private final By CHECK_BOX_SELECT_ALL = By.name("allbox");
    private final By A_TASK_ID = By.cssSelector("div#todos-content ul>li>a");

    public ToDoList(WebDriver driver, boolean navigateToUrl) {
        super(driver);
        this.driver = driver;

        if(navigateToUrl){
            this.baseUrl = "http://localhost/nsstodoautomation/";
            driver.get(baseUrl + "index.php");
        }
    }

    public ToDoList typeTaskName(String taskName) {
        findElement(INPUT_TASK_NAME, 5).sendKeys(taskName);
        return this;
    }

    public ToDoList clickAdd() throws InterruptedException {
        findElement(BUTTON_ADD, 5).click();
        Thread.sleep(2000);
        return this;
    }

    public ToDoList clickSelectAllCheckbox(){
        findElement(CHECK_BOX_SELECT_ALL, 5).click();
        return this;
    }

   
    public ToDoList clickRemove() throws InterruptedException {
        findElement(BUTTON_REMOVE, 5).click();
        Thread.sleep(1000);
        return this;
    }

    public ModifyTaskPage clickTaskId() {
        findElement(A_TASK_ID, 5).click();
        return new ModifyTaskPage(driver);
    }

    public void verifyTaskNameIsInList(String taskName) {
       boolean found = findAllElements(ALL_TASK_NAMES, 5)
               .stream()
               .map(webElement -> webElement.getText())
               .anyMatch(text -> text.contains(taskName));

        Assert.assertTrue(found, "Task with name '" + taskName + "'");
    }

    public void verifyAllTasksDeleted() {
        List<WebElement>  elements= findAllElements(ALL_TASK_NAMES, 5);

        Assert.assertEquals(elements.size(), 0, "Number of tasks");
    }


}
