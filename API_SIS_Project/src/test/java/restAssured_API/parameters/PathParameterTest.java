package restAssured_API.parameters;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class PathParameterTest {

	@Test
	public void pathParamater() {

		baseURI = "http://rmgtestingserver";
		port = 8084;

		given().pathParam("pid", "TY_PROJ_7390")

				.when().get("/projects/{pid}")

				.then().assertThat().statusCode(200).contentType(ContentType.JSON)
				.time(Matchers.lessThan(4500l), TimeUnit.MILLISECONDS).log().all();

	}

}
