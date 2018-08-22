package todolist;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseUtils {
	
	private WebDriver webDriver = null;
	private String baseUrl = "http://localhost/nsstodoautomation/"; 
	
	public BaseUtils(WebDriver driver) {
		webDriver = driver;
	}
	
	public void openLandingPage() {
		webDriver.get(baseUrl + "index.php");
		
	}
	
	public String getPageLabel() {
		return webDriver.findElement(By.id("label-first")).getText();
	}
	
	public ArrayList<String> getCategories() {
		
		List<WebElement> categories = webDriver.findElement(By.className("controls")
				).findElements(By.tagName("span"));
		
		ArrayList<String> categoryList = new ArrayList<String>();
		for (int i = 1; i < categories.size(); i++) {
			categoryList.add(categories.get(i).getText().trim().toLowerCase());
		}
		return categoryList;
	}
	
	public ArrayList<Task> getAllTasksInfo() {
		
		List<WebElement> tasks = webDriver.findElement(By.id("todos-content")
				).findElement(By.tagName("ul")).findElements(By.tagName("li"));
		
		String taskInfo = "";
		String tokens[] = null;
		ArrayList<Task> tasksList = new ArrayList<Task>();
		for (int i = 1; i < tasks.size(); i++) {
			taskInfo = tasks.get(i).getText().trim().replaceFirst("[0-9]*", "");
			tokens = taskInfo.replaceAll("\\)", " ").split("\\(");
			Task task = new Task();
			task.setTaskName(tokens[0]);
			for(int j = 1; j < tokens.length; j++) {
				if(tokens[j].trim().matches("\\d+.*")) {
					task.setDueDate(tokens[j]);
					
				} else
					task.setTaskCategory(tokens[j]);
			}
			tasksList.add(task);
		}
		return tasksList;
	}
}
