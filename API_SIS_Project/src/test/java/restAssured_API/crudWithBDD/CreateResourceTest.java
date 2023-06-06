package restAssured_API.crudWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import genericUtility.Java_Utility;
import io.restassured.http.ContentType;

public class CreateResourceTest {
	@Test
	public void createResource() {
		Java_Utility jLib = new Java_Utility();
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "SKM_1");
		jObj.put("projectName", "Student_Management_"+jLib.randomNumber());
		jObj.put("status", "Created");
		jObj.put("teamSize", 10);
		
		given().body(jObj).contentType(ContentType.JSON)
		
		.when().post("/addProject")
		
		.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
		
		
	}

}
