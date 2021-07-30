package PageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.BaseClass;
import TestUtilities.TestUtil;

public class HomePage extends BaseClass{

	TestUtil testutil;

	@FindBy(id="search_str")
	WebElement searchBx;

	@FindBy(xpath="//div[@class='ausggestleft']/following-sibling::div[@id='autosuggestlist']/ul/li[1]")
	WebElement searchSuggestion;

	@FindBy(xpath="//div[@class='tab-pane fade active']//div[@class='indprirange']/div[@class='rangamount clearfix'][2]/div[@id='sp_yearlylow']")
	WebElement fifty2WeekRangeLow;

	@FindBy(xpath="//div[@class='tab-pane fade active']//div[@class='indprirange']/div[@class='rangamount clearfix'][2]/div[@id='sp_yearlyhigh']")
	WebElement fifty2WeekRangeHigh;

	@FindBy(xpath="//div[@class='tab-pane fade active']//div[@class='indprirange']/div[@class='rangamount clearfix'][1]/div[@id='sp_low']")
	WebElement todayRangeLow;

	@FindBy(xpath="//div[@class='tab-pane fade active']//div[@class='indprirange']/div[@class='rangamount clearfix'][1]/div[@id='sp_high']")
	WebElement todayRangeHigh;

	@FindBy(xpath="//div[@class='oview_table']//td[contains(text(),'Open')]//following-sibling::td[@class='nseopn bseopn']")
	WebElement openValue;

	@FindBy(xpath="//div[@class='oview_table']//td[contains(text(),'Previous Close')]//following-sibling::td[@class='nseprvclose bseprvclose']")
	WebElement prevCloseValue;

	@FindBy(id="nsecp")
	WebElement currentValue;

	@FindBy(id="nsechange")
	WebElement changedValueAndPercentage;

	@FindBy(linkText = "Commodities")
	WebElement commoditiesLink;
	
	@FindBy(xpath = "//div[@class='bxcom']//a[contains(text(),'Currencies')]")
	WebElement currenciesLnk;

	public HomePage() {
		PageFactory.initElements(driver, this);	
		testutil = new TestUtil();
	}

	public void typeInSearchBxAndSelect(String inputData) {
		searchBx.click();
		searchBx.sendKeys(inputData);
		searchBx.click();
		for(int i=0; i<=2;i++){
			try{
				testutil.clickableElementEW(searchSuggestion);
				searchSuggestion.click();
				break;
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		//testutil.stalenessOfElement(searchSuggestion);
	}

	public String[] get52WeekValue() {
		String[] fifty2WValues = new String[2];
		fifty2WValues[0] = fifty2WeekRangeLow.getText();
		fifty2WValues[1] = fifty2WeekRangeHigh.getText();
		return fifty2WValues;
	}

	public String[] todayValues() {
		String[] todayValue = new String[2];
		todayValue[0] = todayRangeLow.getText();
		todayValue[1] = todayRangeHigh.getText();
		return todayValue;
	}

	public String getOpenValue() {
		String openVal = openValue.getText();
		return openVal;
	}

	public String getPrevCloseValue() {
		String prevCloseVal = prevCloseValue.getText();
		return prevCloseVal;
	}

	public String getCurrentValue() {
		String currentVal = currentValue.getText();
		return currentVal;
	}

	public String getChangedValueAndPercentage() {
		String changeValueAndPer = changedValueAndPercentage.getText();
		return changeValueAndPer;
	}

	public void clickCommodities() {
		commoditiesLink.click();
	}
	
	public void clickCurrencies() {
		testutil.jsScrollBy(0, 120);
		//testutil.clickableElementEW(currenciesLnk);
		currenciesLnk.click();		
	}

}
