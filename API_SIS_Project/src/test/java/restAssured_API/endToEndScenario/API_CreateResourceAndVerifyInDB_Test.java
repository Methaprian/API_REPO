package restAssured_API.endToEndScenario;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtility.API_BaseClass;
import genericUtility.API_EndPoints;
import io.restassured.response.Response;
import pojoUtilityForAPI.POJOClass;
import static io.restassured.RestAssured.*;

import java.sql.SQLException;

public class API_CreateResourceAndVerifyInDB_Test extends API_BaseClass {
	
	@Test(dataProvider = "testData")
	public void createResourceAndVerifyInDB(String createdBy, String projectName, String status, int teamSize) throws SQLException {
		
		POJOClass cp = new POJOClass(createdBy, projectName+jLib.randomNumber(), status, teamSize);
		
		//Send Request
		Response response = given().spec(reqst)
		.body(cp)
		.when().post(API_EndPoints.createProject);
		
		//Capture Resource
		
		String expData = rLib.getJSONData(response, "projectId");
		System.out.println(expData);
		
		//Validate Response in DB
		String query = "select * from project";
		String actData = dLib.readDataFromDB(query, 1, expData);
		
		Assert.assertEquals(actData, expData);
		System.out.println("Test Case Pass");
		
		response.then().log().all();
		
	}
		
	@DataProvider(name = "testData")
	public Object[][] testDataBlock() {

		Object[][] data = new Object[1][4];

		data[0][0] = "SKM_1";
		data[0][1] = "MICROMAX_";
		data[0][2] = "Created";
		data[0][3] = 18;
		
		return data;
	}

}
