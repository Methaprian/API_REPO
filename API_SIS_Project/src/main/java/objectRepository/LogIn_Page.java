package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.IPathConstants;
import genericUtility.WebDriver_Utility;

public class LogIn_Page {

	@FindBy (xpath = "//input[@name='user']")
	private WebElement userNameTF;
	
	@FindBy (xpath = "//input[@name='password']")
	private WebElement passwordTF;
	
	@FindBy(xpath = "//label[@for='customCheck']/../input[@type='checkbox']")
	private WebElement rememberMeCheckBox;
	
	@FindBy(name = "btnlogin")
	private WebElement signInButton;
	
	
	public LogIn_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getUserNameTF() {
		return userNameTF;
	}


	public WebElement getPasswordTF() {
		return passwordTF;
	}


	public WebElement getRememberMeCheckBox() {
		return rememberMeCheckBox;
	}


	public WebElement getSignInButton() {
		return signInButton;
	}
	
	//Business Library
	public void loginToAPP(WebDriver_Utility wu, WebDriver driver) {
		userNameTF.sendKeys(IPathConstants.applicationUN);
		passwordTF.sendKeys(IPathConstants.applicationPassword);
		signInButton.click();
		wu.acceptPopup(driver);
	}
}
