package restAssured_API.responseValidation;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class StaticResponseValidationTest {

	@Test
	public void staticResponseValidation() {

		String expData = "TY_PROJ_6269";

		baseURI = "http://rmgtestingserver";
		port = 8084;

		Response resp = when().get("/projects");

		String resp1 = (String) resp.jsonPath().get("[17].projectId");
		Assert.assertEquals(resp1, expData);

		System.out.println(" <--------------- Data Verified --------------->");
		resp.then().assertThat().statusCode(200).contentType(ContentType.JSON).time(Matchers.lessThan(4500l),
				TimeUnit.MILLISECONDS);

	}
}
