package PageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.BaseClass;
import TestUtilities.TestUtil;

public class LoginPage extends BaseClass {
	
	TestUtil testutil;
	
	@FindBy(linkText="moneycontrol.com")
	WebElement continueToSite;
	
	@FindBy(xpath = "//a[@class='userlink']")
	WebElement loginLink;
	
	@FindBy(linkText = "Log-in")
	WebElement loginBtn;
	
	@FindBy(xpath = "//iframe[@src='https://accounts.moneycontrol.com/mclogin/?d=2undefined&cpurl=https://www.moneycontrol.com/']")
	WebElement loginframe;
	
	@FindBy(xpath = "//div[@class='signinblock']//input[@id='email']")
	WebElement emailTxtBox;
	
	@FindBy(xpath = "//div[@class='signinblock']//input[@id='pwd']")
	WebElement pwdBox;
	
	@FindBy(id = "ACCT_LOGIN_SUBMIT")
	WebElement loginSubmitBtn;
	
	@FindBy(xpath = "//div[@class='signinblock']//div[@id='error_api']")
	WebElement invalidDataError;
	
	@FindBy(xpath="//div[@class='user_after_login alp']/a")
	WebElement loggedInuser;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);	
	}
	
	public void continueToMoneyCtrl() {
		continueToSite.click();
		testutil = new TestUtil();
	}
	
	public void clickOnLoginLink() {
		testutil.clickableElementEW(loginLink);
		Actions act = new Actions(driver);
		act.moveToElement(loginLink).build().perform();
		loginLink.click();
		//act.click(loginLink);
	}
	
	public void clickOnLoginButton() {
		testutil.clickableElementEW(loginBtn);
		Actions act = new Actions(driver);
		act.moveToElement(loginBtn).build().perform();
		loginBtn.click();
	}
	
	public void enterEmailTxt(String emailId) {
		testutil.visibilityOfElementEW(emailTxtBox);
		emailTxtBox.click();
		emailTxtBox.clear();
		emailTxtBox.sendKeys(emailId);
	}
	
	public void enterPassTxt(String passWord) {
		testutil.visibilityOfElementEW(pwdBox);
		pwdBox.click();
		pwdBox.clear();
		pwdBox.sendKeys(passWord);
	}
	
	public void clickLoginSbumit() {
		loginSubmitBtn.isEnabled();
		loginSubmitBtn.click();
	}
	
	public WebElement loginFrame() {
		return loginframe;
	}
	
	public String validateLoggedInmail() {
		testutil.visibilityOfElementEW(loggedInuser);
		String usermail = loggedInuser.getText();
		return usermail;
	}
	
	public String validateInvalidError() {
		testutil.visibilityOfElementEW(invalidDataError);
		String errorMsg = invalidDataError.getText();
		return errorMsg;
	}
	
	public void validateLoginDisabled() {
		testutil.invisibleElementCheck(loginSubmitBtn);
	}

}
