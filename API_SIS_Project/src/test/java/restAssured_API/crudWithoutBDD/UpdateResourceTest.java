package restAssured_API.crudWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericUtility.Java_Utility;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateResourceTest {
	@Test
	public void updateResource() {
		
		Java_Utility jLib = new Java_Utility();
		
		// Step 1: Pre-requisites
		
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Methaprian S.K");
		jObj.put("projectName", "SMS_"+jLib.randomNumber());
		jObj.put("status", "OnGoing");
		jObj.put("teamSize", 15);
		
		RequestSpecification reqs = RestAssured.given();
		reqs.body(jObj);
		reqs.contentType(ContentType.JSON);
		
		// Step 2 : Perform Action
		
		Response resp = reqs.put("http://rmgtestingserver:8084/projects/TY_PROJ_7360");
		
		//Step 3: Validate
		
		System.out.println(resp.getStatusCode());
		
		
	}

}
