package checkCommoditiesPrice;

import java.io.IOException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import HandleExcel.ReadWriteExcelData;
import PageClasses.CommoditiesPage;
import PageClasses.HomePage;
import TestBase.BaseClass;
import TestUtilities.TestUtil;

public class CheckGoldPrice extends BaseClass {

	CommoditiesPage commoditiespage;
	HomePage homepage;
	TestUtil testutil;
	ReadWriteExcelData readwriteExcel;
	String excelpath = "src//main//resources//ExcelData//GoldRate.xlsx";

	public CheckGoldPrice() {	
		super(); 

	}
	@BeforeTest
	public void setUp() {
		initialization();
		commoditiespage = new CommoditiesPage();
		homepage = new HomePage();
		testutil = new TestUtil();
	}

	@Test(priority = 0)
	public void getGoldRate() throws InterruptedException, IOException {
		homepage.clickCommodities();
		commoditiespage.clickCommoditiesPgLnk();
		testutil.switchWindow();
		int dc = commoditiespage.countDates().size();	
		for(int i=0;i<dc-1;i++) {
			commoditiespage.clickOnday(i+1);	
			//System.out.println("Clicked on date");
			ReadWriteExcelData.setCellData(excelpath,"GRate", i+1, 0, commoditiespage.getDateWisePrice(i));
			ReadWriteExcelData.setCellData(excelpath,"GRate", i+1, 1, commoditiespage.goldRateChangeAndPer(i));
		}
	}
	@AfterTest
	public void closeBrowser() {
		tearDown();
	}
}
