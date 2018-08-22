package todolist;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BestTest {

	final static String binaryPath = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
	final static String chromeDriverPath = "C:\\Users\\Sharada\\Desktop\\chromedriver.exe";
	
	    public WebDriver driver;
	    private String baseUrl = "http://localhost/nsstodoautomation/"; 

	    @Before
	    public void beforeTest() {
	    	System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			ChromeOptions chromeOpt= new ChromeOptions();
			chromeOpt.setBinary(binaryPath);
			driver = new ChromeDriver (chromeOpt);
			
	    	driver.get(baseUrl + "index.php");
	    }

	    @After
	    public void afterTest(){
	        driver.quit();
	    }

	    public ToDoList getToDoApp() {
	        return new ToDoList(driver, true);
	    }
	
}
