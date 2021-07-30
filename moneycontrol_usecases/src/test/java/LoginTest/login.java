package LoginTest;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class login {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver","C:\\Users\\NirmalaArjunan\\Music\\Files\\geckodriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.moneycontrol.com/");
		driver.findElement(By.linkText("moneycontrol.com")).click();
		driver.findElement(By.xpath("//a[@class='userlink']")).click();
		String mainWin = driver.getWindowHandle();
		System.out.println(mainWin);
		driver.findElement(By.linkText("Log-in")).click();
		WebDriverWait wit = new WebDriverWait(driver, 20);
		wit.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@src='https://accounts.moneycontrol.com/mclogin/?d=2undefined&cpurl=https://www.moneycontrol.com/']")));
		//WebElement frameEl = driver.findElement(By.id("myframe"));
		//driver.switchTo().frame(frameEl);

		System.out.println("After Switch: "+driver.getTitle());
		WebElement emaiBx = driver.findElement(By.xpath("//div[@class='signinblock']//input[@id='email']"));
		wit.until(ExpectedConditions.visibilityOf(emaiBx));
		emaiBx.sendKeys("nimmi");
		driver.findElement(By.id("pwd")).sendKeys("password1");		
		driver.findElement(By.id("ACCT_LOGIN_SUBMIT")).click();
		Thread.sleep(3000);
		driver.switchTo().window(mainWin);
		driver.close();

	}

}
