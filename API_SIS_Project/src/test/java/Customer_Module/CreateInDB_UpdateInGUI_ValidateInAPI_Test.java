package Customer_Module;

import static io.restassured.RestAssured.when;

import org.junit.Test;

import genericUtility.IPathConstants;
import genericUtility.RequestSpecBuilderWithBaseClass;
import objectRepository.Edit_Customer_Page;

public class CreateInDB_UpdateInGUI_ValidateInAPI_Test extends RequestSpecBuilderWithBaseClass {

	@Test
	public void endToEndScenario3() throws Throwable {
		
		
		//Create in Database
		String firstname = eLib.readDataFromExcel("customer", 1, 0)+jLib.randomNumber();
		String lastname = eLib.readDataFromExcel("customer", 1, 1)+jLib.randomNumber();
		int phoneNumber = (int) (eLib.readIntegerFromExcel("customer", 1, 2)+jLib.randomNumber());
		dLib.updateDataInDB(firstname, lastname, phoneNumber);
		String customerID = "";
		
		
		//Update in GUI
		String firstname1 = eLib.readDataFromExcel("customer", 3, 0)+jLib.randomNumber();
		String lastname1 = eLib.readDataFromExcel("customer", 3, 1)+jLib.randomNumber();
		int phoneNumber1 = (int) (eLib.readIntegerFromExcel("customer", 1, 2)+jLib.randomNumber());
		homePage.clickOnCustomer(wlib, driver);
		customerPage.searchOption(phoneNumber1, wlib, driver);
		customerPage.clickOnMoreOption(driver, wlib);
		customerPage.clickOnEditOption(wlib, driver);
		Edit_Customer_Page editCustomer = new Edit_Customer_Page(driver);
		editCustomer.updateCustomerData(firstname1, lastname1, phoneNumber1);
		
		//Validate in API
		when().get(IPathConstants.baseURI+":"+IPathConstants.port+"/"+customerID)
		.then().assertThat().statusCode(200).log().all();
	}
}
