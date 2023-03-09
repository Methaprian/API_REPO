package genericUtility;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import objectRepository.AddCustomer_Page;
import objectRepository.Customer_Page;
import objectRepository.Home_Page;
import objectRepository.LogIn_Page;

public class BaseClass {

	public WebDriver driver;
	static WebDriver sdriver;
	
	public Database_Utility dLib = new Database_Utility();
	public Excel_Utility eLib = new Excel_Utility();
	public File_Utility fLib = new File_Utility();
	public Java_Utility jLib = new Java_Utility();
	public WebDriver_Utility wlib = new WebDriver_Utility();
	
	public Home_Page homePage = new Home_Page(driver);
	public LogIn_Page loginPage = new LogIn_Page(driver);
	public Customer_Page customerPage = new Customer_Page(driver);
	public AddCustomer_Page addCustomerPage = new AddCustomer_Page(driver);
	
	
	@BeforeTest
	public void configBeforeTest() throws Throwable {
		dLib.connectToDB();
	}
	
	@BeforeClass
	public void configBeforeClass() throws Throwable {
		String Browser = fLib.readDataFromFile("browser");
		if (Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (Browser.equalsIgnoreCase("opera")) {
			driver = new OperaDriver();
		} else if (Browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("Browser has not been launched");
		}
		sdriver = driver;
		wlib.maximizeBrowser(driver);
		driver.get(IPathConstants.applicationURL);
		wlib.implicitlyWait(driver);
	}
	
	@BeforeMethod
	public void configBeforeMethod() {
		LogIn_Page loginPage = new LogIn_Page(driver);
		loginPage.loginToAPP(wlib, driver);
	}
	
	@AfterMethod
	public void configAfterMethod() {
		Home_Page homePage = new Home_Page(driver);
		homePage.logOut(wlib, driver);
	}
	
	
	@AfterClass
	public void configAfterClass() {
		driver.quit();
	}
	
	@AfterTest
	public void configAfterTest() throws Throwable {
		dLib.closeFromDB();
	}
	
	
	
}
