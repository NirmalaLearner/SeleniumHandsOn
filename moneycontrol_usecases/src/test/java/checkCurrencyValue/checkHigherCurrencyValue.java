package checkCurrencyValue;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import HandleExcel.ReadWriteExcelData;
import PageClasses.CurrenciesPage;
import PageClasses.HomePage;
import TestBase.BaseClass;
import TestUtilities.TestUtil;

public class checkHigherCurrencyValue extends BaseClass {
	
	CurrenciesPage currenciesPage;
	HomePage homepage;
	TestUtil testutil;
	ReadWriteExcelData readwriteExcel;
	String excelpath = "src//main//resources//ExcelData//CurrencyData.xlsx";

	public checkHigherCurrencyValue() {	
		super(); 

	}
	@BeforeTest
	public void setUp() {
		initialization();
		currenciesPage = new CurrenciesPage();
		homepage = new HomePage();
		testutil = new TestUtil();
	}

	@Test(priority = 0)
	public void getCurrencyValue() throws InterruptedException, IOException {
		homepage.clickCurrencies();
		Assert.assertTrue(currenciesPage.checkCurrencyExchangeRateTble());
		List<String> countryNames = currenciesPage.getCountryNames();
		List<String> currencyVals = currenciesPage.getCurrencyVals();
		int dc = currenciesPage.getCountryNames().size();	
		for(int i=0;i<dc;i++) {
			ReadWriteExcelData.setCellData(excelpath,"data", i+1, 0, countryNames.get(i));
			ReadWriteExcelData.setCellData(excelpath,"data", i+1, 1,currencyVals.get(i) );
		}
		
	}
	@AfterTest
	public void closeBrowser() {
		tearDown();
	}

}
