package restAssured_API.parameters;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class QuerryParamaterTest {

	@Test
	public void queryParameter() {

		baseURI = "https://reqres.in";

		given().queryParam("page", 2)

				.when().get("/api/users")

				.then().assertThat().statusCode(200).contentType(ContentType.JSON)
				.time(Matchers.lessThan(4500l), TimeUnit.MILLISECONDS).log().all();
	}

}
