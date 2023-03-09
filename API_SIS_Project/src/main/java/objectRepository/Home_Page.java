package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriver_Utility;

public class Home_Page {

	@FindBy (xpath = "//span[.='Customer']")
	private WebElement customerModule;
	
	@FindBy(xpath = "//span[.='Employee']")
	private WebElement employeeModule;
	
	@FindBy (xpath = "//span[.='Product']")
	private WebElement productModule;
	
	@FindBy (xpath = "//span[.='Inventory']")
	private WebElement inventoryModule;
	
	@FindBy (xpath = "//span[.='Supplier']")
	private WebElement supplierModule;
	
	@FindBy (xpath = "//span[.='Transaction']")
	private WebElement transactionModule;
	
	@FindBy (xpath = "//span[.='Accounts']")
	private WebElement accountsModule;
	
	@FindBy(xpath = "//span[.='POS']")
	private WebElement POSModule;
	
	@FindBy(xpath = "//a[@id='userDropdown']")
	private WebElement menuOptionModule;
	
	@FindBy (xpath = "//button[@class='dropdown-item']")
	private WebElement profileOption;
	
	@FindBy (xpath = "//a[contains(.,'Settings')]")
	private WebElement settingsOption;
	
	@FindBy (xpath = "//a[contains(.,'Logout')]")
	private WebElement logoutOption;
	
	
	public Home_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getCustomerModule() {
		return customerModule;
	}


	public WebElement getEmployeeModule() {
		return employeeModule;
	}


	public WebElement getProductModule() {
		return productModule;
	}


	public WebElement getInventoryModule() {
		return inventoryModule;
	}


	public WebElement getTransactionModule() {
		return transactionModule;
	}


	public WebElement getAccountsModule() {
		return accountsModule;
	}


	public WebElement getPOSModule() {
		return POSModule;
	}


	public WebElement getMenuOptionModule() {
		return menuOptionModule;
	}


	public WebElement getProfileOption() {
		return profileOption;
	}


	public WebElement getSettingsOption() {
		return settingsOption;
	}


	public WebElement getLogoutOption() {
		return logoutOption;
	}
	
	//Business Library
	public void clickOnCustomer(WebDriver_Utility wu, WebDriver driver) {
		wu.elementToBeClickable(driver, customerModule);
		customerModule.click();
	}
	
	public void clickOnSupplier(WebDriver_Utility wu,  WebDriver driver) {
		wu.elementToBeClickable(driver, supplierModule);
	}
	
	public void logOut(WebDriver_Utility wu, WebDriver driver) {
		wu.elementToBeClickable(driver, menuOptionModule);
		menuOptionModule.click();
		wu.elementToBeClickable(driver, logoutOption);
		logoutOption.click();
	}
	
	public void POS(WebDriver_Utility wu, WebDriver driver) {
		wu.elementToBeClickable(driver, POSModule);
		POSModule.click();
	}
}
