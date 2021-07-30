package TestUtilities;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.BaseClass;

public class TestUtil extends BaseClass {

	public void mouseHover(WebElement element) {		
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();		
	}
	
	public void actClick(WebElement element) {		
		Actions act = new Actions(driver);
		act.click(element).build().perform();		
	}
	
	public void switchWindow() {
		String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                System.out.println("Switched to childWindow");
            }
        }
	}
	
	public void frameToBeAvailableAndSwitchToItEW(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));

	}
	
	public void visibilityOfElementEW(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	public void clickableElementEW(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	
	public void invisibleElementCheck(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOf(element));

	}
	
	public void stalenessOfElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);		
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element)));

	}
	
	public List<WebElement> findAllElements(String path) {
		List<WebElement> allEle = driver.findElements(By.xpath(path));
		return allEle;
	}
	
	public void jsScrollToView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public void jsScrollBy(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")"); 
	}
	
	
}
