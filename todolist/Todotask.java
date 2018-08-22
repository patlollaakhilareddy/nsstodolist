package todolist;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Todotask {
	public class BaseTest {
	     WebDriver driver;
	     final static String binaryPath = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
	 	final static String chromeDriverPath = "C:\\Users\\Sharada\\Desktop\\chromedriver.exe";

	    @BeforeTest
	    public void beforeTest() {
	    	System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			ChromeOptions chromeOpt= new ChromeOptions();
	    }

	    @AfterTest
	    public void afterTest(){
	        //driver.quit();
	    }

	    public ToDoList getToDoApp() {
	        return new ToDoList(driver, true);
	   
	    }
	}
}
