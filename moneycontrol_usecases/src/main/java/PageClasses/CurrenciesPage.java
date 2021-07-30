package PageClasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.BaseClass;
import TestUtilities.TestUtil;

public class CurrenciesPage extends BaseClass{
	TestUtil testutil;

	@FindBy(xpath="//h2[@class='grhd']")
	WebElement currencyExchangeRateTble;
	
	@FindBy(xpath="//div[@class='curdata']//tr//td[1]")
	WebElement allCountryName;
	
	@FindBy(xpath="//div[@class='curdata']//td[@class='bgylw'][1]")
	WebElement allCurValue;

	
	public CurrenciesPage() {
		PageFactory.initElements(driver, this);	
		testutil = new TestUtil();
	}
	
	public Boolean checkCurrencyExchangeRateTble() {
		Boolean checkCERTble = currencyExchangeRateTble.isDisplayed();
		return checkCERTble;
	}
		
	public List<WebElement> allCountryNames() {
		List<WebElement> allCountryNames = testutil.findAllElements("//div[@class='curdata']//tr//td[1]");
		return allCountryNames;		
	}
	
	public List<WebElement> allCurValues() {
		List<WebElement> allCurValues = testutil.findAllElements("//div[@class='curdata']//td[@class='bgylw'][1]");
		return allCurValues;		
	}
	
	public List<String> getCountryNames() {
		List<String> countryNameList = new ArrayList<String>();
		List<WebElement> countryLst = allCountryNames();
		for (WebElement webElement : countryLst) {		
			String countryName = webElement.getText().toString();
			countryNameList.add(countryName);
		}
		return countryNameList;	
	}

	public List<String> getCurrencyVals() {
		List<String> currencyList = new ArrayList<String>();
		List<WebElement> currLst = allCurValues();
		for (WebElement webElement : currLst) {		
			String currencyVal = webElement.getText().toString();
			currencyList.add(currencyVal);
		}
		return currencyList;	
	}
}
