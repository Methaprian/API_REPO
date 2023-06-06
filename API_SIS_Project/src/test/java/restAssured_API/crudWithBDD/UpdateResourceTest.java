package restAssured_API.crudWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericUtility.Java_Utility;
import io.restassured.http.ContentType;

public class UpdateResourceTest {

	@Test
	public void updateResource() {
		Java_Utility jLib = new Java_Utility();

		baseURI = "http://rmgtestingserver";
		port = 8084;

		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Methaprian S.K");
		jObj.put("projectName", "Student_Management_327");
		jObj.put("status", "OnGoing");
		jObj.put("teamSize", 10);

		given().body(jObj).contentType(ContentType.JSON)
		
		.when().put("/projects/TY_PROJ_7371")
		
		.then().assertThat().statusCode(200).contentType(ContentType.JSON)
		.time(Matchers.lessThan(5000l),TimeUnit.MILLISECONDS)
		.log().all();
	}

}
