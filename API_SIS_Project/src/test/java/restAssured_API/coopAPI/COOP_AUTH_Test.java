package restAssured_API.coopAPI;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class COOP_AUTH_Test {

	@Test
	public void coopAPI() {

		Response resp = given().formParam("client_id", "MICRO_API")
						.formParam("client_secret", "6fefe3f9f57f353435d2439f6849e20e")
						.formParam("grant_type", "client_credentials")
						.formParam("redirect_uri", "http://microapis.com")
						.formParam("code", "authorization_code")
				
						.when().post("http://coop.apps.symfonycasts.com/token");

		String acc_token = resp.jsonPath().get("access_token");
		System.out.println(acc_token);
		
		given()
		.auth().oauth2(acc_token)
		.pathParam("userID", 4545)
		
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{userID}/eggs-collect")
		
		.then()
		.assertThat().statusCode(200).log().all();
		
//		resp.then().log().all();

	}

}
