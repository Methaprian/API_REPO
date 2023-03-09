package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Edit_Customer_Page {

	
	@FindBy (xpath = "//div[contains(@class, 'text-warning')]//input[@name='firstname']")
	private WebElement firstNameTFinEdit;
	
	@FindBy (xpath = "//div[contains(@class, 'text-warning')]//input[@name='lastname']")
	private WebElement lastNameTFinEdit;
	
	@FindBy (xpath = "//div[contains(@class, 'text-warning')]//input[@name='phone']")
	private WebElement phoneNumberTFinEdit;
	
	@FindBy (xpath = "//a[contains(.,'Back')]")
	private WebElement backButton;
	
	@FindBy(xpath = "//button[contains(.,'Update')]")
	private WebElement updateButton;
	
	public Edit_Customer_Page (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getFirstNameTFinEdit() {
		return firstNameTFinEdit;
	}

	public WebElement getLastNameTFinEdit() {
		return lastNameTFinEdit;
	}

	public WebElement getPhoneNumberTFinEdit() {
		return phoneNumberTFinEdit;
	}

	public WebElement getBackButton() {
		return backButton;
	}

	public WebElement getUpdateButton() {
		return updateButton;
	}
	
	//Business Library
	public void updateCustomerData(String firstname, String lastname, int phonenumber) {
		firstNameTFinEdit.sendKeys(firstname);
		lastNameTFinEdit.sendKeys(lastname);
		String phNoEdit = String.valueOf(phonenumber);
		phoneNumberTFinEdit.sendKeys(phNoEdit);
		updateButton.click();
	}
}
