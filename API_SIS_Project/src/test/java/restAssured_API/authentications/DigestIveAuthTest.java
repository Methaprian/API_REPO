package restAssured_API.authentications;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DigestIveAuthTest {

	@Test
	public void disgestAuth() {

		baseURI = "http://rmgtestingserver";
		port = 8084;

		given().auth().digest("rmgyantra", "rmgy@9999")

				.when().get("/login")

				.then().assertThat().statusCode(202).contentType(ContentType.JSON).log().all();
	}
}