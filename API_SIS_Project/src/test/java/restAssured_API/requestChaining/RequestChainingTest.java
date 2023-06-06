package restAssured_API.requestChaining;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import genericUtility.Java_Utility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoUtilityForAPI.POJOClass;

public class RequestChainingTest {

	@Test
	public void requestChaining() {

		baseURI = "http://rmgtestingserver";
		port = 8084;

		Java_Utility jLib = new Java_Utility();

		POJOClass pObj = new POJOClass("METHAPRIAN S.K", "MACRO_" + jLib.randomNumber(), "Created", 12);

		// 1st Request
		Response req1 = given().body(pObj).contentType(ContentType.JSON).when().post("/addProject");

		String proID = (String) req1.jsonPath().get("projectId");
		System.out.println(proID);

		// 2nd Request

		given().pathParam("pid", proID)

				.when().get("/projects/{pid}")

				.then().assertThat().statusCode(200).contentType(ContentType.JSON)
				.time(Matchers.lessThan(4500l), TimeUnit.MILLISECONDS).log().all();
	}
}