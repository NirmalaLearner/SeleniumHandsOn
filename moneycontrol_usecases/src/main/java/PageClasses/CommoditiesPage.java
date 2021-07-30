package PageClasses;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import TestBase.BaseClass;
import TestUtilities.TestUtil;

public class CommoditiesPage extends BaseClass{

	TestUtil testutil;

	@FindBy(xpath="//div[@class='commodity_container']//a[contains(text(),'GOLD')]")
	WebElement commoditiesGoldLink;

	@FindBy(xpath="//h1[@class='FL']")
	WebElement commoditiesPageTtle;
	

	@FindBy(xpath="//div[@id='commodity_innertab0']//div[@class='FL brdr PR20 gr_13']//span[@class='gr_30']")
	WebElement goldRate;

	@FindBy(xpath="//div[@id='commodity_innertab0']//div[@class='FL brdr PR20 gr_13']//strong")
	WebElement goldRateChange;

	public CommoditiesPage() {
		PageFactory.initElements(driver, this);	
		testutil = new TestUtil();
	}

	public void clickCommoditiesPgLnk() {
		commoditiesGoldLink.click();
	}

	public String checkcommoditiesPageTtle() {
		String commoditiesPgTtle = commoditiesGoldLink.getText();
		return commoditiesPgTtle;
	}

	public List<WebElement> countDates() {
		List<WebElement> allDatesList = testutil.findAllElements("//div[@class='goldQtc']//ul/li");
		return allDatesList;		
	}
	
	public List<WebElement> countDateWiseRates() {
		List<WebElement> dateTables = testutil.findAllElements("//div[@class='gqtcont']//div[contains(@id,\"commodity_innertab\")]//div[contains(@class,\"FL brdr PR20\")]//span[1]");
		return dateTables;		
	}
	
	public List<WebElement> countDateWiseRateChanges() {
		List<WebElement> dateTables = testutil.findAllElements("//div[@class='gqtcont']//div[contains(@id,\"commodity_innertab\")]//div[contains(@class,\"FL brdr PR20\")]//strong");
		return dateTables;		
	}
	
	public void clickOnday(int k) {	
		WebElement ele = countDates().get(k);
		ele.click();
	}
	
	public String getDateWisePrice(int n) {	
		WebElement ele = countDateWiseRates().get(n);
		String gldRate = ele.getText();
		return gldRate;
	}
	
	public String goldRateChangeAndPer(int m) {	
		WebElement ele = countDateWiseRateChanges().get(m);
		String gldRateChange = ele.getText();
		return gldRateChange;
	}

}
