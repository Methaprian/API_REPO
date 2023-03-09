package Customer_Module;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.io.IOException;

import org.junit.Test;

import genericUtility.IPathConstants;
import genericUtility.RequestSpecBuilderWithBaseClass;
import io.restassured.specification.RequestSpecification;
import pojoUtility.Customer_Module;

public class CreateInGUI_UpdateInDB_ValidateInAPI_Test extends RequestSpecBuilderWithBaseClass {

	
	@Test
	public void endToEndScenario5() throws Throwable {
		
		
		
			//Create in API
				String firstname = eLib.readDataFromExcel("customer", 1, 0)+jLib.randomNumber();
				String lastname = eLib.readDataFromExcel("customer", 1, 1)+jLib.randomNumber();
				int phoneNumber = (int) (eLib.readIntegerFromExcel("customer", 1, 2)+jLib.randomNumber());
				Customer_Module customer = new Customer_Module(firstname, lastname, phoneNumber);
				given().body(customer)
				.when().spec(requestSpec);
				
				String customerID = "";
				
				//Update in Database
				String firstname1 = eLib.readDataFromExcel("customer", 2, 0)+jLib.randomNumber();
				String lastname1 = eLib.readDataFromExcel("customer", 2, 1)+jLib.randomNumber();
				int phonenumber1 = (int) (eLib.readIntegerFromExcel("customer", 2, 2)+jLib.randomNumber());
				dLib.updateDataInDB(firstname1, lastname1, phonenumber1);
				
				//Validate in API
				when().get(IPathConstants.baseURI+":"+IPathConstants.port+"/"+customerID)
				.then().assertThat().statusCode(200).log().all();
	}
}
