package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer_Page {

	
	@FindBy (xpath = "//form[@action='cust_transac.php?action=add']//input[@name='firstname']")
	private WebElement firstNameTF;
	
	@FindBy (xpath = "//form[@action='cust_transac.php?action=add']//input[@name='lastname']")
	private WebElement lastNameTF;
	
	@FindBy (xpath = "//form[@action='cust_transac.php?action=add']//input[@name='phonenumber']")
	private WebElement phonenumberTF;
	
	@FindBy(xpath = "//form[@action='cust_transac.php?action=add']//button[contains(.,'Save')]")
	private WebElement SaveButton;
	
	public AddCustomer_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getFirstNameTF() {
		return firstNameTF;
	}

	public WebElement getLastNameTF() {
		return lastNameTF;
	}

	public WebElement getPhonenumberTF() {
		return phonenumberTF;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}
	
	//Business Library
	public void createCustomer(String firstname, String lastname, int phonenumber) throws Throwable {
		firstNameTF.sendKeys(firstname);
		lastNameTF.sendKeys(lastname);
		String phNo = String.valueOf(phonenumber);
		phonenumberTF.sendKeys(phNo);
		SaveButton.click();
	}
}
