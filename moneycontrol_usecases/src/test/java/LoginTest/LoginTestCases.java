package LoginTest;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageClasses.LoginPage;
import TestBase.BaseClass;
import TestUtilities.TestUtil;

public class LoginTestCases extends BaseClass{
	
	LoginPage loginpage;
	TestUtil testutil;
	
	public LoginTestCases() {	
		super();
			
	}
	@BeforeTest
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		testutil = new TestUtil();	
	}
	
	@Test(priority = 0)
	public void loginWvaliddata() throws InterruptedException {	
		loginpage.continueToMoneyCtrl();
		loginpage.clickOnLoginLink();
		loginpage.clickOnLoginButton();
		testutil.frameToBeAvailableAndSwitchToItEW(loginpage.loginFrame());
		loginpage.enterEmailTxt("nirmalalearner@gmail.com");
		loginpage.enterPassTxt("Fen0my@266");
		loginpage.clickLoginSbumit();
		driver.switchTo().defaultContent();
		Assert.assertEquals(loginpage.validateLoggedInmail(), "Hi Nirmalalearner40gmailcom");
	}
	
	@Test(priority = 1)
	public void loginWInvaliddata() throws InterruptedException {	
		loginpage.continueToMoneyCtrl();
		loginpage.clickOnLoginLink();
		loginpage.clickOnLoginButton();
		testutil.frameToBeAvailableAndSwitchToItEW(loginpage.loginFrame());
		loginpage.enterEmailTxt("nirmalalearner@gmail.com");
		loginpage.enterPassTxt("Fen0my");
		loginpage.clickLoginSbumit();
		loginpage.validateInvalidError();
		Assert.assertEquals(loginpage.validateInvalidError(), "Invalid User Id/EmailID or Password. Please try again.");
	}
	
	@Test(priority = 2)
	public void loginWMissingdata() throws InterruptedException {	
		loginpage.continueToMoneyCtrl();
		loginpage.clickOnLoginLink();
		loginpage.clickOnLoginButton();
		testutil.frameToBeAvailableAndSwitchToItEW(loginpage.loginFrame());
		loginpage.enterEmailTxt("nirmalalearner@gmail.com");
		loginpage.enterPassTxt("");
		loginpage.validateLoginDisabled();
	}
	
	@AfterTest
	public void closeBrowser() {
		tearDown();
	}
	
}
