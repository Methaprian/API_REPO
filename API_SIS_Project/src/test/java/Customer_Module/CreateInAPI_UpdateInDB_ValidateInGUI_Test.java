package Customer_Module;

import static io.restassured.RestAssured.given;

import org.junit.Test;
import org.openqa.selenium.By;

import genericUtility.EndPointsLibrary;
import genericUtility.IPathConstants;
import genericUtility.RequestSpecBuilderWithBaseClass;
import objectRepository.Customer_Page;
import objectRepository.Home_Page;
import pojoUtility.Customer_Module;

public class CreateInAPI_UpdateInDB_ValidateInGUI_Test extends RequestSpecBuilderWithBaseClass{

	
	@Test
	public void endToEndScenario1() throws Throwable {
		
		
		//Create Customer in API
		String firstname = eLib.readDataFromExcel("customer", 1, 0)+jLib.randomNumber();
		String lastname = eLib.readDataFromExcel("customer", 1, 1)+jLib.randomNumber();
		int phoneNumber = (int) (eLib.readIntegerFromExcel("customer", 1, 2)+jLib.randomNumber());
		
		Customer_Module customer = new Customer_Module(firstname, lastname, phoneNumber);
		given().body(customer)
		.when().spec(requestSpec).post(IPathConstants.baseURI+IPathConstants.port+EndPointsLibrary.createCustomer);
		
		//Update in Database
		String firstname1 = eLib.readDataFromExcel("customer", 2, 0)+jLib.randomNumber();
		String lastname1 = eLib.readDataFromExcel("customer", 2, 1)+jLib.randomNumber();
		int phonenumber1 = (int) (eLib.readIntegerFromExcel("customer", 2, 2)+jLib.randomNumber());
		dLib.updateDataInDB(firstname1, lastname1, phonenumber1);
		
		//Valiadte in GUI
		Home_Page homePage = new Home_Page(driver);
		homePage.clickOnCustomer(wlib, driver);
		Customer_Page customerPage = new Customer_Page(driver);
		customerPage.searchOption(phonenumber1, wlib, driver);
		String actualData = driver.findElement(By.xpath("(//th[contains(.,'Phone Number')]/../../..//td)[3]")).getText();
		int actualData1 = Integer.parseInt(actualData);
		if (actualData1==phonenumber1) {
			System.out.println("The customer has been valiadated upon verification");
		} else {
			System.out.println("Customer is not present");
		}
		
	}
}
