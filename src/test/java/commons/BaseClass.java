package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
	
	public static WebDriver driver;
	public static FileReader configReader;
	public static Properties configProperties = new Properties();
	
	@BeforeMethod
	public void setup() throws IOException {
		if (driver == null) {
			configReader = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
			configProperties.load(configReader);
		}
		if (configProperties.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(configProperties.getProperty("url"));
		}
		else if (configProperties.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(configProperties.getProperty("url"));
		}
		else if (configProperties.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(configProperties.getProperty("url"));
		}
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
