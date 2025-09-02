package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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

//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--disable-blink-features=AutomationControlled");
//			options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//			options.setExperimentalOption("useAutomationExtension", false);

			// Disable the password manager
//			Map<String, Object> prefs = new HashMap<>();
//			prefs.put("credentials_enable_service", false);
//			prefs.put("profile.password_manager_enabled", false);
//			options.setExperimentalOption("prefs", prefs);

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-blink-features=AutomationControlled"); // optional
			options.setExperimentalOption("prefs", Map.of(
					"credentials_enable_service", false,
					"profile.password_manager_enabled", false
			));
			options.addArguments("--headless");           // Run headless
			options.addArguments("--no-sandbox");         // Important for Jenkins/Linux
			options.addArguments("--disable-dev-shm-usage");
//			options.addArguments("--window-size=1920,1080");
//			driver = new ChromeDriver(options);

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
