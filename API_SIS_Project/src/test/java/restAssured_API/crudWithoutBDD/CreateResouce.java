package restAssured_API.crudWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.Java_Utility;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateResouce {
	@Test
	public void createResource() {
		Java_Utility jLib = new Java_Utility();
		
		//Step 1: Pre-requisite for Request Body 
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "SKM_1");
		jObj.put("projectName", "Student_Management_"+jLib.randomNumber());
		jObj.put("status", "Created");
		jObj.put("teamSize", 10);
		
		RequestSpecification reqs = RestAssured.given();
		reqs.body(jObj);
		reqs.contentType(ContentType.JSON);
		
		//Step 2: Perform the Action
		Response response = reqs.post("http://rmgtestingserver:8084/addProject");
		
		//Step 3: Validation of Response
		System.out.println(response.prettyPeek());
		System.out.println(response.asString());
		
		
	}

}
