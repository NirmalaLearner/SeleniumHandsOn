package TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;

	public BaseClass() {
		try {
			prop = new Properties();
			FileInputStream fileIn = new FileInputStream("src//main//resources//PropertyFiles//config.properties");
			prop.load(fileIn);
		} catch(IOException e) {
			e.getMessage();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriverpath"));
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxdriverpath"));
			driver = new FirefoxDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", prop.getProperty("iedriverpath"));
			driver = new InternetExplorerDriver();
			break;
		default:
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriverpath"));
			driver = new ChromeDriver();		
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));	
	}

	public void tearDown() {
		driver.quit();
	}

}