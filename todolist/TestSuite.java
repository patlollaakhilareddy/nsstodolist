package todolist;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver; 
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Test;

public class TestSuite {

	private static WebDriver driver = null;
	static BaseUtils toDoList = null; 
	final static String binaryPath = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
	final static String chromeDriverPath = "C:\\Users\\Sharada\\Desktop\\chromedriver.exe";
	

	
	public static void checkStatus() {
		
		Assert.assertEquals("NSS-TODO List v 1.1", toDoList.getPageLabel());
	}
  
   
	
	private static WebElement findElement(By iNPUT_TASK_NAME2) {
	// TODO Auto-generated method stub
	return null;
}
	public static void printNoCategoryTasksCount(ArrayList<Task> tasks) {
		
		int count = 0;
		for(int i = 0; i < tasks.size(); i++) {
			Task task = tasks.get(i);
			if(task.getTaskCategory() == null || task.getTaskCategory().trim().toLowerCase().equals("none"))
				count++;
		}
		System.out.println("Number of tasks with no category = " + count);
	}
	
	public static void printAllTaskNames(ArrayList<Task> tasks) {
	
		String names = "";
		for(int i = 0; i < tasks.size(); i++) {
			Task task = tasks.get(i);
			names += task.getTaskName() + ",";
		}
		System.out.println("Aggregate task names - ");
		System.out.println(names.substring(0, names.length() - 1));
	}
	
	@Test
	public void testsuite() {
		
		checkStatus();
		ArrayList<Task> tasks = toDoList.getAllTasksInfo();
		printNoCategoryTasksCount(tasks);
		printAllTaskNames(tasks);
		//TestTaskAdd();
	}
	
	@BeforeClass
	public static void setupTestSuite() {
		
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		ChromeOptions chromeOpt= new ChromeOptions();
		chromeOpt.setBinary(binaryPath);
		driver = new ChromeDriver (chromeOpt);
		toDoList = new BaseUtils(driver);
		toDoList.openLandingPage();
	}
	
	@AfterClass
	public static void cleanTestSuite() {
		
		driver.close();
	}

}
