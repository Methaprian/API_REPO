package Customer_Module;

import static io.restassured.RestAssured.when;

import org.junit.Test;

import genericUtility.IPathConstants;
import genericUtility.RequestSpecBuilderWithBaseClass;

public class CreateInGUI_DeleteInAPI_ValidateInDB_Test extends RequestSpecBuilderWithBaseClass {

	@Test
	public void endToEndScenario4() throws Throwable {
		
		
		//Create in GUI
		String firstname = eLib.readDataFromExcel("customer", 1, 0)+jLib.randomNumber();
		String lastname = eLib.readDataFromExcel("customer", 1, 1)+jLib.randomNumber();
		int phoneNumber = (int) (eLib.readIntegerFromExcel("customer", 1, 2)+jLib.randomNumber());
		homePage.clickOnCustomer(wlib, driver);
		customerPage.clickOnAddCustomer(wlib, driver);
		addCustomerPage.createCustomer(firstname, lastname, phoneNumber);
		String customerID = "";
		
		
		//Delete in API
		when().delete(IPathConstants.baseURI+IPathConstants.port+"/"+customerID)
		.then().assertThat().statusCode(204).log().all();
		
		
		//Validate in Database
		String query = "select * from project";
		dLib.readDataFromDB(query, 1, customerID);
		
		
		
		
	}
}
