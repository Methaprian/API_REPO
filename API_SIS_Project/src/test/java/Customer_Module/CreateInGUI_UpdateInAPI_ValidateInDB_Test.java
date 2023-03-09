package Customer_Module;

import org.junit.Test;


import genericUtility.EndPointsLibrary;
import genericUtility.IPathConstants;
import genericUtility.RequestSpecBuilderWithBaseClass;
import static io.restassured.RestAssured.*;
import pojoUtility.Customer_Module;


import java.io.IOException;


public class CreateInGUI_UpdateInAPI_ValidateInDB_Test extends RequestSpecBuilderWithBaseClass {

	@Test
	public void endToEndScenario5() throws Throwable, IOException {
		
		
		
		//Create in GUI
				String firstname = eLib.readDataFromExcel("customer", 1, 0)+jLib.randomNumber();
				String lastname = eLib.readDataFromExcel("customer", 1, 1)+jLib.randomNumber();
				int phoneNumber = (int) (eLib.readIntegerFromExcel("customer", 1, 2)+jLib.randomNumber());
				homePage.clickOnCustomer(wlib, driver);
				customerPage.clickOnAddCustomer(wlib, driver);
				addCustomerPage.createCustomer(firstname, lastname, phoneNumber);
				String customerID ="";
	
		//Update in API
				String firstname1 = eLib.readDataFromExcel("customer", 2, 0)+jLib.randomNumber();
				String lastname1 = eLib.readDataFromExcel("customer", 2, 1)+jLib.randomNumber();
				int phonenumber = (int) (eLib.readIntegerFromExcel("customer", 2, 2)+jLib.randomNumber());
				Customer_Module customer = new Customer_Module(firstname1, lastname1, phonenumber);
				given().spec(requestSpec).body(customer)
				.when().put(EndPointsLibrary.updateCustomer+customerID);
				
		//ValidateInDB
				String query = "select * from project";
				dLib.readDataFromDB(query, 2, firstname1);
				
	}
}
