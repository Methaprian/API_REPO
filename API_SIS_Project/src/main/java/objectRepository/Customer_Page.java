package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriver_Utility;

public class Customer_Page {

	
	@FindBy (xpath = "//h4[contains(.,'Customer')]/.//a[@data-toggle='modal']")
	private WebElement addcustomerButton;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchOption;
	
	@FindBy (xpath = "(//th[contains(.,'Action')]/../../..//a[contains(.,'...')])[1]")
	private WebElement moreOption;
	
	@FindBy(xpath = "(//th[contains(.,'Action')]/../../..//a[contains(.,'Edit')])[1]")
	private WebElement editButton;
	
	
	public Customer_Page (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getEditButton() {
		return editButton;
	}


	public WebElement getMoreOption() {
		return moreOption;
	}


	public WebElement getAddcustomerButton() {
		return addcustomerButton;
	}


	public WebElement getSearchOption() {
		return searchOption;
	}
	
	
	//Business Library
	public void clickOnAddCustomer(WebDriver_Utility wu, WebDriver driver) {
		wu.elementToBeClickable(driver, addcustomerButton);
		addcustomerButton.click();
	}
	
	public void searchOption(int phoneNumber, WebDriver_Utility wu, WebDriver driver) {
		wu.visibilityOfElement(driver, searchOption);
		String phoneNumber1 = String.valueOf(phoneNumber);
		searchOption.sendKeys(phoneNumber1);
	}
	
	public void clickOnMoreOption(WebDriver driver, WebDriver_Utility wu) {
		wu.elementToBeClickable(driver, moreOption);
		moreOption.click();
	}
	
	public void clickOnEditOption(WebDriver_Utility wu, WebDriver driver) {
		wu.elementToBeClickable(driver, editButton);
		editButton.click();
	}
}
