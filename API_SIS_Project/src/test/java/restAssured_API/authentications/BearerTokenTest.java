package restAssured_API.authentications;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericUtility.Java_Utility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class BearerTokenTest {

	@Test
	public void bearerToken() {

		Java_Utility jLib = new Java_Utility();
		baseURI = "https://api.github.com";

		JSONObject jObj = new JSONObject();
		jObj.put("name", "MICRO_" + jLib.randomNumber());

		given().auth().oauth2("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").body(jObj).contentType(ContentType.JSON)

				.when().post("/user/repos")

				.then().assertThat().statusCode(201).contentType(ContentType.JSON)
				.time(Matchers.lessThan(3000l), TimeUnit.MILLISECONDS).log().all();
	}

}
