package seachCompanies;

import java.io.IOException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import HandleExcel.ReadWriteExcelData;
import PageClasses.HomePage;
import TestBase.BaseClass;
import TestUtilities.TestUtil;

public class Seach10CompanyAndStoreToExcel extends BaseClass {
	
	HomePage homepage;
	TestUtil testutil;
	ReadWriteExcelData readwriteExcel;
	String excelpath = "src//main//resources//ExcelData//ExcelMoneyControlSearch.xlsx";
	
	public Seach10CompanyAndStoreToExcel() {	
		super(); 
			
	}
	@BeforeTest
	public void setUp() {
		initialization();
		homepage = new HomePage();
		testutil = new TestUtil();	
	}
	
	@Test(priority = 0)
	public void loginWvaliddata() throws InterruptedException, IOException {
		int rowCount = ReadWriteExcelData.getRowCount(excelpath, "companies");
		int colCount = ReadWriteExcelData.getCellCount(excelpath, "companies", rowCount);
		//System.out.println(rowCount+colCount);
		for(int i=1;i<rowCount+1;i++) {
			homepage.typeInSearchBxAndSelect(ReadWriteExcelData.getCellData(excelpath,"companies", i, 0));
			for(int j=0;j<colCount;j++) {
				ReadWriteExcelData.setCellData(excelpath,"companies", i, j+1, homepage.getOpenValue());
				ReadWriteExcelData.setCellData(excelpath,"companies", i, j+2, homepage.getCurrentValue());
				ReadWriteExcelData.setCellData(excelpath, "companies", i, j+4, homepage.get52WeekValue()[0]);
				ReadWriteExcelData.setCellData(excelpath, "companies", i, j+5, homepage.get52WeekValue()[1]);
				ReadWriteExcelData.setCellData(excelpath, "companies", i, j+6, homepage.getPrevCloseValue());
				ReadWriteExcelData.setCellData(excelpath, "companies", i, j+7, homepage.getChangedValueAndPercentage());		
		}	
	}
	}
	
	@AfterTest
	public void closeBrowser() {
		tearDown();
	}

}
