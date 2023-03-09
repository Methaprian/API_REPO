package Customer_Module;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.junit.Test;

import genericUtility.RequestSpecBuilderWithBaseClass;
import objectRepository.Customer_Page;
import objectRepository.Edit_Customer_Page;
import objectRepository.Home_Page;
import pojoUtility.Customer_Module;

public class CreateInAPI_UpdateInGUI_ValidateInDB_Test extends RequestSpecBuilderWithBaseClass {

	
	
	@Test
	public void endToEndScenario2() throws Throwable {
		
		
		//Create in API
		String firstname = eLib.readDataFromExcel("customer", 1, 0)+jLib.randomNumber();
		String lastname = eLib.readDataFromExcel("customer", 1, 1)+jLib.randomNumber();
		int phoneNumber = (int) (eLib.readIntegerFromExcel("customer", 1, 2)+jLib.randomNumber());
		Customer_Module customer = new Customer_Module(firstname, lastname, phoneNumber);
		given().body(customer)
		.when().spec(requestSpec);
		
		//Update in GUI
		String firstname1 = eLib.readDataFromExcel("customer", 3, 0)+jLib.randomNumber();
		String lastname1 = eLib.readDataFromExcel("customer", 3, 1)+jLib.randomNumber();
		int phonenumber1 = (int) (eLib.readIntegerFromExcel("customer", 3, 2)+jLib.randomNumber());
		homePage.clickOnCustomer(wlib, driver);
		customerPage.searchOption(phoneNumber, wlib, driver);
		customerPage.clickOnMoreOption(driver, wlib);
		customerPage.clickOnEditOption(wlib, driver);
		Edit_Customer_Page editCustomer = new Edit_Customer_Page(driver);
		editCustomer.updateCustomerData(firstname1, lastname1, phonenumber1);
		
		//Validate in Database
		String query = "select * from project";
		dLib.readDataFromDB(query, 1, firstname1);
		
		
	}
}
