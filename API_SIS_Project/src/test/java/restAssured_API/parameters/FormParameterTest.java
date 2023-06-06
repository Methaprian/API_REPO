package restAssured_API.parameters;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import genericUtility.Java_Utility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class FormParameterTest {

	@Test
	public void formParameter() {

		Java_Utility jLib = new Java_Utility();
		baseURI = "http://rmgtestingserver";
		port = 8084;

		given().formParam("createdBy", "SKM_123").formParam("projectName", "SMS_POINT_" + jLib.randomNumber())
				.formParam("status", "Created").formParam("teamSize", 12).contentType(ContentType.JSON)

				.when().post("/addProject")

				.then().assertThat().statusCode(201).contentType(ContentType.JSON)
				.time(Matchers.lessThan(4500l), TimeUnit.SECONDS).log().all();
	}

}
